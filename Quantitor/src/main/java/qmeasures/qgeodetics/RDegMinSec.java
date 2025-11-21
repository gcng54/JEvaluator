package qmeasures.qgeodetics;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Objects;

public record RDegMinSec(int Degree, int Minute, double Second) {

    public RDegMinSec(int Degree, double Minutes) {
        this(Degree, (int) Minutes, (Minutes - (int) Minutes) * 60);
    }

    public RDegMinSec(double degrees) {
        double minutes = (degrees - (int) degrees) * 60;
        int minute = (int) minutes;
        this((int) degrees, minute, (minutes - minute) * 60);
    }

    public RDegMinSec() {
        this(0, 0, 0);
    }

    public double toDegrees() {
        return Degree + (Minute / 60.0) + (Second / 3600.0);
    }

    public double toSeconds() {
        return Degree * 3600 + Minute * 60.0 + Second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RDegMinSec that = (RDegMinSec) o;
        return Degree == that.Degree && Minute == that.Minute && Double.compare(Second, that.Second) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Degree, Minute, Second);
    }

    @Override
    public @NotNull String toString() {
        return String.format(Locale.ENGLISH, "%d°%02d'%05.2f\"", Degree, Minute, Second);
    }


    /** Creates a {@link Longitude} instance by parsing a coordinate string expressed
     * in <b>ICAO-compliant DMS_S</b> (Degrees–Minutes–Seconds with Symbol) format.
     * <p>
     * The input must follow the conventions defined in
     * <b>ICAO Annex 15 — Aeronautical Information Services</b>, where longitude
     * is expressed in degrees (°), minutes (′), and seconds (″) of arc,
     * followed by an <b>East (E)</b> or <b>West (W)</b> direction indicator.
     * <p>
     * This method automatically validates and parses DMS-formatted strings such as:
     * <ul>
     *   <li>{@code 021°04'03.98"E}</li>
     *   <li>{@code 21°4'3.9"E}</li>
     *   <li>{@code 21deg4min3.98secW}</li>
     * </ul>
     * Optional degrees, minutes, or seconds symbols are supported (°, o, deg, ', min, ″, sec, etc.).
     * The seconds component may include decimal precision (e.g., 0.01″).
     * <p>
     * If the input does not conform to a valid DMS structure or is {@code null},
     * a {@link UnitSystemArgumentException} is thrown.
     *
     * <h4>Examples:</h4>
     * <pre>{@code
     * Longitude lon1 = Longitude.ofDMSFormat("021°04'03.98\"E");  // Valid, ICAO precision
     * Longitude lon2 = Longitude.ofDMSFormat("21°4'3.9\"W");      // Valid, lower precision
     * Longitude lon3 = Longitude.ofDMSFormat("21deg4min3.98secE"); // Valid, alternate format
     * Longitude.ofDMSFormat("21°4'3.9");  // X Invalid — missing direction (E/W)
     * }</pre>
    */
    public static RDegMinSec parseDMSFormat(@NotNull String dmsString) {
        if (dmsString == null || dmsString.isBlank()) {
            throw new IllegalArgumentException("Input DMS string cannot be null or empty.");
        }

        String trimmed = dmsString.trim().toUpperCase(Locale.ENGLISH);
        boolean isNegative = trimmed.endsWith("W") || trimmed.endsWith("S");
        trimmed = trimmed.replaceAll("[^0-9.°'\"A-Z]", ""); // Remove unwanted characters

        String degreePart = trimmed.split("[°DEG]")[0];
        String minutePart = trimmed.contains("'") ? trimmed.split("'")[0].split("[°DEG]")[1] : "0";
        String secondPart = trimmed.contains("\"") ? trimmed.split("\"")[0].split("'")[1] : "0";

        int degrees = Integer.parseInt(degreePart);
        int minutes = Integer.parseInt(minutePart);
        double seconds = Double.parseDouble(secondPart);

        if (isNegative) {
            degrees = -degrees;
        }

        return new RDegMinSec(degrees, minutes, seconds);
    }



    public int absDegree(){
        return Math.abs(Degree);
    }

    public int intSecond(){
        return (int) Second();
    }

    public double milliSecond(){
        return Second * 1000;

    }


}
    
