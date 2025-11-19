package qmeasures.time;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;

public abstract class ATime<Q extends ATime<Q>> extends AQuantity<Q, ETimes, ETimeDims> {

    protected ATime(Double value, ETimes unit, ETimeDims dimension) {  super(value, unit, dimension);  }

    protected ATime(Double value, ETimeDims dimension) {  super(value, ETimes.SECOND, dimension);  }

    protected ATime(Double value) {  super(value, ETimes.SECOND, ETimeDims.TIME);  }
    @Override public abstract Q of(Double value, ETimes unit);

    @Override public ETimes getUnit() { return (ETimes) super.getUnit(); }
    
    @Override public ETimeDims getDimension() { return (ETimeDims) super.getDimension(); }

    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; };

    public ATime<?> toDimension(ETimeDims dimension) {
        return switch (dimension) {
            case ETimeDims.TIME ->  toQTime();
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    // Dimension Conversions

    public QTime toQTime(){ return new QTime(this.getValue(), this.getUnit()); }

	// Get Quantity of this.value in Unit

	public Q ofSecond() { return this.of(ETimes.SECOND);	}
	public Q ofMinute() { return this.of(ETimes.MINUTE);	}
	public Q ofHour() {	return this.of(ETimes.HOUR);	}
	public Q ofDay() { return this.of(ETimes.DAY);	}
	public Q ofWeek() {	return this.of(ETimes.WEEK);	}
	public Q ofMonth() { return this.of(ETimes.MONTH);	}
	public Q ofYear() {	return this.of(ETimes.YEAR);	}
	public Q ofDecade() { return this.of(ETimes.DECADE);	}
	public Q ofCentury() { return this.of(ETimes.CENTURY);	}

	// Get Quantity of value in Unit

	public Double inSecond() { return this.inUnit(ETimes.SECOND);	}
	public Double inMinute() { return this.inUnit(ETimes.MINUTE);	}
	public Double inHour() { return this.inUnit(ETimes.HOUR);	}
	public Double inDay() { return this.inUnit(ETimes.DAY);	}
	public Double inWeek() { return this.inUnit(ETimes.WEEK);	}
	public Double inMonth() { return this.inUnit(ETimes.MONTH);	}
	public Double inYear() { return this.inUnit(ETimes.YEAR);	}
	public Double inDecade() { return this.inUnit(ETimes.DECADE);	}
	public Double inCentury() { return this.inUnit(ETimes.CENTURY);	}

}