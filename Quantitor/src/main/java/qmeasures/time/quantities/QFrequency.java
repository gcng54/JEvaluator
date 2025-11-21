
package qmeasures.time.quantities;

import qmeasures.time.units.ETimes;

/**
 * Time quantity representing a frequency (cycles per second, Hz).
 */
public class QFrequency extends ATimeDim<QFrequency> {

    public QFrequency(ATime<?> time) { super(time, ETimeDims.FREQUENCY); }

    protected QFrequency(double value) { super(value, ETimes.SECOND, ETimeDims.FREQUENCY);  }

    public QFrequency(double value, ETimes unit) { super(value, unit, ETimeDims.FREQUENCY); }

    @Override public QFrequency of(double value, ETimes unit) {  return new QFrequency(value, unit);   }

}