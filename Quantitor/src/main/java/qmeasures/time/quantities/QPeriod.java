package qmeasures.time.quantities;


import qmeasures.time.ETimes;

public class QPeriod extends ATimeDim<QPeriod> {

    public QPeriod(ATime<?> time) { super(time, ETimeDims.PERIOD);  }

	public QPeriod(double value, ETimes unit) { super(value, unit, ETimeDims.PERIOD); }

    public QPeriod(double value) { this(value, ETimes.SECOND); }
    
    @Override public QPeriod of(double value, ETimes unit) {  return new QPeriod(value, unit);   }

}