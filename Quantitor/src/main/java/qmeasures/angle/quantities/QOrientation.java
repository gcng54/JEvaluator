package qmeasures.angle.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.angle.units.EAngles;

/**
 * Concrete angle quantity representing orientation.
 */
public final class QOrientation extends AAngleDim<QOrientation> {

    public QOrientation(AAngle<?> Angle) {
        super(Angle, EAngleDims.ORIENTATION);
    }

    protected QOrientation(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.ORIENTATION);
    }

    public QOrientation(double value, EAngles unit) {
        super(value, unit, EAngleDims.ORIENTATION);
    }

    @Contract("_, _ -> new")
    @Override public @NotNull QOrientation of(double value, EAngles unit) {
        return new QOrientation(value, unit);
    }

    public enum EOrientation {
        N, S, E, W
    }
}
