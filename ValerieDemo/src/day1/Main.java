package day1;

//the entrance of program
public class Main {
	public static void main(String[] args) {
		/*
		//create an Object of Human -> instantiate
		//ClassName objectName = new ClassName();
		Human h1 = new Human("Jack",18,"male");	// Jack 18 male
		//.    ->    的
//		h1.name = "Jack";
//		h1.setName("Jack");
////		h1.age = -18;
//		h1.setAge(-18);
////		h1.gender = "male";
//		h1.setGender("male");
		
		h1.breath();
		h1.eat();
		
//		System.out.println(h1.getName());
		
		System.out.println("---------------");
		
		Human h2 = new Human("Alice",19,"female");	//Alice 19 female
		h2.breath();
		h2.eat();
//		h2.setAge(9);
		
		
		Chinese c1 = new Chinese();
		c1.eat();	//Chinese eat with chopsticks
		c1.breath();
		
		System.out.println();
		
		American a1 = new American();
		a1.eat();	//American eat pizza
		a1.breath();
	
		
		
		*/
		
		
		Human2 jack = new Human2("Jack",18,"male");	
//		System.out.println("Name:"+jack.getName());
//		System.out.println("Age:"+jack.getAge());
//		System.out.println("Gender:"+jack.getGender());
		System.out.println(jack);	//print the object, using the toString method automatically
		
		
		Human2 alice = new Human2("Alice",19,"female");
//		System.out.println("Name:"+alice.getName());
//		System.out.println("Age:"+alice.getAge());
//		System.out.println("Gender:"+alice.getGender());
		System.out.println(alice);
		
		/*
		 equals:  1.for String,to compare the content
		 2.for other Object, to compare the memory address
		 */

		String s1 = new String("hello");
		String s2 = new String("hello");
		System.out.println(s1.equals(s2));
		

		
		Human2 j = new Human2("Jack",18,"male");	
		System.out.println(jack.equals(j));	//
		
		
		
		
		
		
		
		
	}
}
