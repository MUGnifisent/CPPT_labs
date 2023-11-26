public class App {
    public static void main(String[] args) throws Exception {
        Printer printer = new Printer();
        printer.turnOn();
        printer.connectPrinterToDaInternet("", "", 2);
        printer.hastyFillUp();
        printer.getInkInfo();
        printer.getInternetInfo();
        printer.getPaperTrayInfo();
        printer.printViaInternet(5);
        printer.printViaFlsh(100);
        printer.turnOff();
        printer.dispose();
    }
}
