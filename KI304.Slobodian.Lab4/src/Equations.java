/**
 * Class <code>Equations</code> implements method for y=cos(x)/tg(2x)
 * expression
 * calculation
 * 
 * @author Yaroslav Slobodian
 * @version 1.0
 */

public class Equations {

    /**
     * Method calculates the y=ctg(x)/(sin(2x) + 4cos(x)) expression
     * 
     * @param x Angle in degrees
     * @throws CalcException
     */
    public double calculate(int x) throws CalcException {
        double y, rad;
        rad = x * Math.PI / 180.0;
        try {
            y = (Math.cos(rad)/Math.sin(rad))/(Math.sin(2*rad) + 4 * Math.cos(rad));
            if (y == Double.NaN || y == Double.NEGATIVE_INFINITY || y == Double.POSITIVE_INFINITY || x == 90 || x == -90) throw new ArithmeticException();
        } catch (ArithmeticException ex) {
            if (rad == Math.PI / 2.0 || rad == -Math.PI / 2.0)
                throw new CalcException("Exception reason: Illegal value of X for tangent calculation");
            else if (x == 0)
                throw new CalcException("Exception reason: X = 0");
            else
                throw new CalcException("Unknown reason of the exception during exception calculation");
        }
        return y;
    }

}