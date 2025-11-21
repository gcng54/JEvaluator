package qmeasures.power.quantities;

import qmeasures.power.units.EPowerUnit;

/**
 * Abstract base class for specific power dimensions.
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class APowerDim<Q extends APowerDim<Q>> extends APower<Q> {

    protected APowerDim(double value, EPowerUnit unit, EPowerDims dimension) {
        super(value, unit, dimension);
    }

    protected APowerDim(APower<?> time, EPowerDims dimension) {
        super(time.getValue(), time.getUnit(), dimension);
    }
    protected APowerDim(APower<?> time) {super(time.getValue(), time.getUnit(), EPowerDims.POWER);  }
    
    public Q of(APower<?> time){  return of(time.getValue(), time.getUnit()); };

}