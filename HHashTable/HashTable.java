package HHashTable;

public class HashTable {
    class Node{
        String key;
        String value;
        Node next;
        Node(String key, String value){
            this.key=key;
            this.value=value;
        }
    }
    int length =7;
    Node[] dataMap;
    public HashTable(){
        dataMap= new Node[length];
    }

    public void set(String key, String value){
        Node newNode = new Node(key, value);
        int hashKey = getHashKey(key);
        var NodeList=dataMap[hashKey];
        if (NodeList == null){
            dataMap[hashKey]= newNode;
            return;
        }
        Node temp = dataMap[hashKey];
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next= newNode;
    }

    public String get(String key){
        int index = getHashKey(key);
        if(dataMap[index]==null)
            return null;
        Node temp = dataMap[index];
        while (temp != null){
            if(temp.key== key){
                return temp.value;
            }
            temp= temp.next;
        }
        return null;
    }


    public int getHashKey(String hashKey){
        var keyArr=hashKey.toCharArray();
        int key=0;
        for (int i=0; i< hashKey.length();i++){
            key = (key + keyArr[i]) % length;
        }
    return key;
    }


    public static void main(String[] args) {
        HashTable ht = new HashTable();
        ht.set("Happy", "100");
        ht.set("Happy1", "23");
        ht.set("Happy2", "23");
        ht.set("Happ4", "100");
        System.out.println(ht.get("Happy3"));
    }
}
