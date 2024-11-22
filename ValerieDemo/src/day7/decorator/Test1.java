package day7.decorator;

public class Test1 {

	public static void main(String[] args) {
		Beverage beverage = new Coffee();
		System.out.println(beverage.description()+",$"+beverage.cost());
		
		beverage = new Milk(beverage);
		System.out.println(beverage.description()+",$"+beverage.cost());
		
		beverage = new Chocolate(beverage);
		System.out.println(beverage.description()+",$"+beverage.cost());
		
//		beverage = new Coffee();
//		System.out.println(beverage.description()+",$"+beverage.cost());
		
//		beverage = new Milk(beverage);
//		System.out.println(beverage.description()+",$"+beverage.cost());
		
		System.out.println();
		
		Beverage tea = new Tea();
		System.out.println(tea.description()+",$"+tea.cost());
		
		tea = new Sugar(tea);
		System.out.println(tea.description()+",$"+tea.cost());
		
		tea = new Milk(tea);
		System.out.println(tea.description()+",$"+tea.cost());
		
		
		Beverage coffee = new Coffee(); 
	}

}

//Description				cost
//Coffee					3
//CoffeeWithMilk			4
//CoffeeWithSugar			3.5
//CoffeeWithMilkAndSugar	4.5
//Tea						2
//TeaWithMilk				3

//1.component:define the basic responsibilities 
//2.concrete component
//3.decorator:maintains a reference to a Component object,it defines the same responsibilities as component
//4.concrete decorator


interface Beverage{
	String description();
	double cost();
}

class Coffee implements Beverage{

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Coffee";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 3;
	}
}

class Tea implements Beverage{

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return "Tea";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}

abstract class CondimentDecorator implements Beverage{

}

class Milk extends CondimentDecorator{
	Beverage beverage;
	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String description() {
		// Coffee,Milk
		return beverage.description() + ",Milk";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+1;
	}
	
}

class Sugar extends CondimentDecorator{
	Beverage beverage;
	public Sugar(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return beverage.description()+",Sugar";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+0.5;
	}
	
}


class Chocolate extends CondimentDecorator{
	Beverage beverage;
	public Chocolate(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String description() {
		// TODO Auto-generated method stub
		return beverage.description()+",Chocolate";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return beverage.cost()+1.5;
	}
	
}
















