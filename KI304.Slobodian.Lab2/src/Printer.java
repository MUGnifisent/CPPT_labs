import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
* Class <code>Printer</code> implements the printer
*/
public class Printer {
    private Ink ink;
    private InternetAdapter internetAdapter;
    private PaperTray paperTray;

    private PrintWriter file;

    public boolean isEnabled;
    /**
    * Constructor
    */
    public Printer() throws FileNotFoundException{
        this.ink = new Ink();
        this.internetAdapter = new InternetAdapter();
        this.paperTray = new PaperTray();

        this.isEnabled = false;

        this.file = new PrintWriter(new File("Log.txt"));
    }
    /**
    * Constructor
    *@param <code>redP</code> The persentage of red ink
	*@param <code>greenP</code> The persentage of red ink
    *@param <code>blueP</code> The persentage of red ink
    *@param <code>CType</code> index of the connection type
    *@param <code>IsC</code> bool, if connected is true
    *@param <code>CStrength</code> strength of the connection
    *@param <code>ssid</code> ssid, if WiFi
    *@param <code>pass</code> password, if WiFi
    *@param <code>ptIndex</code> index of the paper type
    *@param <code>pAmount</code> amount of paper in the tray
    *@param <code>maxPAmount</code> maximal amount of paper in the tray
    */
    public Printer(float redP, float greenP, float blueP, int CType, boolean IsC, int CStrength, String ssid, String pass, int ptIndex, int pAmount, int maxPAmount) throws FileNotFoundException{
        this.ink = new Ink(redP, greenP, blueP);
        this.internetAdapter = new InternetAdapter(CType, IsC, CStrength, ssid, pass);
        this.paperTray = new PaperTray(ptIndex, pAmount, maxPAmount);

        this.isEnabled = false;

        this.file = new PrintWriter(new File("Log.txt"));
    }
    /**
	 * Method turns the printer on
	 */
    public void turnOn() {
        isEnabled = true;

        file.println("You succesfully turned your printeron. Great job, champ!");
        file.println();
        file.flush();
    }
    /**
	* Method turns the printer off
	*/
    public void turnOff() {
        isEnabled = false;    

        file.println(internetAdapter.disconnect());
        file.println("You succesfully turned your printer off.");
        file.println();
        file.flush();
    }
    /**
	* Method gets information about inks of the printer
	*/
    public void getInkInfo(){
        file.println("Ink levels of your printer are:");
        file.println("Red: " + ink.checkRedInkLevel()+"%");
        file.println("Green: "+ ink.checkGreenInkLevel()+"%");
        file.println("Blue: "+ ink.checkBlueInkLevel()+"%");
        file.println();
        file.flush();
    }
    /**
	* Method gets information about internet connection of the printer
	*/
    public void getInternetInfo(){
        if(internetAdapter.checkIfConnected()){
            file.println("You are connected to the internet via " + internetAdapter.checkConnectionType()+".");
            if(internetAdapter.checkWifiSSID() != ""){
                file.println("SSID: "+internetAdapter.checkWifiSSID());
                file.println("Password: "+internetAdapter.checkWifiPassword());
            }
            file.println("Connection strength: "+internetAdapter.checkConnectionStrength());
        }
        else{
            file.println("You are not connected to internet.");
        }
        file.println();
        file.flush();
    }
    /**
	* Method gets information about the paper tray of the printer
	*/
    public void getPaperTrayInfo(){
        file.println("As of now, in your paper tray rests " + paperTray.checkPaperAmount() + " sheets of paper out of " + paperTray.checkMaxPaperAmount() + " possible.");
        file.println("The format of the paper is " + paperTray.checkPaperType() + ".");
        file.println();
        file.flush();
    }
    /**
	* Method fills up printer to the brim
	*/
    public void hastyFillUp(){
        file.println("You decided to try and place into your printer maximal amounts of ink and paper, no matter the consequences.");
        file.println("...");
        file.println(ink.fillRedInk(100));
        file.println("...");
        file.println(ink.fillGreenInk(100));
        file.println("...");
        file.println(ink.fillBlueInk(100));
        file.println("...");
        file.println("...");
        file.println(paperTray.changePaperAmount(paperTray.checkMaxPaperAmount()));
        file.println();
        file.flush();
    }
    /**
	* Method fills up printer with set amount of paper and inks
    *@param rAmount amount of red ink
    *@param gAmount amount of green ink
    *@param bAmount amount of blue ink
    *@param pTypeIndex index of the paper type
    *@param pAmount amount of the paper
	*/
    public void toughtfulFillUp(float rAmount, float gAmount, float bAmount, int pTypeIndex, int pAmount){
        file.println("You decided to try and place into your printer ink and paper, paying attention to what are you doing.");
        file.println("...");
        file.println(ink.fillRedInk(rAmount));
        file.println("...");
        file.println(ink.fillGreenInk(gAmount));
        file.println("...");
        file.println(ink.fillBlueInk(bAmount));
        file.println("...");
        file.println(paperTray.changePaperType(pTypeIndex));
        file.println("...");
        file.println(paperTray.changePaperAmount(pAmount));
        file.println();
        file.flush();
    }
    /**
	* Method connects printer tto the internet, either via WiFi or Ethernet
    *@param ssid SSID, if WiFi
    *@param pass Password, if WiFi
    *@param connectionTypeInex index of the connection type
	*/
    public void connectPrinterToDaInternet(String ssid, String pass, int connectionTypeInex){
        file.println("You decided to try and connect your printer to the internet.");
        file.println("...");
        if(connectionTypeInex == 1){
            file.println(internetAdapter.connectToWifi(ssid, pass));
        }
        else if(connectionTypeInex == 2){
            file.println(internetAdapter.connectToEthernet());
        }
        file.println();
        file.flush();
    }
    /**
	* Method tries to print something via internet
    * @param sheets amount of printed sheets
	*/
    public void printViaInternet(int sheets){
        file.println("You decided to try to print some papers on your printer via the internet.");
        file.println("...");
        if(internetAdapter.checkIfConnected()){
            if(paperTray.checkPaperAmount() < sheets || ink.checkRedInkLevel() < sheets || ink.checkGreenInkLevel() < sheets || ink.checkBlueInkLevel() < sheets){
                file.println("You failed! Your printer dont have something!");
            }
            else{
                file.println("Your prints came out nice.");
                file.println(paperTray.changePaperAmount(-sheets));
            }
        }
        else{
           file.println("You failed! Your printer is not connected to da internet!"); 
        }
        file.println();
        file.flush();
    }
    /**
	* Method tries to print something from the Flash drive
    * @param sheets amount of printed sheets
	*/
    public void printViaFlsh(int sheets){
        file.println("You decided to try to print some papers on your printer via Flash drive.");
        file.println("...");
        if(paperTray.checkPaperAmount() < sheets || ink.checkRedInkLevel() < sheets || ink.checkGreenInkLevel() < sheets || ink.checkBlueInkLevel() < sheets){
            file.println("You failed! Your printer dont have something!");
        }
        else{
            file.println("Your prints came out nice.");
            file.println(paperTray.changePaperAmount(-sheets));
        }
        file.println();
        file.flush();
    }
    public void dispose() {
        file.close();
    }
}

