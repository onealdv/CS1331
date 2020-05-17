/**
* @author onealdv
* @version 1.0
*/
public class Coordinates {

    private final double latitude;
    private final double longitude;

    /**
    * Constructor for Coordinates object
    *
    * @param latitude This constant double represents
    * the latitude in a set of coordinates.
    * @param longitude This constant double represents
    * the longitude in a set of coordinates.
    */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
    * Overrides equals method
    *
    * @return boolean value if this object is equals to other
    */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Coordinates)) {
            return false;
        }

        Coordinates o = (Coordinates) other;
        return this.latitude == o.latitude
                && this.longitude == o.longitude;
    }
    /**
    * Overrides toString method
    *
    * @return latitude and longitude in string format
    */
    @Override
    public String toString() {
        return "latitude: " + latitude + ", longitude: " + longitude;
    }

    /**
    * Getter method for latitude
    *
    * @return double value of latitude variable
    */
    public double getLatitude() {
        return latitude;
    }

    /**
    * Getter method for longitude
    *
    * @return double value of longitude variable
    */
    public double getLongitude() {
        return longitude;
    }
}
