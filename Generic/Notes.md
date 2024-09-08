### 1.What is Generic ,from which version this feature is availble?
-  Generic is a Java 5v new Feature

### 2.Why generic ?
- It is used for providing type-safe information to the compiler
- By Using generic feature we can inform to compiler the type of objects we want to store in a collection object with type-safety
- by using generic feature we can inform to compiler the type of objects we want to store in collection object with type-safety
- by using generic we can create homogeneous collection

### How Generic?
```
class ClassName<generic parameter name>{
    
}
```
### Sample program?
    - without generic collection is heterogeneous
```
class ArrayList{
    void add(Object obj){}
    Object get(int index){}
}

 ArrayList a1=new ArrayList();  // heterogenous collections
  a1.add("a"); // allowed
  a1.add(5); //allowed
  String s1=a1.get(0);//not allowed
```
- with generic -> collection is homogeneous
```
class ArryList<E>{ // generic class -> common all data types
    void add(E e){}
    E get(int i){}
}
ArrayList<String> al1=new ArrayList<String>(); // homogeneous collection
al1.add("a");//allowed  // accept only String type
al1.add(5);// not allowed


ArrayList<Integer> al2=new ArrayList<String>(); // homogeneous collection
al2.add("a");//not allowed  // accept only Integer type
al2.add(5);// allowed
```

###  Compiler activaties?

  - 1.  It the method call ,itverfies wheather the method argument is matched with this object's  generic parameter type, if matched compiled,else compiler will throw error
  - 2. It performs type eraser
        It replaced generic parameter name with Object
   - 3. Hence Generic concept is not known to JVM.it is only know to only compiler
   - 4. so ,this feature is communication between developer and compiler

### What are the advantages of generic feature?
- we can specify the type of object allowed to store in collectionat the time compilation itself
- so that at
    - 1. at runtime we will not required to do casting
    - 2. we will not get ClassCastException
    - 3. we no need to use instanceof operator condition
    - 4. hence a program execution is fast
    - 5. we can avoid method overloading program become dynamic nature
- Basically generic feature is added to Java language
    - 1. for creating container type class for storing and retrieving different type of objects
    - 2. by avoid ClassCastException and instanceof operator usage
    - 2. and for simplifying collection programming
    

### where can we generic?
- we can use generic syntax with
    - 1. with interface
    - 2. with class
    - 3. with method (static and non static method)


### Basically generic is used for preparing conatiner kind of class for storing differenet type of values and objects
- Solution - generic interface with lambda expression,refer Java 8v new Features

### Creating Generic interface,Generic class,Generic method?
- creating interface - used for Arithmetic operation and containerization or Storing Object
- Generic class - containerization or Storing Object
- Generic Method -containerization or Storing Object
```
interface Example<T>{
    //generic interface
}

class Sample<T>{
    //generic class
}

class Test{
    <T> void m1(T t1){} // non- static generic method
    static <T> void m2(T t2) // static generic method
}


class A<T>{
void m1(T t){} // method with class generic parameter name
    
<T> void m2(T t){} //generic method ,class generic type is not applied

static <T> void m3(T t){} //generic method ,class generic type is not applied
    
    
}

class A<T> {
	void m1(T t) {
		// method with class generic
		System.out.println("m1 "+t);
	}

	<T> void m2(T t) {
		// generic method, class generic type is not applied
		System.out.println("m2 "+t);
	}

	static <T> void m3(T t) {
		// generic method, class generic type is not applied
		System.out.println("m3 "+t);
	}
	
	<U> void m4(T t,U u) {
		// generic method, class generic type is not applied
		System.out.println("m4 "+t+" U "+u);
	}
	
	/*static <U> void m4(T t,U u) {
		// generic method, class generic type is not applied
		System.out.println("m4 "+t+" U "+u);// compiler throw error because T is class generic type not allowed 
	}*/

}

```

### Generic Inheritance
```
/**
	 * ? is called wild character
	 * Solution of above problem we must defined a method to make shape all objects
	 * shape or its sub class
	 * - we can specify Boundaries by using extends and super
	 * 1. ? extends Shape -> allowed shape or its sub class objects
	 * 2. ? super Shape  -> allowed shape or its super objects
	 */
```
