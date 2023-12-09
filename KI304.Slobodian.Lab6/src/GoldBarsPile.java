public class GoldBarsPile implements Object {
    private float barCost;
    private int barsAmount;

    /**
    * Constructor
    * @param barcost cost of one bar
    * @param barsamount amount of bars in the pile
    */
    public GoldBarsPile(float barcost, int barsamount){
        barCost = barcost;
        barsAmount = barsamount;
    }

    /**
    * Metod sets cost of the bar
    * @param barcost cost of one bar
    */
    public void SetBarCost(float barcost){
        barCost = barcost;
    }
    /**
    * Metod sets amount of the bars
    * @param barsamount amount of bars in the pile
    */
    public void SetBarsAmount(int barsamount){
        barsAmount = barsamount;
    }

    /**
    * @return cost of one bar
    */
    public float GetBarCost(){
        return barCost;
    }
    /**
    * @return amount of bars in the pile
    */
    public int GetBarsAmount(){
        return barsAmount;
    }

    /**
    * @return value of the pile
    */
    public double GetValue(){
        double v = barCost * barsAmount;
        return v;
    }

     /**
    * Method prints object data
    */
    public void PrintData() {
        System.out.print("Object: Pile of gold bars\nIn bars, there is "+barsAmount+" bars, each costing "+barCost+"$.\nTotal value of the pile is equal to "+GetValue()+"$");
    }

    /**
    * Method compares objects
    * @param obj Object
    * @return int (0, 1, -1)
    */
    public int compareTo(Object obj) {
        Double v = GetValue();
        return v.compareTo(obj.GetValue());
    }
}
