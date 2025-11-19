package qmeasures.angle;

/**
 * Concrete angle quantity representing bearing.
 */
public final class QBearing extends AAngle<QBearing> {

    public QBearing(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.BEARING);
    }

    public QBearing(Double value, EAngles unit) {
        super(value, unit, EAngleDims.BEARING);
    }

    @Override public QBearing of(Double value, EAngles unit) {
        return new QBearing(value, unit);
    }
}
