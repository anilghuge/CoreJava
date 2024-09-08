package com.example.streamoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
	public static void main(String[] args) {
		/*
		 count() :long count()
		 	Q]When to use count( )? 
			=>When you want to determine the number of elements in a finite stream
		*/
		Stream<String> s = Stream.of("Cow", "Tiger", "Elephant");
		System.out.println(s.count());
		System.out.println();
		
		/*
		 min() and max() :
		 					Optional<T> min(<? super T> comparator)
                              Optional<T> max(<? super T> comparator)
                 
               Q]When to use min( ) and max( )?
               =>when you want to find the smallest or largest value in a finite stream. 
               As the method signature represents, the min() and max() methods allow us to pass a custom comparator and
               find the smallest or largest value in a finite stream according to that sort order. 
               Like count(), min() and max() works on a finite stream. Also like count(), 
               both methods are reductions because they return a single value after looking at the entire stream. 
		 */
		Stream<String> s1 = Stream.of("Java", "Python", "Scala");
		Optional<String> min=s1.min((s3,s4)->s3.length()-s4.length());
		min.ifPresent(System.out::println); 
		
		/*
		 findAny( ) and findFirst( ) :: Optional<T> findAny()
                              			Optional<T> findFirst()
                              			
                Q]When to use findAny() and findFirst()? 
				=>You wish to find the first element in a stream that satisfies a particular condition then use findFirst(). 
				The findFirst() and findAny() methods in Stream return an Optional describing the first element of a stream. 
				Neither takes an argument, implying that any mapping or filtering operations have already been done.

				The findAny() method returns an Optional describing some element of the stream,
				 or an empty Optional if the stream is empty. In a non-parallel operation, 
				 findAny() will most likely return the first element in the Stream, but there is no guarantee for this.
				  For maximum performance when processing the parallel operation, the result cannot be reliably determined.
		 */
		Optional<Integer> firstEvenNumber = Stream.of(9, 5, 8, 7, 4, 9, 2, 11, 3)
                .filter(n -> n % 2 == 0)
                .findFirst();
			System.out.println(firstEvenNumber.get());
		
			Optional<Integer> firstNumberDivisibleBy5 = Stream.of(9, 5, 8, 7, 4, 9, 2, 11, 10, 3)
                    .filter(n -> n > 10)             
                    .filter(n -> n % 5 == 0)    //empty stream in this line
                    .findFirst();
			System.out.println(firstNumberDivisibleBy5);
			
		/*
		 anyMatch( ), allMatch( ), and noneMatch( )
			 boolean anyMatch(Predicate <? super T> predicate)
			boolean allMatch(Predicate <? super T> predicate)
			boolean noneMatch(Predicate <? super T> predicate) 
			
			Q]When to use anyMatch( ), allMatch( ), and noneMatch( )? 
			=>When you wish to determine if any elements in a stream match a Predicate, 
			or if all match, or if none match, then use the methods anyMatch(), allMatch(), 
			and noneMatch() respectively.
		 */
		
			List<String> listOfSkills = Arrays.asList("Core Java", "Spring Boot", "Hibernate", "Angular"); 

			Predicate<String> pred = x -> x.startsWith("S"); 
			System.out.println(listOfSkills.stream().anyMatch(pred));         // true 
			System.out.println(listOfSkills.stream().allMatch(pred));         // false 
			System.out.println(listOfSkills.stream().noneMatch(pred));        // false
			/*
			 The above program shows that we can reuse the same predicate, but we need a different stream each time. 
			 anyMatch() returns true because one of the four elements match. allMatch() 
			 returns false because three of them doesn’t match.
			  noneMatch() also returns false because one matches.
			 */
			
			/*
			 forEach() :void forEach(Consumer<? super T> action)
			 
			 When to use forEach( )? 
			 =>Needless to mention, when we want to iterate the elements of a stream.
			  Notice that this is the only terminal operation with a return type of void. 
			  Moreover, note that you can call forEach() directly on a Collection or on a Stream. 
			  Stream API in Java 8 cannot use a traditional for loop to run because they don’t implement the Iterable interface.
			 */
			Stream<String> streamofSkills = Stream.of("Java", "Python", "Angular");
			 streamofSkills.forEach(System.out::println);
			 System.out.println();
			/*
			 collect( ) :
			 	Please note that the collect() method doesn’t belong to the Collector class. 
			 	It is defined in Stream class and that’s the reason you can call it on Stream after 
			 	doing any filtering or mapping operations. However, 
			 	it accepts a Collector to accumulate elements of Stream into a specified Collection.
					
				Furthermore, the Collector class provides various methods like 
				toList(), toSet(), toMap(), and toConcurrentMap() to collect
				 the result of Stream into List, Set, Map, and ConcurrentMap respectively. 
				 Additionally, it also provides a special toCollection() method that 
				 we can use to collect Stream elements into a specified Collection 
				 like ArrayList, Vector, LinkedList, HashSet etc.
				 
				 <R> R collect(Supplier<R> supplier,  BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner)
				  <R, A> R collect(Collector<? super T,  A, R> collector)
				  
				 Q]When to use collect()? 
				 =>Most of the time, when you want to convert a stream back to a Collection 
				 which you got after applying various operations such as filter(), map() etc. 
				 It allows you to accumulate the result into a choice of containers you want like a list, set, map etc.
			 */
			 
			 Stream<String> streamOfSkills = Stream.of("Java", "Scala", "Python", "Spring");
			 streamOfSkills
			    .filter(x -> x.startsWith("S"))
			    .collect(Collectors.toList())     //Collecting the result of a stream into a List
			    .forEach(System.out::println);
			 System.out.println();
			 
			 Stream<String> streamOfSkills1 = Stream.of("Java", "Scala", "Python", "Spring");

			 streamOfSkills1
			 .filter(x -> x.length() > 3)
			 .collect(Collectors.toCollection(ArrayList::new))    //Collecting the result of a stream into a List of our choice
			 .forEach(System.out::println);
			 
			 /*
			  reduce() :The reduce() method combines a stream into a single object. As we can tell from the name, it is a reduction.
			 		T reduce(T identity, BinaryOperator<T> accumulator)
			 		Optional<T> reduce(BinaryOperator<T> accumulator)
			 		<U> U reduce(U identity,  BiFunction<U, ? super T, U> accumulator,BinaryOperator<U> combiner)
			 		
			 		Identity: An element that is the initial value of the reduction operation and the default result if the stream is empty

					Accumulator:  A function that takes two parameters: a partial result of the reduction operation and the next element of the stream

					Combiner: A function that we use to combine the partial result of the reduction operation 
					when the reduction is parallelized or when there’s a mismatch between the types of the accumulator arguments 
					and the types of the accumulator implementation
					
				Q]When to use reduce( )?
				=>When you wish to produce one single result from a sequence of elements, by repeatedly applying a 
					combining operation to the elements in the sequence.
			  */
			 List<String> letters = Arrays.asList("j", "a", "v", "a", "t", "e", "c", "h", "o", "n", "l", "i", "n", "e"); 
			 String result = letters .stream()
			     .reduce(" ", (partialString, element) -> partialString + element);
			 System.out.println(result);
			 /*
			  In the example above, ” ” is the identity. It indicates the initial value of the reduction operation and also
			   the default result when the stream of String values is empty.
			   Likewise, the lambda expression “(partialString, element) -> partialString + element” is the accumulator 
			  as it takes the partial concatenation of String values and the next element in the stream.
			  */
			 /*
			  Of course, we can also change it to the expression that uses a method reference like as below using Stream API in Java 8:
			  */
			 String result1 = letters.stream().reduce(" ", String::concat);
			 System.out.println(result1);

			 /*
			  Likewise, let’s observe an example of Stream of Integers as below using Stream API in Java 8:
			  */
			 BinaryOperator<Integer> op = (a, b) ->a * b; 
			 Stream<Integer> empty = Stream.empty(); 
			 Stream<Integer> oneElement = Stream.of(3); 
			 Stream<Integer> threeElements = Stream.of(3, 4, 5); 
			 empty.reduce(op).ifPresent(System.out::print); // no output 
			 oneElement.reduce(op).ifPresent(System.out::print); // 3 
			 threeElements.reduce(op).ifPresent(System.out::print); // 60
	}
}
