package qmeasures.angle.units;

import qmeasures.angle.quantities.AAngle;
import qmeasures.angle.quantities.EAngleDims;

/**
 * Represents an angle measured in radians.
 * It provides type safety and convenience methods for working specifically with radian values.
 * <p>
 * This class extends {@link AAngle} with the unit set to radians.
 * and is initialized with the unit set to {@link EAngles#RADIAN}
 * and with dimension set to {@link EAngleDims#ANGLE}.
 * </p>
 * <p>
 * Its value is clamped within {@link #getMinQ()} and {@link #getMaxQ()}.
 * </p>
 * @see EAngles
 * @see TDegree
 */
public class TRadian extends AAngle<TRadian> {

    public TRadian(double value) {
        super(value, EAngles.RADIAN, EAngleDims.ANGLE);
    }

    @Override
    public TRadian of(double value, EAngles dummy) {
        return new TRadian(value);
    }

}