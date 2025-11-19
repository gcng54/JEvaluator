package qmeasures.time;


public class QFrequency extends ATime<QFrequency> {

	public QFrequency(double value, ETimes unit) { super(value, unit, ETimeDims.FREQUENCY); }

    public QFrequency(double value) { this(value, ETimes.SECOND); }

    @Override public QFrequency of(Double value, ETimes unit) {  return new QFrequency(value, unit);   }

}