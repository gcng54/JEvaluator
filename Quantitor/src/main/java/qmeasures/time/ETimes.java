package qmeasures.time;

import java.util.Locale;

import qmeasures.core.IUnit;


public enum ETimes implements IUnit<ETimes> {
	TIME("T", 1.0), SECOND("sec", 1.0), MINUTE("min", 60.0), HOUR("hr", 3_600.0), DAY("d", 86_400.0),
	WEEK("wk", 604_800.0), MONTH("mo", 2_592_000.0), YEAR("yr", 31_536_000.0), DECADE("dec", 315_360_000.0),
	CENTURY("cen", 3_153_600_000.0);

	private final String symbol;
	private final double factor;

	ETimes(String symbol, double factor) {
		validateFactor(factor);
		this.symbol = symbol;
		this.factor = factor;
	}

	@Override 	public String getSymbol() {		return symbol;	}

	@Override	public double getFactor() {		return factor;	}

	@Override	public ETimes getBaseUnit() {		return SECOND;	}

	@Override	public ETimeDims getBaseDimension() {		return ETimeDims.TIME;	}

	public static ETimes fromName(String name_) {
		return ETimes.valueOf(name_.toUpperCase(Locale.ENGLISH));
	}

	@Override	public String toString() {	return IUnit.toSentenceCase(this.name()) + "s";	}
}
