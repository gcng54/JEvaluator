package qmeasures.angle.units;

import qmeasures.angle.quantities.AAngle;
import qmeasures.angle.quantities.EAngleDims;

/**
 * Represents an angle measurement in arcseconds.
 * It provides type safety and convenience methods for working specifically with arcsecond values.
 * <p>
 * This class extends {@link AAngle} with the unit set to arcseconds.
 * and is initialized with the unit set to {@link EAngles#ARCSECOND}
 * and with dimension set to {@link EAngleDims#ANGLE}.
 * </p>
 * <p>
 * Its value is clamped within {@link #getMinQ()} and {@link #getMaxQ()}.
 * </p>
 * @see EAngles
 * @see TDegree
 */
public class TArcSecond extends AAngle<TArcSecond> {

    public TArcSecond(double value) {
        super(value, EAngles.ARCSECOND, EAngleDims.ANGLE);
    }

    @Override
    public TArcSecond of(double value, EAngles dummy) {
        return new TArcSecond(value);
    }

}