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
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            first it checks if x = 0 otherwise it computes the square root
     *            of the positive number
     * @param epsilon
     *            relative error entered by the user
     * @return estimate of square root
     */
    private static double sqrt(double x, double epsilon) {
        double r = x;
        //while loop to update r to be the closest estimate
        if (x == 0) {
            r = 0;
        } else {
            while (((r * r) - x) / x > epsilon) {
                r = (r + x / r) / 2;
            }
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
        out.print(
                "Enter the number you want to calculate the square root of: ");
        double x = in.nextDouble();
        while (x >= 0) {
            out.print("Enter the value of epsilon: ");
            double epsilon = in.nextDouble();
            //Calling the method sqrt while passing x and epsilon as a parameter
            double estimate = sqrt(x, epsilon);
            out.println(estimate);
            out.print(
                    "Enter the number you want to calculate the square root of: ");
            x = in.nextDouble();
        }
        in.close();
        out.close();
    }
}
