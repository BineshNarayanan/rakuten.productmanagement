# rakuten.productmanagement

Note : Please create a database with the scripts of the table in folder DBScripts. If the database connection fails the test also fails, else choose to skip tests.

This project is implemented using Spring MVC, Hibernate, Bootstrap framework on UI, Maven for artifact build.

Once deployed the login url would be http://MACHINENAME:PORT/productmanagement

By default two users 
1. rakuten (pwd:123456)
2. SUPERUSER (pwd:123456).

As the name suggests SUPERUSER is the user who has complete access to add, edit and delete product. The user rakuten has view only access.

The connection properties are available in jdbc.properties in productmanagement-persistence module.

3 types of Sorting is being implemented. Hook for adding ProductFilter is being provided which can be taken up as improvement.

Improvements foreseen:
1. Templatisation of JSPs
2. currently the css is inline it can be separated.
3. Better logging.
4. ProductFilter implementation.
5. Better validation on UI.


