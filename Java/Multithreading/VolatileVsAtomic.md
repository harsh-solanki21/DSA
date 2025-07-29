
# Volatile vs Atomic

Understanding the difference between `volatile` variables and `atomic` classes is key to writing correct and efficient concurrent programs in Java.

## ⚡ Volatile

### ✅ What is it?
- A keyword in Java used to indicate that a variable's value will be modified by different threads.
- Ensures **visibility**: changes made by one thread are immediately visible to other threads.

### ✅ Key Features
- **Does not guarantee atomicity.**
- Lightweight compared to synchronization.
- Suitable for flags or simple state tracking.

### ✅ Example
```java
volatile boolean running = true;

public void stop() {
    running = false;
}
```

### ✅ Use Case
- Use for flags, signals, or state variables where atomicity is not required but visibility is critical.

---

## 🧮 Atomic Classes (java.util.concurrent.atomic)

### ✅ What is it?
- A set of classes (e.g., `AtomicInteger`, `AtomicBoolean`, `AtomicLong`) that support **lock-free**, thread-safe operations on single variables.

### ✅ Key Features
- Provides **atomicity** and **visibility**.
- Uses low-level atomic CPU instructions (CAS - Compare And Swap).
- Thread-safe increment, decrement, and update operations.

### ✅ Example
```java
AtomicInteger counter = new AtomicInteger(0);

counter.incrementAndGet();  // Atomically increment by 1
counter.getAndAdd(5);       // Atomically add 5 and return old value
```

### ✅ Use Case
- Use when multiple threads are updating a shared variable and atomic updates are required (e.g., counters, flags).

---

## 🆚 Key Differences

| Feature             | Volatile                  | Atomic                    |
|---------------------|---------------------------|----------------------------|
| Visibility          | ✅ Yes                    | ✅ Yes                     |
| Atomicity           | ❌ No                     | ✅ Yes                     |
| Use-case            | Signals, flags            | Counters, flags with updates |
| Performance         | ⚡ High (lightweight)     | ⚠️ Moderate (heavier)     |
| CAS operations      | ❌ No                     | ✅ Yes                     |

## 📝 Notes
- Use **`volatile`** when you just want to ensure that changes made to a variable are visible to other threads, and you don’t need compound actions.
- Use **Atomic classes** when you need **atomic** read-modify-write operations on a shared variable.

