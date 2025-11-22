
package qmeasures.length.quantities;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.length.units.ELengthUnit;

/**
 * Abstract base class for all length quantities (e.g., distance, altitude, height).
 * Provides unit conversion, dimension conversion, and arithmetic operations for lengths.
 *
 * @param <Q> the concrete type of the length quantity
 */
public abstract class ALength<Q extends ALength<Q>> extends AQuantity<Q, ELengthUnit, ELengthDims> {

    /**
     * Constructs a length quantity with the specified value, unit, and dimension.
     * @param value the value in the given unit
     * @param unit the length unit
     * @param dimension the length dimension
     */
    protected ALength(double value, ELengthUnit unit, ELengthDims dimension) {  super(value, unit, dimension);  }

    /**
     * Constructs a length quantity with the specified value and dimension, using meters as the unit.
     * @param value the value in meters
     * @param dimension the length dimension
     */
    protected ALength(double value, ELengthDims dimension) {  super(value, ELengthUnit.METER, dimension);  }

    /**
     * Constructs a length quantity with the specified value, using meters and LENGTH as defaults.
     * @param value the value in meters
     */
    protected ALength(double value) {  super(value, ELengthUnit.METER, ELengthDims.LENGTH);  }

    /**
     * Constructs a length quantity with the specified value, using meters and LENGTH as defaults.
     * @param value the value in meters
     */
    protected ALength() {  super(0.0, ELengthUnit.METER, ELengthDims.LENGTH);  }

    /**
     * Creates a new instance of this length type with the given value and unit.
     * @param value the value
     * @param unit the unit
     * @return a new instance of Q
     */
    @Override public abstract Q of(double value, ELengthUnit unit);

    /**
     * Gets the unit of this length quantity.
     * @return the length unit
     */
    @Override public ELengthUnit getUnit() { return super.getUnit(); }
    
    /**
     * Gets the dimension of this length quantity.
     * @return the length dimension
     */
    @Override public ELengthDims getDimension() { return super.getDimension(); }

    /**
     * Returns the clamping mode for length quantities (BOUND).
     * @return the clamp mode
     */
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; }

    /**
     * Converts this length to a specific type using reflection.
     * @param targetType the target class
     * @return a new instance of the target type
     * @param <T> the type of length
     */
    public <T extends ALength<T>> T to(Class<T> targetType) {
        try {
            return targetType.getConstructor(double.class, ELengthUnit.class)
                            .newInstance(this.getValue(), this.getUnit());
        } catch (Exception e) {
            throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
        }
    }

    // Dimension Conversions

    /**
     * Returns the area (square) of the given length.
     * @param length the length
     * @return a QArea instance
     */
    public QArea toArea(Q length) {
        if (length == null) {
            throw new IllegalArgumentException("Cannot take the nullified length.");
        }
        double new_value = Math.pow(length.getValue(), 2);
        return new QArea(new_value, this.getUnit());
    }

    /**
     * Returns the volume (cube) of the given length.
     * @param length the length
     * @return a QVolume instance
     */
    public QVolume toVolume(Q length) {
        if (length == null) {
            throw new IllegalArgumentException("Cannot take the nullified length.");
        }
        double new_value = Math.pow(length.getValue(), 3);
        return new QVolume(new_value, this.getUnit());
    }

    /**
     * Divides this length by another length, returning a QLength.
     * @param divisor the divisor length
     * @return a QLength instance
     */
    public QLength div (QLength divisor) {
        if (divisor == null || divisor.getBaseValue() == 0) {
            throw new IllegalArgumentException("Division by zero or null is not allowed.");
        }
        double new_value = this.getUnit().fromBaseValue(this.getBaseValue() / divisor.getBaseValue());
        return new QLength(new_value, this.getUnit());
    }

    // Unit conversion methods

	/** @return this length in meters */
	public Q ofMeter() { return this.of(ELengthUnit.METER);}
	/** @return this length in kilometers */
	public Q ofKilometer() {return this.of(ELengthUnit.KILOMETER);}
	/** @return this length in millimeters */
	public Q ofMillimeter() {return this.of(ELengthUnit.MILLIMETER);}
	/** @return this length in feet */
	public Q ofFoot() {return this.of(ELengthUnit.FOOT);}
	/** @return this length in nautical miles */
	public Q ofNauticalMile() {return this.of(ELengthUnit.NAUTICALMILE);}
	/** @return this length in data miles */
	public Q ofDataMile() {return this.of(ELengthUnit.DATAMILE);}
	/** @return this length in flight levels */
	public Q ofFlightLevel() {return this.of(ELengthUnit.FLIGHTLEVEL);}
	/** @return this length in yards */
	public Q ofYard() {return this.of(ELengthUnit.YARD);}
	/** @return this length in inches */
	public Q ofInch() {return this.of(ELengthUnit.INCH);}
	/** @return this length in miles */
	public Q ofMile() {return this.of(ELengthUnit.MILE);}

    // Unit conversion with value

    /** @return a new length in meters */
    public Q ofMeter(double value) { return this.of(value, ELengthUnit.METER);}    
    /** @return a new length in kilometers */
    public Q ofKilometer(double value) {return this.of(value, ELengthUnit.KILOMETER);}    
    /** @return a new length in millimeters */
    public Q ofMillimeter(double value) {return this.of(value, ELengthUnit.MILLIMETER);}    
    /** @return a new length in feet */
    public Q ofFoot(double value) {return this.of(value, ELengthUnit.FOOT);}    
    /** @return a new length in nautical miles */
    public Q ofNauticalMile(double value) {return this.of(value, ELengthUnit.NAUTICALMILE);}
    /** @return a new length in data miles */
    public Q ofDataMile(double value) {return this.of(value, ELengthUnit.DATAMILE);}    
    /** @return a new length in flight levels */
    public Q ofFlightLevel(double value) {return this.of(value, ELengthUnit.FLIGHTLEVEL);}    
    /** @return a new length in yards */
    public Q ofYard(double value) {return this.of(value, ELengthUnit.YARD);}    
    /** @return a new length in inches */
    public Q ofInch(double value) {return this.of(value, ELengthUnit.INCH);}    
    /** @return a new length in miles */
    public Q ofMile(double value) {return this.of(value, ELengthUnit.MILE);}    

    // Get value in specific units

    /** @return the value in meters */
    public double inMeter() { return this.inUnit(ELengthUnit.METER);}    
    /** @return the value in kilometers */
    public double inKilometer() { return this.inUnit(ELengthUnit.KILOMETER);}    
    /** @return the value in millimeters */
    public double inMillimeter() { return this.inUnit(ELengthUnit.MILLIMETER);}    
    /** @return the value in yards */
    public double inYard() { return this.inUnit(ELengthUnit.YARD);}    
    /** @return the value in feet */
    public double inFoot() { return this.inUnit(ELengthUnit.FOOT);}    
    /** @return the value in inches */
    public double inInch() { return this.inUnit(ELengthUnit.INCH);}    
    /** @return the value in miles */
    public double inMile() { return this.inUnit(ELengthUnit.MILE);}    
    /** @return the value in nautical miles */
    public double inNauticalMile() { return this.inUnit(ELengthUnit.NAUTICALMILE);}
    /** @return the value in data miles */
    public double inDataMile() { return this.inUnit(ELengthUnit.DATAMILE);}    
    /** @return the value in flight levels */
    public double inFlightLevel() { return this.inUnit(ELengthUnit.FLIGHTLEVEL);}    

}

