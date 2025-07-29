# 🧵 `wait()`, `notify()`, and `notifyAll()`

In Java multithreading, `wait()`, `notify()`, and `notifyAll()` are methods provided by the `Object` class to facilitate **inter-thread communication**, allowing threads to communicate about the availability of resources or the change in state.

---

## 📌 `wait()`

- Causes the **current thread** to wait until another thread invokes `notify()` or `notifyAll()` on the same object.
- Releases the lock on the object.
- Must be called within a **synchronized block** or method.

```java
synchronized(obj) {
    obj.wait();
}
```

---

## 📌 `notify()`

- Wakes up a **single thread** that is waiting on the object's monitor.
- The thread will not proceed until the current thread releases the lock.

```java
synchronized(obj) {
    obj.notify();
}
```

---

## 📌 `notifyAll()`

- Wakes up **all threads** that are waiting on the object's monitor.
- Only one of the threads will acquire the lock and continue execution.

```java
synchronized(obj) {
    obj.notifyAll();
}
```

---

## 🚨 Important Notes

- These methods must be used within a **synchronized context**, otherwise they throw `IllegalMonitorStateException`.
- `wait()` causes the thread to release the lock and go into a waiting state.
- `notify()` and `notifyAll()` do **not release the lock immediately**; the lock is released only after the synchronized block completes.
- These are low-level methods. For higher-level control, Java provides constructs like `Lock`, `Condition`, `Semaphore`, etc.

---

## ✅ Example: Producer-Consumer using `wait()` and `notify()`

```java
class SharedBuffer {
    private int data;
    private boolean hasData = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (hasData) {
            wait();
        }
        data = value;
        hasData = true;
        System.out.println("Produced: " + value);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!hasData) {
            wait();
        }
        System.out.println("Consumed: " + data);
        hasData = false;
        notify();
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {}
        });

        producer.start();
        consumer.start();
    }
}
```

---

## 📘 Summary Table

| Method       | Purpose                                 | Lock Required? | Releases Lock? |
|--------------|------------------------------------------|----------------|----------------|
| `wait()`     | Pauses thread until notified             | ✅ Yes         | ✅ Yes         |
| `notify()`   | Wakes one waiting thread                 | ✅ Yes         | ❌ No          |
| `notifyAll()`| Wakes all waiting threads                | ✅ Yes         | ❌ No          |

---

