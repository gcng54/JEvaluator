package qmeasures.speed.units;

import java.util.Locale;

import org.jetbrains.annotations.NotNull;
import qmeasures.core.IUnit;
import qmeasures.speed.quantities.ESpeedDims;

/**
 * Enumeration of speed units (e.g., meters per second, kilometers per hour, knots).
 * Provides conversion factors and symbols for each unit.
 */
public enum ESpeeds implements IUnit<ESpeeds> {
  /** Meters per second (base unit) */
  METERS_PER_SECOND("m/s", 1.0),
  /** Kilometers per hour */
  KILOMETERS_PER_HOUR("km/h", 0.277778),
  /** Miles per hour */
  MILES_PER_HOUR("mph", 0.44704),
  /** Knots (nautical miles per hour) */
  KNOTS("kn", 0.514444),
  /** Mach number 
   * Typical value at sea level is approximately 340.29 m/s */
  MACH("Mach", 340.29);

  private final String symbol;
  private final double factor;

  /**
   * Constructs a speed unit with the given symbol and conversion factor to meters per second.
   * @param symbol the unit symbol
   * @param factor the conversion factor to meters per second
   */
  ESpeeds(String symbol, double factor) {
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
   * Gets the conversion factor to meters per second.
   * @return the factor
   */
  @Override public double getFactor() { return factor; }

  /**
   * Returns a human-readable string for this unit.
   * @return the unit name
   */
  @Override public String toString() {
    return switch (this) {
      case KNOTS -> "knots";
      case METERS_PER_SECOND -> "meters/second";
      case KILOMETERS_PER_HOUR -> "kilometers/hour";
      case MILES_PER_HOUR -> "miles/hour";
      case MACH -> "Mach";
    };
  }

  /**
   * Gets the enum value from a string name (case-insensitive).
   * @param name_ the name
   * @return the ESpeeds value
   */
  public static ESpeeds fromName(@NotNull String name_) { return ESpeeds.valueOf(name_.toUpperCase(Locale.ENGLISH)); }

  /**
   * Gets the base dimension for this unit (always SPEED).
   * @return the base dimension
   */
  @Override public ESpeedDims getBaseDimension() { return ESpeedDims.SPEED; }

  /**
   * Gets the base unit for this unit (always METERS_PER_SECOND).
   * @return the base unit
   */
  @Override public ESpeeds getBaseUnit() { return ESpeeds.METERS_PER_SECOND; }

}

