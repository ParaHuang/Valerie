package day6;

public class Test1 {

	public static void main(String[] args) {
//		MyInterface mi1 = new MyInterface() {
//			
//			@Override
//			public void fun1(String str) {
//				System.out.println(str);
//			}
//		};
		
		//lambda 			(paramter1,parameter2)->{methods body}
		//Method reference  : the method format should be same as abstract method  
		
		//only lambda
		MyInterface mi1 = str->System.out.println(str);
		mi1.fun1("hello world");
		
		//lambda + method reference
		MyInterface mi2 = System.out::println;
		mi2.fun1("hello");
		
		
		
	}

}






interface MyInterface{
	void fun1(String str);
}




