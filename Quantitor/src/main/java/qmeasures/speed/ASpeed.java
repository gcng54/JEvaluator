package qmeasures.speed;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;

/**
 * Abstract base class for all speed quantities (e.g., airspeed, ground speed, sea speed).
 * Provides unit conversion, dimension conversion, and arithmetic operations for speed.
 *
 * @param <Q> the concrete type of the speed quantity
 */
public abstract class ASpeed<Q extends ASpeed<Q>> extends AQuantity<Q, ESpeeds, ESpeedDims> {

    /**
     * Constructs a speed quantity with the specified value, unit, and dimension.
     * @param value the value in the given unit
     * @param unit the speed unit
     * @param dimension the speed dimension
     */
    protected ASpeed(Double value, ESpeeds unit, ESpeedDims dimension) {  super(value, unit, dimension);  }

    /**
     * Constructs a speed quantity with the specified value and dimension, using meters per second as the unit.
     * @param value the value in m/s
     * @param dimension the speed dimension
     */
    protected ASpeed(Double value, ESpeedDims dimension) {  super(value, ESpeeds.METERS_PER_SECOND, dimension);  }

    /**
     * Constructs a speed quantity with the specified value, using meters per second and SPEED as defaults.
     * @param value the value in m/s
     */
    protected ASpeed(Double value) {  super(value, ESpeeds.METERS_PER_SECOND, ESpeedDims.SPEED);  }

    /**
     * Creates a new instance of this speed type with the given value and unit.
     * @param value the value
     * @param unit the unit
     * @return a new instance of Q
     */
    @Override public abstract Q of(Double value, ESpeeds unit);

    /**
     * Gets the unit of this speed quantity.
     * @return the speed unit
     */
    @Override public ESpeeds getUnit() { return (ESpeeds) super.getUnit(); }
    
    /**
     * Gets the dimension of this speed quantity.
     * @return the speed dimension
     */
    @Override public ESpeedDims getDimension() { return (ESpeedDims) super.getDimension(); }

    /**
     * Returns the clamping mode for speed quantities (BOUND).
     * @return the clamp mode
     */
    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; };

    /**
     * Converts this speed to another dimension (e.g., airspeed, ground speed, sea speed).
     * @param dimension the target dimension
     * @return a new speed quantity of the target dimension
     */
    public ASpeed<?> toDimension(ESpeedDims dimension) {
        return switch (dimension) {
            case SPEED ->  toQSpeed();
            case GROUND_SPEED ->  toQGroundSpeed();
            case SEA_SPEED ->  toQSeaSpeed();
            case AIR_SPEED ->  toQAirSpeed();
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    /**
     * Converts this speed to a specific type using reflection.
     * @param targetType the target class
     * @return a new instance of the target type
     * @param <T> the type of speed
     */
    public <T extends ASpeed<T>> T to(Class<T> targetType) {
        try {
            return targetType.getConstructor(Double.class, ESpeeds.class)
                            .newInstance(this.getValue(), this.getUnit());
        } catch (Exception e) {
            throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
        }
    }

    // Dimension Conversions

    /** @return this speed as a QSpeed */
    public QSpeed toQSpeed(){ return new QSpeed(this.getValue(), this.getUnit()); }
    /** @return this speed as a QGroundSpeed */
    public QGroundSpeed toQGroundSpeed(){ return new QGroundSpeed(this.getValue(), this.getUnit()); }
    /** @return this speed as a QSeaSpeed */
    public QSeaSpeed toQSeaSpeed(){ return new QSeaSpeed(this.getValue(), this.getUnit()); }
    /** @return this speed as a QAirSpeed */
    public QAirSpeed toQAirSpeed(){ return new QAirSpeed(this.getValue(), this.getUnit()); }

    // Get Quantity of this.value in Unit

    /** @return this speed in meters per second */
    public Q ofMeterPerSecond() { return this.of(ESpeeds.METERS_PER_SECOND); }
    /** @return this speed in kilometers per hour */
    public Q ofKilometerPerHour() { return this.of(ESpeeds.KILOMETERS_PER_HOUR); }
    
    // Get value in specific units

    /** @return the value in meters per second */
    public Double inMeterPerSecond() { return this.inUnit(ESpeeds.METERS_PER_SECOND); }
    /** @return the value in kilometers per hour */
    public Double inKilometerPerHour() { return this.inUnit(ESpeeds.KILOMETERS_PER_HOUR); }
    
}