package qmeasures.angle.quantities;

import org.jetbrains.annotations.NotNull;

import qmeasures.angle.units.EAngles;
import qmeasures.core.AQuantity;
import qmeasures.core.Clampable;
import qmeasures.qgeodetics.RDegMinSec;

/**
 * Abstract base class for all angle quantities (e.g., latitude, longitude, bearing, azimuth).
 * Provides unit conversion, dimension conversion, trigonometric functions, and turn checks for angles.
 *
 * @param <Q> the concrete type of the angle quantity
 */
public abstract class AAngle<Q extends AAngle<Q>> extends AQuantity<Q, EAngles, EAngleDims> {

	/**
	 * Constructs an angle quantity with the specified value, unit, and dimension.
	 * @param value the value in the given unit
	 * @param unit the angle unit
	 * @param dimension the angle dimension
	 */
	protected AAngle(double value, EAngles unit, EAngleDims dimension) {  super(value, unit, dimension);  }

	/**
	 * Constructs an angle quantity with the specified value, using degrees and ANGLE as defaults.
	 * @param degree the value in degrees
	 */
	protected AAngle(double degree) {  super(degree, EAngles.DEGREE, EAngleDims.ANGLE);  }


	/**
	 * Constructs an angle quantity with the specified value, using degrees and ANGLE as defaults.
	 * @param degree the value in degrees
	 */
	protected AAngle(int Degree, int Minute, double Second) {
		super(new RDegMinSec(Degree, Minute, Second).toDegrees(), EAngles.DEGREE, EAngleDims.ANGLE);  }


	/**
	 * Creates a new instance of this angle type with the given value and unit.
	 * @param value the value
	 * @param unit the unit
	 * @return a new instance of Q
	 */
	@Override public abstract Q of(double value, EAngles unit);


	/** @return a new angle in unit from degrees */
	public Q ofDegMinSec(int Degree, int Minute, double Second) {
		return this.ofDegMinSec(new RDegMinSec(Degree, Minute, Second));
	}

	/** @return a new angle in unit from degrees */
	public Q ofDegMinSec(RDegMinSec dms) {
		return this.of(getUnit().fromBaseValue(dms.toDegrees()));
	}

	/**
	 * Gets the unit of this angle quantity.
	 * @return the angle unit
	 */
	@Override public EAngles getUnit() { return super.getUnit(); }
    
	/**
	 * Gets the dimension of this angle quantity.
	 * @return the angle dimension
	 */
	@Override public EAngleDims getDimension() { return super.getDimension(); }

	/**
	 * Returns the clamping mode for angle quantities (WRAP).
	 * @return the clamp mode
	 */
	public Clampable.EClampMode getClampMode(){ return Clampable.EClampMode.WRAP; }

	/**
	 * Converts this angle to another dimension (e.g., latitude, longitude, bearing, etc.).
	 * @param dimension the target dimension
	 * @return a new angle quantity of the target dimension
	 */
	public AAngle<?> toDimension(@NotNull EAngleDims dimension) {
		return switch (dimension) {
			case ANGLE ->  to(QAngle.class);
			case LATITUDE ->  to(QLatitude.class);
			case LONGITUDE ->  to(QLongitude.class);
			case BEARING ->  to(QBearing.class);
			case AZIMUTH ->  to(QAzimuth.class);
			case HEADING ->  to(QHeading.class);
			case ELEVATION ->  to(QElevation.class);
			case DIRECTION ->  to(QDirection.class);
			case ROTATION ->  to(QRotation.class);
			case ORIENTATION ->  to(QOrientation.class);
			default -> throw new IllegalArgumentException("Unexpected value: " + dimension);
		};
	}

	/**
	 * Converts this angle to a specific type using reflection.
	 * @param targetType the target class
	 * @return a new instance of the target type
	 * @param <T> the type of angle
	 */
	public <T extends AAngle<T>> T to(Class<T> targetType) {
		try {
			return targetType.getConstructor(double.class, EAngles.class)
							.newInstance(this.getValue(), this.getUnit());
		} catch (Exception e) {
			throw new IllegalArgumentException("Conversion to the specified type is not supported.", e);
		}
	}

    public RDegMinSec getDegMinSec(){
        return new RDegMinSec(this.getBaseValue());
    }

    public String toStringDMS(){
        return this.getDegMinSec().toString();
    }

	// TRIGONOMETRIC FUNCTIONS

	/** @return the sine of this angle (in radians) */
	public double sin() { return (Math.sin(this.inRadian()));  }

	/** @return the cosine of this angle (in radians) */
	public double cos() { return (Math.cos(this.inRadian()));  }

	/** @return the tangent of this angle (in radians) */
	public double tan() {return (Math.tan(this.inRadian()));}

	/**
	 * Returns an angle whose sine is the specified value.
	 * @param value the value (must be in [-1, 1])
	 * @return a new angle in radians
	 * @throws IllegalArgumentException if value is out of range
	 */
	public Q ofArcSin(double value) {
		if (value < -1.0 || value > 1.0) {
			throw new IllegalArgumentException("Value out of range for arcsine. Valid range is [-1, 1].");
		}
		return this.of(Math.asin(value), EAngles.RADIAN);
	}

	/**
	 * Returns an angle whose cosine is the specified value.
	 * @param value the value (must be in [-1, 1])
	 * @return a new angle in radians
	 * @throws IllegalArgumentException if value is out of range
	 */
	public Q ofArcCos(double value) {
		if (value < -1.0 || value > 1.0) {
			throw new IllegalArgumentException("Value out of range for arccosine. Valid range is [-1, 1].");
		}
		return this.of(Math.acos(value), EAngles.RADIAN);
	}

	/**
	 * Returns an angle whose tangent is the specified value.
	 * @param value the value
	 * @return a new angle in radians
	 */
	public Q ofArcTan(double value) {return this.of(Math.atan(value), EAngles.RADIAN);}

	/**
	 * Returns an angle whose tangent is the quotient of the specified values.
	 * @param value the numerator
	 * @param value2 the denominator
	 * @return a new angle in radians
	 */
	public Q ofArcTan2(double value, double value2) {return this.of(Math.atan2(value, value2), EAngles.RADIAN);}

	/**
	 * Compute azimuth in radians from x (east) and y (north) components.
	 * Convention: 0..2π, 0 = north, π/2 = east, π = south, 3π/2 = west.
	 * Returns 0.0 for the zero vectors by convention.
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
		// atan2 returns 0 for (0, 1) (north), which is correct for azimuth
		double ang = Math.atan2(x, y); // returns [-PI, PI], 0 = north, PI/2 = east
		if (ang < 0.0) ang += 2.0 * Math.PI; // normalize to [0, 2PI)
		// If an angle is extremely close to 0 or 2*PI, snap to 0.0 to avoid -0.0 or floating-point noise
		if (Math.abs(ang) < 1e-12 || Math.abs(ang - 2.0 * Math.PI) < 1e-12) ang = 0.0;
		return this.of(ang, EAngles.RADIAN);
	}

	// TURN CHECKS

	/** @return true if the angle is a full turn (360°) */
	public boolean isTurnFull() { return isTurnRatio(1.0);  }

	/** @return true if the angle is a half turn (180°) */
	public boolean isTurnHalf() { return isTurnRatio(0.5);  }

	/** @return true if the angle is a quarter turn (90°) */
	public boolean isTurnQuarter() { return isTurnRatio(0.25);  }

	/**
	 * Checks if the angle represents a specific ratio of a full turn (tolerance is 1e-10).
	 *
	 * @param turnRatio The ratio of a full turn to check against (e.g., 0.5 for half_turn).
	 * @return true if the angle corresponds to the specified turn ratio, false otherwise.
	 */
	public boolean isTurnRatio(double turnRatio) {
		if (turnRatio < 0.0 || turnRatio > 1.0) {
			throw new IllegalArgumentException("Value out of range for turn ratio. Valid range is [0, 1].");
		}
		// Compute the value in turns and compare the fractional part to the target ratio.
		// Use modulo 1.0 to handle multiple full turns. Treat turnRatio==1.0 as 0.0 (full turn).
		double turns = this.inTurn();
		double frac = ((turns % 1.0) + 1.0) % 1.0; // normalized to [0,1)
		double target = ((turnRatio % 1.0) + 1.0) % 1.0; // normalized to [0,1)
		return Math.abs(frac - target) < 1e-10;
	}

	// convert of specific units

	/** @return this angle in degrees */
	public Q ofDegree() { return this.of(EAngles.DEGREE);}
	/** @return this angle in radians */
	public Q ofRadian() {return this.of(EAngles.RADIAN);}
	/** @return this angle in turns */
	public Q ofTurn() {return this.of(EAngles.TURN);}
	/** @return this angle in gradians */
	public Q ofGradian() {return this.of(EAngles.GRADIAN);}
	/** @return this angle in arcminutes */
	public Q ofArcMinute() {return this.of(EAngles.ARCMINUTE);}
	/** @return this angle in arcseconds */
	public Q ofArcSecond() {return this.of(EAngles.ARCSECOND);}

	// convert of specific units with value

	/** @return a new angle in degrees */
	public Q ofDegree(double value) { return this.of(value, EAngles.DEGREE);}
	/** @return a new angle in radians */
	public Q ofRadian(double value) {return this.of(value, EAngles.RADIAN);}
	/** @return a new angle in turns */
	public Q ofTurn(double value) {return this.of(value, EAngles.TURN);}
	/** @return a new angle in gradians */
	public Q ofGradian(double value) {return this.of(value, EAngles.GRADIAN);}
	/** @return a new angle in arcminutes */
	public Q ofArcMinute(double value) {return this.of(value, EAngles.ARCMINUTE);}
	/** @return a new angle in arcseconds */
	public Q ofArcSecond(double value) {return this.of(value, EAngles.ARCSECOND);}

	// get value in specific units

	/** @return the value in degrees */
	public double inDegree() { return this.inUnit(EAngles.DEGREE);}
	/** @return the value in radians */
	public double inRadian() { return this.inUnit(EAngles.RADIAN);}
	/** @return the value in turns */
	public double inTurn() { return this.inUnit(EAngles.TURN);}
	/** @return the value in gradians */
	public double inGradian() { return this.inUnit(EAngles.GRADIAN);}
	/** @return the value in arcminutes */
	public double inArcMinute() { return this.inUnit(EAngles.ARCMINUTE);}
	/** @return the value in arcseconds */
	public double inArcSecond() { return this.inUnit(EAngles.ARCSECOND);}

}
