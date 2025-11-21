package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.RDegMinSec;
import qmeasures.angle.units.QDegree;
import qmeasures.core.Clampable;

import java.util.Locale;

/**
 * Concrete angle quantity representing longitude.
 * Format is a "%03d:%02d:%05.2f%.c"
 */
public final class QLongitude extends AAngle<QLongitude> {

    public QLongitude(QDegree Degree) {
        super(Degree.getValue(), EAngles.DEGREE, EAngleDims.LONGITUDE);
    }

    protected QLongitude(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.LONGITUDE);
    }

    public QLongitude(double value, EAngles unit) {
        super(value, unit, EAngleDims.LONGITUDE);
    }

    @Override public QLongitude of(double value, EAngles unit) {
        return new QLongitude(value, unit);
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.LONGITUDE; }

    public String toStringDMS() {

        RDegMinSec degMinSec = this.getDegMinSec();

        char orientation = getBaseValue() >= 0 ? 'E' : 'W';

        return String.format(Locale.ENGLISH,"%03d:%02d:%05.2f%.c",
                degMinSec.absDegree(), degMinSec.Minute(), degMinSec.Second(), orientation);
    }
}
