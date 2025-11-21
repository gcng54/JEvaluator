package qmeasures.angle.quantities;

import qmeasures.angle.units.EAngles;


/**
 * Concrete angle quantity representing azimuth.
 */
public final class QAzimuth extends AAngleDim<QAzimuth> {
    public QAzimuth(AAngle<?> Angle) {
        super(Angle, EAngleDims.AZIMUTH);
    }

    protected QAzimuth(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.AZIMUTH);
    }

    public QAzimuth(double value, EAngles unit) {
        super(value, unit, EAngleDims.AZIMUTH);
    }

    @Override public QAzimuth of(double value, EAngles unit) {
        return new QAzimuth(value, unit);
    }

}
