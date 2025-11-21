package qmeasures.angle.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.angle.units.EAngles;


/**
 * Concrete angle quantity representing direction.
 */
public final class QDirection extends AAngleDim<QDirection> {

    public QDirection(AAngle<?> Angle) {
        super(Angle, EAngleDims.DIRECTION);
    }
    protected QDirection(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.DIRECTION);
    }

    public QDirection(double value, EAngles unit) {
        super(value, unit, EAngleDims.DIRECTION);
    }

    @Contract("_, _ -> new")
    @Override public @NotNull QDirection of(double value, EAngles unit) {
        return new QDirection(value, unit);
    }

}
