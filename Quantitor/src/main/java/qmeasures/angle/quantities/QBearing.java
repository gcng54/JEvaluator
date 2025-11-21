package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;
import qmeasures.angle.units.QDegree;

public final class QBearing extends AAngle<QBearing> {

    /**
     * Constructs a QBearing instance with the specified value in degrees.
     * <p>
     * This constructor initializes the bearing quantity using the given value,
     * setting the unit to degrees and the dimension to bearing.
     * </p>
     *
     * @param value the bearing value in degrees
     */
    public QBearing(QDegree Degree) {
        super(Degree.getValue(), EAngles.DEGREE, EAngleDims.BEARING);
    }

    protected QBearing(double degree) {
        super(degree, EAngles.DEGREE, EAngleDims.BEARING);
    }

    public QBearing(double value, EAngles unit) {
        super(value, unit, EAngleDims.BEARING);
    }

    @Override public QBearing of(double value, EAngles unit) {
        return new QBearing(value, unit);
    }
}
