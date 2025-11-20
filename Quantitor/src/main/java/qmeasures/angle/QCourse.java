package qmeasures.angle;

/**
 * Concrete angle quantity representing course.
 */
public final class QCourse extends AAngle<QCourse> {

    public QCourse(double value) {
        super(value, EAngles.DEGREE, EAngleDims.COURSE);
    }

    public QCourse(double value, EAngles unit) {
        super(value, unit, EAngleDims.COURSE);
    }

    @Override public QCourse of(double value, EAngles unit) {
        return new QCourse(value, unit);
    }
}
