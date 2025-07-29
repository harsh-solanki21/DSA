
# 🎯 Java Queue Collection

The `Queue` interface is designed for holding elements prior to processing, typically in FIFO (first-in-first-out) order.

---

## 🔰 Core Implementations

### ✅ PriorityQueue
- Implements min-heap by default.
- Elements processed by priority (ascending).
- Not thread-safe.
- O(log n) insert and remove.

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(3);
pq.add(1);
pq.add(2);
System.out.println(pq.peek()); // 1
pq.poll(); // Removes 1
```

For max-heap:
```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
```

---

### ✅ Deque / ArrayDeque
- Double-ended queue.
- Can act as stack or queue.
- Faster than Stack/LinkedList.
- Not thread-safe.

```java
Deque<String> dq = new ArrayDeque<>();
dq.addFirst("first");
dq.addLast("last");
System.out.println(dq.getFirst()); // "first"
System.out.println(dq.removeLast()); // "last"
```

### ✅ LinkedList as Deque
- Implements both List and Deque interfaces.
- Doubly-linked list structure.
- Allows null elements.
- Slightly slower than ArrayDeque for deque operations.

```java
Deque<String> llDeque = new LinkedList<>();
llDeque.addFirst("start");
llDeque.addLast("end");
System.out.println(llDeque.getLast()); // "end"
llDeque.removeFirst(); // Removes "start"
```

---

## 🧠 Summary

| Feature       | PriorityQueue | ArrayDeque |
|---------------|---------------|------------|
| Ordering      | Priority based| FIFO / LIFO|
| Null Allowed  | ❌             | ❌          |
| Thread Safe   | ❌             | ❌          |
| Use As Stack  | ❌             | ✅          |
| Use As Queue  | ✅             | ✅          |
