package day2;

import java.util.ArrayList;
import java.util.List;

public class Client {

	public static void main(String[] args) {
		//create Student : leaf
		Student harry = new Student("Harry Potter");
		Student hermione = new Student("Hermione Granger");
		Student ron = new Student("Ron Weasley");
		
		Student cedric = new Student("Cedric Diggory");
		
		Student luna = new Student("Luna Lovegood");
		
		Student draco = new Student("Draco Malfoy");
		
//		harry.add(null);
//		harry.remove(null);
		
//		harry.display();
		
		//create House: composite
		House gryffindor = new House("Gryffindor");
		House hufflepuff = new House("Hufflepuff");
		House slytherin = new House("Slytherin");
		House ravenclaw = new House("Ravenclaw");
		
		//house can add
		gryffindor.add(harry);
		gryffindor.add(hermione);
		gryffindor.add(ron);
//		gryffindor.remove(ron);
//		gryffindor.display();
		
		hufflepuff.add(cedric);
		
		slytherin.add(draco);
		
		ravenclaw.add(luna);
		
		//school
		Hogwarts hogwarts = new Hogwarts();
		hogwarts.add(gryffindor);
		hogwarts.add(hufflepuff);
		hogwarts.add(slytherin);
		hogwarts.add(ravenclaw);
		
//		Student s1 = new Student("Mike");
//		hogwarts.add(s1);
		
		//show's the full structure of Hogwart
		hogwarts.display();
		
		
	}

}

//common operation:   add, remove, display  ->Component
//Hogwarts school:composite
//House:composite
//Student:leaf

abstract class HogwartsComponet{	//we are only forced to override the unimplemented methods
	void add(HogwartsComponet  componet) {
		throw new UnsupportedOperationException("Student can't add anything");
	}//this has method body, it's implemented
	
	void remove(HogwartsComponet componet) {
		throw new UnsupportedOperationException("Student can't remove anything");
	}
	abstract void display();
}


class Hogwarts extends HogwartsComponet{
	private List<HogwartsComponet> list = new ArrayList<>();

	@Override
	public void add(HogwartsComponet componet) {
		list.add(componet);
	}

	@Override
	public void remove(HogwartsComponet componet) {
		list.remove(componet);
	}

	@Override
	public void display() {
		System.out.println("Hogwarts School of Witchcraft and Wizardry:");
		for(HogwartsComponet c:list) {
			System.out.println();
			c.display();
		}
	}
	
	
}

class House extends HogwartsComponet{
	private String houseName;
	private List<HogwartsComponet> members = new ArrayList<>();
	
	public House(String housrName) {
		this.houseName = housrName;
	}
	
	@Override
	public void add(HogwartsComponet componet) {
		members.add(componet);
	}

	@Override
	public void remove(HogwartsComponet componet) {
		members.remove(componet);
	}

	@Override
	public void display() {
		System.out.println("This is House "+houseName);
		System.out.println("We have Student:");
		for(HogwartsComponet c:members) {
			c.display();
		}
	}
		
}

class Student extends HogwartsComponet{
	private String name;
	
	
	public Student(String name) {
		super();
		this.name = name;
	}

	@Override
	public void display() {
		System.out.println("This is "+name);
	}
}




















