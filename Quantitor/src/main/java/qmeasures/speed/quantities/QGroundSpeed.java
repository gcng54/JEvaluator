
package qmeasures.speed.quantities;

import qmeasures.speed.units.ESpeeds;

/**
 * Speed quantity representing ground speed (typically measured in km/h).
 */
public class QGroundSpeed extends ASpeedDim<QGroundSpeed> {

    public QGroundSpeed(ASpeed<?> speed) { super(speed, ESpeedDims.GROUND_SPEED); }

    protected QGroundSpeed(double value) { super(value, ESpeeds.KILOMETERS_PER_HOUR, ESpeedDims.GROUND_SPEED); }

    public QGroundSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.GROUND_SPEED);}
    
    @Override public QGroundSpeed of(double value, ESpeeds unit) { return new QGroundSpeed(value, unit); }

}
