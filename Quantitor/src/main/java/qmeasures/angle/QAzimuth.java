package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing azimuth.
 */
public final class QAzimuth extends AAngle<QAzimuth> {

    public QAzimuth(double value) {
        super(value, EAngles.DEGREE, EAngleDims.AZIMUTH);
    }

    public QAzimuth(double value, EAngles unit) {
        super(value, unit, EAngleDims.AZIMUTH);
    }

    @Override public QAzimuth of(double value, EAngles unit) {
        return new QAzimuth(value, unit);
    }

}
