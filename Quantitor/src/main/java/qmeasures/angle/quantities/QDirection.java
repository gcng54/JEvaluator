package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.units.QDegree;

/**
 * Concrete angle quantity representing direction.
 */
public final class QDirection extends AAngle<QDirection> {

    public QDirection(QDegree Degree) {
        super(Degree.getValue(), EAngles.DEGREE, EAngleDims.DIRECTION);
    }

    protected QDirection(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.DIRECTION);
    }

    public QDirection(double value, EAngles unit) {
        super(value, unit, EAngleDims.DIRECTION);
    }

    @Override public QDirection of(double value, EAngles unit) {
        return new QDirection(value, unit);
    }

}
