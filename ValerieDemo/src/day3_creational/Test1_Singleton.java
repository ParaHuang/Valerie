package day3_creational;

import java.util.Calendar;

public class Test1_Singleton {

	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		s1.showMessage();

		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		System.out.println(calendar1);
		System.out.println(calendar2);
	}

}

class Singleton{
	//1.declare a private static reference of this class
	private static Singleton instance;
	
	//2.make constructor private
	private Singleton() {}
	
	//3.supply an global visit point to get access to the instance
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	public void showMessage() {
		System.out.println("hello , singleton message");
	}
}
