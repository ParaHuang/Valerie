package day7.template;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		System.out.println("making coffee---------");
		Beverage coffee = new Coffee();
		coffee.prepare();

		System.out.println("\nmaking tea---------");
		Beverage tea = new Tea();
		tea.prepare();
	}

}



//1.template method:a skeleton of some certain steps,it's final
//2.abstract method:defined in abstract class,but need be implements by subclass
//3.concrete method:already has definition, the subclass can't modify,usually has final
//4.hook method:it's has a definition already,subclass is allowed to override it

abstract class Beverage{
	//template, define a skeleton
	public final void prepare() {
		boilingWater();
		//add something
		brew();
		//pure water
		pourIntoCup();
		//add condiments
		if(wantCondiment()) {
			addCondiments();
		}
	}
	
	
	//concrete
	public final void boilingWater() {
		System.out.println("boiling water,need 10 mins...");
	}
	public final void pourIntoCup() {
		System.out.println("pour beverage into a cup");
	}
	
	//abstract
	public abstract void brew();
	public abstract void addCondiments();
	
	//hook
	public boolean wantCondiment() {
		return true;
	}
	
}

class Coffee extends Beverage{

	@Override
	public void brew() {
		System.out.println("Dripping coffee through filter");
	}

	@Override
	public void addCondiments() {
		System.out.println("add sugar and milk");
	}
	
	@Override
	public boolean wantCondiment() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("do you want to add sugar and mile?(y/n):");
		String anwser = scanner.next();
		return anwser.equalsIgnoreCase("y");
	}
	
}

class Tea extends Beverage{

	@Override
	public void brew() {
		System.out.println("steeping the tea bag");
	}

	@Override
	public void addCondiments() {
		System.out.println("add honey and lemon");
	}
	
}


















