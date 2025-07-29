
# ⚙️ Executors Framework

The **Executors Framework** in Java provides a high-level API for managing threads. It decouples task submission from the mechanics of how each task will be run, including thread use, scheduling, etc.

## ✅ Why Executors?

- Simplifies thread management.
- Improves performance by reusing existing threads.
- Allows control over thread pool size and behavior.
- Provides various executor implementations for different use cases.

---

## 🧵 Types of Executors

### 1. `Executor` Interface
- Base interface for executing `Runnable` tasks.

```java
Executor executor = command -> new Thread(command).start();
executor.execute(() -> System.out.println("Task executed!"));
```

---

### 2. `ExecutorService` Interface
- Provides methods for managing and controlling task execution.

```java
ExecutorService service = Executors.newFixedThreadPool(2);
service.execute(() -> System.out.println("Task 1"));
service.shutdown();
```

---

### 3. `ScheduledExecutorService`
- Supports delayed and periodic task execution.

```java
ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
scheduler.schedule(() -> System.out.println("Delayed task"), 3, TimeUnit.SECONDS);
scheduler.shutdown();
```

---

## 🧰 Common Factory Methods (from `Executors` class)

| Method | Description |
|--------|-------------|
| `newSingleThreadExecutor()` | A single worker thread. |
| `newFixedThreadPool(int n)` | Fixed number of threads. |
| `newCachedThreadPool()` | Creates new threads as needed and reuses old ones. |
| `newScheduledThreadPool(int corePoolSize)` | Allows scheduling of tasks. |

---

## 🛑 Shutdown Executors

```java
service.shutdown(); // Waits for tasks to complete
service.shutdownNow(); // Attempts to stop all executing tasks
```

---

## 📝 Example with `Callable` and `Future`

```java
ExecutorService executor = Executors.newSingleThreadExecutor();
Callable<String> task = () -> {
    Thread.sleep(1000);
    return "Task completed";
};

Future<String> future = executor.submit(task);
System.out.println(future.get()); // Output after 1 second
executor.shutdown();
```

---

## ⚠️ Best Practices

- Always shutdown executors to free resources.
- Use `ThreadPoolExecutor` directly for more control.
- Avoid creating too many threads—can lead to resource exhaustion.
- Prefer `Executors.newFixedThreadPool()` or `newCachedThreadPool()` over manual thread creation.

---

## 📌 Summary

- The Executors Framework provides a robust way to manage thread execution.
- Improves efficiency and system stability.
- Greatly reduces boilerplate code needed to manage threads.
