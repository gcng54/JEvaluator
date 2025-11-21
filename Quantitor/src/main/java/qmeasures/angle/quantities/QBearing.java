package qmeasures.angle.quantities;

import qmeasures.angle.units.EAngles;

public final class QBearing extends AAngleDim<QBearing> {

    public QBearing(AAngle<?> Angle) {
        super(Angle, EAngleDims.BEARING);
    }

    protected QBearing(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.BEARING);
    }

    public QBearing(double value, EAngles unit) {
        super(value, unit, EAngleDims.BEARING);
    }

    @Override public QBearing of(double value, EAngles unit) {
        return new QBearing(value, unit);
    }
}
