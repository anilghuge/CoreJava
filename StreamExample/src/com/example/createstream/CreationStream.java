package com.example.createstream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/*
 1) Using Stream.of() method 
  	static <T> Stream<T> of(T� values)
  	static<T> Stream<T> of(T t)
  	static<T> Stream<T> ofNullable(T t)
 2) Stream from a Collection using stream() & parallelStream() methods
 3) Stream from an Array using Arrays.stream()
 4)Stream.builder()
 5)Stream.empty()
 6)Stream.generate()
 7)Stream.iterate()
 8)Stream of a File
*/


public class CreationStream {
	public static<T> void display(Stream<T> s) {
		Iterator<?> i1=s.iterator();
		while(i1.hasNext()) {
			System.out.print(i1.next()+" ");
		}
		System.out.println();
	}
	
	public <T> void display1(Stream<T> s) {
		Iterator<?> i1=s.iterator();
		while(i1.hasNext()) {
			System.out.print(i1.next()+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("======================Stream.of() Start===============================");
		//Using Stream.of(T� values) method 
		Stream<Integer> s1=Stream.of(1,2,3,4,5);
		display(s1);
		System.out.println("------------------------");
		// Using Stream.of(T t) method
		Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		Stream<Integer> streamOfArrayOfIntegers = Stream.of(array1);
		display(streamOfArrayOfIntegers);
		System.out.println("------------------------");
		// Using Stream.ofNullable() method
		Integer[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9,null};
		Stream<Integer[]> streamOfNullableArrayOfIntegers=Stream.ofNullable(array2);
		Iterator<Integer[]> i1=streamOfNullableArrayOfIntegers.iterator();
		while(i1.hasNext()) {
			System.out.print(Arrays.toString(i1.next())+" ");
		}
		System.out.println();
		System.out.println("-------------------------");
		Stream<Integer> streamOfArrayOfInteger = Stream.ofNullable(null);
		display(streamOfArrayOfInteger);
		System.out.println("======================Stream.of() End===============================");

		System.out.println("======================stream() & parallelStream() Start==============================");
		List<String> list = Arrays.asList("https://","javatechonline", "dot", "com"); //creating a list
		//OR
		List<String> list1 = List.of("https://","javatechonline", "dot", "com"); //creating a list using of() of JDK 9

		Stream<String> streamofStrings = list.stream(); // creating a sequential stream (used most of the time)
		display(streamofStrings);
		System.out.println("-------------------------");
		Stream<String> streamofString = list1.parallelStream(); // creating a parallel stream
		display(streamofString);
			
		
		System.out.println("======================stream() & parallelStream() End==============================");
		
		System.out.println("======================Arrays.stream() Start==============================");
		String[] arr= new String[] { "a", "b", "c" };

		Stream<String> streamOfStrings = Arrays.stream(arr);
		display(streamOfStrings);
		System.out.println("======================Arrays.stream() End==============================");
		
		System.out.println("======================Stream.builder() Start==============================");
		Stream<Object> s4=Stream.builder().add("a").add("b").build();
		display(s4);
		
		Stream<String> s5=Stream.<String>builder().add("a").add("b").build();
		display(s5);
		System.out.println("======================Stream.builder() End==============================");
		
		System.out.println("======================Stream.empty() Start==============================");
		Stream<String>  emptyStream = Stream.empty();
		display(emptyStream);
		System.out.println("======================Stream.empty() End==============================");
		System.out.println("====================== Stream.generate() Start==============================");
		Random random = new Random();
		Stream<Integer> stream = 
                Stream.generate(
                  () -> {return random.nextInt(100);} // generating random numbers between 0 and 99
                ).limit(5);
		display(stream);
		System.out.println("====================== Stream.generate() End==============================");
		
		System.out.println("====================== Stream.iterate()Start==============================");
		Stream<Integer> streamOfOddNumbers = Stream.iterate(1, n -> n + 2).limit(5);
		display(streamOfOddNumbers);
		System.out.println("====================== Stream.iterate() End==============================");
		
		System.out.println("====================== Stream of a File Start==============================");
		try {
			Stream<String> streamOfString  = Files.lines(Paths.get("path"));
			streamOfString.forEach((line) -> System.out.println(line));          // Printing contents of the File
			streamOfString.close();
			//Stream<String> streamWithCharset = Files.lines(path, Charset.forName("UTF-8"));
			//streamWithCharset.forEach((line) -> System.out.println(line));
			//streamWithCharset.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  // Generating Stream from a File
		System.out.println("======================Stream of a File End==============================");
		
		System.out.println(CreationStream.class.getClassLoader());
	}
}
