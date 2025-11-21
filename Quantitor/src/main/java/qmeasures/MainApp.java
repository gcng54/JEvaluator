package qmeasures;
import qmeasures.angle.quantities.EAngleDims;
import qmeasures.angle.quantities.QAngle;
import qmeasures.angle.quantities.QAzimuth;
import qmeasures.angle.quantities.QLatitude;
import qmeasures.angle.quantities.QOrientation;
import qmeasures.angle.units.EAngles;
import qmeasures.angle.units.TDegree;
import qmeasures.length.quantities.QAltitude;
import qmeasures.length.quantities.QArea;
import qmeasures.length.quantities.QLength;
import qmeasures.length.quantities.QRange;
import qmeasures.length.units.ELengthUnit;
import qmeasures.speed.quantities.ESpeedDims;
import qmeasures.speed.quantities.QAirSpeed;
import qmeasures.speed.quantities.QSpeed;
import qmeasures.speed.units.ESpeedUnit;
import qmeasures.time.quantities.QDuration;
import qmeasures.time.units.ETimeUnit;
import qmeasures.temperature.units.TCelsius;
import qmeasures.temperature.quantities.QTemperature;
import qmeasures.temperature.units.ETemperatures;
import qmeasures.temperature.units.TFahrenheit;
import qmeasures.temperature.units.TKelvin;

/**
 * Example application demonstrating usage of quantity classes.
 */
public class MainApp {

    public static void main(String[] args) {
        showcaseOrientationToolkit();
        showcaseFlightLegComputation();
        showcaseTemperatureProfile();
    }

    private static void showcaseOrientationToolkit() {
        System.out.println("=== Angle and orientation toolkit ===");
        QAngle runwayHeading = new QAngle(183.5, EAngles.DEGREE);
        System.out.println("Runway heading (deg): " + runwayHeading.inDegree());
        System.out.println("Runway heading (DMS): " + runwayHeading.toStringDMS());

        QOrientation orientation = (QOrientation) runwayHeading.toDimension(EAngleDims.ORIENTATION);
        System.out.println("Orientation dimension value: " + orientation.inDegree());

        QAngle interceptAzimuth = runwayHeading.ofArcTanXY(12.0, 30.0);
        System.out.println("Intercept azimuth derived from XY: " + interceptAzimuth.inDegree());

        QAzimuth outboundLeg = new QAzimuth(new TDegree(45.0));
        System.out.println("Outbound leg azimuth (rad): " + outboundLeg.inRadian());

        QLatitude reportedLat = new QLatitude(95.2, EAngles.DEGREE);
        System.out.println("Latitude clamped into valid range: " + reportedLat.inDegree());
        System.out.println();
    }

    private static void showcaseFlightLegComputation() {
        System.out.println("=== Flight leg computation ===");
        QSpeed cruise = new QSpeed(820.0, ESpeedUnit.KILOMETERS_PER_HOUR);
        QDuration legDuration = new QDuration(1.8, ETimeUnit.HOUR);
        double cruiseMeters = cruise.inMeterPerSecond() * legDuration.inSecond();
        QLength cruiseSegment = new QLength(cruiseMeters, ELengthUnit.METER);
        System.out.println("Cruise segment (km): " + cruiseSegment.inKilometer());

        QLength taxiOut = new QLength(8.0, ELengthUnit.KILOMETER);
        QLength totalPath = cruiseSegment.add(taxiOut);
        System.out.println("Total path incl. taxi (km): " + totalPath.inKilometer());

        QAltitude requestedAltitude = new QAltitude(120_000.0, ELengthUnit.METER);
        System.out.println("Requested altitude after clamp (m): " + requestedAltitude.getValue());

        QRange radarRange = new QRange(15_000_000.0, ELengthUnit.METER);
        System.out.println("Radar range capped to (km): " + radarRange.inKilometer());

        QArea corridor = cruiseSegment.toArea(new QLength(2.5, ELengthUnit.KILOMETER));
        System.out.println("Air corridor cross-section (km^2): " + corridor.ofKilometer().getValue());

        QAirSpeed airSpeed = (QAirSpeed) cruise.toDimension(ESpeedDims.AIR_SPEED);
        System.out.println("Air speed dimension preserved (m/s): " + airSpeed.inMeterPerSecond());
        System.out.println();
    }

    private static void showcaseTemperatureProfile() {
        System.out.println("=== Temperature profile ===");
        QTemperature seaLevel = new QTemperature(30.0, ETemperatures.CELSIUS);
        QTemperature cruise = new QTemperature(-45.0, ETemperatures.CELSIUS);
        System.out.println("Sea level temperature (K): " + seaLevel.inKelvin());
        System.out.println("Cruise temperature (°F): " + cruise.inFahrenheit());

        QTemperature delta = seaLevel.sub(cruise);
        System.out.println("Temperature drop (°C): " + delta.getValue());

        QTemperature absoluteCheck = new QTemperature(-500.0, ETemperatures.CELSIUS);
        System.out.println("Absolute zero guard (°C): " + absoluteCheck.inCelsius());

        TCelsius cabin = new TCelsius(22.0);
        TFahrenheit cabinF = new TFahrenheit(cabin.getValue() * 9.0 / 5.0 + 32);
        TKelvin cabinK = new TKelvin(cabin.inKelvin());
        System.out.println("Cabin comfort Celsius: " + cabin.getValue());
        System.out.println("Cabin comfort Fahrenheit: " + cabinF.getValue());
        System.out.println("Cabin comfort Kelvin: " + cabinK.getValue());
    }
}
