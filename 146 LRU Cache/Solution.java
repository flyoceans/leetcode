public class LRUCache {

  class LinkedNode {
    int key;
    int value;
    LinkedNode prev;
    LinkedNode next;
  }

  private void addNode(LinkedNode node) {
    /**
     * Always add the new node right after head.
     */
    node.prev = head;
    node.next = head.next;

    head.next.prev = node;
    head.next = node;
  }

  private void removeNode(LinkedNode node){
    /**
     * Remove an existing node from the linked list.
     */
    LinkedNode prev = node.prev;
    LinkedNode next = node.next;

    prev.next = next;
    next.prev = prev;
  }

  private void moveToHead(LinkedNode node){
    /**
     * Move certain node in between to the head.
     */
    removeNode(node);
    addNode(node);
  }

  private LinkedNode popTail() {
    /**
     * Pop the current tail.
     */
    LinkedNode res = tail.prev;
    removeNode(res);
    return res;
  }

  private Map<Integer, LinkedNode> cache = new HashMap<>();
  private int size;
  private int capacity;
  private LinkedNode head, tail;

  public LRUCache(int capacity) {
    this.size = 0;
    this.capacity = capacity;

    head = new LinkedNode();
    tail = new LinkedNode();

    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    LinkedNode node = cache.get(key);
    if (node == null) return -1;

    // move the accessed node to the head;
    moveToHead(node);

    return node.value;
  }

  public void put(int key, int value) {
    LinkedNode node = cache.get(key);

    if(node == null) {
      LinkedNode newNode = new LinkedNode();
      newNode.key = key;
      newNode.value = value;

      cache.put(key, newNode);
      addNode(newNode);

      ++size;

      if(size > capacity) {
        // pop the tail
        LinkedNode tail = popTail();
        cache.remove(tail.key);
        --size;
      }
    } else {
      // update the value.
      node.value = value;
      moveToHead(node);
    }
  }
}