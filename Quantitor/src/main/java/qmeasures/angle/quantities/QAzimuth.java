package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.units.QDegree;

/**
 * Concrete angle quantity representing azimuth.
 */
public final class QAzimuth extends AAngle<QAzimuth> {
    public QAzimuth(QDegree Degree) {
        super(Degree.getValue(), EAngles.DEGREE, EAngleDims.AZIMUTH);
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
