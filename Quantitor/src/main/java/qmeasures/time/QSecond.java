package qmeasures.time;

public class QSecond extends ATime<QSecond> {

    public QSecond(double value) { super(value, ETimes.SECOND, ETimeDims.TIME);  }

    @Override  public QSecond of(Double value, ETimes unit) { return new QSecond(value);  }

}