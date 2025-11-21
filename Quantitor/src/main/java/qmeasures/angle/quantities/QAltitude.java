package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;

/**
 * Concrete angle quantity representing altitude.
 */
public final class QAltitude extends AAngleDim<QAltitude> {

    public QAltitude(AAngle<?> Angle) {
        super(Angle, EAngleDims.ALTITUDE);
    }

    protected QAltitude(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.ALTITUDE);
    }

    public QAltitude(double value, EAngles unit) {
        super(value, unit, EAngleDims.ALTITUDE);
    }

    @Override
    public QAltitude of(double value, EAngles unit) {
        return new QAltitude(value, unit);
    }

}