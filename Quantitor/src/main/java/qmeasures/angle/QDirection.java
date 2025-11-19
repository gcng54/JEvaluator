package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing direction.
 */
public final class QDirection extends AAngle<QDirection> {

    public QDirection(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.DIRECTION);
    }

    public QDirection(Double value, EAngles unit) {
        super(value, unit, EAngleDims.DIRECTION);
    }

    @Override public QDirection of(Double value, EAngles unit) {
        return new QDirection(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };
}
