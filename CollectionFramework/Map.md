# HashMap

- HashMap is similar to HashTable, but it is Unsynchronized.
- Insertion order is not retained in the HashMap.
- HashMap doesn't allow duplicate keys but allows duplicate values.
- All the operations(put, get, containsKey, keySet) works in O(1).

```java
public static void main(String[] args) {
    HashMap<String, Integer> map = new HashMap<>();

    map.put("nisarg", 10); // to insert values
    map.put("nisarg", 20); // will update the value 20 from 10
    map.size();
    map.get("nisarg"); // to get the value of the key
    map.get("harsh"); // Harsh is not present in the map. So it will return null
    map.remove("nisarg");
    map.containsKey("nisarg"); // if present returns true, otherwise false

    map.getOrDefault("b", 500);
    // get the value mapped with specified key.
    // If no value is mapped with the provided key then the default value is returned.

    // to display all the keys
    Set<String> keys = map.keySet();
    System.out.println(keys);

    // display map data using loop
    for (String key : hm.keySet()) {
        Integer val = map.get(key);
        System.out.println(key + " " + val);
    }

    // Iterate the map using for-each loop
    for (Map.Entry<String, Integer> e : map.entrySet()) {
        System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
    }
}
```

# HashTable

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

# TreeMap

- TreeMap is sorted in ascending order.
- Does not allow null keys.
- Internally TreeMap is based on red-black tree.
- All the operations(put, get, containsKey, keySet) works in O(log n).

```java
public static void main(String[] args) {
    TreeMap<Integer, String> tm = new TreeMap<>();

    tm.put(10, "ten");  // insert values in treemap
    tm.containsKey(10);  // search a key
    tm.containsValue("ten");  // search a value

    // TreeMap Traverse
    for (Map.Entry<Integer, String> e : tree_map.entrySet()) {
        System.out.println(e.getKey() + " " + e.getValue());
    }
}
```

# HashMap vs HashTable

1. As stated above the main difference between HashMap & Hashtable is `synchronization`. If there is a need of `thread-safe` operation then Hashtable can be used as all its methods are synchronized, but it’s a legacy class and should be avoided as there is nothing about it, which cannot be done by HashMap.


2. Synchronized operation gives poor performance, so it should be avoided until unless required. Hence, for non-thread environment HashMap should be used without any doubt.
