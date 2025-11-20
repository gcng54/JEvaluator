package qmeasures.angle;

public class QRadian extends AAngle<QRadian> {

    public QRadian(double value) {
        super(value, EAngles.RADIAN, EAngleDims.ANGLE);
    }

    @Override
    public QRadian of(double value, EAngles dummy) {
        return new QRadian(value);
    }

}