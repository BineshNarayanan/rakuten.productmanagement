package com.productmanagement.web.controller;


import static org.junit.Assert.assertEquals;

import java.beans.PropertyEditor;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import com.productmanagement.model.Product;

public class AppControllerTest {
	
	private AppController controller;
	private ModelMap model;
	
	@Before
	public void init(){
		controller = new AppController();
		model = new ModelMap();
	}
	
	@Test
	public void showProducts(){
		String viewName = controller.showProducts(model);
		assertEquals("ShowProducts method in the controller failed", "products", viewName);
	}
	
	@Test
	public void sort(){
		String viewName = controller.sort("popularity",model);
		assertEquals("sort method in the controller failed", "products", viewName);
	}
	
	@Test
	public void showProductInDetail(){
		String viewName = controller.showProductInDetail("1", model);
		assertEquals("showProductInDetail method in the controller failed", "product_detail", viewName);
	}
	
	@Test
	public void deleteProduct(){
		String viewName = controller.deleteProduct("1", "ABC", model);
		assertEquals("deleteProduct method in the controller failed", "products", viewName);
	}
	
	@Test
	public void login(){
		String viewName = controller.login(model);
		assertEquals("login method in the controller failed", "products", viewName);
	}
	
	@Test
	public void productAdd(){
		String viewName = controller.productAdd(model);
		assertEquals("login method in the controller failed", "product_detail", viewName);
	}
	
	@Test
	public void productSave(){
		Product product = new Product();
		Model model =  createMockModel();
		BindingResult bindingResult = createMockBindingResult();
		product.setId(1);
		String viewName = controller.productSave(product, bindingResult, model, null);
		assertEquals("ProductSave method in the controller failed", "redirect:/product/1", viewName);

	}
	
	private BindingResult createMockBindingResult(){
		BindingResult bindingResult = new BindingResult() {
			
			public void setNestedPath(String nestedPath) {
				// TODO Auto-generated method stub
				
			}
			
			public void rejectValue(String field, String errorCode, Object[] errorArgs,
					String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			public void rejectValue(String field, String errorCode,
					String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			public void rejectValue(String field, String errorCode) {
				// TODO Auto-generated method stub
				
			}
			
			public void reject(String errorCode, Object[] errorArgs,
					String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			public void reject(String errorCode, String defaultMessage) {
				// TODO Auto-generated method stub
				
			}
			
			public void reject(String errorCode) {
				// TODO Auto-generated method stub
				
			}
			
			public void pushNestedPath(String subPath) {
				// TODO Auto-generated method stub
				
			}
			
			public void popNestedPath() throws IllegalStateException {
				// TODO Auto-generated method stub
				
			}
			
			public boolean hasGlobalErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean hasFieldErrors(String field) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean hasFieldErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean hasErrors() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public String getObjectName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getNestedPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public List<ObjectError> getGlobalErrors() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getGlobalErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public ObjectError getGlobalError() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Object getFieldValue(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Class<?> getFieldType(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public List<FieldError> getFieldErrors(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public List<FieldError> getFieldErrors() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getFieldErrorCount(String field) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public int getFieldErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public FieldError getFieldError(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public FieldError getFieldError() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getErrorCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public List<ObjectError> getAllErrors() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void addAllErrors(Errors errors) {
				// TODO Auto-generated method stub
				
			}
			
			public String[] resolveMessageCodes(String errorCode, String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] resolveMessageCodes(String errorCode) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void recordSuppressedField(String field) {
				// TODO Auto-generated method stub
				
			}
			
			public Object getTarget() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] getSuppressedFields() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Object getRawFieldValue(String field) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public PropertyEditorRegistry getPropertyEditorRegistry() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Map<String, Object> getModel() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public PropertyEditor findEditor(String field, Class<?> valueType) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void addError(ObjectError error) {
				// TODO Auto-generated method stub
				
			}
		};
		return bindingResult;
	}
	
	private Model createMockModel(){
		Model model = new Model() {
			
			public Model mergeAttributes(Map<String, ?> attributes) {
				return null;
			}
			
			public boolean containsAttribute(String attributeName) {
				return false;
			}
			
			public Map<String, Object> asMap() {
				return null;
			}
			
			public Model addAttribute(String attributeName, Object attributeValue) {
				return null;
			}
			
			public Model addAttribute(Object attributeValue) {
				return null;
			}
			
			public Model addAllAttributes(Map<String, ?> attributes) {
				return null;
			}
			
			public Model addAllAttributes(Collection<?> attributeValues) {
				return null;
			}
		};
		return model;
	}
}
