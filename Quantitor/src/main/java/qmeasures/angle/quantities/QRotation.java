package qmeasures.angle.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.angle.units.EAngles;
import qmeasures.angle.units.TDegree;

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
 * @see TDegree
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

    @Contract("_, _ -> new")
    @Override public @NotNull QRotation of(double value, EAngles unit) {
        return new QRotation(value, unit);
    }

}
