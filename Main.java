import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
      } catch (NumberFormatException nfe) {
        print(s + " was not a positive number");
      }
    } while (n >= 0);

    double mean = sdOrMean(list, false, 0);
    double stdDev = sdOrMean(list, true, mean);

    print("The mean of your list is " + mean + ", and the standard deviation of your list is " + stdDev + "");

    input.close();
  }

  /** convenience function because java can suck sometimes */
  public static void print(Object o) {
    System.out.println(o);
  }

  public static int avg(Iterable<Integer> list) {
    int sum = 0;
    for(int num : list)
      sum += num;
    return sum;
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

  public static double sdOrMean(Iterable<Double> list, boolean isStdDev, double mean) {
    double sum = 0;
    int amt = 0;
    for(double num : list) {
        if(isStdDev) {
          sum += powD((num - mean), 2);
        } else {
          sum += num;
        }
        amt++;
    }

    if(isStdDev){
      return Math.sqrt(sum / (amt - 1));
    }

    return sum / amt;
  }

}
