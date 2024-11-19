package day6;

import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test4 {

	public static void main(String[] args) {
		//to see if a number is even or not
//		Predicate<Integer> predicate = new Predicate<Integer>() {
//			
//			@Override
//			public boolean test(Integer t) {
//				// TODO Auto-generated method stub
//				return false;
//			}
//		};
		
		Predicate<Integer> predicate = t->t%2==0;
		System.out.println(predicate.test(120));
		
		
		List<Integer> list = List.of(12,33,45,66,68,91,23);
		//pick out the element which suits for the Predicate
		Stream<Integer> evenStream = list.stream().filter(predicate);
		
		evenStream.forEach(System.out::println);
		
//		//Predicate, to see if a string starts with hi
//		Predicate<String> predicate2 = t->t.startsWith("hi");
//		boolean f = predicate2.test("Hi Jack");
//		System.out.println(f);
		
		List<String> list2 = List.of("hi jack","hey tom","hi~~~","Hi~~~");		
		
		list2.stream()
			.filter(t->t.startsWith("hi"))
			.forEach(System.out::println);
		
		/*
		 map   			->	Function
		 forEach		->  Consumer
		 filter			->  Predicate
		 */
		
		//use Supplier to get a random number, range:1~10
		Supplier<Integer> supplier = ()->new Random().nextInt(1, 11);
		int num1 = supplier.get();
		System.out.println(num1);
	}

}










