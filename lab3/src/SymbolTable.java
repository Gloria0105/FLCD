import java.security.NoSuchAlgorithmException;

public class SymbolTable {

		public HashTable hashTable = new HashTable();
		int position = 0;

		private Integer add(String key) throws NoSuchAlgorithmException {
				int value = position+1;
				position ++;
				hashTable.put(key,value);
				return hashTable.get(key);
		}
		public Integer getPosition(String key) throws NoSuchAlgorithmException {
				if(hashTable.get(key)==null)
				{
						return add(key);
				}
				else return hashTable.get(key);
		}


	public HashTable getHashTable() {
		return hashTable;
	}
}
