import java.util.ArrayList;
import java.util.List;

class Shape {
	void area() {
		System.out.println("Area from executed from shape");
	}
}

class Rectangle extends Shape {
	@Override
	void area() {
		System.out.println("Area from executed from rectangle");
	}
}

class Sequre extends Shape {
	@Override
	void area() {
		System.out.println("Area from executed from sequre");
	}
}

class Circle extends Shape {
	@Override
	void area() {
		System.out.println("Area from executed from circle");
	}
}

public class Test_Generic_With_Inheritance {
	public static void main(String[] args) {
		Shape s1 = new Rectangle();
		s1.area();
		//==================
		ArrayList<Shape> al1=new ArrayList<Shape>();
		al1.add(new Shape());
		al1.add(new Rectangle());
		al1.add(new Sequre());
		al1.add(new Circle());
		
		System.out.println(al1);
		
		//===============================
		List<Shape> list1=new ArrayList<Shape>();
		
		/**
		 * In Below Example showing error because Object is new ArrayList<Rectangle>();
		 * this can store or hold Shape Object and It Sibling Object so Compiler
		 * Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
		 *	Type mismatch: cannot convert from ArrayList<Rectangle> to List<Shape>
		 */
//		List<Shape> list2=new ArrayList<Rectangle>();
//		list2.add(new Shape());
//		list2.add(new Rectangle());
//		list2.add(new Sequre());
//		list2.add(new Circle());
		//list2.add("abc");
		//================================
		
		m2(new ArrayList<Shape>());
		m2(new ArrayList<Rectangle>());
		m2(new ArrayList<Sequre>());
		m2(new ArrayList<Integer>());
		m2(new ArrayList<String>());
		
		m3(new ArrayList<Shape>());
		m3(new ArrayList<Rectangle>());
		m3(new ArrayList<Sequre>());
//		m3(new ArrayList<Integer>());
//		m3(new ArrayList<String>());
		
		m4(new ArrayList<Shape>());
//		m4(new ArrayList<Rectangle>());
//		m4(new ArrayList<Sequre>());
//		m4(new ArrayList<Integer>());
//		m4(new ArrayList<String>());
		
	}
	
	/**
	 * ? is called wild character
	 * Solution of above problem we must defined a method to make shape all objects
	 * shape or its sub class
	 * - we can specify Boundaries by using extends and super
	 * 1. ? extends Shape -> allowed shape or its sub class objects
	 * 2. ? super Shape  -> allowed shape or its super objects
	 */
	static void m2(ArrayList<?> s) {
		//ArrayList of any type
		
	}
	
	static void m3(ArrayList<? extends Shape> s) {
		//wild card with shape and sub class boundaries
		
	}
	
	static void m4(ArrayList<? super Shape> s) {
		//wild card with shape and sub class boundaries
		
	}
}

