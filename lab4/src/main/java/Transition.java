public class Transition {
    private String initialState;
    private String finalState;
    private String code; //route

    public Transition(String initialState, String finalState, String code) {
        this.initialState = initialState;
        this.finalState = finalState;
        this.code = code;
    }

    public String getInitialState() {
        return initialState;
    }

    public String getFinalState() {
        return finalState;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "("+
                 initialState + ";"+
                 code + ")->" +
                 finalState  +
                ", ";
    }
}
