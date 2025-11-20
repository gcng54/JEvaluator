package qmeasures.angle;

/**
 * Concrete angle quantity representing bearing.
 */
public final class QBearing extends AAngle<QBearing> {

    public QBearing(double value) {
        super(value, EAngles.DEGREE, EAngleDims.BEARING);
    }

    public QBearing(double value, EAngles unit) {
        super(value, unit, EAngleDims.BEARING);
    }

    @Override public QBearing of(double value, EAngles unit) {
        return new QBearing(value, unit);
    }
}
