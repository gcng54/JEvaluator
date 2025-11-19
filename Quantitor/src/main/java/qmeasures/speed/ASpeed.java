package qmeasures.speed;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;

/**
 * Abstract speed quantity.
 */
public abstract class ASpeed<Q extends ASpeed<Q>> extends AQuantity<Q, ESpeeds, ESpeedDims> {

    protected ASpeed(Double value, ESpeeds unit, ESpeedDims dimension) {  super(value, unit, dimension);  }

    protected ASpeed(Double value, ESpeedDims dimension) {  super(value, ESpeeds.METERS_PER_SECOND, dimension);  }
    protected ASpeed(Double value) {  super(value, ESpeeds.METERS_PER_SECOND, ESpeedDims.SPEED);  }
    @Override public abstract Q of(Double value, ESpeeds unit);

    @Override public ESpeeds getUnit() { return (ESpeeds) super.getUnit(); }
    
    @Override public ESpeedDims getDimension() { return (ESpeedDims) super.getDimension(); }

    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.BOUND; };

    public ASpeed<?> toDimension(ESpeedDims dimension) {
        return switch (dimension) {
            case ESpeedDims.SPEED ->  toQSpeed();
            case ESpeedDims.GROUND_SPEED ->  toQGroundSpeed();
            case ESpeedDims.SEA_SPEED ->  toQSeaSpeed();
            case ESpeedDims.AIR_SPEED ->  toQAirSpeed();
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    public <T extends ASpeed<T>> T to(Class<T> targetType) {
    // Use reflection or a factory to create the target type
        try {
            return targetType.getConstructor(Double.class, ESpeeds.class)
                            .newInstance(this.getValue(), this.getUnit());
        } catch (Exception e) {
            throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
        }
    }

    // Dimension Conversions

    public QSpeed toQSpeed(){ return new QSpeed(this.getValue(), this.getUnit()); }
    public QGroundSpeed toQGroundSpeed(){ return new QGroundSpeed(this.getValue(), this.getUnit()); }
    public QSeaSpeed toQSeaSpeed(){ return new QSeaSpeed(this.getValue(), this.getUnit()); }
    public QAirSpeed toQAirSpeed(){ return new QAirSpeed(this.getValue(), this.getUnit()); }

	// Get Quantity of this.value in Unit

	public Q ofMeterPerSecond() { return this.of(ESpeeds.METERS_PER_SECOND);	}
	public Q ofKilometerPerHour() { return this.of(ESpeeds.KILOMETERS_PER_HOUR);	}
	
	// Get Quantity of value in Unit

	public Double inMeterPerSecond() { return this.inUnit(ESpeeds.METERS_PER_SECOND);	}
	public Double inKilometerPerHour() { return this.inUnit(ESpeeds.KILOMETERS_PER_HOUR);	}
	
}