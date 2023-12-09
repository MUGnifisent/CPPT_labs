import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Class <code>CalcWFio</code> work with binary and text files
 * 
 * @author Yaroslav Slobodian
 * @version 1.0
 */

public class Output {
    private String fileName;

    /**
     * Constructor
     */
    public Output() {
        this.fileName = "test";
    }

    /**
     * Constructor
     * 
     * @param fn File name
     */
    public Output(String fN) {
        this.fileName = fN;
    }

    /**
     * Write result in txt file
     * 
     * @param result Result
     * @throws FileNotFoundException
     */

    public void writeResTxt(double result) throws FileNotFoundException {
        PrintWriter file = new PrintWriter(new File(fileName + ".txt"));
        file.print(result);
        file.close();
    }

    /**
     * Read result from txt file
     * 
     * @return message
     */
    public String readResTxt() {
        String fName = fileName + ".txt";
        String result;
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.next();
                s.close();
            } else
                throw new FileNotFoundException("File " + fName + "not found");
        } catch (FileNotFoundException ex) {
            result = ex.getMessage();
        }

        return result;
    }

    /**
     * Write result in bin file
     * 
     * @param result Result
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void writeResBin(double result) throws FileNotFoundException, IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fileName + ".bin"));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Read result from bin file
     * 
     * @return message
     * @throws FileNotFoundException
     * @throws IOException
     */
    public double readResBin() throws FileNotFoundException, IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fileName + ".bin"));
        double result = f.readDouble();
        f.close();
        return result;
    }

}