
public class Test_Generics {

	public static void main(String[] args) {
		/**
		 * we can create object of generic class without passing generic parameter type
		 * then compiler gives a waring "RAW Type" then method parameter will be
		 * 'Object'
		 */
		Addition a1 = new Addition();
		a1.add(10, 20);
		a1.add(10.5, 20.5);
		a1.add("a", "b");

		Addition<Integer> a2 = new Addition<>();
		a2.add(10, 20);
		// a2.add(10.5, 20.5);
		// a2.add("a", "b");

		Addition<Double> a3 = new Addition<>();
		// a3.add(10, 20);
		a3.add(10.5, 20.5);
		// a3.add("a", "b");

		Addition<String> a4 = new Addition<>();
		// a4add(10, 20);
		// a4.add(10.5, 20.5);
		a4.add("a", "b");

		// =====================
		// Using lambda expression to add two integers
		Adder<Integer> addIntegers = (num1, num2) -> num1 + num2;
		System.out.println("Sum of integers: " + addIntegers.add(10, 20));

		// Using lambda expression to add two doubles
		Adder<Double> addDoubles = (num1, num2) -> num1 + num2;
		System.out.println("Sum of doubles: " + addDoubles.add(5.5, 2.3));

		// Using lambda expression to add two floats
		Adder<Float> addFloats = (num1, num2) -> num1 + num2;
		System.out.println("Sum of floats: " + addFloats.add(4.5f, 3.2f));

		// =================
		DataStoringClass<Integer> storingClass = new DataStoringClass<>();
		storingClass.setValue(10);
		System.out.println("" + storingClass);

		// =========================
		Add.add(10, 20);
		Add.add(10.5, 20.5);
		// =======================

		Sub<Integer> sub = (t1, t2) -> System.out.println(t1 - t2);
		sub.sub(20, 10);

		Sub<Double> doubleSub = (t1, t2) -> System.out.println(t1 - t2);
		doubleSub.sub(20.0, 10.0);
		
		//===========================
		
		A<Integer> aa1=new A<>();
		aa1.m1(10);
		aa1.m2(10);
		A.m3(10);
	}
}

/*
 * class Addition{ void add(int a,int b) { System.out.println(a+b); } }
 */

/**
 * method overloading feature makes program static nature code,because every
 * time we must define new overloaded methods with new parameters
 */

/*
 * class Addition{ void add(int a,int b) { System.out.println(a+b); }
 * 
 * void add(double a,double b) { System.out.println(a+b); }
 * 
 * void add(String a,String b) { System.out.println(a+b); } }
 */

class Addition<T> {

	void add(T t1, T t2) {
		// System.out.println(t1+t2);
	}
}

class DataStoringClass<T> {
	private T value;

	public void setValue(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "" + value;
	}

}

class Add {
	// Generic Method
	static <T> void add(T t1, T t2) {
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t1 == t2);
		// System.out.println(t1+t2);
		// limitation of generic types
		// we can't perform Arithmetic calculations because the argument type can be
		// non number primitive type also
	}
}

//generic interface
interface Sub<T> {
	void sub(T t1, T t2);
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