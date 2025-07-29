
# 📚 Java List Collection

The `List` interface in Java is an **ordered** collection that may contain **duplicate elements**. It allows precise control over where elements are inserted and accessed.

---

## 🔰 Core Implementations

### ✅ ArrayList
- Resizable array implementation.
- Fast random access, slow insert/delete in middle.
- Not thread-safe (use `Collections.synchronizedList()` if needed).
- Duplicate values allowed.
- Maintains insertion order.
- Grows by 1.5x when capacity is exceeded.
- Backed by an array.

```java
ArrayList<Integer> list = new ArrayList<>();
// we can initialize initial capacity of the ArrayList in the ()

ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 1, 1, 3, 5)); // to add initial values
```

```java
List<String> list = new ArrayList<>();
list.add("A");
list.add("B");
list.add(1, "C"); // Insert at index
System.out.println(list.get(1)); // Access element
list.remove("A");
Collections.sort(list); // Sort
```

---

### ✅ LinkedList
- Doubly linked list implementation.
- Fast insert/delete, slow random access.
- Implements both `List` and `Deque`.
- Allows null and duplicates.

```java
LinkedList<Integer> ll = new LinkedList<>();
ll.add(10);
ll.addFirst(5);
ll.addLast(15);
ll.removeFirst();
System.out.println(ll.peekLast());
```

---

### ✅ Vector
- Thread-safe (synchronized) version of ArrayList.
- Slower due to synchronization.
- Grows by doubling the size.
- Rarely used in modern code.

```java
Vector<Integer> vec = new Vector<>();
vec.add(100);
vec.addElement(200);
System.out.println(vec.get(0));
```

---

### ✅ Stack
- LIFO structure (extends Vector).
- Useful for recursive/undo operations.
- Methods: `push()`, `pop()`, `peek()`, `empty()`, `search()`.

```java
Stack<String> stack = new Stack<>();
stack.push("Java");
stack.push("Python");
System.out.println(stack.peek()); // Top element
stack.pop(); // Remove top
System.out.println(stack.empty()); // Check empty
```

---

## 🧠 Summary

| Feature       | ArrayList | LinkedList | Vector | Stack |
|---------------|-----------|------------|--------|-------|
| Order         | ✅         | ✅          | ✅      | ✅     |
| Duplicates    | ✅         | ✅          | ✅      | ✅     |
| Thread-safe   | ❌         | ❌          | ✅      | ✅     |
| Fast Access   | ✅         | ❌          | ✅      | ✅     |
| LIFO Support  | ❌         | ❌          | ❌      | ✅     |
