package qmeasures.angle.quantities;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import qmeasures.angle.units.EAngles;

public final class QElevation extends AAngleDim<QElevation> {

    public QElevation(AAngle<?> Angle) {
        super(Angle, EAngleDims.ELEVATION);
    }

    protected QElevation(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.ELEVATION);
    }

    public QElevation(double value, EAngles unit) {
        super(value, unit, EAngleDims.ELEVATION);
    }

    @Contract("_, _ -> new")
    @Override public @NotNull QElevation of(double value, EAngles unit) {
        return new QElevation(value, unit);
    }
}
