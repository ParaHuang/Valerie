package day3_creational;


public class Test4_Abstract_Factory {

	public static void main(String[] args) {
		System.out.println("=======build up an ios app");
		ProduceFactory factory1 = new IOSFactory();
		UIController ui1 = factory1.createUIController();
		OperationController op1 = factory1.createOperationController();
		KeyBoardController key1 = factory1.createKeyBoardController();
		ui1.display();
		op1.controlling();
		key1.typing();

		System.out.println("=======build up an android app");
//		ProduceFactory factory1 = new AndroidFactory();
//		UIController ui1 = factory1.createUIController();
//		OperationController op1 = factory1.createOperationController();
//		KeyBoardController key1 = factory1.createKeyBoardController();
//		ui1.display();
//		op1.controlling();
//		key1.typing();
		
		
	}

}


// application					
//abstract product				Iphone						Android
//UIController					IOSUIController				AndroidUIController
//OperationController			IOSOperationController		xxxx
//KeypadController				xxxx						xxxx	

//4 roles
//Abstract Products
//concrete product

//abstract factory
//concrete factory

interface UIController{
	void display();
}

interface OperationController{
	void controlling();
}

interface KeyBoardController{
	void typing();
}

//ISO
class IOSUIController implements UIController{

	@Override
	public void display() {
		System.out.println("displaying an app interface in IOS");
	}
	
}

class IOSOperationController implements OperationController{

	@Override
	public void controlling() {
		System.out.println("controlling an app in IOS");
	}
	
}

class IOSKeyBoardController implements KeyBoardController{

	@Override
	public void typing() {
		System.out.println("typing in ISO app");
	}
	
}

//Android
//create 2 concrete products related to Android

interface ProduceFactory{
	UIController createUIController();
	OperationController createOperationController();
	KeyBoardController createKeyBoardController();
}

class IOSFactory implements ProduceFactory{

	@Override
	public UIController createUIController() {
		// TODO Auto-generated method stub
		return new IOSUIController();
	}

	@Override
	public OperationController createOperationController() {
		// TODO Auto-generated method stub
		return new IOSOperationController();
	}

	@Override
	public KeyBoardController createKeyBoardController() {
		// TODO Auto-generated method stub
		return new IOSKeyBoardController();
	}
	
}

//create a concrete factory , which produce all android related products




















