import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UI {
    FAReader faReader;

    public UI(FAReader faReader) {
        this.faReader = faReader;
    }

    private static void showMenu() {
        System.out.println("1 - States");
        System.out.println("2 - Alphabet");
        System.out.println("3 - Transitions");
        System.out.println("4 - Final states");
        System.out.println("5 - Initial state");
        System.out.println("6 - DFA check");
    }

    public void states() {
        List<String> states = faReader.getStates();
        StringBuilder sb = new StringBuilder("Q = {");
        int i = 0;
        for (String state : states) {
            i++;
            if (states.size() == i) {
                sb.append(state).append(" ");
                break;
            }
            sb.append(" ").append(state).append(", ");
        }
        sb.append("}");
        System.out.println(sb);
    }

    public void alphabet() {
        List<String> alphabet = faReader.getAlphabet();
        StringBuilder sb = new StringBuilder("E = {");
        int i = 0;
        for (String alph : alphabet) {
            i++;
            if (alphabet.size() == i) {
                sb.append(alph).append(" ");
                break;
            }
            sb.append(" ").append(alph).append(", ");
        }
        sb.append("}");
        System.out.println(sb);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            UI.showMenu();
            System.out.println(">> ");

            try {
                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        states();
                        break;
                    case 2:
                        alphabet();
                        break;
                    case 3:
                        transitions();
                        break;
                    case 4:
                        finalStates();
                        break;
                    case 5:
                        initialState();
                        break;
                    case 6:
                        acceptSequence();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        throw new AssertionError("\nError - Unknown operation \n");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void transitions() {
        Map<Pair, List<String>> transitions = faReader.getTransitions();
        System.out.println("S = {");
        for (Pair pair : transitions.keySet()) {
            String sb = "(" +
                    pair.getKey() +
                    ", " +
                    pair.getValue() +
                    ") => " +
                    transitions.get(pair);
            System.out.println(sb);
        }
        System.out.println("}");
    }

    private void initialState() {
        String initialState = faReader.getInitialState();
        System.out.println("q0 = " + initialState);
    }

    private void finalStates() {
        List<String> states = faReader.getFinalStates();
        StringBuilder sb = new StringBuilder("F = { ");
        int i = 0;
        for (String state : states) {
            i++;
            if (states.size() == i) {
                sb.append(state).append(" ");
                break;
            }
            sb.append(state).append(", ");
        }
        sb.append("}");
        System.out.println(sb);
    }
    public void acceptSequence() {
        Scanner scanner = new Scanner(System.in);
        String seq = scanner.nextLine();
        if(faReader.accept(seq)) {
            System.out.println("Sequence accepted");
        } else {
            System.out.println("Sequence is NOT accepted");
        }
    }

}
