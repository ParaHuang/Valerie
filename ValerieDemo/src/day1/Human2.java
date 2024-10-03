package day1;

import java.util.Objects;

//Encapsulation: make fields private,methods public, access private fields by public methods(getters and setters)
public class Human2 {
	//fields,attributes
	private String name;
	private int age;
	private String gender;
	
	//constructor:
	//1.the special method can be only called by new
	//2.use it to initialize fields
	public Human2(String name,int age,String gender){
		System.out.println("using the constructor");
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0 || age>140) {
			System.out.println("invalid age");
		}else {
			this.age = age;
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	//functions,methods
	void eat() {
		System.out.println(name+" is eating");
	}
	
	void breath() {
		System.out.println("the "+gender+" is breathing");
	}


	@Override
	public String toString() {
		return "Human2 [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	
//	@Override
//	public String toString() {//to get the organized information of this class in String format	
//		return "Name:"+this.name+",Age:"+this.age+",Gender:"+this.gender;
//	}
	
	//if you want Java think 2 human with same name, age,gender as the same person
	//override hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human2 other = (Human2) obj;
		return age == other.age && Objects.equals(gender, other.gender) && Objects.equals(name, other.name);
	}
	
	

	
}




















