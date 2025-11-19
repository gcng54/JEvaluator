package qmeasures.angle;

import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;

/**
 * Abstract angle quantity.
 */
public abstract class AAngle<Q extends AAngle<Q>> extends AQuantity<Q, EAngles, EAngleDims> {

    protected AAngle(Double value, EAngles unit, EAngleDims dimension) {  super(value, unit, dimension);  }

    protected AAngle(Double value, EAngleDims dimension) {  super(value, EAngles.DEGREE, dimension);  }

    protected AAngle(Double value) {  super(value, EAngles.DEGREE, EAngleDims.ANGLE);  }

    @Override public abstract Q of(Double value, EAngles unit);

    @Override public EAngles getUnit() { return (EAngles) super.getUnit(); }
    
    @Override public EAngleDims getDimension() { return (EAngleDims) super.getDimension(); }

    public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; };

    public AAngle<?> toDimension(EAngleDims dimension) {
        return switch (dimension) {
            case EAngleDims.ANGLE ->  to(QAngle.class);
			case EAngleDims.LATITUDE ->  to(QLatitude.class);
			case EAngleDims.LONGITUDE ->  to(QLongitude.class);
			case EAngleDims.BEARING ->  to(QBearing.class);
			case EAngleDims.AZIMUTH ->  to(QAzimuth.class);
			case EAngleDims.HEADING ->  to(QHeading.class);
			case EAngleDims.COURSE ->  to(QCourse.class);
			case EAngleDims.DIRECTION ->  to(QDirection.class);
			case EAngleDims.ROTATION ->  to(QRotation.class);
			case EAngleDims.ORIENTATION ->  to(QOrientation.class);
            default -> throw new IllegalStateException("Unexpected getBaseValue: " + dimension);
        };
    }

    public <T extends AAngle<T>> T to(Class<T> targetType) {
    // Use reflection or a factory to create the target type
        try {
            return targetType.getConstructor(Double.class, EAngles.class)
                            .newInstance(this.getValue(), this.getUnit());
        } catch (Exception e) {
            throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
        }
    }

	// TRIGONOMETRIC FUNCTIONS

	public double sin() { return (Math.sin(this.inRadian()));  }

	public double cos() { return (Math.cos(this.inRadian()));  }

	public double tan() {return (Math.tan(this.inRadian()));}

	public Q ofArcSin(double value) {
		if (value < -1.0 || value > 1.0) {
            throw new IllegalArgumentException("Value out of range for arcsine. Valid range is [-1, 1].");
        }
		return this.of(Math.asin(value), EAngles.RADIAN);
	}

	public Q ofArcCos(double value) {
		if (value < -1.0 || value > 1.0) {
			throw new IllegalArgumentException("Value out of range for arccosine. Valid range is [-1, 1].");
		}
		return this.of(Math.acos(value), EAngles.RADIAN);
	}

	public Q ofArcTan(double value) {return this.of(Math.atan(value), EAngles.RADIAN);	}

	public Q ofArcTan2(double value, double value2) {return this.of(Math.atan2(value, value2), EAngles.RADIAN);	}
	
	/**
	 * Compute azimuth in radians from x (east) and y (north) components.
	 * Convention: 0..2π, 0 = north, π/2 = east, π = south, 3π/2 = west.
	 * Returns 0.0 for the zero vector by convention.
	 *
	 * @param x east component
	 * @param y north component
	 * @return azimuth in radians in range [0, 2*PI)
	 * @throws IllegalArgumentException if x or y is Infinite or NaN
	 */
	public Q ofArcTanXY(double x, double y) {
		if (Double.isInfinite(x) || Double.isInfinite(y) || Double.isNaN(x) || Double.isNaN(y)) {
			throw new IllegalArgumentException("Invalid input: x and y must be finite numbers.");
		}
		// If both components are zero, return 0 by convention (undefined direction)
		if (x == 0.0 && y == 0.0) {
			return this.of(0.0);
		}
		// Use atan2(x, y) so north corresponds to 0 and positive x (east) gives positive clockwise angle
		double ang = Math.atan2(x, y); // returns [-PI, PI]
		if (ang < 0.0) ang += 2.0 * Math.PI; // normalize to [0, 2PI)
		return this.of(ang, EAngles.RADIAN);
	}

	/**
    void cardinalDirectionsDegrees() {
        // north
        assertEquals(0.0, AAngle.azimuthDegreesFromXY(0.0, 1.0), 1e-9);
        // east
        assertEquals(90.0, AAngle.azimuthDegreesFromXY(1.0, 0.0), 1e-9);
        // south
        assertEquals(180.0, AAngle.azimuthDegreesFromXY(0.0, -1.0), 1e-9);
        // west
        assertEquals(270.0, AAngle.azimuthDegreesFromXY(-1.0, 0.0), 1e-9);
    }
	*/

	// TURN CHECKS
    public boolean isTurnFull() { return isTurnRatio(1.0);  }

    public boolean isTurnHalf() { return isTurnRatio(0.5);  }

    public boolean isTurnQuarter() { return isTurnRatio(0.25);  }
	/**
	 * Checks if the angle represents a specific ratio of a full turn tolerance is (1e-10).
	 *
	 * @see #isQurnFull()
	 * @see #isQurnHalf()
	 * @see #isQurnQuarter()
	 *
	 * @param turnRatio Qhe ratio of a full turn to check against (e.g., 0.5 for half turn).
	 * @return true if the angle corresponds to the specified turn ratio, false otherwise.
	 */
    public boolean isTurnRatio(double turnRatio) {
		if (turnRatio < 0.0 || turnRatio > 1.0) {
			throw new IllegalArgumentException("Value out of range for turn ratio. Valid range is [0, 1].");
		}
        return Math.abs((this.getBaseValue() / (2.0 * Math.PI * turnRatio)) % 360) < 1e-10;
    }

    // convert of specific units
    
	public Q ofDegree() { return this.of(EAngles.DEGREE);}
	public Q ofRadian() {return this.of(EAngles.RADIAN);	}
	public Q ofTurn() {return this.of(EAngles.TURN);	}
    public Q ofGradian() {return this.of(EAngles.GRADIAN);	}
    public Q ofArcMinute() {return this.of(EAngles.ARC_MINUTE);	}
    public Q ofArcSecond() {return this.of(EAngles.ARC_SECOND);	}

	// convert of specific units with value

	public Q ofDegree(Double value) { return this.of(value, EAngles.DEGREE);}
	public Q ofRadian(Double value) {return this.of(value, EAngles.RADIAN);	}
	public Q ofTurn(Double value) {return this.of(value, EAngles.TURN);	}
	public Q ofGradian(Double value) {return this.of(value, EAngles.GRADIAN);	}
	public Q ofArcMinute(Double value) {return this.of(value, EAngles.ARC_MINUTE);	}
	public Q ofArcSecond(Double value) {return this.of(value, EAngles.ARC_SECOND);	}

    // get value in specific units

	public Double inDegree() { return this.inUnit(EAngles.DEGREE);	}
	public Double inRadian() { return this.inUnit(EAngles.RADIAN);	}
    public Double inTurn() { return this.inUnit(EAngles.TURN);	}
    public Double inGradian() { return this.inUnit(EAngles.GRADIAN);	}
    public Double inArcMinute() { return this.inUnit(EAngles.ARC_MINUTE);	}
    public Double inArcSecond() { return this.inUnit(EAngles.ARC_SECOND);	}
	
}

