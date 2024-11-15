package day5;

public class Test1 {
	public static void main(String[] args) {
		MyInterface mi1 = new MyInterface() {
			
			@Override
			public int changeStringIntoInt(String str) {
//				return Integer.parseInt(str);
//				return MathOperator.makeDouble1(str);
				return new Integer(str);
			}
		};
		int num1 = mi1.changeStringIntoInt("109");
		System.out.println(num1);
		
//		MyInterface mi2 = (parameters)->{method body};
		MyInterface mi2 = str -> Integer.parseInt(str);
		System.out.println(mi2.changeStringIntoInt("889"));
		
		MyInterface mi3 = Integer::parseInt;
		System.out.println(mi3.changeStringIntoInt("222"));
		
		MyInterface mi4 = MathOperator::makeDouble1;
		System.out.println(mi4.changeStringIntoInt("5"));

		//MyInterface mi4 = MathOperator::makeDouble;		//✅
		//MyInterface mi4 = MathOperator::makeDouble2;		//❌
		//MyInterface mi4 = MathOperator::makeDouble3;		//❌
		MathOperator math = new MathOperator();
		MyInterface mi5 = math::makeTriple;
		System.out.println(mi5.changeStringIntoInt("5"));
		
		MyInterface mi6 = Integer::new;
		System.out.println(mi6.changeStringIntoInt("89"));
	}
}

interface MyInterface{
	int changeStringIntoInt(String str);			//"5"->5
}

class MathOperator{
	public static int makeDouble1(String str) {
		int num = Integer.parseInt(str);
		return num*2;
	}
	public static void makeDouble2(String str) {
		int num = Integer.parseInt(str);
		System.out.println(num*2);
	}
	public static double makeDouble3(String str) {
		int num = Integer.parseInt(str);
		return num*2;
	}
	
	public int makeTriple(String str) {
		int num = Integer.parseInt(str);
		return num*3;
	}
}


//method reference:
//get an instance of a functional interface
//the only code of method body is using a method of the other class
//a. if this abstract method of functional interface has a return type
//then the method you are calling has to be in same format as that abstract method
//b. if this abstract method of functional interface is void
//the method you are calling only need has the same format of parameters


//1.	static method		ClassName::methodName
//2.	instance method		instance::methodName
//3.	constructor			ClassName::new




