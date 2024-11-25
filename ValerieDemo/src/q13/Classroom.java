package q13;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	private Invigilator invigilator;
	private String name;
	private int maxCapacity;
	private List<Student> students;
	
	public Classroom(String name,String invigilatorName, int maxCapacity) {
		this.name = name;
		this.invigilator = new Invigilator(invigilatorName);
		this.maxCapacity = maxCapacity;
		students = new ArrayList<>();
	}
	
	public void addStudent(String studentId) {
		if(students.size() == maxCapacity) {
			throw new IllegalStateException("Classroom reach the max capacity");
		}
		
		if(findStudentById(studentId) != -1) {
			throw new IllegalStateException("This student is already in this classroom");
		}
		students.add(new Student(studentId));
	}
	
	public void removeStudent(String studentID) {
		int index = findStudentById(studentID);

		if(index == -1) {
			throw new IllegalStateException("This student is not in this classroom");
		}
		
		students.remove(index);
	}
	
	public int findStudentById(String studentId) {
		for(int i=0 ; i<students.size() ; i++) {
			if(students.get(i).getStudentID().equals(studentId)) {
				return i;
			}
		}
		return -1;
	}
	
	public String getName() {
		return name;
	}
}












