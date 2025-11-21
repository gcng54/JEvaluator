
package qmeasures.length.units;

import java.util.Locale;
import qmeasures.core.IUnit;
import qmeasures.length.quantities.ELengthDims;

/**
 * Enumeration of common length units, with meter as the base unit.
 * Provides conversion factors and symbols for each unit.
 */
public enum ELengths implements IUnit<ELengths> {
  /** Meter (base unit) */
  METER("m", 1.0),
  /** Kilometer */
  KILOMETER("km", 1_000.0),
  /** Millimeter */
  MILLIMETER("mm", 0.001),
  /** Mile */
  MILE("mi", 1609.344),
  /** Yard */
  YARD("yd", 0.9144),
  /** Foot */
  FOOT("ft", 0.3048),
  /** Inch */
  INCH("in", 0.0254),
  /** Nautical Mile */
  NAUTICALMILE("NM", 1852.0),
  /** Data Mile (6000 feet) */
  DATAMILE("DM", 1828.8),
  /** Flight Level (100 feet) */
  FLIGHTLEVEL("FL", 30.48);
    
  private final String symbol;
  private final double factor;

  /**
   * Constructs a length unit with the given symbol and conversion factor to meters.
   * @param symbol the unit symbol
   * @param factor the conversion factor to meters
   */
  ELengths(String symbol, double factor) {
    validateFactor(factor);
    this.factor = factor;
    this.symbol = symbol;
  }

  /**
   * Gets the symbol for this unit.
   * @return the unit symbol
   */
  @Override public String getSymbol() { return symbol; }

  /**
   * Gets the conversion factor to meters.
   * @return the factor
   */
  @Override public double getFactor() { return factor; }

  /**
   * Returns a human-readable string for this unit.
   * @return the unit name
   */
  @Override public String toString() {
    return switch (this) {
      case FOOT -> "Feet";
      case INCH -> "Inches";
      case FLIGHTLEVEL -> "FlightLevel";
      default -> IUnit.toSentenceCase(this.name()) + "s";
    };
  }

  /**
   * Gets the enum value from a string name (case-insensitive).
   * @param name_ the name
   * @return the ELengths value
   */
  public static ELengths fromName(String name_) {
    return ELengths.valueOf(name_.toUpperCase(Locale.ENGLISH));
  }

  /**
   * Gets the base dimension for this unit (always LENGTH).
   * @return the base dimension
   */
  @Override public ELengthDims getBaseDimension() { return ELengthDims.LENGTH; }

  /**
   * Gets the base unit for this unit (always METER).
   * @return the base unit
   */
  @Override public ELengths getBaseUnit() { return ELengths.METER; }

}

