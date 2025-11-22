package qmeasures.angle.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.angle.units.EAngles;
import qmeasures.angle.units.TDegree;
import qmeasures.angle.units.TRadian;
import qmeasures.core.Clampable;
import qmeasures.geodetics.RDegMinSec;

import java.util.Locale;

/**
 * Concrete angle quantity representing latitude.
 * Format is a "%02d:%02d:%05.2f.%c"
 */
public final class QLatitude extends AAngleDim<QLatitude> {

    public QLatitude(AAngle<?> Angle) {
        super(Angle, EAngleDims.LATITUDE);
    }

    public QLatitude(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.LATITUDE);
    }

    public QLatitude(double value, EAngles unit) {
        super(value, unit, EAngleDims.LATITUDE);
    }

    /**
     * Creates a Latitude from a Degree quantity.
     * @param degree the degree quantity
     * @return new QLatitude
     */
    @Contract("_ -> new")
    public static @NotNull QLatitude of(@NotNull TDegree degree) {
        return new QLatitude(degree.getValue(), EAngles.DEGREE);
    }

    /**
     * Creates a Latitude from a Radian quantity.
     * @param radian the radian quantity
     * @return new QLatitude
     */
    @Contract("_ -> new")
    public static @NotNull QLatitude of(@NotNull TRadian radian) {
        return new QLatitude(radian.getValue(), EAngles.RADIAN);
    }

    @Contract("_, _ -> new")
    @Override public @NotNull QLatitude of(double value, EAngles unit) {
        return new QLatitude(value, unit);
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.LATITUDE; }


    public @NotNull String toStringDMSO() {

        RDegMinSec degMinSec = this.getDegMinSec();

        char orientation = getBaseValue() >= 0 ? 'N' : 'S';

        return String.format(Locale.ENGLISH,"%02d:%02d:%05.2f.%c",
                            degMinSec.absDegree(), degMinSec.Minute(), degMinSec.Second(), orientation);
    }

}
