package qmeasures.speed;

public class QSpeed extends ASpeed<QSpeed> {

	public QSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.SPEED);}

    public QSpeed(double value) { this(value, ESpeeds.METERS_PER_SECOND);  }

    @Override public QSpeed of(Double value, ESpeeds unit) { return new QSpeed(value, unit); }

}