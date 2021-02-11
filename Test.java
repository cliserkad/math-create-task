import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	public static final DecimalFormat DF = new DecimalFormat("#.##");

	public static final double[] INPUTS_1 = { 7, 5, 13, 41, 2, 8 };
	public static final double AVG_OUTPUT_1 = 12.66;
	public static final double SD_OUTPUT_1 = 14.34;

	public static final double[] INPUTS_2 = { 1, 3, 7, 14, 23 };
	public static final double AVG_OUTPUT_2 = 9.60;
	public static final double SD_OUTPUT_2 = 8.98;

	public static void main(String[] args) {
		test1();
		test2();
		System.out.println("All tests passed!");
	}

	public static void test1() {
		final double mean = limitPrecision(Main.standardDeviation0(INPUTS_1, 0));
		final double stdDev = limitPrecision(Main.standardDeviation0(INPUTS_1, mean));
		if(mean != AVG_OUTPUT_1) {
			throw new IllegalStateException("Mean of " + mean + " did not match expected mean of " + AVG_OUTPUT_1);
		}
		if(stdDev != SD_OUTPUT_1) {
			throw new IllegalStateException("Standard deviation of " + stdDev + " did not match expected standard deviation of " + SD_OUTPUT_1);
		}
	}

	public static void test2() {
		final double mean = limitPrecision(Main.standardDeviation0(INPUTS_2, 0));
		final double stdDev = limitPrecision(Main.standardDeviation0(INPUTS_2, mean));
		if(mean != AVG_OUTPUT_2) {
			throw new IllegalStateException("Mean of " + mean + " did not match expected mean of " + AVG_OUTPUT_2);
		}
		if(stdDev != SD_OUTPUT_2) {
			throw new IllegalStateException("Standard deviation of " + stdDev + " did not match expected standard deviation of " + SD_OUTPUT_2);
		}
	}

	public static double limitPrecision(double d) {
		DF.setRoundingMode(RoundingMode.DOWN);
		return Double.valueOf(DF.format(d));
	}

}
