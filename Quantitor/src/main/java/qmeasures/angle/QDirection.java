package qmeasures.angle;

/**
 * Concrete angle quantity representing direction.
 */
public final class QDirection extends AAngle<QDirection> {

    public QDirection(double value) {
        super(value, EAngles.DEGREE, EAngleDims.DIRECTION);
    }

    public QDirection(double value, EAngles unit) {
        super(value, unit, EAngleDims.DIRECTION);
    }

    @Override public QDirection of(double value, EAngles unit) {
        return new QDirection(value, unit);
    }

}
