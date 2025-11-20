package qmeasures.angle;

/**
 * Concrete angle quantity representing orientation.
 */
public final class QOrientation extends AAngle<QOrientation> {

    public QOrientation(double value) {
        super(value, EAngles.DEGREE, EAngleDims.ORIENTATION);
    }

    public QOrientation(double value, EAngles unit) {
        super(value, unit, EAngleDims.ORIENTATION);
    }

    @Override public QOrientation of(double value, EAngles unit) {
        return new QOrientation(value, unit);
    }

    public enum EOrientation {
        N, S, E, W
    }
}
