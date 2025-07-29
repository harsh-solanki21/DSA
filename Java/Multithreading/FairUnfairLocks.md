
# ⚖️ Fair vs Unfair Locks

Java's `ReentrantLock` allows configuring lock **fairness policy**, which determines the **order in which threads acquire the lock**.

---

## 🧠 What is Lock Fairness?

Fairness refers to the **ordering policy** of thread access to the lock:

- **Fair Lock**: Threads acquire the lock **in the order they requested it** (FIFO).
- **Unfair Lock**: Threads may **"jump the queue"** and acquire the lock even if other threads have been waiting longer.

---

## 🔐 Creating Fair and Unfair Locks

### 🔸 Fair Lock:
```java
ReentrantLock fairLock = new ReentrantLock(true); // true = fair policy
```

### 🔸 Unfair Lock (Default):
```java
ReentrantLock unfairLock = new ReentrantLock(); // false = unfair (default)
```

---

## 📋 Key Differences

| Feature             | Fair Lock                          | Unfair Lock                         |
|---------------------|-------------------------------------|-------------------------------------|
| Order               | FIFO                                | May allow barging                   |
| Starvation          | Less likely                         | More likely                         |
| Throughput          | Lower (due to context switching)    | Higher (due to aggressive locking)  |
| CPU Efficiency      | Less                                 | Better under high contention        |
| Use Case            | Predictable response time           | Maximize performance                |

---

## 🧪 Example

```java
import java.util.concurrent.locks.ReentrantLock;

public class FairUnfairExample {
    private final ReentrantLock lock;

    public FairUnfairExample(boolean isFair) {
        this.lock = new ReentrantLock(isFair);
    }

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairUnfairExample example = new FairUnfairExample(true); // Try false for unfair

        for (int i = 0; i < 5; i++) {
            new Thread(example::accessResource, "Thread-" + i).start();
        }
    }
}
```

---

## 📝 Important Notes

- Fair locks reduce thread starvation, making them useful in real-time and fairness-critical applications.
- Unfair locks are better for performance in most general-purpose apps.
- Fair locks might lead to **reduced throughput** due to frequent context switching.
- Always release the lock in a `finally` block.

---

## ✅ Summary

- Use **fair locks** when **predictable access** is needed.
- Use **unfair locks** when **throughput and performance** are more important than access order.

---
