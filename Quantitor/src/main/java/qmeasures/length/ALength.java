package qmeasures.length;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;

/**
 * Abstract length quantity.
 */
public abstract class ALength<Q extends ALength<Q>> extends AQuantity<Q, ELengths, ELengthDims> {

    protected ALength(Double value, ELengths unit, ELengthDims dimension) {  super(value, unit, dimension);  }

    protected ALength(Double value, ELengthDims dimension) {  super(value, ELengths.METER, dimension);  }

    protected ALength(Double value) {  super(value, ELengths.METER, ELengthDims.LENGTH);  }

    @Override public abstract Q of(Double value, ELengths unit);

    @Override public ELengths getUnit() { return (ELengths) super.getUnit(); }
    
    @Override public ELengthDims getDimension() { return (ELengthDims) super.getDimension(); }

    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; };

    public ALength<?> toDimension(ELengthDims dimension) {
        return switch (dimension) {
            case ELengthDims.LENGTH ->  toQLength();
            case ELengthDims.DISTANCE ->  toQDistance();
            case ELengthDims.ALTITUDE ->  toQAltitude();
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    public QArea toArea(Q length) {
        if (length == null) {
            throw new IllegalArgumentException("Cannot take the nullified length.");
        }
        double new_value = Math.pow(length.getValue(), 2);
        return new QArea(new_value, this.getUnit());
    }

    public QVolume toVolume(Q length) {
        if (length == null) {
            throw new IllegalArgumentException("Cannot take the nullified length.");
        }
        double new_value = Math.pow(length.getValue(), 3);
        return new QVolume(new_value, this.getUnit());
    }

    public QLength div (QLength divisor) {
        if (divisor.getBaseValue() == 0 || divisor == null) {
            throw new IllegalArgumentException("Division by zero or null is not allowed.");
        }
        double new_value = this.getUnit().fromBaseValue(this.getBaseValue() / divisor.getBaseValue());
        return new QLength(new_value, this.getUnit());
    }

    // Dimension Conversions

    public QLength toQLength(){ return new QLength(this.getValue(), this.getUnit()); }

    public QDistance toQDistance(){ return new QDistance(this.getValue(), this.getUnit()); }

    public QAltitude toQAltitude(){ return new QAltitude(this.getValue(), this.getUnit()); }

    public QEarthecric toQEarthecric(){ return new QEarthecric(this.getValue(), this.getUnit()); }

    public QRange toQRange(){ return new QRange(this.getValue(), this.getUnit()); }

    public QHeight toQHeight(){ return new QHeight(this.getValue(), this.getUnit()); }

    public QElevation toQElevation(){ return new QElevation(this.getValue(), this.getUnit()); }

    public QWaveLength toQWaveLength(){ return new QWaveLength(this.getValue(), this.getUnit()); }

    

    // convert of specific units
    
	public Q ofMeter() { return this.of(ELengths.METER);}
	public Q ofKilometer() {return this.of(ELengths.KILOMETER);	}
	public Q ofMillimeter() {return this.of(ELengths.MILLIMETER);	}
	public Q ofFoot() {	return this.of(ELengths.FOOT);}
	public Q ofNauticalMile() {	return this.of(ELengths.NAUTMILE);}
	public Q ofDataMile() {	return this.of(ELengths.DATAMILE);	}
	public Q ofFlightLevel() {	return this.of(ELengths.FLIGHTLEVEL);}
	public Q ofYard() {	return this.of(ELengths.YARD);}
	public Q ofInch() {	return this.of(ELengths.INCH);	}
	public Q ofMile() {	return this.of(ELengths.MILE);}

    // convert of specific units with value
    public Q ofMeter(Double value) { return this.of(value, ELengths.METER);}
    public Q ofKilometer(Double value) {return this.of(value, ELengths.KILOMETER);	}
    public Q ofMillimeter(Double value) {return this.of(value, ELengths.MILLIMETER);	}
    public Q ofFoot(Double value) {	return this.of(value, ELengths.FOOT);}
    public Q ofNauticalMile(Double value) {	return this.of(value, ELengths.NAUTMILE);}
    public Q ofDataMile(Double value) {	return this.of(value, ELengths.DATAMILE);	}
    public Q ofFlightLevel(Double value) {	return this.of(value, ELengths.FLIGHTLEVEL);}
    public Q ofYard(Double value) {	return this.of(value, ELengths.YARD);}
    public Q ofInch(Double value) {	return this.of(value, ELengths.INCH);	}
    public Q ofMile(Double value) {	return this.of(value, ELengths.MILE);}

    // get value in specific units

	public Double inMeter() { return this.inUnit(ELengths.METER);	}
	public Double inKilometer() { return this.inUnit(ELengths.KILOMETER);	}
    public Double inMillimeter() { return this.inUnit(ELengths.MILLIMETER);	}
	public Double inYard() { return this.inUnit(ELengths.YARD);	}
    public Double inFoot() { return this.inUnit(ELengths.FOOT);	}
	public Double inInch() { return this.inUnit(ELengths.INCH);	}
    public Double inMile() { return this.inUnit(ELengths.MILE);	}
	public Double inNautMile() { return this.inUnit(ELengths.NAUTMILE);	}
	public Double inDataMile() { return this.inUnit(ELengths.DATAMILE);	}
	public Double inFlightLevel() { return this.inUnit(ELengths.FLIGHTLEVEL);	}

}

