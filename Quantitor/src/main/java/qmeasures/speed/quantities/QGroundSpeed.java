
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeedUnit;

/**
 * Speed quantity representing ground speed (typically measured in km/h).
 */
public class QGroundSpeed extends ASpeedDim<QGroundSpeed> {

    public QGroundSpeed(ASpeed<?> speed) { super(speed, ESpeedDims.GROUND_SPEED); }

    protected QGroundSpeed(double value) { super(value, ESpeedUnit.KILOMETERS_PER_HOUR, ESpeedDims.GROUND_SPEED); }

    public QGroundSpeed(double value, ESpeedUnit unit) { super(value, unit, ESpeedDims.GROUND_SPEED);}
    
    @Override public QGroundSpeed of(double value, ESpeedUnit unit) { return new QGroundSpeed(value, unit); }

}
