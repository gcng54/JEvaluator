package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing azimuth.
 */
public final class QAzimuth extends AAngle<QAzimuth> {

    public QAzimuth(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.AZIMUTH);
    }

    public QAzimuth(Double value, EAngles unit) {
        super(value, unit, EAngleDims.AZIMUTH);
    }

    @Override public QAzimuth of(Double value, EAngles unit) {
        return new QAzimuth(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };


}
