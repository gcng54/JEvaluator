
package qmeasures.power.quantities;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.power.units.EPowerUnit;

/**
 * Abstract base class for all time quantities (e.g., duration, period, frequency).
 * Provides unit conversion, dimension conversion, and arithmetic operations for time.
 *
 * @param <Q> the concrete type of the time quantity
 */
public abstract class APower<Q extends APower<Q>> extends AQuantity<Q, EPowerUnit, EPowerDims> {

	/**
	 * Constructs a time quantity with the specified value, unit, and dimension.
	 * @param value the value in the given unit
	 * @param unit the power unit
	 * @param dimension the power dimension
	 */
	protected APower(double value, EPowerUnit unit, EPowerDims dimension) {  super(value, unit, dimension);  }

	/**
	 * Constructs a time quantity with the specified value and dimension, using seconds as the unit.
	 * @param value the value in seconds
	 * @param dimension the power dimension
	 */
	protected APower(double value, EPowerDims dimension) {  super(value, EPowerUnit.WATT, dimension);  }

	/**
	 * Constructs a power quantity with the specified value, using watts and POWER as defaults.
	 * @param value the value in watts
	 */
	protected APower(double value) {  super(value, EPowerUnit.WATT, EPowerDims.POWER);  }

	/**
	 * Creates a new instance of this time type with the given value and unit.
	 * @param value the value
	 * @param unit the unit
	 * @return a new instance of Q
	 */
	@Override public abstract Q of(double value, EPowerUnit unit);

	/**
	 * Gets the unit of this time quantity.
	 * @return the power unit
	 */
	@Override public EPowerUnit getUnit() { return super.getUnit(); }
    
	/**
	 * Gets the dimension of this power quantity.
	 * @return the power dimension
	 */
	@Override public EPowerDims getDimension() { return  super.getDimension(); }

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
	public APower<?> toDimension(EPowerDims dimension) {
		return switch (dimension) {
			case POWER ->  to(QPower.class);
        };
	}

	/**
	 * Converts this time to a specific type using reflection.
	 * @param targetType the target class
	 * @return a new instance of the target type
	 * @param <T> the type of time
	 */
	public <T extends APower<T>> T to(Class<T> targetType) {
		try {
			return targetType.getConstructor(double.class, EPowerUnit.class)
							.newInstance(this.getValue(), this.getUnit());
		} catch (Exception e) {
			throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
		}
	}

	// Unit conversion methods

	/** @return this time in seconds */
	public Q ofWatt() { return this.of(EPowerUnit.WATT); }
	public Q ofKilowatt() { return this.of(EPowerUnit.KILOWATT); }
	public Q ofMegawatt() { return this.of(EPowerUnit.MEGAWATT); }
	public Q ofGigawatt() { return this.of(EPowerUnit.GIGAWATT); }
	public Q ofBtuPerHour() { return this.of(EPowerUnit.BTU_PER_HOUR); }
	public Q ofFootPoundPerSecond() { return this.of(EPowerUnit.FOOT_POUND_PER_SECOND); }
	public Q ofHorsePower() { return this.of(EPowerUnit.HORSE_POWER); }
	
	// Unit conversion with value

	/** @return a new time in watts */
	public Q ofWatt(double value) { return this.of(value, EPowerUnit.WATT); }
	public Q ofKilowatt(double value) { return this.of(value, EPowerUnit.KILOWATT); }
	public Q ofMegawatt(double value) { return this.of(value, EPowerUnit.MEGAWATT); }
	public Q ofGigawatt(double value) { return this.of(value, EPowerUnit.GIGAWATT); }
	public Q ofBtuPerHour(double value) { return this.of(value, EPowerUnit.BTU_PER_HOUR); }
	public Q ofFootPoundPerSecond(double value) { return this.of(value, EPowerUnit.FOOT_POUND_PER_SECOND); }
	public Q ofHorsePower(double value) { return this.of(value, EPowerUnit.HORSE_POWER); }
	
	// Get value in specific units

	/** @return the value in seconds */
	public double inWatt() { return this.inUnit(EPowerUnit.WATT); }
	public double inKilowatt() { return this.inUnit(EPowerUnit.KILOWATT); }
	public double inMegawatt() { return this.inUnit(EPowerUnit.MEGAWATT); }
	public double inGigawatt() { return this.inUnit(EPowerUnit.GIGAWATT); }
	public double inBtuPerHour() { return this.inUnit(EPowerUnit.BTU_PER_HOUR); }
	public double inFootPoundPerSecond() { return this.inUnit(EPowerUnit.FOOT_POUND_PER_SECOND); }
	public double inHorsePower() { return this.inUnit(EPowerUnit.HORSE_POWER); }

	
}