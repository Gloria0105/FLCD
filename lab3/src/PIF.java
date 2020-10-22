import java.util.HashMap;

public class PIF {
    public HashMap<String,Integer >pifTable=new HashMap<>();

    public void add(String token, Integer index){
        pifTable.put(token,index);
    }
}
