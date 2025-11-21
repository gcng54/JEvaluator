
package qmeasures.pressure.units;

import java.util.Locale;
import qmeasures.core.IUnit;
import qmeasures.pressure.quantities.EPressureDims;

/**
 * Enumeration of time units (e.g., SECOND, MINUTE, HOUR, DAY).
 * Provides conversion factors and symbols for each unit.
 */
public enum EPressureUnit implements IUnit<EPressureUnit> {
	PASCAL("Pa", 1.0),
	HECTOPASCAL("hPa", 100.0),
	KILOPASCAL("kPa", 1000.0),
	MEGAPASCAL("MPa", 1000000.0),
	BAR("bar", 100000.0),
	MILLIBAR("mbar", 100.0),
	PSI("psi", 6894.76),
	ATMOSPHERE("atm", 101325.0);

	

	private final String symbol;
	private final double factor;

	/**
	 * Constructs a time unit with the given symbol and conversion factor to seconds.
	 * @param symbol the unit symbol
	 * @param factor the conversion factor to seconds
	 */
	EPressureUnit(String symbol, double factor) {
		validateFactor(factor);
		this.symbol = symbol;
		this.factor = factor;
	}

	/**
	 * Gets the symbol for this unit.
	 * @return the unit symbol
	 */
	@Override public String getSymbol() { return symbol; }

	/**
	 * Gets the conversion factor to seconds.
	 * @return the factor
	 */
	@Override public double getFactor() { return factor; }

	/**
	 * Gets the base unit for this unit (always SECOND).
	 * @return the base unit
	 */
	@Override public EPressureUnit getBaseUnit() { return PASCAL; }

	/**
	 * Gets the base dimension for this unit (always TIME).
	 * @return the base dimension
	 */
	@Override public EPressureDims getBaseDimension() { return EPressureDims.PRESSURE; }

	/**
	 * Gets the enum value from a string name (case-insensitive).
	 * @param name_ the name
	 * @return the ETimes value
	 */
	public static EPressureUnit fromName(String name_) {
		return EPressureUnit.valueOf(name_.toUpperCase(Locale.ENGLISH));
	}

	/**
	 * Returns a human-readable string for this unit.
	 * @return the unit name
	 */
	@Override public String toString() { return IUnit.toSentenceCase(this.name()) + "s"; }
}
