/**
* Class <code>Ink</code> implements inks of printer
*/
public class Ink {

    private float redPersentage;
    private float greenPersentage;
    private float bluePersentage;
   
    /**
    * Constructor
    */
    public Ink(){
        this.redPersentage = 100;
        this.greenPersentage = 100;
        this.bluePersentage = 100;
    }

    /**
	 * Constructor
	 * @param <code>redP</code> The persentage of red ink
	 * @param <code>greenP</code> The persentage of red ink
     * @param <code>blueP</code> The persentage of red ink
	 */
    public Ink(float redP, float greenP, float blueP){
        this.redPersentage = redP;
        this.greenPersentage = greenP;
        this.bluePersentage = blueP;
    }
    /**
	 * Method returns the persentage of red ink
	 * @return The persentage of red ink
	 */
    public float checkRedInkLevel(){
        return redPersentage;
    }
    /**
	 * Method returns the persentage of green ink
	 * @return The persentage of red ink
	 */
    public float checkGreenInkLevel(){
        return greenPersentage;
    }
    /**
	 * Method returns the persentage of blue ink
	 * @return The persentage of red ink
	 */
    public float checkBlueInkLevel(){
        return bluePersentage;
    }
    /**
	 * Method adds up red ink
	 * @param amount amount of ink pouring
     * @return consequences of your actions
	 */
    public String fillRedInk(float amount){
        if(amount <= 0){
            return "You poured in exactly nothing.\nRed ink level stayed on " + checkRedInkLevel() + " persents.";
        }
        redPersentage = redPersentage + amount;
        if(redPersentage > 100){
            float diff = redPersentage - 100;
            redPersentage = 100;
            return "You poured in too much and " + diff + " persents of ink are now spilled!\nRed ink reservoir is full.";
        }
        else{
            return "You poured in " + amount + " persents of ink.\nRed ink reservoir contains " + checkRedInkLevel() + " persents of ink.";
        }
    }
    /**
	 * Method adds up green ink
	 * @param amount amount of ink pouring
     * @return consequences of your actions
	 */
    public String fillGreenInk(float amount){
        if(amount <= 0){
            return "You poured in exactly nothing.\nGreen ink level stayed on " + checkGreenInkLevel() + " persents.";
        }
        greenPersentage = greenPersentage + amount;
        if(greenPersentage > 100){
            float diff = greenPersentage - 100;
            greenPersentage = 100;
            return "You poured in too much and " + diff + " persents of ink are now spilled!\nGreen ink reservoir is full.";
        }
        else{
            return "You poured in " + amount + " persents of ink.\nGreen ink reservoir contains " + checkGreenInkLevel() + " persents of ink.";
        }
    }
    /**
	 * Method adds up blue ink
	 * @param amount amount of ink pouring
     * @return consequences of your actions
	 */
    public String fillBlueInk(float amount){
        if(amount <= 0){
            return "You poured in exactly nothing.\nBlue ink level stayed on " + checkBlueInkLevel() + " persents.";
        }
        bluePersentage = bluePersentage + amount;
        if(bluePersentage > 100){
            float diff = bluePersentage - 100;
            bluePersentage = 100;
            return "You poured in too much and " + diff + " persents of ink are now spilled!\nBlue ink reservoir is full.";
        }
        else{
            return "You poured in " + amount + " persents of ink.\nBlue ink reservoir contains " + checkBlueInkLevel() + " persents of ink.";
        }
    }
}
