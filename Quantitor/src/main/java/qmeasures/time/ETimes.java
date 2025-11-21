
package qmeasures.time;

import java.util.Locale;
import qmeasures.core.IUnit;
import qmeasures.time.quantities.ETimeDims;

/**
 * Enumeration of time units (e.g., SECOND, MINUTE, HOUR, DAY).
 * Provides conversion factors and symbols for each unit.
 */
public enum ETimes implements IUnit<ETimes> {
	/** Generic time unit (T, factor 1) */
	TIME("T", 1.0),
	/** Second (base unit) */
	SECOND("sec", 1.0),
	/** Minute */
	MINUTE("min", 60.0),
	/** Hour */
	HOUR("hr", 3_600.0),
	/** Day */
	DAY("d", 86_400.0),
	/** Week */
	WEEK("wk", 604_800.0),
	/** Month (30 days) */
	MONTH("mo", 2_592_000.0),
	/** Year (365 days) */
	YEAR("yr", 31_536_000.0),
	/** Decade (10 years) */
	DECADE("dec", 315_360_000.0),
	/** Century (100 years) */
	CENTURY("cen", 3_153_600_000.0);

	private final String symbol;
	private final double factor;

	/**
	 * Constructs a time unit with the given symbol and conversion factor to seconds.
	 * @param symbol the unit symbol
	 * @param factor the conversion factor to seconds
	 */
	ETimes(String symbol, double factor) {
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
	@Override public ETimes getBaseUnit() { return SECOND; }

	/**
	 * Gets the base dimension for this unit (always TIME).
	 * @return the base dimension
	 */
	@Override public ETimeDims getBaseDimension() { return ETimeDims.TIME; }

	/**
	 * Gets the enum value from a string name (case-insensitive).
	 * @param name_ the name
	 * @return the ETimes value
	 */
	public static ETimes fromName(String name_) {
		return ETimes.valueOf(name_.toUpperCase(Locale.ENGLISH));
	}

	/**
	 * Returns a human-readable string for this unit.
	 * @return the unit name
	 */
	@Override public String toString() { return IUnit.toSentenceCase(this.name()) + "s"; }
}
