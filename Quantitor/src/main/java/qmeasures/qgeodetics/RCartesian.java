package qmeasures.qgeodetics;

import qmeasures.length.quantities.QLength;

public record RCartesian(QLength cX, QLength cY, QLength cZ) implements IPosition<RCartesian> {

    @Override public double getX() { return cX.getBaseValue();  };
    @Override public double getY() { return cY.getBaseValue();  };
    @Override public double getZ() { return cZ.getBaseValue();  };

    public RCartesian(QLength x, QLength y) {
        this(x, y, new QLength());
    }

    public RCartesian {
        if (cX == null || cY == null || cZ == null) {
            throw new IllegalArgumentException("Cartesian coordinates cannot be null.");
        }
    }

    @Override public RCartesian create(double x, double y, double z) {
        return new RCartesian(new QLength(x), new QLength(y), new QLength(z));
    }

    @Override public RCartesian fromPosition() {
        return create(cX.fromBaseValue(getX()),
                    cY.fromBaseValue(getY()),
                    cZ.fromBaseValue(getZ()));
    }


}

