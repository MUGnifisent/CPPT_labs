/**
 * Class App realize example program for lab 6
 * 
 * @author Yaroslav Slobodian
 * @version 1.0
 */

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Safe<? super Object> safe = new Safe<Object>();

        safe.AddObject(new CashBlocksPile(50, 5, 100));
        safe.AddObject(new CashBlocksPile(100, 8, 100));
        safe.AddObject(new GoldBarsPile(1000, 2));
        safe.AddObject(new GoldBarsPile(500, 5));

        Object res = safe.FindMax();
        System.out.print("\n\n\nThe biggest object in the safe is: \n");
        res.PrintData();
    }
}