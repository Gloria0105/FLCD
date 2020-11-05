import java.util.ArrayList;
import java.util.List;

public class FiniteAutomata {
    private List<String> Q;
    private List<Transition> S;
    private List<String> F;
    private List<String> E;
    private String q0;


    public FiniteAutomata() {
        this.Q = new ArrayList<>();
        this.S = new ArrayList<>();
        this.F = new ArrayList<>();
        this.E = new ArrayList<>();
    }

    public void addState(String state) {
        Q.add(state);
    }

    public void addTransition(Transition transition) {
        S.add(transition);
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
        return Q;
    }

    public List<Transition> getS() {
        return S;
    }

    public List<String> getF() {
        return F;
    }

    public List<String> getE() {
        return E;
    }

    public String getQ0() {
        return q0;
    }
}
