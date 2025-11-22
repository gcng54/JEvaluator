package qmeasures.earth;

import qmeasures.geometry.ICartesian;
import qmeasures.length.quantities.QLength;

public record REarthCartesian(QLength distX, QLength distY, QLength distZ) implements ICartesian<REarthCartesian> {

    @Override public double getX() { return distX.getBaseValue();  };
    @Override public double getY() { return distY.getBaseValue();  };
    @Override public double getZ() { return distZ.getBaseValue();  };

    public REarthCartesian(QLength distX, QLength distY) {
            this(distX, distY, new QLength());
    }

    public REarthCartesian {
        if (distX == null || distY == null || distZ == null) {
            throw new IllegalArgumentException("Geocentric coordinates cannot be null.");
        }
    }

    @Override public REarthCartesian create(double x, double y, double z) {
        return new REarthCartesian(new QLength(x), new QLength(y), new QLength(z));
    }

}
