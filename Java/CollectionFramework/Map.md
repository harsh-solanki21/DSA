
# 🗺️ Java Map Collection

The `Map` interface represents a collection of **key-value pairs**. It does **not** allow duplicate keys, but can have duplicate values.

---

## 🔰 Core Implementations

### ✅ HashMap
- Unordered map (no insertion or sorted order).
- Allows one null key and multiple null values.
- Not thread-safe.
- All the operations(put, get, containsKey, keySet) works in O(1).

```java
Map<String, Integer> map = new HashMap<>();
map.put("Apple", 10);
map.put("Banana", 20);
System.out.println(map.get("Apple"));
map.remove("Banana");
map.containsKey("Apple");
```

---

### ✅ HashTable
- It is similar to HashMap, but is synchronized.
- Hashtable stores key/value pair in hash table.
- Insertion order is not retained in the hashtable.

```java
public static void main(String[] args) {
    Hashtable<Integer, String> ht = new Hashtable<>();

    ht.put(1, "one"); // to add element
    ht.put(2, "two");
    ht.put(3, "three");

    ht.put(2, "For"); // update the value at key 2
    ht.remove(4); // Remove the map entry with key 4
    ht.clear(); // to clear hashtable
    ht.contains("Harsh"); // to check for the value
    ht.containsValue("Harsh"); // same as above
    ht.containsKey(2); // to check for the key
    ht.get(2); // returns the value at the key 2
    ht.isEmpty();
    ht.size();
    ht.remove(2, "two");
    ht.replace(key.oldValue, newValue);

    // Iterating using enhanced for loop
    for (Map.Entry<String, Integer> e : ht.entrySet()) {
        System.out.println(e.getKey() + " " + e.getValue());
    }
}
```

---

### ✅ LinkedHashMap
- Maintains **insertion order**.
- Similar to HashMap but with predictable iteration order.

```java
Map<String, String> lhm = new LinkedHashMap<>();
lhm.put("one", "1");
lhm.put("two", "2");
System.out.println(lhm);
```

---

### ✅ TreeMap
- Sorted map (natural key order).
- No null keys allowed.
- Internally TreeMap is based on red-black tree.
- O(log n) for most operations.

```java
Map<Integer, String> tm = new TreeMap<>();
tm.put(3, "Three");
tm.put(1, "One");
tm.put(2, "Two");
System.out.println(tm); // Sorted by key
```

---

### ✅ EnumMap
- Specialized map for enum keys only.
- Very fast and compact.
- Maintains the natural order of enum keys.

```java
enum Day { MON, TUE, WED }
EnumMap<Day, String> emap = new EnumMap<>(Day.class);
emap.put(Day.MON, "Work");
emap.put(Day.TUE, "Meeting");
System.out.println(emap.get(Day.MON));
```

---

## 🧠 Summary

| Feature      | HashMap | LinkedHashMap | TreeMap | EnumMap |
|--------------|---------|---------------|---------|---------|
| Ordered      | ❌       | ✅             | ✅       | ✅       |
| Null Key     | ✅       | ✅             | ❌       | ❌       |
| Thread Safe  | ❌       | ❌             | ❌       | ❌       |
| Use With Enum| ❌       | ❌             | ❌       | ✅       |
