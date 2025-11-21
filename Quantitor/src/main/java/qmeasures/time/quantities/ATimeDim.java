package qmeasures.time.quantities;

import qmeasures.time.units.ETimes;

/**
 * Abstract base class for specific time dimensions.
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class ATimeDim<Q extends ATimeDim<Q>> extends ATime<Q> {

    protected ATimeDim(double value, ETimes unit, ETimeDims dimension) {
        super(value, unit, dimension);
    }

    protected ATimeDim(ATime<?> time, ETimeDims dimension) {
        super(time.getValue(), time.getUnit(), dimension);
    }
    protected ATimeDim(ATime<?> time) {super(time.getValue(), time.getUnit(), ETimeDims.TIME);  }
    
    public Q of(ATime<?> time){  return of(time.getValue(), time.getUnit()); };

}