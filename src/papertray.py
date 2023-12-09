from enum import Enum

class PaperTray:
    class PaperTypes(Enum):
        A1 = 1
        A2 = 2
        A3 = 3
        A4 = 4
        A5 = 5


    def __init__(self, pt = PaperTypes.A4, pAmount = 1, maxPAmount = 100):
        self.paperType = pt
        self.paperAmount = pAmount
        self.maxPaperAmount = maxPAmount

    def checkPaperAmount(self):
        return self.paperAmount

    def checkPaperType(self):
        return str(self.paperType)

    def checkMaxPaperAmount(self):
        return self.maxPaperAmount

    def changePaperType(self, ptIndex):
        if ptIndex < 1 or ptIndex > len(self.PaperTypes):
            return "You tried to shove a paper with an invalid format into your printer!\nYou failed."
        else:
            self.paperType = self.PaperTypes(ptIndex)
            self.paperAmount = 1
            return f"You placed one sheet of {self.checkPaperType().name} paper into your printer's paper tray."

    def changePaperAmount(self, amount):
        if amount > 0:
            if amount + self.paperAmount > self.maxPaperAmount:
                self.paperAmount = self.maxPaperAmount
                return f"You tried to shove too much paper in your printer's paper tray!\nAll excess paper is now covering your room's floor.\nYour printer's tray is full, containing {self.checkPaperAmount()} sheets of paper."
            else:
                self.paperAmount += amount
                return f"Your printer's tray is containing {self.checkPaperAmount()} sheets of paper now."
        elif amount < 0:
            if amount + self.paperAmount < 0:
                self.paperAmount = 0
                return f"You tried to take non-existing papers from your printer's tray. After all REAL paper was taken, your printer's tray is empty, containing {self.checkPaperAmount()} sheets of paper."
            else:
                self.paperAmount += amount
                return f"Your printer's tray is containing {self.checkPaperAmount()} sheets of paper now."
        else:
            return "You stared at your paper tray.\nIt stared back."
