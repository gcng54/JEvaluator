package qmeasures.earth;

import qmeasures.angle.quantities.QLatitude;
import qmeasures.angle.units.TDegree;
import qmeasures.length.units.TMeter;

public enum EEarthRadiuses {

    SPHERE      (newEarthRadiusInMeters(6371007.184)),             // Sphere Earth radius in meter
    EQUATOR     (newEarthRadiusInMeters(6378137.20410038)),        // Equator Earth radius in meter
    POLAR       (newEarthRadiusInMeters(6356752.51761607)),        // Polar Earth radius in meter
    MINIMUM     (newEarthRadiusInMeters(6.3e+06)),                 // Min Earth radius and Geocentric (6.3e+06) in meter
    MAXIMUM     (newEarthRadiusInMeters(6.4e+06)),                 // Max Earth radius and Geocentric (6.4e+06) in meter
    TRNORMAL    (newEarthRadiusInMeters(6.386426328418286e+06)),   // Earth radius deflat 38.5
    TRELLIPSE   (newEarthRadiusInMeters(6.365047929623225e+06)),   // Earth radius deflat 38.5
    TRTANGENT   (newEarthRadiusInMeters(6.375249619497354e+06)),   // Earth radius deflat 38.5
    TRSEOBSERVE (newEarthRadiusInMeters(6.373334556743117e+06)),   // Earth radius deflat 38.5 (CHECK?)
    TRSTEREO    (newEarthRadiusInMeters(6.373334556743117e+06));   // Earth radius deflat 38.5 (6,373,334 m)

    public static final double ECC2        = 0.00669438000426;         // f = 1- po/eq, e2=2f-f*f = 1-po2/eq2
    public static final double MECC2       = 0.998320779610063;        // 1-Ecc2

    public static final double WGS84_A = 6378137.0;           // WGS84 major axis
    public static final double WGS84_B = 6356752.314245;  // WGS84 minor axis
    public static final double WGS84_F = 1 / 298.257223563; // WGS84 flattening
    public static final double WGS84_E2 = WGS84_F * (2 - WGS84_F);      // WGS84 eccentricity squared

    public static final QLatitude TRLATITUDE = new QLatitude(new TDegree(38.5));  // deflatitude in Turkiye 38.5

    private  final QEarthRadius earthRadius;

    EEarthRadiuses(QEarthRadius earthRadius) {
        this.earthRadius = earthRadius;
    }

    public QEarthRadius getEarthRadius() {
        return earthRadius;
    }

    private static QEarthRadius newEarthRadiusInMeters(double earthRadiusInMeters) {
        return new QEarthRadius(new TMeter(earthRadiusInMeters));
    }




}
