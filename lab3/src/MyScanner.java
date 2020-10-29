import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScanner {
    File file = new File("token.in.txt");
    File p1 = new File("p1-flcd.txt");
    public List<String> operators = new ArrayList();
    public List<String> separators = new ArrayList();
    public List<String> reservedWords = new ArrayList();
    public PIF pif = new PIF();
    public SymbolTable symbolTableIdentifiers = new SymbolTable();
    public SymbolTable symbolTableConstants = new SymbolTable();


    public void readTokenFile(String filename) {
        //read the token.in file and add each operator and separator to it s list
        List<String> lines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        separators.add("\t");
        for (int i = 0; i <= lines.size(); i++) {
            if (i <= 10) {
                operators.add(lines.get(i));
            }
            if (i > 10 && i <= 18) {
                separators.add(lines.get(i));
            }
            if (i > 18 && i <= 32) {
                reservedWords.add(lines.get(i));
            }

        }
    }

    private List<String> readFile(String filename) {
        //read every file and return a list with the lines
        List<String> lines = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public List<String> tokenize(String line, int lineCount) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(line, " ,()[]{};+-*/%=><!\t", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (!token.equals(" ")) {
                if (token.equals("<") || token.equals(">")) {
                    String nextToken = st.nextToken();
                    if (nextToken.equals("=")) {
                        tokens.add(token + nextToken);
                    } else {
                        tokens.add(token);
                        tokens.add(nextToken);
                    }
                } else {
                    if (token.equals(";")) {
                        try {
                            String nextToken = st.nextToken();
                            if (token.equals(nextToken)) {
                                tokens.add(token + nextToken);
                            } else {
                                tokens.add(token);
                                tokens.add(nextToken);
                            }
                        } catch (NoSuchElementException e) {
                            System.out.println("Lexical error for token: " + token + " at line: " + lineCount);
                        }
                    } else {
                        tokens.add(token);
                    }

                }
            }
        }


        return tokens;
    }

    private void writeToFilePif(String filename, PIF pif) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));

        List<String> tokens = pif.getTokens();
        List<Pair> entries = pif.getEntries();
        writer.write(pif.toString());
        writer.close();
    }

    private void writeToFileSt(String filename, SymbolTable symbolTable) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(symbolTable.hashTable.toString());
        writer.close();
    }


    public boolean isIdentifier(String token) {

        String pattern = "^[a-z]([a-z]|[0-9])*$";
        //lower case letters (a-z) of the english alphabet
        //a sequence of letters, followed by a sequence of digits,
        // such that the first character is a letter
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(token);
        return m.find();
    }

    public boolean isConstant(String token) {

        String pattern = "^(0|[+\\-]?[1-9][0-9]*)$|^\".*\"$";
        //a sequence of digits starting with a nonzero-digit
        // or a single signed or unsigned nonzero-digit
        // or a zerodigit
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(token);
        return m.find();
    }

    public boolean isOperator(String token) {
        for (String operator : operators) {
            if (token.equals(operator)) return true;
        }
        return false;
    }

    public boolean isSeparator(String token) {
        for (String separator : separators) {
            if (token.equals(separator)) return true;
        }
        return false;
    }

    public boolean isReservedWord(String token) {
        for (String reservedWord : reservedWords) {
            if (token.equals(reservedWord)) return true;
        }
        return false;
    }

    public void generate() throws NoSuchAlgorithmException, FileNotFoundException {
        //generate symbol table and pif

        String fileIn = "p1err-flcd.txt";
        String pifFile = "pif.txt";
        String symbolTableIdentifiersFile = "symbolTableIdentifiers.txt";
        String symbolTableConstantsFile = "symbolTableConstants.txt";
        this.readTokenFile("token.in.txt");

        List<String> lines = readFile(fileIn);
        int lineCount = 0;
        for (String line : lines) {
            lineCount += 1;
            List<String> tokens = tokenize(line, lineCount);
            for (String token : tokens) {
                if (isOperator(token) || isSeparator(token) || isReservedWord(token)) {
                    pif.add(token, new Pair(-1, -1));
                } else {
                    if (isIdentifier(token)) {
                        // put 1 in pif
                        Map.Entry<Integer, Integer> pos = new Pair(1, symbolTableIdentifiers.getPosition(token));
                        pif.add(token, new Pair(pos.getKey(), pos.getValue()));
                    } else if (isConstant(token)) {
                        // put 2 in pif
                        Map.Entry<Integer, Integer> pos = new Pair(2, symbolTableConstants.getPosition(token));
                        pif.add(token, new Pair(pos.getKey(), pos.getValue()));
                    } else {
                        throw new RuntimeException("Unable to classify token: " + token + "at line:"+lineCount);
                    }

                }
            }

        }

        System.out.println("Classification done");
        try {
            writeToFilePif(pifFile, pif);
            writeToFileSt(symbolTableIdentifiersFile, symbolTableIdentifiers);
            writeToFileSt(symbolTableConstantsFile, symbolTableConstants);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
