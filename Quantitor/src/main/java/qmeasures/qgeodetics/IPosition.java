package qmeasures.qgeodetics;

import org.jetbrains.annotations.NotNull;

public interface IPosition<T extends IPosition<T>> {

    double getX();
    double getY();
    double getZ();

    T create(double x, double y, double z);
    
    default T fromPosition() {
        return create(getX(), getY(), getZ());
    };

    default double[] toArray() {
        return new double[] { getX(), getY(), getZ() };
    }

    default T clamp(@NotNull IPosition<T> min, @NotNull IPosition<T> max) {
        return create(
            clampa(this.getX(), min.getX(), max.getX()),
            clampa(this.getY(), min.getY(), max.getY()),
            clampa(this.getZ(), min.getZ(), max.getZ())
        );
    }

    default String toStringXYZ() {
        return String.format("X: %.6f, Y: %.6f, Z: %.6f", getX(), getY(), getZ());
    }

    default double hypotXYZ(@NotNull IPosition<T> other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        double dz = this.getZ() - other.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    default double hypotXY(@NotNull IPosition<T> other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    default T add(@NotNull IPosition<T> other) {
        return create(this.getX() + other.getX(),
                    this.getY() + other.getY(),
                    this.getZ() + other.getZ()
        );
    }

    default T sub(@NotNull IPosition<T> other) {
        return create(this.getX() - other.getX(),
                    this.getY() - other.getY(),
                    this.getZ() - other.getZ()
        );
    }

    default T rsub(@NotNull IPosition<T> other) {
        return create(other.getX() - this.getX(),
                    other.getY() - this.getY(),
                    other.getZ() - this.getZ()
        );
    }

    default T ratio( @NotNull IPosition<T> other){
        if (other.isAnyZero(1e-10)) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return create(this.getX() / other.getX(),
                    this.getY() / other.getY(),
                    this.getZ() / other.getZ()
        );
    }

    default T invert() {
        if (this.isAnyZero(1e-10)) {
            throw new IllegalArgumentException("Cannot invert position with zero component.");
        }
        return create(1.0 / this.getX(),
                    1.0 / this.getY(),
                    1.0 / this.getZ()
        );
    }


    default T negative() {
        return create(-this.getX(), -this.getY(), -this.getZ());
    }

    default T scale(double factor) {
        return create(this.getX() * factor,
                    this.getY() * factor,
                    this.getZ() * factor
        );
    }

    default T transform (@NotNull IPosition<T> other, double scalar) {
        return create(
            this.getX() + other.getX() * scalar,
            this.getY() + other.getY() * scalar,
            this.getZ() + other.getZ() * scalar
        );
    }

    default T divide(double divisor) {
        if (divisor == 0.0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return create(this.getX() / divisor,
                    this.getY() / divisor,
                    this.getZ() / divisor
        );
    }

    default double dot(@NotNull IPosition<T> other) {
        return this.getX() * other.getX()
             + this.getY() * other.getY()
             + this.getZ() * other.getZ();
    }

    default double magnitude() {
        return Math.sqrt(this.getX() * this.getX()
                       + this.getY() * this.getY()
                       + this.getZ() * this.getZ());
    }

    default T normalize() {
        double mag = magnitude();
        if (mag == 0.0) {
            throw new IllegalArgumentException("Cannot normalize a zero-length vector.");
        }
        return divide(mag);
    }

    default T cross(@NotNull IPosition<T> other) {
        return create(this.getY() * other.getZ() - this.getZ() * other.getY(),
                    this.getZ() * other.getX() - this.getX() * other.getZ(),
                    this.getX() * other.getY() - this.getY() * other.getX()
        );
    }

    default double angle(@NotNull IPosition<T> other) {
        double dotProd = this.dot(other);
        double mags = this.magnitude() * other.magnitude();
        if (mags == 0.0) {
            throw new IllegalArgumentException("Cannot compute angle with zero-length vector.");
        }
        double cosTheta = clampa(dotProd / mags, -1.0, 1.0);
        return Math.acos(cosTheta);
    }

    default boolean equals(@NotNull IPosition<T> other, double epsilon) {
        return Math.abs(this.getX() - other.getX()) <= epsilon &&
                Math.abs(this.getY() - other.getY()) <= epsilon &&
                Math.abs(this.getZ() - other.getZ()) <= epsilon;
    }

    default IPosition<T> copy() {
        return create(this.getX(), this.getY(), this.getZ());
    }

    default boolean isZero(double epsilon) {
        return Math.abs(this.getX()) <= epsilon &&
                Math.abs(this.getY()) <= epsilon &&
                Math.abs(this.getZ()) <= epsilon;
    }

    default boolean isAnyZero(double epsilon) {
        return Math.abs(this.getX()) <= epsilon || Math.abs(this.getY()) <= epsilon || Math.abs(this.getZ()) <= epsilon;
    }


    default boolean isValid() {
        return !Double.isNaN(this.getX()) && !Double.isNaN(this.getY()) && !Double.isNaN(this.getZ()) &&
                !Double.isInfinite(this.getX()) && !Double.isInfinite(this.getY()) && !Double.isInfinite(this.getZ());
    }

    default boolean greater(@NotNull IPosition<T> other) {
        return this.getX() > other.getX() &&
                this.getY() > other.getY() &&
                this.getZ() > other.getZ();
    }

    default boolean less(@NotNull IPosition<T> other) {
        return this.getX() < other.getX() &&
                this.getY() < other.getY() &&
                this.getZ() < other.getZ();
    }

    default boolean greaterOrEqual(@NotNull IPosition<T> other) {
        return this.getX() >= other.getX() &&
                this.getY() >= other.getY() &&
                this.getZ() >= other.getZ();
    }

    default boolean lessOrEqual(@NotNull IPosition<T> other) {
        return this.getX() <= other.getX() &&
                this.getY() <= other.getY() &&
                this.getZ() <= other.getZ();
    }
    
    private double clampa(double d, double e, double f) {
        if (d < e) { return e;  }
        if (d > f) { return f;  }
        return d;
    }



}
