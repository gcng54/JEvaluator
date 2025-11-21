package qmeasures.angle.quantities;

import qmeasures.angle.units.EAngles;

/**
 * Abstract base class for specific angle dimensions (e.g., Latitude, Heading).
 * This separates "Dimension" quantities from "Unit" quantities (like QDegree).
 *
 * @param <Q> the concrete type of the dimension quantity
 */
public abstract class AAngleDim<Q extends AAngleDim<Q>> extends AAngle<Q> {

    protected AAngleDim(double value, EAngles unit, EAngleDims dimension) {
        super(value, unit, dimension);
    }

	protected AAngleDim(AAngle<?> Angle, EAngleDims dimension) {super(Angle.getValue(), Angle.getUnit(), dimension);  }
    
	protected AAngleDim(AAngle<?> Angle) {super(Angle.getValue(), Angle.getUnit(), EAngleDims.ANGLE);  }

	public Q of(AAngle<?> Angle){
        return of(Angle.getValue(), Angle.getUnit());
    };


}
