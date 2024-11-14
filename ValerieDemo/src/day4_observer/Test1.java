package day4_observer;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		WeatherStation weatherStation = new WeatherStation();
		
		Ctrip c = new Ctrip();
		Recipe r = new Recipe();

		weatherStation.addObserver(c);
		weatherStation.addObserver(r);
		weatherStation.setTemperature(20);

		System.out.println("----------");
		weatherStation.removeObserver(r);
		weatherStation.setTemperature(35);
	}

}


//Subject interface(hold the instances of Observer)
interface Subject{
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
	void notifyObservers();
}


//Observer interface
interface Observer{
	void update(float temperature);
}

//WeatcherStation			-> subject
class WeatherStation implements Subject{
	private List<Observer> observers = new ArrayList<Observer>();
	private int temperature;

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for(Observer o:observers) {
			o.update(temperature);
		}
	}
	
	public void setTemperature(int temperature) {
		this.temperature = temperature;
		//notify all the observers
		notifyObservers();
	}
}


//Applications:Ctrip, Recipe-> observer
class Ctrip implements Observer{

	@Override
	public void update(float temperature) {
		if(temperature<20) {
			System.out.println("travale with more clothes");
		}else {
			System.out.println("drinking more ice water");
		}
	}
	
}

class Recipe implements Observer{

	@Override
	public void update(float temperature) {
		if(temperature<0) {
			System.out.println("have more hot soup");
		}else if(temperature<20) {
			System.out.println("normal food");
		}else {
			System.out.println("ice water");
		}
	}
	
}























