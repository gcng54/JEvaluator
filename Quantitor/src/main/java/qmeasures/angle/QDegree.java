package qmeasures.angle;

public class QDegree extends AAngle<QDegree> {

    public QDegree(double value) {
        super(value, EAngles.DEGREE, EAngleDims.ANGLE);
    }

    @Override public QDegree of(double value, EAngles dummy) {
        return new QDegree(value);
    }

}