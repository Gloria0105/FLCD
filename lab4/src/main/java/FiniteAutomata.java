
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiniteAutomata {
    private List<String> Q;
    private Map<Pair,List<String>> S;
    private List<String> F;
    private List<String> E;
    private String q0;


    public FiniteAutomata() {
        this.Q = new ArrayList<>();
        this.S = new HashMap<>();
        this.F = new ArrayList<>();
        this.E = new ArrayList<>();
    }

    public void addState(String state) {
        Q.add(state);
    }

    public void addTransition(Pair pair, String state) {
        if (S.containsKey(pair)) {
            S.get(pair).add(state);
        } else {
            S.put(pair, new ArrayList<String>());
            S.get(pair).add(state);
        }
    }

    public void addFinalState(String finalState) {
        F.add(finalState);
    }

    public void addToAlphabet(String elem) {
        E.add(elem);
    }

    public void setInitialState(String initialState) {
        this.q0 = initialState;
    }

    public List<String> getQ() {
        //all states
        return Q;
    }

    public Map<Pair, List<String>> getS() {
        //transitions
        return S;
    }

    public List<String> getF() {
        //final states
        return F;
    }

    public List<String> getE() {
        // alphabet
        return E;
    }

    public String getQ0() {
        //initial state
        return q0;
    }
}
