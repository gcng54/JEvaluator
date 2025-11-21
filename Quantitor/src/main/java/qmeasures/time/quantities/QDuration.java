
package qmeasures.time.quantities;

import qmeasures.time.units.ETimes;

/**
 * Time quantity representing a duration (elapsed time, always >= 0).
 */
public class QDuration extends ATimeDim<QDuration> {

    public QDuration(ATime<?> time) { super(time, ETimeDims.DURATION); }

    protected QDuration(double value) { super(value, ETimes.SECOND, ETimeDims.DURATION);  }

    public QDuration(double value, ETimes unit) { super(value, unit, ETimeDims.DURATION); }

    @Override public QDuration of(double value, ETimes unit) {  return new QDuration(value, unit);   }

}