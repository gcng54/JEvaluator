package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.units.QDegree;

/**
 * Concrete angle quantity representing heading.
 */
public final class QHeading extends AAngle<QHeading> {

    public QHeading(QDegree Degree) {
        super(Degree.getValue(), EAngles.DEGREE, EAngleDims.HEADING);
    }

    protected QHeading(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.HEADING);
    }

    public QHeading(double value, EAngles unit) {
        super(value, unit, EAngleDims.HEADING);
    }

    @Override public QHeading of(double value, EAngles unit) {
        return new QHeading(value, unit);
    }

}
