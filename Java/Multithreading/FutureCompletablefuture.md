
# 🚀 Future & CompletableFuture

Java provides powerful tools for asynchronous programming using `Future` and `CompletableFuture`. These are widely used in multi-threading for non-blocking tasks, improving performance and responsiveness.

---

## 📌 Future Interface

- Introduced in Java 5 as part of `java.util.concurrent` package.
- Represents the result of an asynchronous computation.
- Used with `ExecutorService` to submit tasks.

### ✅ Methods in Future:
| Method | Description |
|--------|-------------|
| `get()` | Waits for the computation to complete, then returns the result. |
| `get(long timeout, TimeUnit unit)` | Waits for the specified time. |
| `cancel(boolean mayInterruptIfRunning)` | Attempts to cancel execution. |
| `isDone()` | Returns true if task is completed. |
| `isCancelled()` | Returns true if task was cancelled. |

### 🔧 Example:
```java
ExecutorService executor = Executors.newSingleThreadExecutor();
Future<Integer> future = executor.submit(() -> {
    Thread.sleep(1000);
    return 42;
});

Integer result = future.get(); // Blocks until result is available
```

---

## ⚡ CompletableFuture (Java 8+)

- Asynchronous & non-blocking future.
- Allows chaining multiple async operations.
- Part of `java.util.concurrent` package.

### ✅ Key Features:
- Non-blocking API.
- Method chaining via `thenApply`, `thenAccept`, `thenRun`, etc.
- Exception handling with `exceptionally`, `handle`.
- Combining multiple futures (`allOf`, `anyOf`).

### 🧩 Common Methods:
| Method | Purpose |
|--------|---------|
| `supplyAsync(Supplier)` | Executes a task asynchronously that returns a result. |
| `runAsync(Runnable)` | Executes a task asynchronously without returning a result. |
| `thenApply(fn)` | Processes and transforms the result. |
| `thenAccept(Consumer)` | Consumes the result (no return). |
| `thenRun(Runnable)` | Runs a task after completion (no result). |
| `exceptionally(fn)` | Handles exceptions in async pipeline. |
| `handle((result, ex) -> {})` | Handles both result and exception. |

### 🔧 Example:
```java
CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
    return 10;
}).thenApply(result -> result * 2);

System.out.println(future.get()); // Output: 20
```

---

## 🧠 Combining Multiple CompletableFutures

### ✅ allOf
Waits for all tasks to complete.
```java
CompletableFuture<Void> combined = CompletableFuture.allOf(f1, f2, f3);
combined.join();
```

### ✅ anyOf
Returns the result of whichever task completes first.
```java
CompletableFuture<Object> winner = CompletableFuture.anyOf(f1, f2, f3);
```

---

## ⚠️ Differences: Future vs CompletableFuture

| Feature | Future | CompletableFuture |
|--------|--------|-------------------|
| Introduced In | Java 5 | Java 8 |
| Non-blocking | ❌ | ✅ |
| Manual Completion | ❌ | ✅ |
| Chaining Support | ❌ | ✅ |
| Exception Handling | ❌ | ✅ |
| Combining Tasks | ❌ | ✅ |

---

## 🛡️ Exception Handling

```java
CompletableFuture.supplyAsync(() -> {
    if (true) throw new RuntimeException("Oops!");
    return 1;
}).exceptionally(ex -> {
    System.out.println("Error: " + ex.getMessage());
    return 0;
});
```

---

## 🧵 Thread Pool with CompletableFuture

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
    // your task
}, executor);
```

---

## ✅ Use Cases

- Web service calls.
- Parallel computations.
- Asynchronous workflows.
- Improve UI responsiveness in desktop apps.

---

## 🎯 Summary

- Use `Future` for simple async tasks.
- Use `CompletableFuture` for complex pipelines and non-blocking execution.
- Always manage your thread pools to avoid resource leaks.
