package unsw.blackout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import unsw.response.models.EntityInfoResponse;
import unsw.response.models.FileInfoResponse;
import unsw.utils.Angle;
import unsw.utils.MathsHelper;

/**
 * The controller for the Blackout system.
 *
 * WARNING: Do not move this file or modify any of the existing method
 * signatures
 */
public class BlackoutController {

    private List<Device> devices = new ArrayList<>();
    private List<Satellite> satellites = new ArrayList<>();

    public void createDevice(String deviceId, String type, Angle position) {
        Device newDevice = null;
        if (type.equals("HandheldDevice")) {
            newDevice = new HandheldDevice(deviceId, type, position);
        } else if (type.equals("LaptopDevice")) {
            newDevice = new LaptopDevice(deviceId, type, position);
        } else if (type.equals("DesktopDevice")) {
            newDevice = new DesktopDevice(deviceId, type, position);
        }
        if (newDevice != null) {
            devices.add(newDevice);
        }
    }

    public void removeDevice(String deviceId) {
        for (Device device : devices) {
            if (device.getDeviceId().equals(deviceId)) {
                devices.remove(device);
                return;
            }
        }
    }

    public void createSatellite(String satelliteId, String type, double height, Angle position) {
        Satellite newSatellite = null;
        if (type.equals("StandardSatellite")) {
            newSatellite = new StandardSatellite(satelliteId, type, height, position);
        } else if (type.equals("TeleportingSatellite")) {
            newSatellite = new TeleportingSatellite(satelliteId, type, height, position);
        } else if (type.equals("RelaySatellite")) {
            newSatellite = new RelaySatellite(satelliteId, type, height, position);
        }
        if (newSatellite != null) {
            satellites.add(newSatellite);
        }
    }

    public void removeSatellite(String satelliteId) {
        for (Satellite satellite : satellites) {
            if (satellite.getSatelliteId().equals(satelliteId)) {
                satellites.remove(satellite);
                return;
            }
        }
    }

    public List<String> listDeviceIds() {
        List<String> deviceIds = new ArrayList<>();
        for (Device device : devices) {
            deviceIds.add(device.getDeviceId());
        }
        return deviceIds;
    }

    public List<String> listSatelliteIds() {
        List<String> satelliteIds = new ArrayList<>();
        for (Satellite satellite : satellites) {
            satelliteIds.add(satellite.getSatelliteId());
        }
        return satelliteIds;
    }

    public void addFileToDevice(String deviceId, String filename, String content) {
        // TODO: Task 1g)

        for (Device device : devices) {
            if (device.getDeviceId().equals(deviceId)) {
            	device.addFile(filename, content);
            	break;
            	//figure out which type it is
//            	String type = device.getDeviceType();
//                if (type.equals("HandheldDevice")) {
//                    HandheldDevice handheldDevice = (HandheldDevice) device;
//                    handheldDevice.addFile(filename, content);
//                } else if (type.equals("LaptopDevice")) {
//                	LaptopDevice laptopDevice = (LaptopDevice) device;
//                	laptopDevice.addFile(filename, content);
//                } else if (type.equals("DesktopDevice")) {
//                	DesktopDevice desktopDevice = (DesktopDevice) device;
//                	desktopDevice.addFile(filename, content);
//                }
            }
        }
    	
    }

    public EntityInfoResponse getInfo(String id) {
        // TODO: Task 1h)
    	for (Device device : devices) {
            if (device.getDeviceId().equals(id)) {
            	//return an EntityInfoResonse Object
            	//List<File>  ->  Map<String,FileInfoReponse>
            	List<File> files = device.getFiles();
            	Map<String,FileInfoResponse> map = new HashMap<String, FileInfoResponse>();
            	//xxxxxxxxx to change
            	for(File f:files) {
            		FileInfoResponse response = new FileInfoResponse(f.getFilename(), f.getContent(), f.getContent().length(), true);
            		map.put(f.getFilename(), response);
            	}
            	
            	return new EntityInfoResponse(id, 
            			device.getDevicePosition(), 
            			MathsHelper.RADIUS_OF_JUPITER, 
            			device.getDeviceType(),
            			map);
            }
    	}
    	for (Satellite satellite:satellites) {
    		if(satellite.getSatelliteId().equals(id)) {
    			List<File> files = satellite.getFiles();
            	Map<String,FileInfoResponse> map = new HashMap<String, FileInfoResponse>();
            	for(File f:files) {
            		FileInfoResponse response = new FileInfoResponse(f.getFilename(), f.getContent(), f.getContent().length(), true);
            		map.put(f.getFilename(), response);
            	}
    			return new EntityInfoResponse(id, 
    					satellite.getSatellitePosition(), 
    					satellite.getSatelliteHeight(), 
    					satellite.getSatelliteType(),
    					map);
    		}
    	}
    	System.out.println("------");
    	
        return null;
    }

    public void simulate() {
        // TODO: Task 2a)
    	
    }

    /**
     * Simulate for the specified number of minutes. You shouldn't need to modify
     * this function.
     */
    public void simulate(int numberOfMinutes) {
        for (int i = 0; i < numberOfMinutes; i++) {
            simulate();
        }
    }

    public Device getDeviceById(String id) {
    	for (Device device : devices) {
            if (device.getDeviceId().equals(id)) {
            	return device;
            }
    	}
    	return null;
    }
    
    public Satellite getSatelliteById(String id) {
    	for (Satellite satellite:satellites) {
    		if(satellite.getSatelliteId().equals(id)){//it's the target satellite
				return satellite;
			}
    	}
    	return null;
    }
    
    public List<String> communicableEntitiesInRange(String id) {
        // TODO: Task 2 b)
    	ArrayList<String> list = new ArrayList<String>();
    	
//    	Device targetDevice = null;
    	//if this id is a device id
//    	for (Device device : devices) {
//            if (device.getDeviceId().equals(id)) {
//            	targetDevice = device;
//            	break;
//            }
//    	}
    	Device targetDevice = getDeviceById(id);
    	
    	if(targetDevice != null) {//it's a device
    		for (Satellite satellite:satellites) {
    			boolean isVisible = MathsHelper.isVisible(satellite.getSatelliteHeight(), 
    					satellite.getSatellitePosition(), targetDevice.getDevicePosition());
    			
            	String sType = satellite.getSatelliteType();
            	String dType = targetDevice.getDeviceType();
            	
//            	if(isVisible or certain type satellite) {
            		//certain type satellite
            		//1.TeleportingSatellite   or
            		//2.RelaySatellite			or
            		//3.StandardSatellite     &&   (HandheldDevice  or LaptopDevice)
//            	}
            	
            	if( isVisible &&
            		(sType.equals("TeleportingSatellite")  
            		|| sType.equals("RelaySatellite")
            		|| (sType.equals("StandardSatellite") && (dType.equals("HandheldDevice") || dType.equals("LaptopDevice"))))) {
            		list.add(satellite.getSatelliteId());
            	}
    		}
    	}
    	
    	//it's a satellite id
//    	Satellite targetSatellite = null;
//    	for (Satellite satellite:satellites) {
//    		if(satellite.getSatelliteId().equals(id)){//it's the target satellite
//				targetSatellite = satellite;
//				break;
//			}
//    	}
    	Satellite targetSatellite = getSatelliteById(id);
    	
    	if(targetSatellite!=null) {//it's satellite
	    	//find out all the communicable satellite
	    	for (Satellite satellite:satellites) {
	    		if(!satellite.equals(targetSatellite)){
	    			boolean isVisible = MathsHelper.isVisible(targetSatellite.getSatelliteHeight(), 
	            			targetSatellite.getSatellitePosition(),satellite.getSatelliteHeight(), satellite.getSatellitePosition());
	    			if(isVisible) {
	    				list.add(satellite.getSatelliteId());
	    			}
				}
	    	}
	    	
	    	//find out all the communicable device
	    	for (Device device : devices) {
            	boolean isVisible = MathsHelper.isVisible(targetSatellite.getSatelliteHeight(), 
            			targetSatellite.getSatellitePosition(), device.getDevicePosition());
            	
            	String sType = targetSatellite.getSatelliteType();
            	String dType = device.getDeviceType();
            	if( isVisible &&
            		(sType.equals("TeleportingSatellite")  
            		|| sType.equals("RelaySatellite")
            		|| (sType.equals("StandardSatellite") && (dType.equals("HandheldDevice") || dType.equals("LaptopDevice"))))) {
            		list.add(device.getDeviceId());
            	}
	    	}
    	}
    	
        return list;
    }

    public void sendFile(String fileName, String fromId, String toId) throws FileTransferException {
        // TODO: Task 2 c)
    	EntityInfoResponse fromEntity = getInfo(fromId);
    	FileInfoResponse response = fromEntity.getFiles().get(fileName);
    	//file not found
    	if(response==null || !response.isFileComplete()) {
    		throw new FileTransferException.VirtualFileNotFoundException(fileName);
    	}
    	//bandwidth not enough??
    	
    	
    	//file exist
    	EntityInfoResponse toEntity = getInfo(toId);
    	FileInfoResponse existFile = toEntity.getFiles().get(fileName);
    	if(existFile!=null) {
    		throw new FileTransferException.VirtualFileAlreadyExistsException(fileName);
    	}
    	
    	//storage??
    	
    	
    	
    	//fromEntity send file, toEntity get file
//    	fromEntity.getFiles().remove(fileName);
//    	toEntity.getFiles().put(fileName, new FileInfoResponse(fileName, response.getData(), response.getData().length(), true));
//    	
//    	System.out.println(toEntity.getFiles());
//    	
    	
    	
    	Satellite fromS = getSatelliteById(fromId);
    	Satellite toS = getSatelliteById(toId);
    	Device fromD  = getDeviceById(fromId);
    	Device toD = getDeviceById(toId);
    	
//    	if(fromS != null) {
//    		fromS.removeFile(fileName);
//    	}else {
//    		fromD.removeFile(fileName);
//    	}
    	if(toS != null) {
    		toS.addFile(fileName, response.getData());
    	}else {
    		toD.addFile(fileName, response.getData());
    	}
    	
    	
    }

    public void createDevice(String deviceId, String type, Angle position, boolean isMoving) {
        createDevice(deviceId, type, position);
        // TODO: Task 3
    }

    public void createSlope(int startAngle, int endAngle, int gradient) {
        // TODO: Task 3
        // If you are not completing Task 3 you can leave this method blank :)
    }
}
