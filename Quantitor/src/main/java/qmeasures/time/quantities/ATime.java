
package qmeasures.time.quantities;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.time.units.ETimeUnit;

/**
 * Abstract base class for all time quantities (e.g., duration, period, frequency).
 * Provides unit conversion, dimension conversion, and arithmetic operations for time.
 *
 * @param <Q> the concrete type of the time quantity
 */
public abstract class ATime<Q extends ATime<Q>> extends AQuantity<Q, ETimeUnit, ETimeDims> {

	/**
	 * Constructs a time quantity with the specified value, unit, and dimension.
	 * @param value the value in the given unit
	 * @param unit the time unit
	 * @param dimension the time dimension
	 */
	protected ATime(double value, ETimeUnit unit, ETimeDims dimension) {  super(value, unit, dimension);  }

	/**
	 * Constructs a time quantity with the specified value and dimension, using seconds as the unit.
	 * @param value the value in seconds
	 * @param dimension the time dimension
	 */
	protected ATime(double value, ETimeDims dimension) {  super(value, ETimeUnit.SECOND, dimension);  }

	/**
	 * Constructs a time quantity with the specified value, using seconds and TIME as defaults.
	 * @param value the value in seconds
	 */
	protected ATime(double value) {  super(value, ETimeUnit.SECOND, ETimeDims.TIME);  }

	/**
	 * Creates a new instance of this time type with the given value and unit.
	 * @param value the value
	 * @param unit the unit
	 * @return a new instance of Q
	 */
	@Override public abstract Q of(double value, ETimeUnit unit);

	/**
	 * Gets the unit of this time quantity.
	 * @return the time unit
	 */
	@Override public ETimeUnit getUnit() { return super.getUnit(); }
    
	/**
	 * Gets the dimension of this time quantity.
	 * @return the time dimension
	 */
	@Override public ETimeDims getDimension() { return  super.getDimension(); }

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
	public ATime<?> toDimension(ETimeDims dimension) {
		return switch (dimension) {
			case TIME ->  to(QTime.class);
			case DURATION ->  to(QDuration.class);
			case PERIOD ->  to(QPeriod.class);
			case FREQUENCY ->  to(QFrequency.class);
        };
	}

	/**
	 * Converts this time to a specific type using reflection.
	 * @param targetType the target class
	 * @return a new instance of the target type
	 * @param <T> the type of time
	 */
	public <T extends ATime<T>> T to(Class<T> targetType) {
		try {
			return targetType.getConstructor(double.class, ETimeUnit.class)
							.newInstance(this.getValue(), this.getUnit());
		} catch (Exception e) {
			throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
		}
	}

	// Unit conversion methods

	/** @return this time in seconds */
	public Q ofSecond() { return this.of(ETimeUnit.SECOND); }
	/** @return this time in minutes */
	public Q ofMinute() { return this.of(ETimeUnit.MINUTE); }
	/** @return this time in hours */
	public Q ofHour() { return this.of(ETimeUnit.HOUR); }
	/** @return this time in days */
	public Q ofDay() { return this.of(ETimeUnit.DAY); }
	/** @return this time in weeks */
	public Q ofWeek() { return this.of(ETimeUnit.WEEK); }
	/** @return this time in months */
	public Q ofMonth() { return this.of(ETimeUnit.MONTH); }
	/** @return this time in years */
	public Q ofYear() { return this.of(ETimeUnit.YEAR); }
	/** @return this time in decades */
	public Q ofDecade() { return this.of(ETimeUnit.DECADE); }
	/** @return this time in centuries */
	public Q ofCentury() { return this.of(ETimeUnit.CENTURY); }

	// Unit conversion with value

	/** @return a new time in seconds */
	public Q ofSecond(double value) { return this.of(value, ETimeUnit.SECOND); }
	/** @return a new time in minutes */
	public Q ofMinute(double value) { return this.of(value, ETimeUnit.MINUTE); }
	/** @return a new time in hours */
	public Q ofHour(double value) { return this.of(value, ETimeUnit.HOUR); }
	/** @return a new time in days */
	public Q ofDay(double value) { return this.of(value, ETimeUnit.DAY); }
	/** @return a new time in weeks */
	public Q ofWeek(double value) { return this.of(value, ETimeUnit.WEEK); }
	/** @return a new time in months */
	public Q ofMonth(double value) { return this.of(value, ETimeUnit.MONTH); }
	/** @return a new time in years */
	public Q ofYear(double value) { return this.of(value, ETimeUnit.YEAR); }
	/** @return a new time in decades */
	public Q ofDecade(double value) { return this.of(value, ETimeUnit.DECADE); }
	/** @return a new time in centuries */
	public Q ofCentury(double value) { return this.of(value, ETimeUnit.CENTURY); }

	// Get value in specific units

	/** @return the value in seconds */
	public double inSecond() { return this.inUnit(ETimeUnit.SECOND); }
	/** @return the value in minutes */
	public double inMinute() { return this.inUnit(ETimeUnit.MINUTE); }
	/** @return the value in hours */
	public double inHour() { return this.inUnit(ETimeUnit.HOUR); }
	/** @return the value in days */
	public double inDay() { return this.inUnit(ETimeUnit.DAY); }
	/** @return the value in weeks */
	public double inWeek() { return this.inUnit(ETimeUnit.WEEK); }
	/** @return the value in months */
	public double inMonth() { return this.inUnit(ETimeUnit.MONTH); }
	/** @return the value in years */
	public double inYear() { return this.inUnit(ETimeUnit.YEAR); }
	/** @return the value in decades */
	public double inDecade() { return this.inUnit(ETimeUnit.DECADE); }
	/** @return the value in centuries */
	public double inCentury() { return this.inUnit(ETimeUnit.CENTURY); }

}