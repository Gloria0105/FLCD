import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class FAReader {
    FiniteAutomata fa;

    public FAReader(FiniteAutomata fa, String filename) {
        this.fa = fa;
        readFromFile(filename);
    }

    public List<String> getStates() {
        return fa.getQ();
    }

    public List<String> getAlphabet() {
        return fa.getE();
    }

    public List<String> getFinalStates() {
        return fa.getF();
    }

    public Map<Pair, List<String>> getTransitions() {
        return fa.getS();
    }

    public String getInitialState() {
        return fa.getQ0();
    }

    public void readFromFile(String filename) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                processLine(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void processLine(String line) {
        StringTokenizer st = new StringTokenizer(line, " ={,}");
        String type = st.nextToken();
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            switch (type) {
                case "Q":
                    fa.addState(token);
                    break;
                case "E":
                    fa.addToAlphabet(token);
                    break;
                case "F":
                    fa.addFinalState(token);
                    break;
                case "q0":
                    fa.setInitialState(token);
                    break;
                case "S":
                    createTransition(token);
                    break;
                default:
                    //todo
            }
        }

    }

    private void createTransition(String token) {
        StringTokenizer st = new StringTokenizer(token, "();->");
        String start = st.nextToken();
        String end = st.nextToken();
        String code = st.nextToken();

        fa.addTransition(new Pair(start, code), end);
    }

    public boolean checkDFA() {
        for (Pair pair : fa.getS().keySet()) {
            if(fa.getS().get(pair).size() > 1) {
                return false;
            }
        }

        return true;
    }

    public boolean accept(String sequence) {
        if (checkDFA()) {
            String[] states = sequence.split("(?!^)");

            String currentState = fa.getQ0();
            for (String state : states) {
                Pair pair = new Pair(currentState, state);
                if (fa.getS().containsKey(pair)) {
                    currentState = state;
                } else {
                    return false;
                }
            }
            return fa.getF().contains(currentState);
        }
        return false;
    }
}
