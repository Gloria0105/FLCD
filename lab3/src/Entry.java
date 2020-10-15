public class Entry {
		String key;
		String value;
		Entry next;

		public Entry(String key, String value) {
				this.key = key;
				this.value = value;
				this.next = null;
		}
		@Override
		public String toString() {
				return "[" + key + ", " + value + "]";
		}
}
