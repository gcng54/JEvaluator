package qmeasures.earth;

import qmeasures.geometry.ICartesian;

public record REarthCentrics(QEarthCentric ecX, QEarthCentric ecY, QEarthCentric ecZ) implements ICartesian<REarthCentrics> {

    @Override public double getX() { return ecX.getBaseValue();  };
    @Override public double getY() { return ecY.getBaseValue();  };
    @Override public double getZ() { return ecZ.getBaseValue();  };


    public REarthCentrics(QEarthCentric ecX, QEarthCentric ecY) {
            this(ecX, ecY, new QEarthCentric());
    }

    public REarthCentrics {
        if (ecX == null || ecY == null || ecZ == null) {
            throw new IllegalArgumentException("Geocentric coordinates cannot be null.");
        }
    }

    @Override public REarthCentrics create(double x, double y, double z) {
        return new REarthCentrics(new QEarthCentric(x), new QEarthCentric(y), new QEarthCentric(z));
    }

}
