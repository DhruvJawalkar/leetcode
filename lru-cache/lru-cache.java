/*
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

TC - O(1), for init(), get(), put()
SC - O(capacity), for cache


*/
class LRUCache {
    private class Node {
        int key;
        int val;
        Node next;
        Node prev;
        
        public Node(){}
        public Node(int k, int v){
            this.key = k;
            this.val = v;
        }
    }
    
    private HashMap<Integer, Node> cache;
    private int capacity;
    private Node head, tail;
    
    private void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
        node.prev = null;
        node.next = null;
    }
    
    private void addToHead(Node node){
        Node temp = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = temp;
        temp.prev = node;
    }
    
    private void evictTail(){
        Node toEvict = this.tail.prev;
        removeNode(toEvict);
        
        this.cache.remove(toEvict.key);
    }
    
    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            Node node = this.cache.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
        }
        else{
            if(this.cache.size() == this.capacity){
                evictTail();
            }    
            
            Node newNode = new Node(key, value);
            this.cache.put(key, newNode);
            addToHead(newNode);                
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */