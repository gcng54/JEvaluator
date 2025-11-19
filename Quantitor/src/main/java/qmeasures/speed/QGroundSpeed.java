package qmeasures.speed;

public class QGroundSpeed extends ASpeed<QGroundSpeed> {

    public QGroundSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.GROUND_SPEED);}

    public QGroundSpeed(double value) { this(value, ESpeeds.KILOMETERS_PER_HOUR);  }

    @Override public QGroundSpeed of(Double value, ESpeeds unit) { return new QGroundSpeed(value, unit); }

}
