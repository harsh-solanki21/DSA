
# 🔐 Locks in Java Multithreading

Java provides different mechanisms for handling **thread synchronization** to ensure data consistency and avoid race conditions.

---

## 🧠 Why Locks?

- Prevent concurrent threads from corrupting shared data.
- Used when finer-grained control than `synchronized` is required.
- Java provides **explicit locking** via `java.util.concurrent.locks` package.

---

## 🚀 Types of Locks in Java

### 1. **Intrinsic Locks (or Monitor Locks)**
- Acquired implicitly using `synchronized` keyword.
- Every object in Java has a monitor associated with it.

#### 🧾 Example:
```java
public class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }
}
```

#### 🧵 Limitations of Intrinsic Lock
- A thread blocked on a synchronized lock cannot be interrupted.
- You can't set a timeout while trying to acquire a lock.
- You can't check if a thread holds a lock or how many holds it has.

---

### 2. **Explicit Locks (`ReentrantLock`)**
- Provided by `java.util.concurrent.locks.ReentrantLock`.
- Requires explicit acquisition and release (`lock()` / `unlock()`).

#### ✅ Key Features:
- Try-locking (`tryLock()`)
- Fairness policies
- Interruptible locking

#### 🧾 Example:
```java
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }
}
```

---

## 📝 Important Notes

- 🔁 **ReentrantLock** allows the same thread to acquire the lock multiple times.
- 🕗 Always use `try-finally` to release locks to prevent deadlocks.
- 🚫 Avoid using `synchronized` and `Lock` on the same data — leads to confusion.
- 🧪 Use `tryLock()` to avoid blocking forever.
- ⚠️ Improper locking may lead to:
  - Deadlocks
  - Starvation
  - Livelocks

---

## 📌 Conclusion

- Use `Locks` when you need flexibility and better performance in multi-threaded environments. 

- For simpler needs, `synchronized` blocks are sufficient. Always ensure correct acquisition and release of locks.
