package day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test2 {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("hello","world","hey","hi","hola");
//		List<Integer> lengthList = new ArrayList<Integer>();
//		for(String x:list) {
//			lengthList.add(x.length());
//		}
//		
//		for(Integer x:lengthList) {
//			System.out.println(x);
//		}
		
		
		
		
		// TODO Auto-generated method stub
//		Function:check T,get a value based the algorithm of T -> R
//		Consumer:using T to do something
//		Predicate:using T to make decision, return true/false
//		Supplier:take no input, return something
		
		Function<String, Integer> fun2 = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String t) {
				// TODO Auto-generated method stub
				return t.length();
			}
		};
		
		//return the length of a String
		Function<String, Integer> fun = x->x.length();
//		System.out.println(fun.apply("hello world"));
		
		//Stream
		//map: check every element, get new values based on those element, make them into a new stream
//		Stream s1 = list.stream().map(fun);	//Function	
//		s1.forEach(x->System.out.println(x));
		
		Consumer<Integer> con = x->System.out.println(x);
//		con.accept(199);
		
//		s1.forEach(con);		//Consumer
		
		
//		Consumer<String> con2 = x->System.out.println(x);
		Consumer<String> con2 = new Consumer<String>() {
			
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
//		list.stream().forEach(con2);
		list.stream().forEach(System.out::println);
		
//		Stream<String>
		
		List<Person> l = List.of(new Person(11),new Person(22),new Person(44),new Person(33),new Person(55),new Person(66));
		l.stream().mapToInt(Person::getAge).forEach(System.out::println);
	}

}



class Person{
	int age;
	Person(int age){
		this.age = age;
	}
	public int getAge() {
		return age;
	}
}







