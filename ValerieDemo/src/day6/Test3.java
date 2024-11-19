package day6;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test3 {

	public static void main(String[] args) {
		List<String> list = List.of("hello","hello world","java","lambda","method reference");

		Stream<Integer> s2 = list.stream().map(t->t.length());
		
		
		
//		1.
//		Consumer<String> consumer = new Consumer<String>() {
//			
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		};
//		list.stream().forEach(consumer);
		
		
//		2.
//		Consumer<String> consumer = t->System.out.println(t);
//		list.stream().forEach(consumer);
		
		
//		3.
//		list.stream().forEach(t->System.out.println(t));
		
		
//		4.
		list.stream().forEach(System.out::println);
		
		
		
		
		
		list.stream().forEach(System.out::println);
		
//		Consumer<Integer> consumer2 = System.out::println;
		
		s2.forEach(System.out::println);
		
		
		
		
		
	}

}
