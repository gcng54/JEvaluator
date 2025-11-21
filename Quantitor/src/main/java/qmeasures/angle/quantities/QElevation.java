package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.units.QDegree;

/**
 * Concrete angle quantity representing course.
 */
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

    @Override public QElevation of(double value, EAngles unit) {
        return new QElevation(value, unit);
    }
}
