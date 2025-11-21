
package qmeasures.time.quantities;

import qmeasures.time.units.ETimeUnit;

/**
 * Time quantity representing a frequency (cycles per second, Hz).
 */
public class QFrequency extends ATimeDim<QFrequency> {

    public QFrequency(ATime<?> time) { super(time, ETimeDims.FREQUENCY); }

    protected QFrequency(double value) { super(value, ETimeUnit.SECOND, ETimeDims.FREQUENCY);  }

    public QFrequency(double value, ETimeUnit unit) { super(value, unit, ETimeDims.FREQUENCY); }

    @Override public QFrequency of(double value, ETimeUnit unit) {  return new QFrequency(value, unit);   }

}