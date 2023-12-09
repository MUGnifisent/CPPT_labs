from src.ink import Ink
from src.internetadapter import InternetAdapter
from src.papertray import PaperTray

class Printer:
    def __init__(self):
        self.ink = Ink()
        self.internetAdapter = InternetAdapter()
        self.paperTray = PaperTray()
        self.isEnabled = False

        self.file = open("Log.txt", "w")

    def __init__(self, redP, greenP, blueP, CType, IsC, CStrength, ssid, passw, ptIndex, pAmount, maxPAmount):
        self.ink = Ink(redP, greenP, blueP)
        self.internetAdapter = InternetAdapter(CType, IsC, CStrength, ssid, passw)
        self.paperTray = PaperTray(ptIndex, pAmount, maxPAmount)
        self.isEnabled = False

        self.file = open("Log.txt", "w")

    def turnOn(self):
        self.isEnabled = True
        self.file.write("You successfully turned your printer on. Great job, champ!\n\n")
        self.file.flush()

    def turnOff(self):
        self.isEnabled = False
        self.file.write(self.internetAdapter.disconnect() + "\n")
        self.file.write("You successfully turned your printer off.\n\n")
        self.file.flush()

    def getInkInfo(self):
        self.file.write("Ink levels of your printer are:\n")
        self.file.write(f"Red: {self.ink.checkRedInkLevel()}%\n")
        self.file.write(f"Green: {self.ink.checkGreenInkLevel()}%\n")
        self.file.write(f"Blue: {self.ink.checkBlueInkLevel()}%\n\n")
        self.file.flush()

    def getInternetInfo(self):
        if self.internetAdapter.checkIfConnected():
            self.file.write(f"You are connected to the internet via {self.internetAdapter.checkConnectionType()}.\n")
            if self.internetAdapter.checkWifiSSID() != "":
                self.file.write(f"SSID: {self.internetAdapter.checkWifiSSID()}\n")
                self.file.write(f"Password: {self.internetAdapter.checkWifiPassword()}\n")
            self.file.write(f"Connection strength: {self.internetAdapter.checkConnectionStrength()}\n")
        else:
            self.file.write("You are not connected to the internet.\n\n")
        self.file.flush()

    def getPaperTrayInfo(self):
        self.file.write(f"As of now, in your paper tray rests {self.paperTray.checkPaperAmount()} sheets of paper out of {self.paperTray.checkMaxPaperAmount()} possible.\n")
        self.file.write(f"The format of the paper is {self.paperTray.checkPaperType()}.\n\n")
        self.file.flush()

    def hastyFillUp(self):
        self.file.write("You decided to try and place into your printer maximal amounts of ink and paper, no matter the consequences.\n...\n")
        self.file.write(self.ink.fillRedInk(100) + "\n...\n")
        self.file.write(self.ink.fillGreenInk(100) + "\n...\n")
        self.file.write(self.ink.fillBlueInk(100) + "\n...\n...\n")
        self.file.write(self.paperTray.changePaperAmount(self.paperTray.checkMaxPaperAmount()) + "\n\n")
        self.file.flush()

    def thoughtfulFillUp(self, rAmount, gAmount, bAmount, pTypeIndex, pAmount):
        self.file.write("You decided to try and place into your printer ink and paper, paying attention to what you are doing.\n...\n")
        self.file.write(self.ink.fillRedInk(rAmount) + "\n...\n")
        self.file.write(self.ink.fillGreenInk(gAmount) + "\n...\n")
        self.file.write(self.ink.fillBlueInk(bAmount) + "\n...\n...\n")
        self.file.write(self.paperTray.changePaperType(pTypeIndex) + "\n...\n")
        self.file.write(self.paperTray.changePaperAmount(pAmount) + "\n\n")
        self.file.flush()

    def connectPrinterToDaInternet(self, ssid, passw, connectionTypeIndex):
        self.file.write("You decided to try and connect your printer to the internet.\n...\n")
        if connectionTypeIndex == 1:
            self.file.write(self.internetAdapter.connectToWifi(ssid, passw) + "\n\n")
        elif connectionTypeIndex == 2:
            self.file.write(self.internetAdapter.connectToEthernet() + "\n\n")
        self.file.flush()

    def printViaInternet(self, sheets):
        self.file.write("You decided to try to print some papers on your printer via the internet.\n...\n")
        if self.internetAdapter.checkIfConnected():
            if (
                self.paperTray.checkPaperAmount() < sheets
                or self.ink.checkRedInkLevel() < sheets
                or self.ink.checkGreenInkLevel() < sheets
                or self.ink.checkBlueInkLevel() < sheets
            ):
                self.file.write("You failed! Your printer doesn't have something!\n")
            else:
                self.file.write("Your prints came out nice.\n")
                self.file.write(self.paperTray.changePaperAmount(-sheets) + "\n")
        else:
            self.file.write("You failed! Your printer is not connected to da internet!\n")
        self.file.write("\n")
        self.file.flush()

    def printViaFlsh(self, sheets):
        self.file.write("You decided to try to print some papers on your printer via Flash drive.\n...\n")
        if (
            self.paperTray.checkPaperAmount() < sheets
            or self.ink.checkRedInkLevel() < sheets
            or self.ink.checkGreenInkLevel() < sheets
            or self.ink.checkBlueInkLevel() < sheets
        ):
            self.file.write("You failed! Your printer doesn't have something!\n")
        else:
            self.file.write("Your prints came out nice.\n")
            self.file.write(self.paperTray.changePaperAmount(-sheets) + "\n")
        self.file.write("\n")
        self.file.flush()

    def dispose(self):
        self.file.close()
