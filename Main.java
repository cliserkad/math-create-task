import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final List<Double> list = new ArrayList<>();
		final Scanner input = new Scanner(System.in);
		print("Hello, I am the statistics machine");
		print("Enter positive numbers to create a list to get the mean and standard deviation of the values.");

		double n = 0;
		do {
			String s = "";
			try {
				s = input.nextLine();
				n = Double.parseDouble(s);
				if(n >= 0) {
					list.add(n);
					print("Added " + list.get(list.size() - 1));
				}
			} catch(NumberFormatException nfe) {
				print(s + " was not a positive number");
			}
		} while(n >= 0);

		final double mean = standardDeviation0(list, 0);
		final double stdDev = standardDeviation0(list, mean);

		print("The mean of your list is " + mean + ", and the standard deviation of your list is " + stdDev + "");

		input.close();
	}

	/** convenience function because java can suck sometimes */
	public static void print(Object o) {
		System.out.println(o);
	}

	public static long pow(final int number, int power) {
		if(power == 0 || number == 0) {
			return 1;
		}
		long output = number;
		while(power > 1) {
			output *= number;
			power--;
		}
		return output;
	}

	public static double powD(final double number, double power) {
		if(power == 0 || number == 0) {
			return 1;
		}
		double output = number;
		while(power > 1) {
			output *= number;
			power--;
		}
		return output;
	}

	public static double standardDeviation(Iterable<Double> list) {
		return standardDeviation0(list, standardDeviation0(list, 0));
	}

	public static double standardDeviation0(double[] list, double mean) {
		final List<Double> passableList = new ArrayList<>();
		for(double d : list)
			passableList.add(d);
		return standardDeviation0(passableList, mean);
	}

	/** First pass calculates average, second pass calculates standard deviation */
	public static double standardDeviation0(Iterable<Double> list, double mean) {
		double sum = 0;
		int amt = 0;
		for(double num : list) {
			if(mean != 0) {
				sum += powD((num - mean), 2);
			} else {
				sum += num;
			}
			amt++;
		}

		if(mean != 0) {
			return Math.sqrt(sum / (amt - 1));
		}

		return sum / amt;
	}

}
