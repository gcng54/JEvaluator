package qmeasures.geometry;


public record RCartesian(double cX, double cY, double cZ) implements ICartesian<RCartesian> {

    @Override public double getX() { return cX;  };
    @Override public double getY() { return cY;  };
    @Override public double getZ() { return cZ;  };

    public RCartesian(double x, double y) {
        this(x, y, 0.0);
    }

    public RCartesian() {
        this(0.0, 0.0, 0.0);
    }

    @Override public RCartesian create(double x, double y, double z) {
        return new RCartesian(x, y, z);
    }

    


}

