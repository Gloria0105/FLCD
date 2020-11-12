public class Main {
    public static void main(String[] args) {
        String filename = "C:\\Users\\abac\\Desktop\\Facultate\\flcd\\FLCD\\lab4\\src\\main\\java\\data\\fa.txt";
        FiniteAutomata fa = new FiniteAutomata();
        FAReader controller = new FAReader(fa, filename);
        UI userInterface = new UI(controller);
        userInterface.run();
    }
}
