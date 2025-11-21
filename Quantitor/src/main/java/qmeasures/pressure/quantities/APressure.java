
package qmeasures.pressure.quantities;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.pressure.units.EPressureUnit;

/**
 * Abstract base class for all time quantities (e.g., duration, period, frequency).
 * Provides unit conversion, dimension conversion, and arithmetic operations for time.
 *
 * @param <Q> the concrete type of the time quantity
 */
public abstract class APressure<Q extends APressure<Q>> extends AQuantity<Q, EPressureUnit, EPressureDims> {

	/**
	 * Constructs a time quantity with the specified value, unit, and dimension.
	 * @param value the value in the given unit
	 * @param unit the pressure unit
	 * @param dimension the pressure dimension
	 */
	protected APressure(double value, EPressureUnit unit, EPressureDims dimension) {  super(value, unit, dimension);  }

	/**
	 * Constructs a time quantity with the specified value and dimension, using seconds as the unit.
	 * @param value the value in seconds
	 * @param dimension the pressure dimension
	 */
	protected APressure(double value, EPressureDims dimension) {  super(value, EPressureUnit.PASCAL, dimension);  }

	/**
	 * Constructs a pressure quantity with the specified value, using watts and POWER as defaults.
	 * @param value the value in watts
	 */
	protected APressure(double value) {  super(value, EPressureUnit.PASCAL, EPressureDims.PRESSURE);  }

	/**
	 * Creates a new instance of this time type with the given value and unit.
	 * @param value the value
	 * @param unit the unit
	 * @return a new instance of Q
	 */
	@Override public abstract Q of(double value, EPressureUnit unit);

	/**
	 * Gets the unit of this time quantity.
	 * @return the pressure unit
	 */
	@Override public EPressureUnit getUnit() { return super.getUnit(); }
    
	/**
	 * Gets the dimension of this pressure quantity.
	 * @return the pressure dimension
	 */
	@Override public EPressureDims getDimension() { return  super.getDimension(); }

	/**
	 * Returns the clamping mode for time quantities (BOUND).
	 * @return the clamp mode
	 */
	public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; }

	/**
	 * Converts this time to another dimension (e.g., duration, period, frequency).
	 * @param dimension the target dimension
	 * @return a new time quantity of the target dimension
	 */
	public APressure<?> toDimension(EPressureDims dimension) {
		return switch (dimension) {
			case PRESSURE ->  to(QPressure.class);
        };
	}

	/**
	 * Converts this time to a specific type using reflection.
	 * @param targetType the target class
	 * @return a new instance of the target type
	 * @param <T> the type of time
	 */
	public <T extends APressure<T>> T to(Class<T> targetType) {
		try {
			return targetType.getConstructor(double.class, EPressureUnit.class)
							.newInstance(this.getValue(), this.getUnit());
		} catch (Exception e) {
			throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
		}
	}

	// Unit conversion methods

	/** @return this time in seconds */
	public Q ofPascal() { return this.of(EPressureUnit.PASCAL); }
	public Q ofKilopascal() { return this.of(EPressureUnit.KILOPASCAL); }
	public Q ofMegapascal() { return this.of(EPressureUnit.MEGAPASCAL); }
	public Q ofBar() { return this.of(EPressureUnit.BAR); }
	public Q ofMillibar() { return this.of(EPressureUnit.MILLIBAR); }
	public Q ofPsi() { return this.of(EPressureUnit.PSI); }
	public Q ofAtmosphere() { return this.of(EPressureUnit.ATMOSPHERE); }
	
	
	
	// Unit conversion with value

	/** @return a new time in watts */
	public Q ofPascal(double value) { return this.of(value, EPressureUnit.PASCAL); }
	public Q ofKilopascal(double value) { return this.of(value, EPressureUnit.KILOPASCAL); }
	public Q ofMegapascal(double value) { return this.of(value, EPressureUnit.MEGAPASCAL); }
	public Q ofBar(double value) { return this.of(value, EPressureUnit.BAR); }
	public Q ofMillibar(double value) { return this.of(value, EPressureUnit.MILLIBAR); }
	public Q ofPsi(double value) { return this.of(value, EPressureUnit.PSI); }
	public Q ofAtmosphere(double value) { return this.of(value, EPressureUnit.ATMOSPHERE); }
	
	// Get value in specific units

	/** @return the value in seconds */
	public double inPascal() { return this.inUnit(EPressureUnit.PASCAL); }
	public double inKilopascal() { return this.inUnit(EPressureUnit.KILOPASCAL); }
	public double inMegapascal() { return this.inUnit(EPressureUnit.MEGAPASCAL); }
	public double inBar() { return this.inUnit(EPressureUnit.BAR); }
	public double inMillibar() { return this.inUnit(EPressureUnit.MILLIBAR); }
	public double inPsi() { return this.inUnit(EPressureUnit.PSI); }
	public double inAtmosphere() { return this.inUnit(EPressureUnit.ATMOSPHERE); }
	
	
}