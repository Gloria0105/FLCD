public class Entry {
		String key;
		Integer value;
		Entry next;

		public Entry(String key, Integer value) {
				this.key = key;
				this.value = value;
				this.next = null;
		}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Entry getNext() {
		return next;
	}

	public void setNext(Entry next) {
		this.next = next;
	}

	public void set(Entry hashEntry) {
			setKey(hashEntry.getKey());
			setValue(hashEntry.getValue());
	}

	@Override
	public String toString() {
		return "Entry{" +
				"key='" + key + '\'' +
				", value=" + value +
				'}';
	}
}
