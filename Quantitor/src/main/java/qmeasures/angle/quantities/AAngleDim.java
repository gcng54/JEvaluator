package qmeasures.angle.quantities;

import qmeasures.angle.EAngles;

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

	/**
	 * Constructs an angle quantity with the specified value, using degrees and ANGLE as defaults.
	 * @param value the value in degrees
	 */
	protected AAngleDim(AAngle<?> Angle, EAngleDims dimension) {super(Angle.getValue(), Angle.getUnit(), dimension);  }
    
	/**
	 * Constructs an angle quantity with the specified value, using degrees and ANGLE as defaults.
	 * @param value the value in degrees
	 */
	protected AAngleDim(AAngle<?> Angle) {super(Angle.getValue(), Angle.getUnit(), EAngleDims.ANGLE);  }

	/**
	 * Creates a new instance of this angle type with the given value and unit.
	 * @param value the value
	 * @param unit the unit
	 * @return a new instance of Q
	 */
	public Q of(AAngle<?> Angle){
        return of(Angle.getValue(), Angle.getUnit());
    };


    // You can add dimension-specific logic here if needed
}
