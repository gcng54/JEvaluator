package qmeasures.angle;

/**
 * Concrete angle quantity representing orientation.
 */
public final class QOrientation extends AAngle<QOrientation> {

    public QOrientation(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.ORIENTATION);
    }

    public QOrientation(Double value, EAngles unit) {
        super(value, unit, EAngleDims.ORIENTATION);
    }

    @Override public QOrientation of(Double value, EAngles unit) {
        return new QOrientation(value, unit);
    }
}
