
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeedUnit;

/**
 * Speed quantity representing sea speed (typically measured in knots).
 */
public class QSeaSpeed extends ASpeedDim<QSeaSpeed> {

    public QSeaSpeed(ASpeed<?> speed) { super(speed, ESpeedDims.SEA_SPEED); }

    protected QSeaSpeed(double value) { super(value, ESpeedUnit.KNOTS, ESpeedDims.SEA_SPEED); }
    
    public QSeaSpeed(double value, ESpeedUnit unit) { super(value, unit, ESpeedDims.SEA_SPEED);}

    @Override public QSeaSpeed of(double value, ESpeedUnit unit) { return new QSeaSpeed(value, unit); }

}
