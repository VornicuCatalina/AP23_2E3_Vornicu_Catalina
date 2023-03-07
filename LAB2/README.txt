--------------------
*****COMPULSORY*****
--------------------
+ I created 2 public classes in a package, using "public class <name>"
	The enums are written this way: public enum <name>{}
+ A constructor is created using "public <name>(parameters){}"
	Getters were written like 
"public <type> get<Name variable>()
{
return <variable>;
}"


	Setters were written like: 
"public void set<Name variable>(<type> <name>)
{ 
this.<name variable>=<name>;
}"

+ Used 
"@Override public String toString()
{ 
return <stuff>;
}"

+ Created instances using the keyword "new"
------------------
*****HOMEWORK*****
------------------
+ Using Location[] & Road[]
+ I used @Override equals(Obejct o) ; for checking that i used 2 functions that verify the "equality" of those objects
+ Location became abstract and in those subclases added "extends Location"
+ To verify the instance of the problem, we need to figure out if: the locations exist && the distance between them is the correct one 
	For locations there are not any restrictions, just checking if they were created before
+ The algorithm could be a basic one such as: every single time to find the route from one another ; more complex that uses linked lists, for finding everything faster
BUT i used another idea; for every location , it will be turned into a value (the value from their string) ; and i will work with a matrix that will solve all the stuff:
	-firstly, it will add the 1 values to the indexes where there is a connection (obvious from the road, its neighboors) 
	-secondly, it will add the other inductive connections so the search will be must faster

---------------
*****BONUS*****
---------------
+ 