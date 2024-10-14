package unsw.blackout;

import unsw.utils.Angle;

public class Satellite {
    private String satelliteId;
    private String satelliteType;
    private double satelliteHeight;
    private Angle satellitePosition;

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










