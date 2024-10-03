package day1;

//Inheritance:subclass will inherit those public member from superclass
//public class SubClass extends SuperClass{}
public class Chinese extends Human{
	//override:Subclass overwrite the method from SuperClass
	@Override
	public void eat() {
		System.out.println("Chinese eat with chopsticks");
	}
	
}
