package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing longitude.
 */
public final class QLongitude extends AAngle<QLongitude> {

    public QLongitude(double value) {
        super(value, EAngles.DEGREE, EAngleDims.LONGITUDE);
    }

    public QLongitude(double value, EAngles unit) {
        super(value, unit, EAngleDims.LONGITUDE);
    }

    @Override public QLongitude of(double value, EAngles unit) {
        return new QLongitude(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.LONGITUDE; };
}
