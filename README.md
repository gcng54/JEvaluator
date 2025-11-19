# JEvaluator

A Java library for type-safe physical quantity measurements and calculations.

## Overview

JEvaluator is a Maven-based Java project that provides the **Quantitor** module - a comprehensive framework for working with physical quantities in a type-safe manner. The library enables developers to perform calculations with various units of measurement (length, speed, angle, time) while maintaining dimensional correctness and preventing common unit conversion errors.

## Features

- **Type-Safe Quantities**: Strong typing prevents mixing incompatible units
- **Automatic Unit Conversion**: Seamlessly convert between different units within the same dimension
- **Multiple Physical Dimensions**: Support for length, speed, angle, and time measurements
- **Dimensional Validation**: Ensures calculations maintain physical correctness
- **Value Clamping**: Configurable bounds for quantity values
- **Trigonometric Operations**: Built-in support for angle calculations
- **Extensible Architecture**: Easy to add new quantity types and units

## Supported Quantity Types

### Length (Distance, Altitude, Range, Volume, Area)
- Units: Meter, Kilometer, Mile, Nautical Mile, Foot, Inch
- Dimensions: DISTANCE, ALTITUDE, RANGE, VOLUME, AREA

### Speed (Ground Speed, Air Speed, Sea Speed)
- Units: Meters per Second, Kilometers per Hour, Miles per Hour, Knots
- Dimensions: SPEED, GROUND_SPEED, AIR_SPEED, SEA_SPEED

### Angle (Bearing, Azimuth, Heading, Course, Latitude, Longitude)
- Units: Degree, Radian, Turn, Gradian, Arc Minute, Arc Second
- Dimensions: ANGLE, BEARING, AZIMUTH, HEADING, COURSE, LATITUDE, LONGITUDE, DIRECTION, ROTATION, ORIENTATION
- Trigonometric functions: sin, cos, tan, arcsin, arccos, arctan, arctan2

### Time (Duration, Period, Frequency)
- Units: Second, Minute, Hour, Day
- Dimensions: TIME, DURATION, PERIOD, FREQUENCY

## Quick Start

### Creating Quantities

```java
// Create a distance of 100 meters
QDistance distance = new QDistance(100.0, ELengths.METER);

// Create a speed of 60 kilometers per hour
QSpeed speed = new QSpeed(60.0, ESpeeds.KILOMETERS_PER_HOUR);

// Create an angle of 45 degrees
QAngle angle = new QAngle(45.0, EAngles.DEGREE);

// Create a duration of 30 seconds
QDuration duration = new QDuration(30.0, ETimes.SECOND);
```

### Unit Conversion

```java
// Create a distance in meters
QDistance distance = new QDistance(1000.0, ELengths.METER);

// Convert to kilometers
QDistance distanceInKm = distance.of(ELengths.KILOMETER);
System.out.println(distanceInKm); // 1.0 km

// Get value in a specific unit
Double miles = distance.inUnit(ELengths.MILE); // Returns value in miles
```

### Trigonometric Operations

```java
// Create an angle
QAngle angle = new QAngle(90.0, EAngles.DEGREE);

// Calculate sine, cosine, tangent
double sinValue = angle.sin(); // 1.0
double cosValue = angle.cos(); // 0.0
double tanValue = angle.tan();

// Create angle from inverse trigonometric functions
QAngle arcSinAngle = angle.ofArcSin(0.5); // Returns angle whose sine is 0.5
QAngle arcCosAngle = angle.ofArcCos(0.5); // Returns angle whose cosine is 0.5
QAngle arcTanAngle = angle.ofArcTan(1.0); // Returns angle whose tangent is 1.0
```

### Comparisons and Operations

```java
QDistance d1 = new QDistance(100.0, ELengths.METER);
QDistance d2 = new QDistance(0.1, ELengths.KILOMETER);

// Compare quantities
boolean isEqual = d1.equals(d2); // true (same base value)
boolean isLess = d1.less(d2); // false

// Get value in base unit
double baseValue = d1.getBaseValue(); // Value in base unit (meters)

// Check if value is clamped
boolean isClamped = d1.isClamped();
```

## Project Structure

```
JEvaluator/
├── pom.xml                      # Parent POM configuration
├── Quantitor/                   # Core module for physical quantities
│   ├── pom.xml
│   └── src/
│       ├── main/java/
│       │   └── qmeasures/
│       │       ├── core/        # Base classes and interfaces
│       │       ├── length/      # Length-related quantities
│       │       ├── speed/       # Speed-related quantities
│       │       ├── angle/       # Angle-related quantities
│       │       └── time/        # Time-related quantities
│       └── test/java/           # Unit tests
└── README.md
```

## Building the Project

### Prerequisites

- Java JDK 25 or higher
- Maven 3.6 or higher

### Build Commands

```bash
# Clean and compile the project
mvn clean compile

# Run tests
mvn test

# Package the project
mvn package

# Install to local Maven repository
mvn install
```

## Maven Dependency

To use JEvaluator in your Maven project, add the following dependency (once published):

```xml
<dependency>
    <groupId>ceng.evaluator</groupId>
    <artifactId>Quantitor</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Architecture

The library is built on a hierarchical architecture:

1. **Core Interfaces**: `IQuantity`, `IUnit`, `IDimension` define the base contracts
2. **Abstract Classes**: `AQuantity` provides common functionality for all quantities
3. **Concrete Implementations**: Specific quantity types (e.g., `QDistance`, `QSpeed`, `QAngle`)
4. **Enums for Units**: Type-safe unit definitions (e.g., `ELengths`, `ESpeeds`, `EAngles`)
5. **Dimension Enums**: Define valid ranges and properties for each dimension

### Key Design Principles

- **Immutability**: All quantity objects are immutable
- **Type Safety**: Compile-time checking prevents unit mismatches
- **Base Unit Normalization**: All values are stored in base units internally
- **Dimension Awareness**: Each quantity knows its dimension and valid bounds

## Testing

The project uses JUnit 5 for testing. Tests are located in `Quantitor/src/test/java/`.

```bash
# Run all tests
mvn test

# Run tests for a specific package
mvn test -Dtest=qmeasures.angle.*
```

## Contributing

Contributions are welcome! Please follow these guidelines:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/my-feature`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature/my-feature`)
5. Create a Pull Request

## License

This project is currently in development. License information will be added in a future release.

## Contact

For questions, issues, or suggestions, please open an issue on the GitHub repository.

## Future Enhancements

- Additional quantity types (mass, force, pressure, temperature)
- More unit conversions
- Mathematical operations between compatible quantities
- Integration with scientific computing libraries
- Performance optimizations for high-volume calculations
