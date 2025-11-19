package qmeasures.angle;

/**
 * Concrete angle quantity representing course.
 */
public final class QCourse extends AAngle<QCourse> {

    public QCourse(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.COURSE);
    }

    public QCourse(Double value, EAngles unit) {
        super(value, unit, EAngleDims.COURSE);
    }

    @Override public QCourse of(Double value, EAngles unit) {
        return new QCourse(value, unit);
    }
}
