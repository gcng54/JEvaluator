package qmeasures.qgeodetics;

import qmeasures.length.quantities.QGeocDistance;

public record RGeocentric(QGeocDistance gX, QGeocDistance gY, QGeocDistance gZ) implements IPosition<RGeocentric> {

    @Override public double getX() { return gX.getBaseValue();  };
    @Override public double getY() { return gY.getBaseValue();  };
    @Override public double getZ() { return gZ.getBaseValue();  };


    public RGeocentric(QGeocDistance gX, QGeocDistance gY) {
            this(gX, gY, new QGeocDistance());
    }

    public RGeocentric {
        if (gX == null || gY == null || gZ == null) {
            throw new IllegalArgumentException("Geocentric coordinates cannot be null.");
        }
    }

    @Override public RGeocentric create(double x, double y, double z) {
        return new RGeocentric(new QGeocDistance(x), new QGeocDistance(y), new QGeocDistance(z));
    }

}
