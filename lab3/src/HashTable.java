public class HashTable {
		private static int initialSize = 23;
		private Entry[] entries = new Entry[initialSize];

		public void put(String key, String value) {
				int hash = getHash(key);
				final Entry hashEntry = new Entry(key, value);
				if (entries[hash] == null) {
						entries[hash] = hashEntry;
				}

				else {
						Entry temp = entries[hash];
						while (temp.next != null) {
								temp = temp.next;
						}
						temp.next = hashEntry;
				}
		}

		public String get(String key) {
				int hash = getHash(key);
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

		public int getHash(String key) {
				return Integer.parseInt(key) % initialSize;
		}
		@Override
		public String toString() {
				int bucket = 0;
				StringBuilder hashTableStr = new StringBuilder();
				for (Entry entry : entries) {
						if(entry == null) {
								continue;
						}
						hashTableStr.append("\n bucket[")
										.append(bucket)
										.append("] = ")
										.append(entry.toString());
						bucket++;
						Entry temp = entry.next;
						while(temp != null) {
								hashTableStr.append(" -> ");
								hashTableStr.append(temp.toString());
								temp = temp.next;
						}
				}
				return hashTableStr.toString();
		}
}
