package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing rotation.
 */
public final class QRotation extends AAngle<QRotation> {

    public QRotation(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.ROTATION);
    }

    public QRotation(Double value, EAngles unit) {
        super(value, unit, EAngleDims.ROTATION);
    }

    @Override public QRotation of(Double value, EAngles unit) {
        return new QRotation(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };
}
