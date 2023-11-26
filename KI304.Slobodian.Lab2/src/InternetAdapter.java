import java.util.Random;
/**
* Class <code>InternetAdapter</code> implements paper tray of printer
*/
public class InternetAdapter {
    enum ConnectionTypes{
        NOT_CONNECTED, WIFI, ETHERNET
    }

    Random rand = new Random();

    private ConnectionTypes connectionType;
    private boolean isConnected;
    private int connectionStrength;
    private String wifiSSID;
    private String wifiPassword;
    /**
    * Constructor
    */
    public InternetAdapter() {
        this.connectionType = ConnectionTypes.NOT_CONNECTED;
        this.isConnected = false;
        this.connectionStrength = 0;
        this.wifiSSID = "";
        this.wifiPassword = "";
    }
    /**
    * Constructor
    *@param <code>CType</code> index of the connection type
    *@param <code>IsC</code> bool, if connected is true
    *@param <code>CStrength</code> strength of the connection
    *@param <code>ssid</code> ssid, if WiFi
    *@param <code>pass</code> password, if WiFi
    */
    public InternetAdapter(int CType, boolean IsC, int CStrength, String ssid, String pass){
        this.connectionType = ConnectionTypes.values()[CType];
        this.isConnected = IsC;
        this.connectionStrength = CStrength;
        this.wifiSSID = ssid;
        this.wifiPassword = pass;
    }
    /**
	 * Method returns the connection type
	 * @return The connection type
	 */
    public ConnectionTypes checkConnectionType(){
        return connectionType;
    }
    /**
	 * Method returns if printer connected to the internet
	 * @return If printer connected to the internet
	 */
    public boolean checkIfConnected(){
        return isConnected;
    }
    /**
	 * Method returns strength of the connection
	 * @return The strength of connection to the internet
	 */
    public int checkConnectionStrength(){
        return connectionStrength;
    }
    /**
	 * Method returns ssid of the WiFi
	 * @return The ssid of the WiFi
	 */
    public String checkWifiSSID(){
        return wifiSSID;
    }
    /**
	 * Method returns password of the WiFi
	 * @return The password of the WiFi
	 */
    public String checkWifiPassword(){
        return wifiPassword;
    }

    /**
	 * Method connects internet adapter to the WiFi network
	 * @param ssid SSID
     * @param pass Password
     * @return consequences of your actions
	 */
    public String connectToWifi(String ssid, String pass){
        isConnected = true;
        connectionType = ConnectionTypes.WIFI;
        connectionStrength = rand.nextInt(101);
        wifiSSID = ssid;
        wifiPassword = pass;
        return "Your printer succesfully connected to the WiFi '"+wifiSSID+"' with password '"+wifiPassword+"' and strength of the signal of "+connectionStrength+" percent.";
    }
    /**
	 * Method connects internet adapter to the Ethernet cable
     * @return consequences of your actions
	 */
    public String connectToEthernet(){
        isConnected = true;
        connectionType = ConnectionTypes.ETHERNET;
        connectionStrength = 100;
        wifiSSID = "";
        wifiPassword = "";
        return "Your printer succesfully connected to the Ethernet cable with strength of the signal of "+connectionStrength+" percent. Nice choice!";
    }
    /**
	 * Method disconnects internet adapter from the internet
     * @return consequences of your actions
	 */
    public String disconnect(){
        connectionType = ConnectionTypes.NOT_CONNECTED;
        isConnected = false;
        connectionStrength = 0;
        wifiSSID = "";
        wifiPassword = "";
        return "You disconnected your printer from any sources of internet. Now it cannot be hacked!";
    }
}
