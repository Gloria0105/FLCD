import java.util.Objects;

public class Pair {
    public String key;
    public String value;

    public Pair(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public Pair() {

    }

    public String getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }

    public String setValue(String value) {
        return this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(key, pair.key) &&
                Objects.equals(value, pair.value);
    }


    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

}
