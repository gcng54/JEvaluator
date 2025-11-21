package qmeasures.length.quantities;

import qmeasures.angle.quantities.AAngle;
import qmeasures.angle.quantities.EAngleDims;
import qmeasures.length.ELengths;

/**
 * Abstract base class for specific length dimensions.
 * This separates "Dimension" quantities from the generic "Unit" quantities.
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class ALengthDim<Q extends ALengthDim<Q>> extends ALength<Q> {

    protected ALengthDim(double value, ELengths unit, ELengthDims dimension) {
        super(value, unit, dimension);
    }

    protected ALengthDim(ALength<?> length, ELengthDims dimension) {
        super(length.getValue(), length.getUnit(), dimension);
    }

    protected ALengthDim(ALength<?> length) {super(length.getValue(), length.getUnit(), ELengthDims.LENGTH);  }

	public Q of(ALength<?> length){  return of(length.getValue(), length.getUnit()); };

}