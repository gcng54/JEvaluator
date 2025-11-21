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
 * @see QDegree
 */
public class QRadian extends AAngle<QRadian> {

    public QRadian(double value) {
        super(value, EAngles.RADIAN, EAngleDims.ANGLE);
    }

    @Override
    public QRadian of(double value, EAngles dummy) {
        return new QRadian(value);
    }

}