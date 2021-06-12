class MyHashMap {
    
    LinkedList<Entry>[] bucket;
    final int SIZE = 1009;
    
    class Entry
    {
            int key;
            int val;
            public Entry(int key, int val){
                this.key = key;
                this.val = val;
            }
    }
    public MyHashMap()
    {
        bucket = new LinkedList[SIZE];
        for (int i = 0;i<bucket.length;i++)
        bucket[i] = new LinkedList<Entry>();
    }
    
    public void put(int key, int value) 
    {
        int index = getHash(key); 
        LinkedList<Entry> entryLink = bucket[index]; 
        if (get(key) != -1) remove(key);   
        Entry entry = new Entry(key, value); 
        entryLink.add(entry);    
    }
    public int get(int key) 
    {
        int index = getHash(key);
        LinkedList<Entry> entryLink = bucket[index]; 
        for(int i=0;i<entryLink.size();i++){
             if(entryLink.get(i).key== key)
                return entryLink.get(i).val;
            
        }
        return -1;
    }
    public void remove(int key)
    {
        int index = getHash(key);
        LinkedList<Entry> entryLink = bucket[index];
        for(int i=0;i<entryLink.size();i++){
             if(entryLink.get(i).key== key)
                entryLink.remove(entryLink.get(i));   
        }
    }
    public int getHash(int key)
    {
        return key % SIZE;
    }
}
