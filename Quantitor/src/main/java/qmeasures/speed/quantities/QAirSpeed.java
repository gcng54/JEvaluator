
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeedUnit;

public class QAirSpeed extends ASpeedDim<QAirSpeed> {

    public QAirSpeed(ASpeed<?> speed) { super(speed, ESpeedDims.AIR_SPEED); }

    protected QAirSpeed(double value) { super(value, ESpeedUnit.KNOTS, ESpeedDims.AIR_SPEED); }

    public QAirSpeed(double value, ESpeedUnit unit) { super(value, unit, ESpeedDims.AIR_SPEED);}

    @Override public QAirSpeed of(double value, ESpeedUnit unit) { return new QAirSpeed(value, unit); }

}
