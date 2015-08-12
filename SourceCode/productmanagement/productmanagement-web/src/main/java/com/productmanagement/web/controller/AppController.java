package com.productmanagement.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.productmanagement.logic.impl.ProductService;
import com.productmanagement.model.Product;
import com.productmanagement.model.collection.Products;
import com.productmanagement.persistence.dao.impl.GenericDao;
import com.productmanagement.utils.LoggerUtils;

@Controller
@RequestMapping("/")
public class AppController {
	
	@Autowired
	private ProductService<Product> productService;
	
	private LoggerUtils logger = new LoggerUtils(AppController.class);
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showProducts(ModelMap model) {
		logger.log("In showProducts");
		try {
			Products products = productService.getProducts(null);
			products.sortByPopularity();	
			model.addAttribute("products", products.list());
		} catch (Exception e) {
			//TODO Handle Exception and logging
		}
		return "products";
	}
	
	@RequestMapping(value = "/sort/{sortBy}", method = RequestMethod.GET)
	public String sort(@PathVariable String sortBy, ModelMap model) {
		logger.log("In sort");
		try {
			Products products = productService.getProducts(null);
			if("PriceLowToHigh".equalsIgnoreCase(sortBy)){
				products.sortByPriceLowToHigh();
				model.addAttribute("sortBy","PriceLowToHigh");
			} else if("PriceHighToLow".equalsIgnoreCase(sortBy)) {
				products.sortByPriceHighToLow();
				model.addAttribute("sortBy","PriceHighToLow");
			} else {
				products.sortByPopularity();
				model.addAttribute("sortBy","Popularity");
			}
			model.addAttribute("products", products.list());
		} catch (Exception e) {
			//TODO Handle Exception and logging
		}
		return "products";
	}
	
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String showProductInDetail(@PathVariable String id,ModelMap model) {
		logger.log("In showProductInDetail");
		try {
			Product product = productService.getProductById(id); 
			model.addAttribute("product", product);
		} catch (Exception e) {
			//TODO Handle Exception and logging
			
		}
		return "product_detail";

	}
	
	@RequestMapping(value = "/product/delete/{id}/name/{name}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable String id,@PathVariable String name,ModelMap model) {
		logger.log("In deleteProduct");
		try {
			productService.deleteProduct(productService.getProductById(id)); 
			model.addAttribute("productid", id);
			model.addAttribute("productname", name);
			model.addAttribute("productdeletemessage", "Y");
		} catch (Exception e) {
			//TODO Handle Exception and logging
			
		}
		return showProducts(model);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		logger.log("In login");
		try {
			Products products = productService.getProducts(null);
			model.addAttribute("products", products.list());
		} catch (Exception e) {
			//TODO Handle Exception and logging
		}
		return "products";

	}

	@RequestMapping(value = "/product/add", method = RequestMethod.GET)
	public String productAdd(ModelMap model) {
		logger.log("In productAdd");
		try {
			Product product = new Product();
			model.addAttribute("product", product);
		} catch (Exception e) {
			//TODO Handle Exception and logging
			
		}
		return "product_detail";

	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String productSave(@ModelAttribute("productForm") @Validated Product product,
			BindingResult result, Model model, 
			final RedirectAttributes redirectAttributes) {
		logger.log("In productSave");
		try {
			if (result.hasErrors()) {
				model.addAttribute("product", product);
			} else {
				if(null != product.getId()){
					productService.editProduct(product);
				} else {
					product = productService.addProduct(product);
				}
			}
			model.addAttribute("product", product);
		} catch (Exception e) {
			//TODO Handle Exception and logging
			
		}
		return "redirect:/product/"+product.getId() ;

	}

}