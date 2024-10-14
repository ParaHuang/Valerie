package unsw.blackout;

import java.util.ArrayList;
import java.util.List;

import unsw.utils.Angle;

public class Device {
    private String deviceId;
    private String deviceType;
    private Angle devicePosition;
    private List<File> files = new ArrayList<>();
    
    public void addFile(String filename, String content) {
        File newFile = new File(filename, content);
        this.files.add(newFile);
    }

    public Device(String deviceId, String deviceType, Angle devicePosition) {
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.devicePosition = devicePosition;
    }

    // Getter and Setters
    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceType() {
        return this.deviceType;
    }

    public Angle getDevicePosition() {
        return this.devicePosition;
    }
    
    public List<File> getFiles() {
		return files;
	}

}

//class HandheldDevice extends Device {
//    public HandheldDevice(String deviceId, String deviceType, Angle devicePosition) {
//        super(deviceId, deviceType, devicePosition);
//    }
//}
//
//class LaptopDevice extends Device {
//    public LaptopDevice(String deviceId, String deviceType, Angle devicePosition) {
//        super(deviceId, deviceType, devicePosition);
//    }
//}
//
//class DesktopDevice extends Device {
//    public DesktopDevice(String deviceId, String deviceType, Angle devicePosition) {
//        super(deviceId, deviceType, devicePosition);
//    }
//}
