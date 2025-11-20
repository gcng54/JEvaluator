package qmeasures.angle;

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
    
