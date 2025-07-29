
# 📖 Read-Write Lock in Java Multithreading

Java provides a `ReadWriteLock` interface that improves concurrency in applications with **frequent reads and infrequent writes**.

---

## 🧠 What is a ReadWriteLock?

- A `ReadWriteLock` allows multiple threads to **read** a shared resource **concurrently**, but only one thread to **write** at a time.
- While writing, **no other read or write** thread is allowed.

---

## 🔐 Implementation: `ReentrantReadWriteLock`

Java provides the `ReentrantReadWriteLock` class which implements `ReadWriteLock`.

```java
ReadWriteLock lock = new ReentrantReadWriteLock();
Lock readLock = lock.readLock();
Lock writeLock = lock.writeLock();
```

---

## 🧪 Example: Shared Resource Access

```java
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DataStore {
    private int data = 0;
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final ReentrantReadWriteLock.ReadLock readLock = rwLock.readLock();
    private final ReentrantReadWriteLock.WriteLock writeLock = rwLock.writeLock();

    public void write(int value) {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writing " + value);
            data = value;
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    public int read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reading " + data);
            Thread.sleep(100);
            return data;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        } finally {
            readLock.unlock();
        }
    }
}
```

---

## 📋 Key Features

| Feature               | Description                                        |
|------------------------|----------------------------------------------------|
| ✅ Multiple Readers     | Allowed if no writer holds the lock               |
| 🚫 Writer Exclusive     | Only one writer allowed, blocks all readers/writers |
| 🔁 Reentrancy           | Same thread can re-acquire read or write lock     |
| 🚦 Lock Downgrading     | Allowed (write → read), not vice versa            |

---

## ⚠️ Lock Downgrading

```java
writeLock.lock();
try {
    // Modify shared data
    readLock.lock(); // Downgrading from write to read is allowed
    try {
        // Read after write safely
    } finally {
        readLock.unlock();
    }
} finally {
    writeLock.unlock();
}
```

> 🔴 **Lock upgrading (read → write)** is not allowed and can lead to deadlocks.

---

## ✅ When to Use

- High read-to-write ratio
- Cache systems, configuration stores, databases
- Optimizing read-heavy workloads

---

## 📝 Important Notes

- Never hold read lock and attempt to acquire write lock — risk of **deadlock**.
- `ReentrantReadWriteLock` supports **fair and unfair** modes (`new ReentrantReadWriteLock(true)`).
- Always release locks in `finally` blocks.

---

## 📌 Summary

| Operation     | Allowed Concurrently | Blocked By         |
|---------------|-----------------------|--------------------|
| Read          | Other Readers         | Active Writer      |
| Write         | No one                | Any Active Reader or Writer |

---
