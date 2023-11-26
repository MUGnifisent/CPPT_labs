/**
* Class <code>PaperTray</code> implements paper tray of printer
*/
public class PaperTray {
   
    enum PaperTypes{
        A1, A2, A3, A4, A5
    };

    private PaperTypes paperType;
    private int paperAmount;
    private int maxPaperAmount;
    /**
    * Constructor
    */
    public PaperTray(){
        this.paperType = PaperTypes.A4;
        this.paperAmount = 1;
        this.maxPaperAmount = 100;
    }
    /**
    * Constructor
    *@param <code>ptIndex</code> index of the paper type
    *@param <code>pAmount</code> amount of paper in the tray
    *@param <code>maxPAmount</code> maximal amount of paper in the tray
    */
    public PaperTray(int ptIndex, int pAmount, int maxPAmount){
        this.paperType = PaperTypes.values()[ptIndex - 1];
        this.paperAmount = pAmount;
        this.maxPaperAmount = maxPAmount;
    }
    /**
	 * Method returns the amount of paper in the tray
	 * @return The amount of paper in the tray
	 */
    public int checkPaperAmount(){
        return paperAmount;
    }
    /**
	 * Method returns the type of paper in the tray
	 * @return The type of paper in the tray
	 */
    public PaperTypes checkPaperType(){
        return paperType;
    }
    /**
	 * Method returns the maximal amount of paper in the tray
	 * @return The maximal amount of paper in the tray
	 */
    public int checkMaxPaperAmount(){
        return maxPaperAmount;
    }
    /**
	 * Method changes paper type in the tray
	 * @param ptIndex index of the paper type
     * @return consequences of your actions
	 */
    public String changePaperType(int ptIndex){
        if(ptIndex < 0 || ptIndex > PaperTypes.values().length){
            return "You tried to shove a paper with an invalid format into your printer!\nYou failed.";
        }
        else{
            paperType = PaperTypes.values()[ptIndex - 1];
            paperAmount = 1;
            return "You plased one sheet of " + checkPaperType() + " paper into your printers paper tray.";
        }
    }
    /**
	 * Method changes amount of paper in the tray
	 * @param amount amount of the paper
     * @return consequences of your actions
	 */
    public String changePaperAmount(int amount){
        if(amount > 0){
            if(amount + paperAmount > maxPaperAmount){
                paperAmount = maxPaperAmount;
                return "You tried to shove too much paper in your printers paper tray!\nAll excess paper is now cowering your rooms floor.\nYour printers tray is full, containing " +checkPaperAmount()+" sheets of paper";
            }
            else{
                paperAmount = paperAmount + amount;
                return "Your printers tray is containing " +checkPaperAmount()+" sheets of paper now.";
            }
        }
        else if(amount < 0){
          if(amount + paperAmount < 0){
                paperAmount = 0;
                return "You tried to take nonexisting papers from your printers tray, you schizo! After all REAL paper was taken, your printers tray is empty, containing " +checkPaperAmount()+" sheets of paper";
            }
            else{
                paperAmount = paperAmount + amount;
                return "Your printers tray is containing " +checkPaperAmount()+" sheets of paper now.";
            }  
        }
        else{
            return "You stared on your paper tray.\n It stared back.";
        }
    }
}
