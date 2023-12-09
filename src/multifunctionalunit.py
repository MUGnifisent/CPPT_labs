from enum import Enum

from src.ink import Ink
from src.internetadapter import InternetAdapter
from src.papertray import PaperTray


class MultifunctionalUnit:
    class PowerSource(Enum):
        INTERNAL = "INTERNAL"
        EXTERNAL = "EXTERNAL"

    def __init__(self, redP=0.0, greenP=0.0, blueP=0.0, CType=0, IsC=False, CStrength=0, ssid="", passw="", ptIndex=0, pAmount=0, maxPAmount=100, psIsInternal=False, paperJ=False):
        self.ink = Ink(redP, greenP, blueP)
        self.internetAdapter = InternetAdapter(CType, IsC, CStrength, ssid, passw)
        self.paperTray = PaperTray(ptIndex, pAmount, maxPAmount)

        self.isEnabled = False

        if not psIsInternal:
            self.powerSource = self.PowerSource.EXTERNAL
        else:
            self.powerSource = self.PowerSource.INTERNAL
        self.paperJammed = paperJ

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
        self.file.write("Red: " + str(self.ink.check_red_ink_level()) + "%\n")
        self.file.write("Green: " + str(self.ink.check_green_ink_level()) + "%\n")
        self.file.write("Blue: " + str(self.ink.check_blue_ink_level()) + "%\n\n")
        self.file.flush()

    def getInternetInfo(self):
        if self.internetAdapter.checkIfConnected():
            self.file.write("You are connected to the internet via " + self.internetAdapter.checkConnectionType() + ".\n")
            if self.internetAdapter.checkWifiSSID() != "":
                self.file.write("SSID: " + self.internetAdapter.checkWifiSSID() + "\n")
                self.file.write("Password: " + self.internetAdapter.checkWifiPassword() + "\n")
            self.file.write("Connection strength: " + str(self.internetAdapter.checkConnectionStrength()) + "\n")
        else:
            self.file.write("You are not connected to the internet.\n\n")
        self.file.flush()

    def getPaperTrayInfo(self):
        self.file.write("As of now, in your paper tray rests " + str(self.paperTray.checkPaperAmount()) +
                        " sheets of paper out of " + str(self.paperTray.checkMaxPaperAmount()) + " possible.\n")
        self.file.write("The format of the paper is " + self.paperTray.checkPaperType() + ".\n\n")
        self.file.flush()

    def hastyFillUp(self):
        self.file.write("You decided to try and place into your printer maximal amounts of ink and paper, no matter the consequences.\n")
        self.file.write("...\n")
        self.file.write(self.ink.fill_red_ink(100) + "\n")
        self.file.write("...\n")
        self.file.write(self.ink.fill_green_ink(100) + "\n")
        self.file.write("...\n")
        self.file.write(self.ink.fill_blue_ink(100) + "\n")
        self.file.write("...\n...\n")
        self.file.write(self.paperTray.changePaperAmount(self.paperTray.maxPaperAmount) + "\n\n")
        self.file.flush()

    def thoughtfulFillUp(self, rAmount, gAmount, bAmount, pTypeIndex, pAmount):
        self.file.write("You decided to try and place into your printer ink and paper, paying attention to what you are doing.\n")
        self.file.write("...\n")
        self.file.write(self.ink.fillRedInk(rAmount) + "\n")
        self.file.write("...\n")
        self.file.write(self.ink.fillGreenInk(gAmount) + "\n")
        self.file.write("...\n")
        self.file.write(self.ink.fillBlueInk(bAmount) + "\n")
        self.file.write("...\n")
        self.file.write(self.paperTray.changePaperType(pTypeIndex) + "\n")
        self.file.write("...\n")
        self.file.write(self.paperTray.changePaperAmount(pAmount) + "\n\n")
        self.file.flush()

    def connectPrinterToDaInternet(self, ssid, passw, connectionTypeIndex):
        self.file.write("You decided to try and connect your printer to the internet.\n")
        self.file.write("...\n")
        if connectionTypeIndex == 1:
            self.file.write(self.internetAdapter.connectToWifi(ssid, passw) + "\n")
        elif connectionTypeIndex == 2:
            self.file.write(self.internetAdapter.connectToEthernet() + "\n")
        self.file.write("\n")
        self.file.flush()

    def printViaInternet(self, sheets):
        self.file.write("You decided to try to print some papers on your printer via the internet.\n")
        self.file.write("...\n")
        if not self.paperJammed:
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
        else:
            self.file.write("You failed! Your printer is jammed!\n")
        self.file.write("\n")
        self.file.flush()

    def printViaFlsh(self, sheets):
        self.file.write("You decided to try to print some papers on your printer via Flash drive.\n")
        self.file.write("...\n")
        if not self.paperJammed:
            if (
                self.paperTray.checkPaperAmount() < sheets
                or self.ink.check_red_ink_level() < sheets
                or self.ink.check_green_ink_level() < sheets
                or self.ink.check_blue_ink_level() < sheets
            ):
                self.file.write("You failed! Your printer doesn't have something!\n")
            else:
                self.file.write("Your prints came out nice.\n")
                self.file.write(self.paperTray.changePaperAmount(-sheets) + "\n")
        else:
            self.file.write("You failed! Your printer is jammed!\n")
        self.file.write("\n")
        self.file.flush()

    def dispose(self):
        self.file.close()

    def getPowerSource(self):
        string = str(self.powerSource)
        self.file.write("Your printer for now is connected to " + string + " power source.\n\n")
        self.file.flush()

    def getJamInfo(self):
        if self.paperJammed:
            self.file.write("Your printer is jammed.\n")
        else:
            self.file.write("Your printer is not jammed.\n")
        self.file.write("\n")
        self.file.flush()

    def changePowerSource(self):
        if self.powerSource == self.PowerSource.INTERNAL:
            self.powerSource = self.PowerSource.EXTERNAL
            self.file.write("Your printer is now powered from a wall plug!\n")
        elif self.powerSource == self.PowerSource.EXTERNAL:
            self.powerSource = self.PowerSource.INTERNAL
            self.file.write("Your printer is now powered from its internal battery!\n")
        self.file.write("\n")
        self.file.flush()

    def JAMDAPAPER(self):
        if not self.paperJammed:
            self.paperJammed = True
            self.file.write("You intentionally jammed your printer! WTF!\n")
        else:
            self.file.write("You tried to intentionally jam your printer...\nBut it was already jammed.\nReally??\n")
        self.file.write("\n")
        self.file.flush()

    def UNJAMDAPAPER(self):
        if self.paperJammed:
            self.paperJammed = False
            self.file.write("You successfully un-jammed your printer!\n")
        else:
            self.file.write("You tried to intentionally un-jam your printer...\nBut it was already perfectly fine.\nAre you on drugs??\n")
        self.file.write("\n")
        self.file.flush()
