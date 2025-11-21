package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.RDegMinSec;
import qmeasures.angle.units.QDegree;
import qmeasures.core.Clampable;

import java.util.Locale;

/**
 * Concrete angle quantity representing latitude.
 * Format is a "%02d:%02d:%05.2f.%c"
 */
public final class QLatitude extends AAngle<QLatitude> {

    public QLatitude(QDegree Degree) {
        super(Degree.getValue(), EAngles.DEGREE, EAngleDims.LATITUDE);
    }

    protected QLatitude(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.LATITUDE);
    }

    public QLatitude(double value, EAngles unit) {
        super(value, unit, EAngleDims.LATITUDE);
    }

    @Override public QLatitude of(double value, EAngles unit) {
        return new QLatitude(value, unit);
    }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.LATITUDE; }


    public String toStringDMSO() {

        RDegMinSec degMinSec = this.getDegMinSec();

        char orientation = getBaseValue() >= 0 ? 'N' : 'S';

        return String.format(Locale.ENGLISH,"%02d:%02d:%05.2f.%c",
                             degMinSec.absDegree(), degMinSec.Minute(), degMinSec.Second(), orientation);
    }

}
