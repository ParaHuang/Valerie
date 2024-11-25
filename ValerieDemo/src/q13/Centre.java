package q13;

import java.util.ArrayList;
import java.util.List;

public class Centre {
	private Supervisor supervisor;
	private String name;
	private List<Classroom> classrooms;
	
	public Centre(String name,String supervisorName) {
		this.name = name;
		this.supervisor = new Supervisor(supervisorName);
		this.classrooms = new ArrayList<>();
	}
	
	
	public void addRoom(Classroom room) {
		for(Classroom r:classrooms) {
			if(r.getName() == room.getName()) {
				throw new IllegalStateException("This classroom is already in this centre");
			}
		}
		classrooms.add(room);
	}
}
