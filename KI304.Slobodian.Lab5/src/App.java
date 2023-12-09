import java.util.Scanner;

/**
 * Class <code>App</code> Implements driver for Equations class
 * 
 * @author Yaroslav Slobodian
 * @version 1.0
 */

public class App {
        /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        Output output = new Output();
        try {
            Equations eq = new Equations();
            System.out.print("Enter X: ");
            double res = eq.calculate(in.nextInt());
            output.writeResTxt(res);
            output.writeResBin(res);
            System.out.println(output.readResTxt());
            System.out.println(output.readResBin());
        } catch (CalcException ex) {
            System.out.print(ex.getMessage());
        }
        in.close();

    }
}