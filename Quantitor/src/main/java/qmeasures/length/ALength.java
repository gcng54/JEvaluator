package qmeasures.length;

import qmeasures.core.AQuantity;

/**
 * Abstract length quantity.
 */
public abstract class ALength<Q extends ALength<Q>> extends AQuantity<Q, ELengths, ELengthDims> {

    protected ALength(double value, ELengths unit, ELengthDims dimension) {  super(value, unit, dimension);  }

    protected ALength(double value, ELengthDims dimension) {  super(value, ELengths.METER, dimension);  }

    protected ALength(double value) {  super(value, ELengths.METER, ELengthDims.LENGTH);  }

    @Override public abstract Q of(double value, ELengths unit);

    @Override public ELengths getUnit() { return (ELengths) super.getUnit(); }
    
    @Override public ELengthDims getDimension() { return (ELengthDims) super.getDimension(); }

    @Override public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; };

    @Override public Q to(ELengths unit) {
        double baseValue = this.getUnit().toBaseValue(this.getValue());
        double newValue = unit.fromBaseValue(baseValue);
        return of(newValue, unit);
    }

    public ALength<?> toQ(ELengthDims dimension) {
        return switch (dimension) {
            case ELengthDims.LENGTH ->  toQLength();
            case ELengthDims.DISTANCE ->  toQDistance();
            case ELengthDims.ALTITUDE ->  toQAltitude();
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    // Dimension Conversions

    public QLength toQLength(){ return new QLength(this.getValue(), this.getUnit()); }

    public QDistance toQDistance(){ return new QDistance(this.getValue(), this.getUnit()); }

    public QAltitude toQAltitude(){ return new QAltitude(this.getValue(), this.getUnit()); }

    // convert to specific units
    
	public Q toMeter() { return this.to(ELengths.METER);}

	public Q toKilometer() {return this.to(ELengths.KILOMETER);	}

	public Q toMillimeter() {return this.to(ELengths.MILLIMETER);	}

	public Q toFoot() {	return this.to(ELengths.FOOT);}

	public Q toNauticalMile() {	return this.to(ELengths.NAUTMILE);}

	public Q toDataMile() {	return this.to(ELengths.DATAMILE);	}

	public Q toFlightLevel() {	return this.to(ELengths.FLIGHTLEVEL);}

	public Q toYard() {	return this.to(ELengths.YARD);}

	public Q toInch() {	return this.to(ELengths.INCH);	}

	public Q toMile() {	return this.to(ELengths.MILE);}

    // get value in specific units

	public double inMeter() { return this.of(ELengths.METER);	}

	public double inKilometer() { return this.of(ELengths.KILOMETER);	}

    public double inMillimeter() { return this.of(ELengths.MILLIMETER);	}

	public double inYard() { return this.of(ELengths.YARD);	}

    public double inFoot() { return this.of(ELengths.FOOT);	}

	public double inInch() { return this.of(ELengths.INCH);	}

    public double inMile() { return this.of(ELengths.MILE);	}

	public double inNautMile() { return this.of(ELengths.NAUTMILE);	}

	public double inDataMile() { return this.of(ELengths.DATAMILE);	}

	public double inFlightLevel() { return this.of(ELengths.FLIGHTLEVEL);	}


}

