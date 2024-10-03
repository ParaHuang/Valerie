package day1;

public class American extends Human {
	@Override
	public void eat() {
		System.out.println("American eat pizza");
	}
}


//inheritance chain
//class A {}	//->Object
//class B extends A{}
//class C extends B{}
//class D extends C{}