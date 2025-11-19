package qmeasures.speed;

public class QMeterPerSec extends ASpeed<QMeterPerSec> {

    public QMeterPerSec(double value) { super(value, ESpeeds.METERS_PER_SECOND, ESpeedDims.SPEED);  }
    
    @Override  public QMeterPerSec of(Double value, ESpeeds unit) { return new QMeterPerSec(value);  }

}