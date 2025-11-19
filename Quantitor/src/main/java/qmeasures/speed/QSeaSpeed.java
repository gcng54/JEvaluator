package qmeasures.speed;

public class QSeaSpeed extends ASpeed<QSeaSpeed> {

    public QSeaSpeed(double value, ESpeeds unit) { super(value, unit, ESpeedDims.SEA_SPEED);}

    public QSeaSpeed(double value) { this(value, ESpeeds.KNOTS);  }

    @Override public QSeaSpeed of(Double value, ESpeeds unit) { return new QSeaSpeed(value, unit); }

}
