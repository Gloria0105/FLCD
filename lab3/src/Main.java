import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, FileNotFoundException {
        SymbolTable simbolTable = new SymbolTable();
        System.out.println(simbolTable.getPosition("a"));
        System.out.println(simbolTable.getPosition("c"));
        System.out.println(simbolTable.getPosition("b"));
        MyScanner scanner = new MyScanner();
        scanner.generate();
    }

}
