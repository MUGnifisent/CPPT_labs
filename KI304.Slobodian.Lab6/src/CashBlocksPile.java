public class CashBlocksPile implements Object {
    private float billCost;
    private int blocksAmount;
    private int cashInBlock;

    /**
    * Constructor
    * @param billcost cost of one bill
    * @param blocksamount amount of blocks in the pile
    * @param cashinblock amount of bills in a block
    */
    public CashBlocksPile(float billcost, int blocksamount, int cashinblock){
        billCost = billcost;
        blocksAmount = blocksamount;
        cashInBlock = cashinblock;
    }

    /**
    * Metod sets cost of the bill
    * @param billcost cost of one bill
    */
    public void SetBillCost(float billcost){
        billCost = billcost;
    }
    /**
    * Metod sets amount of the blocks
    * @param blocksamount amount of blocks in the pile
    */
    public void SetBlocksAmount(int blocksamount){
        blocksAmount = blocksamount;
    }

    /**
    * @return cost of one bill
    */
    public float GetBillCost(){
        return billCost;
    }
    /**
    * @return amount of blocks in the pile
    */
    public int GetBlocksAmount(){
        return blocksAmount;
    }

    /**
    * @return value of the pile
    */
    public double GetValue(){
        double v = billCost * cashInBlock * blocksAmount;
        return v;
    }

     /**
    * Method prints object data
    */
    public void PrintData() {
        System.out.print("Object: Pile of cash blocks\nIn blocks, there is "+cashInBlock+"$ bills, "+cashInBlock+" in each block.\nTotal value of the pile is equal to "+GetValue()+"$");
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
