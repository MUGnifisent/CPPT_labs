import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
        try {
            System.out.print("Enter file name: ");
            Scanner in = new Scanner(System.in);
            String fName = in.nextLine();
            PrintWriter fout = new PrintWriter(new File(fName + ".txt"));
            try {
                try {
                    Equations eq = new Equations();
                    System.out.print("Enter X: ");
                    fout.print(eq.calculate(in.nextInt()));
                } finally {
                    fout.flush();
                    fout.close();
                }
            } catch (CalcException ex) {
                System.out.print(ex.getMessage());
            }
            in.close();
        } catch (FileNotFoundException ex) {
            System.out.print("Exception reason: Perhaps wrong file path");
        }

    }
}