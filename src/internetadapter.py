from enum import Enum
import random

class InternetAdapter:
    class ConnectionTypes(Enum):
        NOT_CONNECTED = 0
        WIFI = 1
        ETHERNET = 2

    def __init__(self):
        self.connectionType = self.ConnectionTypes.NOT_CONNECTED
        self.isConnected = False
        self.connectionStrength = 0
        self.wifiSSID = ""
        self.wifiPassword = ""
        self.rand = random.Random()

    def __init__(self, CType, IsC, CStrength, ssid, passw):
        self.connectionType = self.ConnectionTypes(CType)
        self.isConnected = IsC
        self.connectionStrength = CStrength
        self.wifiSSID = ssid
        self.wifiPassword = passw
        self.rand = random.Random()

    def checkConnectionType(self):
        return str(self.connectionType)

    def checkIfConnected(self):
        return self.isConnected

    def checkConnectionStrength(self):
        return self.connectionStrength

    def checkWifiSSID(self):
        return self.wifiSSID

    def checkWifiPassword(self):
        return self.wifiPassword

    def connectToWifi(self, ssid, passw):
        self.isConnected = True
        self.connectionType = self.ConnectionTypes.WIFI
        self.connectionStrength = self.rand.randint(0, 100)
        self.wifiSSID = ssid
        self.wifiPassword = passw
        return f"Your printer successfully connected to the WiFi '{self.wifiSSID}' with password '{self.wifiPassword}' and a signal strength of {self.connectionStrength} percent."

    def connectToEthernet(self):
        self.isConnected = True
        self.connectionType = self.ConnectionTypes.ETHERNET
        self.connectionStrength = 100
        self.wifiSSID = ""
        self.wifiPassword = ""
        return f"Your printer successfully connected to the Ethernet cable with a signal strength of {self.connectionStrength} percent. Nice choice!"

    def disconnect(self):
        self.connectionType = self.ConnectionTypes.NOT_CONNECTED
        self.isConnected = False
        self.connectionStrength = 0
        self.wifiSSID = ""
        self.wifiPassword = ""
        return "You disconnected your printer from any sources of the internet. Now it cannot be hacked!"
