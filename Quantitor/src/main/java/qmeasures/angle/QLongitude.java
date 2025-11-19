package qmeasures.angle;

import qmeasures.core.Clampable;

/**
 * Concrete angle quantity representing longitude.
 */
public final class QLongitude extends AAngle<QLongitude> {

    public QLongitude(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.LONGITUDE);
    }

    public QLongitude(Double value, EAngles unit) {
        super(value, unit, EAngleDims.LONGITUDE);
    }

    @Override public QLongitude of(Double value, EAngles unit) {
        return new QLongitude(value, unit);
    }

    @Override
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.LONGITUDE; };
}
