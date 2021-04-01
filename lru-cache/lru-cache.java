class LRUCache {
    class DLNode{
        int key;
        int val;
        DLNode prev;
        DLNode next;
        
        public DLNode(){}
        
        public DLNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, DLNode> cache;
    int capacity;
    
    DLNode head, tail;
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        
        head = new DLNode();
        tail = new DLNode();
        
        head.next = tail;
        tail.prev = head;
        
        this.capacity = capacity;
    }
    
    private void removeNode(DLNode node){
        DLNode prev = node.prev;
        DLNode next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        node.prev = null;
        node.next = null;
    }
    
    
    private void addToHeadNext(DLNode node){
        DLNode temp = head.next;
        head.next = node;
        node.prev = head;
        
        node.next = temp;
        temp.prev = node;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        
        DLNode node = cache.get(key);
        
        removeNode(node);
        addToHeadNext(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        //if cache contains key or size()<capacity put as usual move DLNode to headNext
        if(!cache.containsKey(key) && cache.size() < capacity){
            DLNode newNode = new DLNode(key, value);
            cache.put(key, newNode);
            addToHeadNext(newNode);
        }
        else if(cache.containsKey(key)){
            DLNode node = cache.get(key);
            node.val = value;
            
            removeNode(node);
            addToHeadNext(node);
        }
        //else remove node from tail.prev, remove cache entry, add new key,val to cache and movetohead
        else{
            DLNode nodeToEvict = tail.prev;
            
            removeNode(nodeToEvict);
            cache.remove(nodeToEvict.key);
            
            this.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */