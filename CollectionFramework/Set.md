# HashSet

- HashSet internally uses hashtable data structure.
- It implements Set interface. so the duplicate values are not allowed.
- It doesn't maintain the order in which elements are inserted.
- NULL elements are allowed in HashSet.
- All the operations (add, get, delete) works in O(1).
- A HashSet is usually used for high-performance operations involving a set of unique data. Since HashSet contains only
  unique elements, its internal structure is optimized for faster searches.
  If you don't want to maintain insertion order but want to store unique objects.

```java
public static void main(String[] args) {
    // HashSet with 8 capacity and 0.75 load factor
    HashSet<Integer> numbers = new HashSet<>(8, 0.75);

    HashSet<Integer> hs = new HashSet<>();
    hs.add(2);
    hs.clear();
    hs.contains(2);
    hs.remove(2);
    hs.isEmpty();
    hs.size();
}
```

# LinkedHashSet

- The LinkedHashSet is an ordered version of HashSet that maintains a doubly-linked List across all elements.
- Duplicate values are not allowed.
- It will add elements in the order of which they are inserted.
- NULL elements are allowed in HashSet.

- When to use: <br />
  If you want to maintain the insertion order of elements and want to store unique objects.

# TreeSet

- TreeSet is basically an implementation of a self-balancing binary search tree like a Red-Black Tree.
- Operations like add, remove, and search takes O(log(N)) time.
- Height of the tree is always O(log(N)) for all the operations.
- This is considered as one of the most efficient data structures in order to store the huge sorted data and perform
  operations on it.
- Operations like printing N elements in the sorted order take O(N) time.
- No duplicate values allowed. They will get ignored.
- Objects in a TreeSet are stored in ascending order.

```java
public static void main(String[] args) {
    TreeSet<String> ts = new TreeSet<>();

    ts.contains("harsh"); // returns true or false
    ts.higher(3); // returns higher value than 3 (returns the immediate next value of 3)
    ts.lower(3); // returns lower value than 3 (returns the immediate previous value of 3)
    ts.pollFirst(); // to remove first value
    ts.pollLast(); // to remove last value

    // Remove duplicates from ArrayList using TreeSet
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 1, 1, 3, 5, 5, 2));
    System.out.println(list); // 4,5,1,1,3,5,5,2

    TreeSet<Integer> ts = new TreeSet<>(list);
    System.out.println(ts); // 1,2,3,4,5
```
