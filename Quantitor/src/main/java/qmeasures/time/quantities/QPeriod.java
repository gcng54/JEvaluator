package qmeasures.time.quantities;


import qmeasures.time.units.ETimeUnit;

public class QPeriod extends ATimeDim<QPeriod> {

    public QPeriod(ATime<?> time) { super(time, ETimeDims.PERIOD);  }

	public QPeriod(double value, ETimeUnit unit) { super(value, unit, ETimeDims.PERIOD); }

    public QPeriod(double value) { this(value, ETimeUnit.SECOND); }
    
    @Override public QPeriod of(double value, ETimeUnit unit) {  return new QPeriod(value, unit);   }

}