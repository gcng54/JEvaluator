package qmeasures.time.quantities;


import qmeasures.time.units.ETimeUnit;

public class QTime extends ATimeDim<QTime> {

    public QTime(ATime<?> time) { super(time, ETimeDims.TIME); }

	public QTime(double value, ETimeUnit unit) { super(value, unit, ETimeDims.TIME);}

    protected QTime(double value) { this(value, ETimeUnit.SECOND);  }

    @Override public QTime of(double value, ETimeUnit unit) { return new QTime(value, unit); }

}