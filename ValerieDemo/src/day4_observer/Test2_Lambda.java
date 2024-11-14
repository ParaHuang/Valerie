package day4_observer;

public class Test2_Lambda {
	public static void main(String[] args) {
		MyFunctionalInterface my1 = new MyFunctionalInterface() {
			
			@Override
			public void fun1() {
				System.out.println("My --------1");
			}
		};
		my1.fun1();
		
		MyFunctionalInterface my2 = ()->{
			System.out.println("My------2");
		};
		my2.fun1();
		
		//1.if there is only 1 sentence about operations, then omit {}
		MyFunctionalInterface my3 = ()->System.out.println("My------3");
		my3.fun1();
		
		//2.the only one operation is return a value, then write value directly after ->
		FunctionalInterfaceWithValueReturn f4 = ()->3;
		System.out.println(f4.fun1());
		
		
		//3.when there is only 1 parameter, you can omit ()
		FunctionalInterfaceWithOneParam f5 = x -> x*x;
		System.out.println(f5.fun1(10));
		
		
//		FunctionalInterfaceWithTwoParam f6 = (x,y) -> x+y;
//		System.out.println(f6.fun1(10,"hello"));
		
		/*
		(parameters) -> {
			operations
		}
		
		==
		
		new InterfaceName() {
			@Override
			public void methodName(parameters) {
				operations
			}
		}
		
		*/
		
	}
}

interface MyFunctionalInterface{
	void fun1();
}

interface FunctionalInterfaceWithValueReturn{
	int fun1();
}

interface FunctionalInterfaceWithOneParam{
	int fun1(int x);
}

interface FunctionalInterfaceWithTwoParam{
	String fun1(int x,String y);
}

class A implements MyFunctionalInterface{

	@Override
	public void fun1() {
		System.out.println("AAAAAAAAA");
	}
	
}