package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing heading.
 */
public final class QHeading extends AAngle<QHeading> {

    public QHeading(double value) {
        super(value, EAngles.DEGREE, EAngleDims.HEADING);
    }

    public QHeading(double value, EAngles unit) {
        super(value, unit, EAngleDims.HEADING);
    }

    @Override public QHeading of(double value, EAngles unit) {
        return new QHeading(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };

}
