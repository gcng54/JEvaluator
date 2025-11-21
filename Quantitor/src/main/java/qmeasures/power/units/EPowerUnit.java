
package qmeasures.power.units;

import java.util.Locale;
import qmeasures.core.IUnit;
import qmeasures.power.quantities.EPowerDims;

/**
 * Enumeration of time units (e.g., SECOND, MINUTE, HOUR, DAY).
 * Provides conversion factors and symbols for each unit.
 */
public enum EPowerUnit implements IUnit<EPowerUnit> {
	WATT("W", 1.0),
	KILOWATT("kW", 1_000.0),
	MEGAWATT("MW", 1_000_000.0),
	GIGAWATT("GW", 1_000_000_000.0),
	BTU_PER_HOUR("BTU/hr", 0.29307107),
	FOOT_POUND_PER_SECOND("ft·lbf/s", 1.355817948),
	HORSE_POWER("hp", 745.69987158227022);

	private final String symbol;
	private final double factor;

	/**
	 * Constructs a time unit with the given symbol and conversion factor to seconds.
	 * @param symbol the unit symbol
	 * @param factor the conversion factor to seconds
	 */
	EPowerUnit(String symbol, double factor) {
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
	@Override public EPowerUnit getBaseUnit() { return WATT; }

	/**
	 * Gets the base dimension for this unit (always TIME).
	 * @return the base dimension
	 */
	@Override public EPowerDims getBaseDimension() { return EPowerDims.POWER; }

	/**
	 * Gets the enum value from a string name (case-insensitive).
	 * @param name_ the name
	 * @return the ETimes value
	 */
	public static EPowerUnit fromName(String name_) {
		return EPowerUnit.valueOf(name_.toUpperCase(Locale.ENGLISH));
	}

	/**
	 * Returns a human-readable string for this unit.
	 * @return the unit name
	 */
	@Override public String toString() { return IUnit.toSentenceCase(this.name()) + "s"; }
}
