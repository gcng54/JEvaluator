package qmeasures.example;

import qmeasures.angle.*;
import qmeasures.length.*;
import qmeasures.speed.*;
import qmeasures.time.*;
import qmeasures.temperature.*;

/**
 * Example application demonstrating usage of quantity classes.
 */
public class MainApp {

    public static void main(String[] args) {
        // Angle examples
        QAngle angle = new QAngle(90.0, EAngles.DEGREE);
        System.out.println("Angle in degrees: " + angle.inDegree());
        System.out.println("Angle in radians: " + angle.inRadian());
        System.out.println("sin(angle): " + angle.sin());
        System.out.println("cos(angle): " + angle.cos());
        System.out.println("tan(angle): " + angle.tan());
        QAngle angleRad = angle.ofRadian(Math.PI / 2);
        System.out.println("Angle from radians (should be 90°): " + angleRad.inDegree());
        System.out.println("Is angle a quarter turn? " + angle.isTurnQuarter());
        QAzimuth azimuth = new QAzimuth(45.0);
        System.out.println("Azimuth in degrees: " + azimuth.inDegree());
        System.out.println("Azimuth as QAngle: " + azimuth.to(QAngle.class).inDegree());

        // Length examples
        QLength length = new QLength(1000.0, ELengths.METER);
        System.out.println("Length in meters: " + length.inMeter());
        System.out.println("Length in kilometers: " + length.inKilometer());
        QLength length2 = new QLength(1.0, ELengths.KILOMETER);
        QLength sumLength = length.of(length.inMeter() + length2.inMeter(), ELengths.METER);
        System.out.println("Sum of 1000m and 1km in meters: " + sumLength.inMeter());
        System.out.println("Sum in kilometers: " + sumLength.inKilometer());

        // Speed examples
        QSpeed speed = new QSpeed(36.0, ESpeeds.KILOMETERS_PER_HOUR);
        System.out.println("Speed in km/h: " + speed.inKilometerPerHour());
        System.out.println("Speed in m/s: " + speed.inMeterPerSecond());
        QSpeed speed2 = new QSpeed(10.0, ESpeeds.METERS_PER_SECOND);
        QSpeed sumSpeed = speed.of(speed.inMeterPerSecond() + speed2.inMeterPerSecond(), ESpeeds.METERS_PER_SECOND);
        System.out.println("Sum of 36km/h and 10m/s in m/s: " + sumSpeed.inMeterPerSecond());
        System.out.println("Sum of 36km/h and 10m/s in km/h: " + speed.add(speed2));
        System.out.println("Sum of 36km/h and 10m/s in m/s: " + speed2.add(speed));

        // Time examples
        QDuration duration = new QDuration(2.0, ETimes.HOUR);
        System.out.println("Duration in hours: " + duration.inHour());
        System.out.println("Duration in seconds: " + duration.inSecond());
        QDuration duration2 = new QDuration(30.0, ETimes.MINUTE);
        QDuration totalDuration = duration.of(duration.inSecond() + duration2.inSecond(), ETimes.SECOND);
        System.out.println("Total duration (2h + 30min) in hours: " + totalDuration.inHour());

        // Temperature examples
        QCelsius tempC = new QCelsius(25.0);
        QFahrenheit tempF = new QFahrenheit(77.0);
        QKelvin tempK = new QKelvin(298.15);
        System.out.println("Temperature in Celsius: " + tempC.getValue());
        System.out.println("Temperature in Fahrenheit: " + tempF.getValue());
        System.out.println("Temperature in Kelvin: " + tempK.getValue());
        // Convert Celsius to Kelvin
        QKelvin tempCtoK = new QKelvin(tempC.getValue() + 273.15);
        System.out.println("25°C in Kelvin: " + tempCtoK.getValue());

        // Edge case: negative temperature
        QCelsius belowZero = new QCelsius(-10.0);
        System.out.println("Below zero in Celsius: " + belowZero.getValue());

        // Example: Calculate distance = speed * time
        double speedMs = speed.inMeterPerSecond();
        double timeSec = duration.inSecond();
        double distance = speedMs * timeSec;
        System.out.println("Distance (speed * time) in meters: " + distance);
    }
}
