package qmeasures.angle.units;

import qmeasures.angle.quantities.AAngle;
import qmeasures.angle.quantities.EAngleDims;

/**
 * Represents an angle measured in degrees.
 * It provides type safety and convenience methods for working specifically with degree values.
 * <p>
 * This class extends {@link AAngle} with the unit set to degrees.
 * and is initialized with the unit set to {@link EAngles#DEGREE}
 * and with dimension set to {@link EAngleDims#ANGLE}.
 * </p>
 * <p>
 * Its value is clamped within {@link #getMinQ()} and {@link #getMaxQ()}.
 * </p>
 * @see EAngles
 * @see TRadian
 */
public class TDegree extends AAngle<TDegree> {

    public TDegree(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.ANGLE);
    }

    @Override public TDegree of(double degree, EAngles dummy) {
        return new TDegree(degree);
    }

}