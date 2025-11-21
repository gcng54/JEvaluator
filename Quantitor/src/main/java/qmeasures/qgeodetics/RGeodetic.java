package qmeasures.qgeodetics;

import qmeasures.angle.quantities.QLatitude;
import qmeasures.angle.quantities.QLongitude;
import qmeasures.length.quantities.QAltitude;


public record RGeodetic(QLongitude longitude, QLatitude latitude, QAltitude altitude) {
    
    public RGeodetic(QLongitude longitude, QLatitude latitude) {
        this(longitude, latitude, new QAltitude());
    }

    public RGeodetic {
        if (latitude == null || longitude == null || altitude == null) {
            throw new IllegalArgumentException("Latitude, Longitude, and Altitude cannot be null.");
        }
    }


}
