package qmeasures.speed;

public class QAirSpeed extends ASpeed<QAirSpeed> {

    public QAirSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.AIR_SPEED);}

    public QAirSpeed(double value) { this(value, ESpeeds.KNOTS);  }

    @Override public QAirSpeed of(Double value, ESpeeds unit) { return new QAirSpeed(value, unit); }

}
