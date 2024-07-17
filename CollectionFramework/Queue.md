# ArrayDeque

- ArrayDeque provides a way to apply resizable array.
- This is a special kind of array that grows and allows users to add or remove an element from both sides of the queue.
- They are not thread-safe which means that in the absence of external synchronization, ArrayDeque does not support
  concurrent access by multiple threads.

```java
public static void main(String[] args) {
    Deque<Integer> dq = new ArrayDeque<Integer>();

    dq.add(10);  // to insert
    dq.clear();
    dq.addFirst(5);  // insert at the start
    dq.addLast(20);  // insert at the end
    dq.element();  // to get head element
    dq.getFirst();  // to get head element
    dq.getLast();  // to get last element
    dq.remove();  // to remove head element
    dq.removeFirst();  // to remove first element
    dq.removeLast();  // to remove last element
}
```

# PriorityQueue

- A PriorityQueue is used when the objects are supposed to be processed based on the priority.
- PriorityQueue is based on priority heap.
- It gets stored in ascending order.
- By default, Priority Queue gives high priority to small values, but we can control it if we want to give high priority
  to large values
- add and remove functions work in O(log(n))
- peek works in O(1)


- In Java, PriorityQueue can be used as a Heap: <br />

1. **Min Heap** <br />
   PriorityQueue<Integer> minHeap = new PriorityQueue<>();


2. **Max Heap** <br />
   PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

```java
public static void main(String[] args) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    pq.add(10);  // insert element
    pq.peek();  // returns the top element
    pq.poll();  // returns the top element and remove it
    pq.remove(10);  // to remove element

    // to iterate elements
    Iterator iterator = pq.iterator();
    System.out.print(iterator.next() + " ");
}
```
