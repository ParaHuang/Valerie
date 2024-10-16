package unsw.blackout;

import java.util.ArrayList;
import java.util.List;

import unsw.utils.Angle;

public class Satellite {
    private String satelliteId;
    private String satelliteType;
    private double satelliteHeight;
    private Angle satellitePosition;
    
    private List<File> files = new ArrayList<>();
    
    public void addFile(String filename, String content) {
        File newFile = new File(filename, content);
        this.files.add(newFile);
    }
    
    public void removeFile(String filename) {
    	for(File f:files) {
    		if(f.getFilename().equals(filename)) {
    			files.remove(f);
    			return;
    		}
    	}
    }

    public Satellite(String satelliteId, String satelliteType, double satelliteHeight, Angle satellitePosition) {
        this.satelliteId = satelliteId;
        this.satelliteType = satelliteType;
        this.satelliteHeight = satelliteHeight;
        this.satellitePosition = satellitePosition;
    }

    // Setters and Getters
    public String getSatelliteId() {
        return this.satelliteId;
    }

    public double getSatelliteHeight() {
        return this.satelliteHeight;
    }

    public String getSatelliteType() {
        return this.satelliteType;
    }

    public Angle getSatellitePosition() {
        return this.satellitePosition;
    }

    public void setSatelliePosition(Angle satellitePosition) {
        this.satellitePosition = satellitePosition;
    }

	public List<File> getFiles() {
		// TODO Auto-generated method stub
		return files;
	}

}

//class StandardSatellite extends Satellite {
//    public StandardSatellite(String satelliteId, String satelliteType, double satelliteHeight,
//            Angle satellitePosition) {
//        super(satelliteId, satelliteType, satelliteHeight, satellitePosition);
//    }
//}
//
//class TeleportingSatellite extends Satellite {
//    public TeleportingSatellite(String satelliteId, String satelliteType, double satelliteHeight,
//            Angle satellitePosition) {
//        super(satelliteId, satelliteType, satelliteHeight, satellitePosition);
//    }
//}

//class RelaySatellite extends Satellite {
//    public RelaySatellite(String satelliteId, String satelliteType, double satelliteHeight, Angle satellitePosition) {
//        super(satelliteId, satelliteType, satelliteHeight, satellitePosition);
//    }
//}










