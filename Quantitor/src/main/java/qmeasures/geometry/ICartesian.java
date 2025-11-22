package qmeasures.geometry;

import org.jetbrains.annotations.NotNull;

public interface ICartesian<T extends ICartesian<T>> {

    // ABSTRACTS

    double getX();
    double getY();
    double getZ();

    T create(double x, double y, double z);

    // DEFAULTS

    default T cloneT() {
        return create(getX(), getY(), getZ());
    }

    default double[] toArray() {
        return new double[] { getX(), getY(), getZ() };
    }

    default T clamp(@NotNull ICartesian<T> min, @NotNull ICartesian<T> max) {
        return create(
            clampValue(this.getX(), min.getX(), max.getX()),
            clampValue(this.getY(), min.getY(), max.getY()),
            clampValue(this.getZ(), min.getZ(), max.getZ())
        );
    }

    default String toStringXYZ() {
        return String.format("X: %.6f, Y: %.6f, Z: %.6f", getX(), getY(), getZ());
    }

    default double hypotXYZ(@NotNull ICartesian<T> other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        double dz = this.getZ() - other.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    default double hypotXY(@NotNull ICartesian<T> other) {
        double dx = this.getX() - other.getX();
        double dy = this.getY() - other.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    default T add(@NotNull ICartesian<T> other) {
        return create(this.getX() + other.getX(),
                    this.getY() + other.getY(),
                    this.getZ() + other.getZ()
        );
    }

    default T sub(@NotNull ICartesian<T> other) {
        return create(this.getX() - other.getX(),
                    this.getY() - other.getY(),
                    this.getZ() - other.getZ()
        );
    }

    default T rsub(@NotNull ICartesian<T> other) {
        return create(other.getX() - this.getX(),
                    other.getY() - this.getY(),
                    other.getZ() - this.getZ()
        );
    }

    default T ratio( @NotNull ICartesian<T> other){
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

    default T transform (@NotNull ICartesian<T> other, double scalar) {
        return create(
            this.getX() + other.getX() * scalar,
            this.getY() + other.getY() * scalar,
            this.getZ() + other.getZ() * scalar
        );
    }

    default T divide(double divisor) {
        if (Math.abs(divisor) < 1e-10) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return create(this.getX() / divisor,
                    this.getY() / divisor,
                    this.getZ() / divisor
        );
    }

    default double dot(@NotNull ICartesian<T> other) {
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
        if (mag < 1e-10) {
            throw new IllegalArgumentException("Cannot normalize a zero-length vector.");
        }
        return divide(mag);
    }

    default T cross(@NotNull ICartesian<T> other) {
        return create(this.getY() * other.getZ() - this.getZ() * other.getY(),
                    this.getZ() * other.getX() - this.getX() * other.getZ(),
                    this.getX() * other.getY() - this.getY() * other.getX()
        );
    }

    default double angle(@NotNull ICartesian<T> other) {
        double dotProd = this.dot(other);
        double mags = this.magnitude() * other.magnitude();
        if (mags < 1e-10) {
            throw new IllegalArgumentException("Cannot compute angle with zero-length vector.");
        }
        double cosTheta = clampValue(dotProd / mags, -1.0, 1.0);
        return Math.acos(cosTheta);
    }

    default boolean equals(@NotNull ICartesian<T> other, double epsilon) {
        return Math.abs(this.getX() - other.getX()) <= epsilon &&
                Math.abs(this.getY() - other.getY()) <= epsilon &&
                Math.abs(this.getZ() - other.getZ()) <= epsilon;
    }

    default T copy() {
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

    default boolean greater(@NotNull ICartesian<T> other) {
        return this.getX() > other.getX() &&
                this.getY() > other.getY() &&
                this.getZ() > other.getZ();
    }

    default boolean less(@NotNull ICartesian<T> other) {
        return this.getX() < other.getX() &&
                this.getY() < other.getY() &&
                this.getZ() < other.getZ();
    }

    default boolean greaterOrEqual(@NotNull ICartesian<T> other) {
        return this.getX() >= other.getX() &&
                this.getY() >= other.getY() &&
                this.getZ() >= other.getZ();
    }

    default boolean lessOrEqual(@NotNull ICartesian<T> other) {
        return this.getX() <= other.getX() &&
                this.getY() <= other.getY() &&
                this.getZ() <= other.getZ();
    }
    
    private double clampValue(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }



}
