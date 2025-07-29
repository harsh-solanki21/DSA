# Mutual Exclusion and Synchronization

## 🔒 Mutual Exclusion
- Ensures that **only one thread** can access the critical section at a time.
- Prevents **race conditions** and ensures **thread safety** when accessing shared resources.

---

## 🔄 Synchronization in Java

### 1. `synchronized` Keyword

#### ✅ Synchronized Method

```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++; // Thread-safe
    }

    public int getCount() {
        return count;
    }
}
```

#### ✅ Synchronized Block

```java
public class Counter {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}
```

- Use when only part of the method needs synchronization.
- Better performance than synchronizing the whole method.

<br />

### 2. `volatile` Keyword
```java
volatile boolean running = true;
```

- Guarantees visibility of changes to variables across threads.
- Does not provide mutual exclusion or atomicity.
- Useful for flags and single-read/write scenarios.