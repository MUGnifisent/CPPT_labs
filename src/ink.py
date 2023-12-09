class Ink:
    def __init__(self):
        self.red_percentage = 100
        self.green_percentage = 100
        self.blue_percentage = 100

    def __init__(self, red_p, green_p, blue_p):
        self.red_percentage = red_p
        self.green_percentage = green_p
        self.blue_percentage = blue_p

    def check_red_ink_level(self):
        return self.red_percentage

    def check_green_ink_level(self):
        return self.green_percentage

    def check_blue_ink_level(self):
        return self.blue_percentage

    def fill_red_ink(self, amount):
        if amount <= 0:
            return f"You poured in exactly nothing.\nRed ink level stayed on {self.check_red_ink_level()} percent."
        self.red_percentage += amount
        if self.red_percentage > 100:
            diff = self.red_percentage - 100
            self.red_percentage = 100
            return f"You poured in too much and {diff} percent of ink is spilled!\nRed ink reservoir is full."
        else:
            return f"You poured in {amount} percent of ink.\nRed ink reservoir contains {self.check_red_ink_level()} percent of ink."

    def fill_green_ink(self, amount):
        if amount <= 0:
            return f"You poured in exactly nothing.\nGreen ink level stayed on {self.check_green_ink_level()} percent."
        self.green_percentage += amount
        if self.green_percentage > 100:
            diff = self.green_percentage - 100
            self.green_percentage = 100
            return f"You poured in too much and {diff} percent of ink is spilled!\nGreen ink reservoir is full."
        else:
            return f"You poured in {amount} percent of ink.\nGreen ink reservoir contains {self.check_green_ink_level()} percent of ink."

    def fill_blue_ink(self, amount):
        if amount <= 0:
            return f"You poured in exactly nothing.\nBlue ink level stayed on {self.check_blue_ink_level()} percent."
        self.blue_percentage += amount
        if self.blue_percentage > 100:
            diff = self.blue_percentage - 100
            self.blue_percentage = 100
            return f"You poured in too much and {diff} percent of ink is spilled!\nBlue ink reservoir is full."
        else:
            return f"You poured in {amount} percent of ink.\nBlue ink reservoir contains {self.check_blue_ink_level()} percent of ink."
