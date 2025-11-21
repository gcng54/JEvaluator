
package qmeasures.length.quantities;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.length.ELengths;
import qmeasures.length.QArea;
import qmeasures.length.QLength;
import qmeasures.length.QVolume;

/**
 * Abstract base class for all length quantities (e.g., distance, altitude, height).
 * Provides unit conversion, dimension conversion, and arithmetic operations for lengths.
 *
 * @param <Q> the concrete type of the length quantity
 */
public abstract class ALength<Q extends ALength<Q>> extends AQuantity<Q, ELengths, ELengthDims> {

    /**
     * Constructs a length quantity with the specified value, unit, and dimension.
     * @param value the value in the given unit
     * @param unit the length unit
     * @param dimension the length dimension
     */
    protected ALength(double value, ELengths unit, ELengthDims dimension) {  super(value, unit, dimension);  }

    /**
     * Constructs a length quantity with the specified value and dimension, using meters as the unit.
     * @param value the value in meters
     * @param dimension the length dimension
     */
    protected ALength(double value, ELengthDims dimension) {  super(value, ELengths.METER, dimension);  }

    /**
     * Constructs a length quantity with the specified value, using meters and LENGTH as defaults.
     * @param value the value in meters
     */
    protected ALength(double value) {  super(value, ELengths.METER, ELengthDims.LENGTH);  }

    /**
     * Creates a new instance of this length type with the given value and unit.
     * @param value the value
     * @param unit the unit
     * @return a new instance of Q
     */
    @Override public abstract Q of(double value, ELengths unit);

    /**
     * Gets the unit of this length quantity.
     * @return the length unit
     */
    @Override public ELengths getUnit() { return super.getUnit(); }
    
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
     * Converts this length to another dimension (e.g., area, volume).
     * @param dimension the target dimension
     * @return a new length quantity of the target dimension
     */
    public ALength<?> toDimension(ELengthDims dimension) {
        return switch (dimension) {
            case LENGTH ->  to(QLength.class);
            case DISTANCE ->  to(QDistance.class);
            case ALTITUDE ->  to(QAltitude.class);
            case EARTH_RADIUS ->  to(QEarthRadius.class);
            case ELEVATION ->  to(QElevation.class);
            case RANGE ->  to(QRange.class);
            case HEIGHT ->  to(QHeight.class);
            case WAVE_LENGTH ->  to(QWaveLength.class);
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    /**
     * Converts this length to a specific type using reflection.
     * @param targetType the target class
     * @return a new instance of the target type
     * @param <T> the type of length
     */
    public <T extends ALength<T>> T to(Class<T> targetType) {
        try {
            return targetType.getConstructor(double.class, ELengths.class)
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
	public Q ofMeter() { return this.of(ELengths.METER);}
	/** @return this length in kilometers */
	public Q ofKilometer() {return this.of(ELengths.KILOMETER);}
	/** @return this length in millimeters */
	public Q ofMillimeter() {return this.of(ELengths.MILLIMETER);}
	/** @return this length in feet */
	public Q ofFoot() {return this.of(ELengths.FOOT);}
	/** @return this length in nautical miles */
	public Q ofNauticalMile() {return this.of(ELengths.NAUTICALMILE);}
	/** @return this length in data miles */
	public Q ofDataMile() {return this.of(ELengths.DATAMILE);}
	/** @return this length in flight levels */
	public Q ofFlightLevel() {return this.of(ELengths.FLIGHTLEVEL);}
	/** @return this length in yards */
	public Q ofYard() {return this.of(ELengths.YARD);}
	/** @return this length in inches */
	public Q ofInch() {return this.of(ELengths.INCH);}
	/** @return this length in miles */
	public Q ofMile() {return this.of(ELengths.MILE);}

    // Unit conversion with value

    /** @return a new length in meters */
    public Q ofMeter(double value) { return this.of(value, ELengths.METER);}    
    /** @return a new length in kilometers */
    public Q ofKilometer(double value) {return this.of(value, ELengths.KILOMETER);}    
    /** @return a new length in millimeters */
    public Q ofMillimeter(double value) {return this.of(value, ELengths.MILLIMETER);}    
    /** @return a new length in feet */
    public Q ofFoot(double value) {return this.of(value, ELengths.FOOT);}    
    /** @return a new length in nautical miles */
    public Q ofNauticalMile(double value) {return this.of(value, ELengths.NAUTICALMILE);}
    /** @return a new length in data miles */
    public Q ofDataMile(double value) {return this.of(value, ELengths.DATAMILE);}    
    /** @return a new length in flight levels */
    public Q ofFlightLevel(double value) {return this.of(value, ELengths.FLIGHTLEVEL);}    
    /** @return a new length in yards */
    public Q ofYard(double value) {return this.of(value, ELengths.YARD);}    
    /** @return a new length in inches */
    public Q ofInch(double value) {return this.of(value, ELengths.INCH);}    
    /** @return a new length in miles */
    public Q ofMile(double value) {return this.of(value, ELengths.MILE);}    

    // Get value in specific units

    /** @return the value in meters */
    public double inMeter() { return this.inUnit(ELengths.METER);}    
    /** @return the value in kilometers */
    public double inKilometer() { return this.inUnit(ELengths.KILOMETER);}    
    /** @return the value in millimeters */
    public double inMillimeter() { return this.inUnit(ELengths.MILLIMETER);}    
    /** @return the value in yards */
    public double inYard() { return this.inUnit(ELengths.YARD);}    
    /** @return the value in feet */
    public double inFoot() { return this.inUnit(ELengths.FOOT);}    
    /** @return the value in inches */
    public double inInch() { return this.inUnit(ELengths.INCH);}    
    /** @return the value in miles */
    public double inMile() { return this.inUnit(ELengths.MILE);}    
    /** @return the value in nautical miles */
    public double inNauticalMile() { return this.inUnit(ELengths.NAUTICALMILE);}
    /** @return the value in data miles */
    public double inDataMile() { return this.inUnit(ELengths.DATAMILE);}    
    /** @return the value in flight levels */
    public double inFlightLevel() { return this.inUnit(ELengths.FLIGHTLEVEL);}    

}

