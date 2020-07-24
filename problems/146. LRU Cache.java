import java.util.*;

class LRUCache {

    class ListNode{
        int key;
        int val;
        ListNode pre;
        ListNode next;
    }

    Map<Integer, ListNode> mCacheMap = new HashMap<>();

    ListNode dummyHead = new ListNode();
    ListNode dummyTail = new ListNode();

    int mCapacity = 0;

    public LRUCache(int capacity) {
        mCapacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.pre = dummyHead;
    }
    
    public int get(int key) {
        ListNode node = mCacheMap.get(key);
        if(node == null) return -1;
        //移除当前节点
        removeNode(node);
        //插入到头部
        insertHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        //先get一下
        if(get(key) != -1){
            ListNode node = mCacheMap.get(key);
            node.val = value;
            return;
        }
        if(mCacheMap.size() >= mCapacity){
            //除尾
            ListNode rmNode = dummyTail.pre;
            mCacheMap.remove(rmNode.key);
            removeNode(rmNode);
        }
        //插入新节点
        ListNode newNode = new ListNode();
        newNode.key = key;
        newNode.val =value;
        insertHead(newNode);
        mCacheMap.put(key, newNode);
    }

    private void removeNode(ListNode node){
        ListNode tempNode = node.pre;
        tempNode.next = node.next;
        tempNode.next.pre = tempNode;
    }

    private void insertHead(ListNode node){
        ListNode tempNode = dummyHead.next;
        dummyHead.next = node;
        node.pre = dummyHead;
        tempNode.pre = node;
        node.next = tempNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */