package qmeasures.time;

// Time for one full cycle of a repeating event
// Use period when dealing with repetitive or cyclic motion, like waves, oscillations, or rotating systems.
// Speed = Wavelength / Period
public class QPeriod extends ATime<QPeriod> {

	public QPeriod(double value, ETimes unit) { super(value, unit, ETimeDims.DURATION); }

    public QPeriod(double value) { this(value, ETimes.SECOND); }
    
    @Override public QPeriod of(Double value, ETimes unit) {  return new QPeriod(value, unit);   }

}