
# 📘 Java Generics

Java Generics provide compile-time type safety and eliminate the need for type casting. They are used with classes, interfaces, and methods.

---

## ✅ Why Use Generics?

- **Type Safety**: Detect type errors at compile time.
- **Eliminates Casting**: No need to cast when retrieving an object.
- **Code Reusability**: Write one class or method to work with different types.

---

## 📦 Generic Class

```java
class Box<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

Usage:
```java
Box<String> stringBox = new Box<>();
stringBox.set("Hello");
String str = stringBox.get(); // No casting needed
```

---

## 🧩 Generic Interface

```java
interface Pair<K, V> {
    K getKey();
    V getValue();
}
```

Implementation:
```java
class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

---

## 📌 Bounded Type Parameters

### Upper Bound: `T extends Class`

```java
public <T extends Number> void printDouble(T number) {
    System.out.println(number.doubleValue());
}
```

- Restricts `T` to be a subtype of `Number`.

### Multiple Bounds

```java
<T extends ClassA & InterfaceB>
```

- A class can be extended and multiple interfaces implemented.

### Lower Bound (Wildcard):

```java
public void add(List<? super Integer> list) {
    list.add(1);
}
```

- Accepts Integer or its superclasses (Number, Object).

---

## 🔁 Wildcards in Generics

| Syntax             | Meaning                          |
|--------------------|----------------------------------|
| `<?>`              | Unknown type                     |
| `<? extends T>`    | Upper bounded wildcard           |
| `<? super T>`      | Lower bounded wildcard           |

Example:
```java
List<? extends Number> numbers = new ArrayList<Integer>();
```

---

## 📥 Generic Methods

```java
public <T> void printArray(T[] array) {
    for (T element : array) {
        System.out.println(element);
    }
}
```

---

## 🚫 Type Erasure

- Java implements generics using **type erasure**.
- Generic type information is removed at runtime.
- Example:
  ```java
  List<String> and List<Integer> → both become List at runtime
  ```

---

## 📝 Key Notes

- Generics enforce **compile-time type checking**.
- Use **bounded types** to restrict the types generics can accept.
- Use **wildcards** for flexible method parameters.
- All generic type info is **erased** at runtime (type erasure).
- You **cannot** create instances of generic types (`new T()` is not allowed).

---

## ❌ Limitations of Generics

- Cannot instantiate generic types: `new T()` ❌
- Cannot create arrays of generic types: `new T[10]` ❌
- Cannot use primitives as type parameters: use wrapper classes like `Integer`, `Double`, etc.
