package qmeasures.angle;

public class QDegree extends AAngle<QDegree> {

    public QDegree(Double value) {
        super(value, EAngles.DEGREE, EAngleDims.ANGLE);
    }

    @Override
    public QDegree of(Double value, EAngles dummy) {
        return new QDegree(value);
    }

}