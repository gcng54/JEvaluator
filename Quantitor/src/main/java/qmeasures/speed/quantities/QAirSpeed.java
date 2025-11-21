
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeeds;

public class QAirSpeed extends ASpeedDim<QAirSpeed> {

    public QAirSpeed(ASpeed<?> speed) { super(speed, ESpeedDims.AIR_SPEED); }

    protected QAirSpeed(double value) { super(value, ESpeeds.KNOTS, ESpeedDims.AIR_SPEED); }

    public QAirSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.AIR_SPEED);}

    @Override public QAirSpeed of(double value, ESpeeds unit) { return new QAirSpeed(value, unit); }

}
