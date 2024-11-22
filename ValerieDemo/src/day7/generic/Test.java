package day7.generic;

public class Test {
	public static void main(String[] args) {
		//generic class
		/*
		//what that generic will be, depends on the moment when you initialize it
		Box<Integer> box = new Box<>();
		box.setValue(11);
		Integer o =  box.getValue();
		o++;
		System.out.println(o);
		
		Box<String> box2 = new Box<>();
		box2.setValue("hello");
		*/
		
		
		//generic methods
		/*
		GenericTest<Integer> test1 = new GenericTest<>();
		test1.show1(12);
//		test1.show("hello");
		test1.<String>show2("hello");
		
		
		Person person = new Person();
		GenericTest<Person> test2 = new GenericTest<>();
		test2.show1(person);
//		test2.show1(12);
		test2.<Integer>show2(234);
		test2.<String>show2("hola");
		test2.show2(3.14);
		test2.show3(1);
		test2.show3(1.45);
		test2.show3(1.3f);
		
		Apple apple = new Apple();
		test2.show4(apple);
		
		BananaMan bm = new BananaMan();
		test2.show5(bm);
		test2.show4(bm);
		*/
		
		//wildcard character
		GenericTest<Integer> test1 = new GenericTest<>();
		
		Box<Number> box = new Box<>(12);
		test1.showValue(box);
		
		Box<Integer> box2 = new Box<>(34);
		test1.showValue(box2);
		
//		Box<String> box3 = new Box<>("hello");
//		test1.showValue(box3);
		
		
	}
}

//1.define generic
//2.use it
class Box<T>{
	T value;
	
	public Box(T value) {
		this.value = value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
}

class Person{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person";
	}
}

interface Fruit{
	
}
class Apple implements Fruit{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Apple";
	}
}

class BananaMan extends Person implements Fruit{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Banana Man";
	}
}

//generic class
class GenericTest<T>{
	
//	public void showValue(Box<Number> box) {
//		System.out.println("the value of this box is:"+box.getValue());
//	}

//	public void showValue(Box<Integer> box) {
//		System.out.println("the value of this box is:"+box.getValue());
//	}
	//wild case
	public void showValue(Box<? extends Number> box) {
		System.out.println("the value of this box is:"+box.getValue());
	}
	//normal methods, it only allows the parameter which is the instance of the generic defined in class
	public void show1(T t) {
		System.out.println(t);
	}
	
	//generic method:only know the generic type when you using the method
	//it only allows all kinds of the parameter 
	public <E> void show2(E t) {
		System.out.println(t);
	}

	//it only allows the parameter which is the instance of Number
	public <E extends Number> void show3(E t) {
		System.out.println(t);
	}
	
	//it only allows the parameter which is the instance of fruit
	public <E extends Fruit> void show4(E t) {
		System.out.println(t);
	}
	
	//for show5, it only allows the parameter which is the instance of Person and Fruit at the same time
	public <E extends Person & Fruit> void show5(E t) {
		System.out.println(t);
	}
	
}

class A{}
class B{}
//single inheritance
class C extends A{}
interface D{}
interface E{}
class F extends A implements D,E{}




























