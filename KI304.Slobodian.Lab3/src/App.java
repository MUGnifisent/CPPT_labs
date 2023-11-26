public class App {
    public static void main(String[] args) throws Exception {
        MultifunctionalUnit printer = new MultifunctionalUnit();
        printer.turnOn();
        printer.connectPrinterToDaInternet("", "", 2);
        printer.hastyFillUp();
        printer.getInkInfo();
        printer.getInternetInfo();
        printer.getPaperTrayInfo();
        printer.getPowerSource();
        printer.changePowerSource();
        printer.JAMDAPAPER();
        printer.printViaInternet(5);
        printer.UNJAMDAPAPER();
        printer.printViaFlsh(100);
        printer.turnOff();
        printer.dispose();
    }
}
