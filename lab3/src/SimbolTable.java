

public class SimbolTable {

		public HashTable hashTable = new HashTable();
		int position = 0;

		private String add(String key){
				int value = position+1;
				position ++;
				hashTable.put(key,String.valueOf(value));
				return hashTable.get(key);
		}
		public String getPosition(String key){
				if(hashTable.get(key)==null)
				{
						return add(key);
				}
				else return hashTable.get(key);
		}


}
