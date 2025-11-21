package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;

/**
 * Concrete angle quantity representing heading.
 */
public final class QHeading extends AAngleDim<QHeading> {

    public QHeading(AAngle<?> Angle) {
        super(Angle, EAngleDims.HEADING);
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
