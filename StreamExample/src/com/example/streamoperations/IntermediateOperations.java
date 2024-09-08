package com.example.streamoperations;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.example.createstream.Programmer;

public class IntermediateOperations {
	public static void main(String[] args) {
		/*1)filter():Stream<T> filter(Predicate<? super T> predicate)
			
			Q]When to use filter()? 
			=>If you want to return a stream from another stream that 
				satisfies a given condition.
		*/
		Stream<String> s1=Stream.of("lion", "cat", "monkey", "cow", "horse");
		s1.filter(x->x.startsWith("c")).forEach(System.out::println);
		System.out.println();
		/*
		 2)distinct():Stream<T> distinct()
		 
		 	Q]When to use distinct()? 
		 	=>If you want to return a stream from another stream with duplicate 
		 		values removed.
		 */
		Stream<String> s2 = Stream.of("cat", "cat", "monkey", "cow", "cat");
		s2.distinct().forEach(System.out::println);
		System.out.println();
		
		/*
		 3) limit() and skip()
		 	Stream<T> limit(int maxSize)
            Stream<T> skip(int n)
            
            Q]When to use limit( ) and skip( )? 
			=>If you want to make your stream smaller. 
			Also, if you want to make a finite stream out of an 
			infinite stream.
		 */
		Stream<Integer> s = Stream.iterate(1, n -> n + 1);
		s.skip(9).limit(6).forEach(System.out::println);
		System.out.println();
		
		/*
		4)map() vs flatMap() :
		 				<R> Stream<R> map(Function<? super T,? extends R> mapper)
		 				<R> Stream<R> flatMap(Function<? super T,? extends Stream<? extends R>> mapper)
		 				
		 	Q]When to use map( ) and flatMap( )? 
			=>	If you want to transform the elements of a stream in some way. 
				Use map() if you want to transform each element into a single value.
				Use flatMap() if you want to transform each element to multiple values 
				and also compress/flatten the resulting stream.
			
			Q]What is the difference between map( ) and flatMap( )? 
			=>	The additional word ‘flat’ in flatMap() method indicates the flattening, 
				which is the additional task done by flatMap(). 
				However below is the list of common differences between them.
				
				map():
					1) It works on stream of values.
					2) It performs the only transformation.
					3) It produces a single value for each input value.
				
				flatMap():
					1) It works on a stream of stream of values.
					2) It performs transformation as well as flattening.
					3) It produces multiple values for each input value.
		 */
		
				List<Programmer> listOfProgrammers = List.of(
			     new Programmer("Programmer1", List.of("Java", "Python", "Angular")),
			     new Programmer("Programmer2", List.of("Ruby", "Angular", "Java")),
			     new Programmer("Programmer3", List.of("React", "Spring", "Angular")));
				
				listOfProgrammers.stream().map(Programmer::getName).collect(Collectors.toList()).forEach(System.out::println);
				System.out.println();
				listOfProgrammers.stream().flatMap(p->p.getSkills().stream()).collect(Collectors.toSet()).forEach(System.out::println);
				System.out.println();
				
		/*
			sorted() :Stream<T> sorted() 
				 	  Stream<T> sorted(Comparator<? super T> comparator)
				 
				 Q]When to use sorted()? 
				 =>When we need to return a stream with the elements sorted. 
				   Just like sorting arrays, Java uses natural ordering unless we specify a comparator
				 */
				Stream<String> streamOfStrings = Stream.of("Sunday", "Monday", "Wednesday", "Friday");
				//streamOfStrings.sorted().forEach(System.out::println);
				System.out.println();
				streamOfStrings.sorted(Comparator.reverseOrder()).forEach(System.out::println);
				System.out.println();
				
		/*
		 peek() 
 				Stream<T> peek(Consumer<? super T> action)

				Q]When to use peek( )? 
				=>Sometimes we need to perform some operations on each element of the stream before any terminal operation is applied. 
					In fact, peek() performs the specified operation on each element of the stream and returns a new stream that we can further use. 
					It is useful for debugging because it allows us to perform a stream operation without actually changing the stream. 
					The most common use for peek() is to output the contents of the stream before any terminal operation is applied.
		 */
				
				IntStream.rangeClosed(0, 5)
			     .peek(n -> System.out.println("original element : " +n))         //prints value before multiplying by 3
			     .map(n -> n * 3)
			     .peek(n -> System.out.println("Tripled element : " +n))          //prints value before filtering
			     .filter(n -> n % 2 == 0)
			     .peek(n -> System.out.println("Divisible By 2 element : " +n))   //prints value after filtering but before summing
			     .sum();
	}
	public static<T> void display(Stream<T> s) {
		Iterator<?> i1=s.iterator();
		while(i1.hasNext()) {
			System.out.print(i1.next()+" ");
		}
		System.out.println();
	}
}
