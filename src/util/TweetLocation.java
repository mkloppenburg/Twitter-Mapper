package util;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import twitter4j.GeoLocation;
import twitter4j.Status;

/**
 * Helpful methods for retrieving/converting GeoLocation/Coordinate objects.
 */
public class TweetLocation {

    // returns the GeoLocation from a provided Twitter status
    public static GeoLocation statusLocation(Status status) {
        GeoLocation bottomRight = status.getPlace().getBoundingBoxCoordinates()[0][0];
        GeoLocation topLeft = status.getPlace().getBoundingBoxCoordinates()[0][2];
        double newLat = (bottomRight.getLatitude() + topLeft.getLatitude())/2;
        double newLon = (bottomRight.getLongitude() + topLeft.getLongitude())/2;
        return new GeoLocation(newLat, newLon);
    }

    // returns a Coordinate converted from a GeoLocation object
    public static Coordinate GeoLocationToCoordinate(GeoLocation loc) {
        return new Coordinate(loc.getLatitude(), loc.getLongitude());
    }

    // returns the Coordinate from a provided Twitter status
    public static Coordinate statusCoordinate(Status status) {
        GeoLocation bottomRight = status.getPlace().getBoundingBoxCoordinates()[0][0];
        GeoLocation topLeft = status.getPlace().getBoundingBoxCoordinates()[0][2];
        double newLat = (bottomRight.getLatitude() + topLeft.getLatitude())/2;
        double newLon = (bottomRight.getLongitude() + topLeft.getLongitude())/2;
        return new Coordinate(newLat, newLon);
    }
}
