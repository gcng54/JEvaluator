package qmeasures.time;


public class QDuration extends ATime<QDuration> {

	public QDuration(double value, ETimes unit) { super(value, unit, ETimeDims.DURATION); }

    public QDuration(double value) { this(value, ETimes.SECOND); }

    @Override public QDuration of(Double value, ETimes unit) {  return new QDuration(value, unit);   }

}