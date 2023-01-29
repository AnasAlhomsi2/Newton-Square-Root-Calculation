import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class Newton1 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton1() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @return estimate of square root
     */
    private static double sqrt(double x) {
        final double relativeError = 0.0001;
        double r = x;
        //while loop to update r to be the closest estimate
        while (((r * r) - x) / x > relativeError) {
            r = (r + x / r) / 2;
        }
        return r;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        out.print("Do wish to calculate another square root: ");
        String userInput = in.nextLine();
        //while loop which has the condition if the user enters "y"
        while (userInput.equals("y")) {
            out.print(
                    "Enter the number you want to calculate the square root of: ");
            double x = in.nextDouble();
            //Calling the method sqrt while passing x as a parameter
            double estimate = sqrt(x);
            out.println(estimate);
            out.print("Do wish to calculate another square root: ");
            userInput = in.nextLine();
        }

        in.close();
        out.close();
    }

}
