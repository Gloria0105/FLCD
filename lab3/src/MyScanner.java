import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MyScanner {
    File file = new File("token.in.txt");
    File p1 = new File("p1-flcd.txt");
    public List<String> operators = new ArrayList();
    public List<String> separators = new ArrayList();
    public List<String> reservedWords = new ArrayList();
    public PIF pif = new PIF();
    public SimbolTable simbolTable = new SimbolTable();

    public String  tokenize(String line, List<String> tokens) {
        StringTokenizer token = null;
        while (!line.isEmpty()) {
            token = new StringTokenizer(line);
        }

        return token.toString();
    }

    public void readFromFile(File file) throws FileNotFoundException {

        int i = 0;
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            i++;
            if (i <= 11) {
                operators.add(myReader.nextLine());
            }
            if (i > 11 && i <= 16) {
                separators.add(myReader.nextLine());
            }
            if (i > 16 && i <= 28) {
                reservedWords.add(myReader.nextLine());
            }

        }
    }

    public boolean isIdentifier(String token) {
        //TODO
        return true;
    }

    public boolean isConstant(String token) {
        //TODO
        return true;
    }

    public boolean isOperator(String token) {
        for(String operator: operators){
            if (token.equals(operator)) return true;
        }
        return false;
    }

    public boolean isSeparator(String token) {
        for(String separator: separators){
            if (token.equals(separator)) return true;
        }
        return false;
    }
    public boolean isReservedWord(String token) {
        for(String reservedWord: reservedWords){
            if (token.equals(reservedWord)) return true;
        }
        return false;
    }
    public void verify(File p1) throws FileNotFoundException {
        List <String> tokens=new ArrayList<>();

        Scanner read = new Scanner(p1);
        while (read.hasNextLine()) {
            tokens.add(tokenize(read.nextLine(),separators));
        }
        for(String token: tokens){
            if(isReservedWord(token)||isOperator(token)){
                //generatePif(token);
            }
        }
    }
    public void generatePif(String token) throws NoSuchAlgorithmException {
       //TODO
    }

}
