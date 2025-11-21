package qmeasures.time;

import qmeasures.time.quantities.ATime;
import qmeasures.time.quantities.ETimeDims;

public class QTime extends ATime<QTime> {

	public QTime(double value, ETimes unit) { super(value, unit, ETimeDims.TIME);}

    public QTime(double value) { this(value, ETimes.SECOND);  }

    @Override public QTime of(double value, ETimes unit) { return new QTime(value, unit); }

}