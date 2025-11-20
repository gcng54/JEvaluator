package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing rotation.
 */
public final class QRotation extends AAngle<QRotation> {

    public QRotation(double value) {
        super(value, EAngles.DEGREE, EAngleDims.ROTATION);
    }

    public QRotation(double value, EAngles unit) {
        super(value, unit, EAngleDims.ROTATION);
    }

    @Override public QRotation of(double value, EAngles unit) {
        return new QRotation(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };
}
