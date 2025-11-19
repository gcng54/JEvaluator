# JEvaluator

JEvaluator is a Java-based project that provides a comprehensive framework for working with physical quantities and measurements through its **JQuantitor** module.

## JQuantitor

JQuantitor is a type-safe, object-oriented library for representing and manipulating physical quantities with units in Java. It provides a robust framework for working with measurements across multiple domains including angles, lengths, speeds, and time.

### Key Features

- **Type-Safe Measurements**: Strong typing ensures that incompatible quantities cannot be mixed
- **Unit Conversions**: Seamless conversion between different units within the same dimension
- **Arithmetic Operations**: Full support for mathematical operations on quantities (add, subtract, multiply, divide, etc.)
- **Clamping & Validation**: Built-in support for value range validation and multiple clamping modes
- **Dimensional Analysis**: Ensures operations are performed on compatible dimensions
- **Rich API**: Extensive set of helper methods for common operations

### Architecture

JQuantitor is built on three core interfaces:

#### 1. **IQuantity**
Represents a physical quantity with a value, unit, and dimension. Provides methods for:
- Value retrieval and conversion
- Arithmetic operations (add, subtract, multiply, divide, power, sqrt, etc.)
- Comparison operations
- Unit conversions

#### 2. **IUnit**
Represents a unit of measurement with:
- Conversion factors to/from base units
- Unit symbols and names
- Compatibility checks with other units

#### 3. **IDimension**
Defines the dimensional type and valid operational ranges:
- Minimum and maximum base values
- Clamping modes (NONE, BOUND, WRAP, CYCLE, etc.)
- Dimension compatibility checking

### Supported Measurements

#### Angle Measurements
- **Base Unit**: Degree (°)
- **Supported Units**: 
  - Degree (°), Radian (rad), Turn, Gradian (gon)
  - Arc Minute ('), Arc Second (")
- **Dimensions**: 
  - Angle, Latitude, Longitude, Bearing, Azimuth
  - Heading, Course, Direction, Rotation, Orientation
- **Special Features**:
  - Trigonometric functions (sin, cos, tan)
  - Inverse trigonometric functions (arcsin, arccos, arctan, arctan2)
  - Azimuth calculations from X/Y components
  - Turn ratio checks (full, half, quarter turns)

#### Length Measurements
- **Base Unit**: Meter (m)
- **Supported Units**:
  - Metric: Meter (m), Kilometer (km), Millimeter (mm)
  - Imperial: Mile (mi), Yard (yd), Foot (ft), Inch (in)
  - Navigation: Nautical Mile (NM), Data Mile (DM), Flight Level (FL)
- **Dimensions**:
  - Length, Distance, Altitude, Elevation, Height, Depth
  - Area, Volume, Range, Wave Length, Earthectic (Earth radius)
- **Features**:
  - Specialized types for altitude, elevation, distance, etc.
  - Range validation (e.g., altitude limited to -430m to 100,000m)

#### Speed Measurements
- **Base Unit**: Meters per Second (m/s)
- **Supported Units**:
  - Meters per Second (m/s)
  - Kilometers per Hour (km/h)
  - Miles per Hour (mph)
  - Knots (kn)
- **Dimensions**: Speed, Air Speed, Ground Speed, Sea Speed
- **Features**: Specialized speed types for different contexts

#### Time Measurements
- **Base Unit**: Second (sec)
- **Supported Units**:
  - Second (sec), Minute (min), Hour (hr), Day (d)
  - Week (wk), Month (mo), Year (yr)
  - Decade (dec), Century (cen)
- **Dimensions**: Time, Duration, Period, Frequency
- **Features**: Support for various time scales from seconds to centuries

### Usage Examples

```java
// Create angle quantities
QAngle angle1 = new QAngle(90.0, EAngles.DEGREE);
QAngle angle2 = new QAngle(Math.PI, EAngles.RADIAN);

// Unit conversions
double radians = angle1.inRadian(); // 1.5708 (π/2)
double degrees = angle2.inDegree(); // 180.0

// Arithmetic operations
QAngle sum = angle1.add(angle2); // 270 degrees
QAngle scaled = angle1.mul(2); // 180 degrees

// Trigonometric functions
double sine = angle1.sin(); // 1.0
double cosine = angle1.cos(); // 0.0

// Length measurements
QLength distance = new QLength(5.0, ELengths.KILOMETER);
QAltitude altitude = new QAltitude(30000.0, ELengths.FOOT);

// Convert between units
double meters = distance.inUnit(ELengths.METER); // 5000.0
double flightLevel = altitude.inUnit(ELengths.FLIGHTLEVEL); // 300.0 (FL300)

// Speed calculations
QSpeed speed = new QSpeed(100.0, ESpeeds.KILOMETERS_PER_HOUR);
double knots = speed.inUnit(ESpeeds.KNOTS); // ~54 knots

// Comparisons
boolean isGreater = speed.greater(new QSpeed(50.0, ESpeeds.KNOTS)); // true

// Time measurements
QTime duration = new QTime(2.5, ETimes.HOUR);
double minutes = duration.inUnit(ETimes.MINUTE); // 150.0
```

### Clamping Modes

JQuantitor supports multiple clamping modes to handle values outside valid ranges:

- **NONE**: No clamping applied
- **BOUND**: Clamps to min/max boundaries
- **WRAP**: Wraps around from max to min (e.g., angles 0-360°)
- **CYCLE**: Similar to wrap but cycles through the range
- **BOUNCE**: Reverses direction at boundaries
- **LATITUDE**: Special handling for latitude values (-90° to 90°)
- **LONGITUDE**: Special handling for longitude values (-180° to 180°)

### Building the Project

JQuantitor requires Java 25 or later and uses Maven for build management.

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package the library
mvn package
```

### Project Structure

```
JEvaluator/
├── pom.xml                          # Parent POM configuration
└── Quantitor/                       # JQuantitor module
    ├── pom.xml                      # Module POM
    └── src/
        ├── main/java/
        │   ├── qmeasures/
        │   │   ├── core/            # Core interfaces and base classes
        │   │   ├── angle/           # Angle-related quantities
        │   │   ├── length/          # Length-related quantities
        │   │   ├── speed/           # Speed-related quantities
        │   │   └── time/            # Time-related quantities
        │   └── qgeodetics/          # Geodetic utilities (placeholder)
        └── test/java/               # Unit tests
```

### Dependencies

- JUnit Jupiter 5.14.0 (for testing)

### Design Principles

1. **Immutability**: All quantity objects are immutable
2. **Type Safety**: Strong typing prevents mixing incompatible quantities
3. **Fluent API**: Method chaining for readable code
4. **Separation of Concerns**: Clear separation between quantities, units, and dimensions
5. **Extensibility**: Easy to add new quantity types, units, or dimensions

### Contributing

Contributions are welcome! When adding new quantities or units:

1. Extend the appropriate abstract class (e.g., `AQuantity`)
2. Define the unit enum implementing `IUnit`
3. Define the dimension enum implementing `IDimension`
4. Add appropriate tests

## License

This project is licensed under the terms specified in the project repository.

## Contact

For questions, issues, or contributions, please refer to the project repository.
