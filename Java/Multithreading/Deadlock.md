
# 🧨 Deadlock in Multithreading

A **deadlock** occurs when two or more threads are blocked forever, each waiting for the other to release a lock. It is a common issue in multithreaded applications.

---

## 🧠 What Causes Deadlock?

Deadlock typically happens when the following conditions are met:

1. **Mutual Exclusion** – A resource is held by only one thread at a time.
2. **Hold and Wait** – A thread holding a resource is waiting to acquire another resource.
3. **No Preemption** – A resource cannot be forcibly taken from a thread.
4. **Circular Wait** – Two or more threads form a circular chain where each thread waits for a resource held by the next.

---

## 🧪 Deadlock Example in Java

```java
public class DeadlockExample {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lockA) {
                System.out.println("Thread 1: Holding lockA...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lockB) {
                    System.out.println("Thread 1: Acquired lockB too!");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lockB) {
                System.out.println("Thread 2: Holding lockB...");
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (lockA) {
                    System.out.println("Thread 2: Acquired lockA too!");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

> ❗ This can cause a **deadlock** where Thread 1 waits for `lockB` and Thread 2 waits for `lockA`.

---

## 🛡️ How to Prevent Deadlock

### ✅ 1. Lock Ordering
Always acquire locks in a **consistent global order**.

```java
synchronized (lockA) {
    synchronized (lockB) {
        // safe operations
    }
}
```

### ✅ 2. Try-Lock with Timeout (`ReentrantLock`)
Use `tryLock()` to avoid waiting indefinitely.

```java
ReentrantLock lock1 = new ReentrantLock();
ReentrantLock lock2 = new ReentrantLock();

if (lock1.tryLock(1, TimeUnit.SECONDS)) {
    if (lock2.tryLock(1, TimeUnit.SECONDS)) {
        try {
            // critical section
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    } else {
        lock1.unlock();
    }
}
```

### ✅ 3. Avoid Nested Locks
Minimize situations where a thread holds one lock and attempts to acquire another.

### ✅ 4. Deadlock Detection
Use thread dumps or tools like `jconsole`, `VisualVM`, or log thread states for detection.

---

## 📋 Important Notes

- Deadlocks can be subtle and hard to reproduce.
- Always design your synchronization strategy with **lock acquisition order** in mind.
- Prefer high-level concurrency utilities (`java.util.concurrent`) when possible.

---

## 📌 Summary

| Cause                | Prevention Strategy                    |
|---------------------|-----------------------------------------|
| Circular wait        | Enforce lock ordering                   |
| Hold and wait        | Acquire all needed locks at once        |
| No preemption        | Use try-lock mechanisms                 |
| Nested locks         | Avoid or minimize them                  |
