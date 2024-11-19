package day6;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
		//create R from T
//		Function<T, R>
		//give you a string, return a interger value (the length of string)
		Function<String, Integer> f = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return t.length();
			}
		};
		
//		int len = f.apply("hello");
//		System.out.println(len);
		
		Function<String, Integer> f2 = t->t.length();
//		System.out.println(f2.apply("hello world"));
		
		List<String> list = List.of("hello","hello world","java","lambda","method reference");
//		for(String s:list) {
//			System.out.println(f2.apply(s));
//		}
			
		//Stream
		//map(return a new Stream),need Function as parameter
		//Stream:a data structure with contains every element of a collection,we use it to access very element in this collection 1 by 1
		Stream<Integer> s2 = list.stream().map(f2);
		
		
		
		Consumer<String> consumer = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		
		consumer.accept("content");
		
		list.stream().forEach(consumer);
		Consumer<Integer> consumer2 = new Consumer<Integer>() {
			
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		};
		
		s2.forEach(consumer2);
		
		
		
		
		
	}

}
