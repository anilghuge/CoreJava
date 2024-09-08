package com.example.convertstreamtocollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
How to convert from a Stream to a Collection?
Example#1: Converting a Stream of strings to a List
Example#2: Converting a Stream of int to a List of Integer
Example#3: Converting an IntStream to an int array
*/
public class ConvertFromStreamToCollection {
	public static<T> void display(Collection<T> s) {
		Iterator<?> i1=s.iterator();
		while(i1.hasNext()) {
			System.out.print(i1.next()+" ");
		}
		System.out.println();
		
		s.stream().forEach(System.out::print);
	}
	public static void main(String[] args) {
		//Example #1:Converting stream of String to List
		List<String> streamString=Stream.of("this", "is", "a", "list", "of", "strings").collect(Collectors.toList());
		display(streamString);
		
		//Example#2: Converting a Stream of int to a List of Integer
			// 1.Using the boxed method : boxed() method converts int to Integer. We can use the boxed method on Stream to convert the IntStream to a Stream<Integer>
			List<Integer> streamInteger1=IntStream.of(1, 2, 3, 4, 5, 6).boxed().collect(Collectors.toList());
			display(streamInteger1);
			
			//2) Using the mapToObj method : The mapToObj() method converts each element from a primitive to an instance of the wrapper class
			List<Integer> streamInteger2=IntStream.of(1, 2, 3, 4, 5, 6).mapToObj(Integer::valueOf).collect(Collectors.toList());
			display(streamInteger2);
			
		//Example#3: Converting an IntStream to an int array
			int[] intArray1 = IntStream.of(1, 2, 3, 4, 5, 6).toArray();
			System.out.println(Arrays.toString(intArray1));
		
	}
}
