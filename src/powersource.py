from abc import ABC, abstractmethod

class PowerSource(ABC):
    @abstractmethod
    def changePowerSource(self):
        pass
