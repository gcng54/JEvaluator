package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing latitude.
 */
public final class QLatitude extends AAngle<QLatitude> {

    public QLatitude(double value) {
        super(value, EAngles.DEGREE, EAngleDims.LATITUDE);
    }

    public QLatitude(double value, EAngles unit) {
        super(value, unit, EAngleDims.LATITUDE);
    }

    @Override public QLatitude of(double value, EAngles unit) {
        return new QLatitude(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.LATITUDE; };
}
