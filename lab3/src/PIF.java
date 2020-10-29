import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PIF {
    public HashMap<String, Map.Entry<Integer, Integer>> pifTable = new HashMap<>();
    public List<String> tokens = new ArrayList<>();
    List<Pair> entries = new ArrayList<>();
    public void add(String token, Map.Entry<Integer, Integer> entry) {
        tokens.add(token);
        Pair pair= new Pair(entry.getKey(),entry.getValue());
        entries.add(pair);
        pifTable.put(token, entry);
    }

    public HashMap<String, Map.Entry<Integer, Integer>> getPifTable() {
        return pifTable;
    }

    public List<String> getTokens() {
        return tokens;
    }

    public List<Pair> getEntries() {
        return entries;
    }

    @Override
    public String toString() {
        return "PIF{" +
                "pifTable=" + pifTable +
                '}';
    }
}
