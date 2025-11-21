package qmeasures.angle.quantities;

import qmeasures.angle.units.EAngles;

/**
 * Represents an angle quantity with a specific value and unit.
 * <p>
 * QAngle extends {@link AAngle} and provides constructors for creating angle instances
 * in degrees or with a specified {@link EAngles} unit. This class is immutable and final.
 * It clamps by {@link EAngleDims#ANGLE} within {@link QAngle#getMinQ()} and {@link QAngle#getMaxQ()}.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     QAngle angleInDegrees = new QAngle(90.0);
 *     QAngle angleInRadians = new QAngle(Math.PI, EAngles.RADIAN);
 * </pre>
 * </p>
 *
 * @see AAngle
 * @see EAngles
 * @see EAngleDims
 */
public class QAngle extends AAngleDim<QAngle> {

    public QAngle(AAngle<?> Angle) {
        super(Angle);  }


    protected QAngle(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.ANGLE);
    }

    public QAngle(double value, EAngles unit) {
        super(value, unit, EAngleDims.ANGLE);
    }

    @Override public QAngle of(double value, EAngles unit) {
        return new QAngle(value, unit);
    }


}

