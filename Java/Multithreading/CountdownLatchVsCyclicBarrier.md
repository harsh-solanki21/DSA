
# CountdownLatch vs CyclicBarrier

Java provides `CountDownLatch` and `CyclicBarrier` classes in `java.util.concurrent` package for thread synchronization.

## 📌 CountDownLatch

### ✅ What is it?
- A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

### ✅ How it works?
- Initialize with a **count**.
- Threads call `countDown()` to decrement the count.
- One or more threads call `await()` to wait until the count reaches zero.

### ✅ Use Case
- Useful when a main thread needs to wait for other threads to complete execution before continuing.

### ✅ Example
```java
CountDownLatch latch = new CountDownLatch(3);

Runnable worker = () -> {
    // Do some work
    latch.countDown();
};

for (int i = 0; i < 3; i++) {
    new Thread(worker).start();
}

latch.await(); // Main thread waits until count reaches 0
```

---

## 🔁 CyclicBarrier

### ✅ What is it?
- A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.

### ✅ How it works?
- Initialize with a **number of threads** (parties).
- Each thread calls `await()`.
- Once all threads reach the barrier, they are released and optionally run a barrier action.

### ✅ Use Case
- Useful for repeated synchronization points, like multiple threads performing phases of a computation in sync.

### ✅ Example
```java
CyclicBarrier barrier = new CyclicBarrier(3, () -> {
    System.out.println("All threads reached the barrier. Proceeding...");
});

Runnable task = () -> {
    // Phase 1 work
    barrier.await(); // Wait for others
    // Phase 2 work
};

for (int i = 0; i < 3; i++) {
    new Thread(task).start();
}
```

---

## 🆚 Key Differences

| Feature             | CountDownLatch             | CyclicBarrier             |
|---------------------|----------------------------|----------------------------|
| Reusable            | ❌ No                      | ✅ Yes                     |
| Wait for others     | ✅ Yes (from main thread)  | ✅ Yes (from all threads)  |
| Barrier action      | ❌ No                      | ✅ Yes                     |
| Usage Scenario      | Wait for tasks to complete | Coordinate multiple phases |

## 📝 Notes
- Use **CountDownLatch** when the number of threads is fixed and you only need one-time synchronization.
- Use **CyclicBarrier** when you need multiple threads to wait at a common point repeatedly (e.g., for multiple computation phases).

