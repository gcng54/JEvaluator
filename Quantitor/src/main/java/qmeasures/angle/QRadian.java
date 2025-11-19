package qmeasures.angle;

public class QRadian extends AAngle<QRadian> {

    public QRadian(Double value) {
        super(value, EAngles.RADIAN, EAngleDims.ANGLE);
    }

    @Override
    public QRadian of(Double value, EAngles dummy) {
        return new QRadian(value);
    }

}