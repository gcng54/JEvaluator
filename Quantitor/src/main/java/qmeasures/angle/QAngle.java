package qmeasures.angle;

/**
 * Concrete base angle quantity representing a angle dimension.
 */
public final class QAngle extends AAngle<QAngle> {

    public QAngle(double value) {
        super(value, EAngles.DEGREE, EAngleDims.ANGLE);
    }

    public QAngle(double value, EAngles unit) {
        super(value, unit, EAngleDims.ANGLE);
    }

    @Override public QAngle of(double value, EAngles unit) {
        return new QAngle(value, unit);
    }


}

