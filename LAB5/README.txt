--------------------
*****COMPULSORY*****
--------------------
+ We created those classes by using the right syntax, and the class that is responsable with external operations regarding a catalog is the CatalogUtil.

+I have created them in the following way:
	- add: using put in that map
	- toString: @Overriding the method toString
	- save: saving it in nonbinary way , but also binary -> to have both of them there
	- load: loading it in the same ways like "save"

------------------
*****HOMEWORK*****
------------------
+ Created many classes that are subclasses of the abstract class Command ;
	- list: a for through docs of the catalog class
	- view: we use the Desktop class to open it and seeing it
	- report: the configuration of the freemarker ; creating the path to the document .ftlh that i am using; saving it in html so it can be opened in browser;

+ Just created them using extends Exception and using controllers in main code (checking using ifs), then if it is not ok, we create the exception: 

Exception e = new Exception("Nonexistent catalog (null)");
            throw new InvalidCatalog(e);

+created it by following a tutorial from netbeans

---------------
*****BONUS*****
---------------
+ 