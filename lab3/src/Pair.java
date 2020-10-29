import java.util.Map;

public class Pair implements Map.Entry<Integer, Integer> {
    public Integer key;
    public Integer value;

    public Pair(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public Integer setValue(Integer value) {
        return this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
