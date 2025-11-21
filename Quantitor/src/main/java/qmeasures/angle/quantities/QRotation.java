package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.units.QDegree;

/**
 * Represents a rotation angle quantity.
 * <p>
 * This class extends {@link AAngle} and provides constructors for creating rotation quantities
 * using degrees or other angle units. It is associated with the {@link EAngleDims#ROTATION} dimension.
 * </p>
 *
 * <p>
 * Example usage:
 * <pre>
 *     QRotation rotation = new QRotation(new QDegree(90.0));
 * </pre>
 * </p>
 *
 * @see AAngle
 * @see QDegree
 * @see EAngles
 * @see EAngleDims
 */

public final class QRotation extends AAngleDim<QRotation> {

    public QRotation(AAngle<?> Angle) {
        super(Angle, EAngleDims.ROTATION);
    }

    protected QRotation(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.ROTATION);
    }

    public QRotation(double value, EAngles unit) {
        super(value, unit, EAngleDims.ROTATION);
    }

    @Override public QRotation of(double value, EAngles unit) {
        return new QRotation(value, unit);
    }

}
