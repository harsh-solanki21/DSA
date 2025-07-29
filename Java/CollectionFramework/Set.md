
# 🔗 Java Set Collection

A `Set` is a collection that **does not allow duplicate elements**. It models the mathematical set abstraction.

---

## 🔰 Core Implementations

### ✅ HashSet
- Backed by HashMap.
- No duplicates allowed.
- No guaranteed order.
- Allows one null element.

```java
Set<String> hs = new HashSet<>();
hs.add("A");
hs.add("B");
hs.add("A"); // Ignored
System.out.println(hs);
```

---

### ✅ LinkedHashSet
- Maintains insertion order.
- Slightly slower than HashSet.

```java
Set<Integer> lhs = new LinkedHashSet<>();
lhs.add(10);
lhs.add(20);
lhs.add(10); // Duplicate
System.out.println(lhs); // Preserves order
```

---

### ✅ TreeSet
- Sorted order (ascending).
- Backed by TreeMap.
- No duplicates.
- No null elements.

```java
Set<String> ts = new TreeSet<>();
ts.add("Zebra");
ts.add("Apple");
ts.add("Mango");
System.out.println(ts); // Sorted set
```

---

### ✅ EnumSet
- Specialized set for enum types.
- High-performance, compact, and type-safe.
- All elements must come from a single enum type.

```java
enum Size { SMALL, MEDIUM, LARGE }
EnumSet<Size> sizes = EnumSet.of(Size.SMALL, Size.MEDIUM);
System.out.println(sizes);
```

---

## 🧠 Summary

| Feature        | HashSet | LinkedHashSet | TreeSet | EnumSet |
|----------------|---------|----------------|---------|---------|
| Order Maintained | ❌     | ✅              | ✅       | ✅       |
| Duplicates Allowed | ❌   | ❌              | ❌       | ❌       |
| Null Allowed   | ✅       | ✅              | ❌       | ❌       |
| Thread Safe    | ❌       | ❌              | ❌       | ❌       |
