
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeeds;

/**
 * Speed quantity representing sea speed (typically measured in knots).
 */
public class QSeaSpeed extends ASpeedDim<QSeaSpeed> {

    public QSeaSpeed(ASpeed<?> speed) { super(speed, ESpeedDims.SEA_SPEED); }

    protected QSeaSpeed(double value) { super(value, ESpeeds.KNOTS, ESpeedDims.SEA_SPEED); }
    
    public QSeaSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.SEA_SPEED);}

    @Override public QSeaSpeed of(double value, ESpeeds unit) { return new QSeaSpeed(value, unit); }

}
