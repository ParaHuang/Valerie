package day6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class Test5 {

	public static void main(String[] args) {
		
		//Comparator
//		List<String> list = new ArrayList<String>();
//		list.add("hello");
//		list.add("Jack");
//		list.add("Amy");
//		list.add("Tom");
//		list.add("hola");
//		list.add("Alex");
//		
//		System.out.println(list);
//		Collections.sort(list);		//the default way to sort String is by letter
//		System.out.println(list);	

		//
		List<Student> list = new ArrayList<>();
		list.add(new Student("hello",10));
		list.add(new Student("Jack",20));
		list.add(new Student("Amy",27));
		list.add(new Student("Tom",14));
		list.add(new Student("hola",21));
		list.add(new Student("Alex",24));
		
		System.out.println(list);
//		Collections.sort(list,rule);
		Comparator<Student> rule = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
//				return str1.compareTo(str2);//'a'<'z'    'a'>'A'
//				return o1.getName().compareTo(o2.getName());
//				return o1.getAge()-o2.getAge();//ascending
				return o2.getAge()-o1.getAge();//descending
			}
		};
		
//		Collections.sort(list,rule);
//		list.sort(rule);
		list.sort((o1,o2)->o2.getAge()-o1.getAge());
		
		System.out.println(list);	
		
		//get the age of student out,make them into a stream , then print 1 by 1
		//Function<Student,Integer>
		Stream<Integer> sAge = list.stream().map(s->s.getAge());
		sAge.forEach(System.out::println);
		
		System.out.println();
		
//		list.stream().mapToInt(new ToIntFunction<Student>() {
//
//			@Override
//			public int applyAsInt(Student s) {
//				// TODO Auto-generated method stub
//				return s.getAge();
//			}
//		})
//			.forEach(System.out::println);
		
		list.stream().map(Student::getAge)
			.forEach(System.out::println);
		
		
		
	}
}

class Student{
	private String name;
	private int age;
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return age+"---"+name;
	}
	
}
