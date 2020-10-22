import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTable {
    private static int initialSize = 64;
    private Entry[] entries = new Entry[initialSize];

    public void put(String key, String value) throws NoSuchAlgorithmException {
        int hash = getHash(key);
        if (hash < 0) hash = -hash;
        final Entry hashEntry = new Entry(key, value);
        if (entries[hash] == null) {
            entries[hash] = hashEntry;
        } else {
            Entry temp = entries[hash];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = hashEntry;
        }
    }

    public String get(String key) throws NoSuchAlgorithmException {
        int hash = getHash(key);
        if (hash < 0) hash = -hash;
        if (entries[hash] != null) {
            Entry temp = entries[hash];

            while (!temp.key.equals(key)
                    && temp.next != null) {
                temp = temp.next;
            }
            return temp.value;
        }

        return null;
    }

    public int getHash(String key) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                key.getBytes(StandardCharsets.UTF_8));
        return new BigInteger(encodedhash).intValue() / 100000000;
    }

    @Override
    public String toString() {
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (Entry entry : entries) {
            if (entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            Entry temp = entry.next;
            while (temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }
}
