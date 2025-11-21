package qmeasures.pressure.quantities;

import qmeasures.pressure.units.EPressureUnit;

/**
 * Abstract base class for specific pressure dimensions.
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class APressureDim<Q extends APressureDim<Q>> extends APressure<Q> {

    protected APressureDim(double value, EPressureUnit unit, EPressureDims dimension) {
        super(value, unit, dimension);
    }

    protected APressureDim(APressure<?> time, EPressureDims dimension) {
        super(time.getValue(), time.getUnit(), dimension);
    }
    protected APressureDim(APressure<?> time) {super(time.getValue(), time.getUnit(), EPressureDims.PRESSURE);  }
    
    public Q of(APressure<?> time){  return of(time.getValue(), time.getUnit()); };

}