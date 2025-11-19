package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing heading.
 */
public final class QHeading extends AAngle<QHeading> {

    public QHeading(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.HEADING);
    }

    public QHeading(Double value, EAngles unit) {
        super(value, unit, EAngleDims.HEADING);
    }

    @Override public QHeading of(Double value, EAngles unit) {
        return new QHeading(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };

}
