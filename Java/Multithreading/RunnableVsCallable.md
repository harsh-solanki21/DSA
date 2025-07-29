
# 🧵 Runnable vs Callable

In Java, both `Runnable` and `Callable` are used to represent tasks that can be executed by multiple threads. However, they have key differences.

---

## 🔁 Runnable Interface

- Introduced in **Java 1.0**.
- Doesn't return any result.
- Cannot throw checked exceptions.

### Syntax

```java
@FunctionalInterface
public interface Runnable {
    void run();
}
```

### Example

```java
public class RunnableExample {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Runnable is running...");
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}
```

---

## 📞 Callable Interface

- Introduced in **Java 5** as part of `java.util.concurrent`.
- Returns a result (`V` is a generic type).
- Can throw checked exceptions.

### Syntax

```java
@FunctionalInterface
public interface Callable<V> {
    V call() throws Exception;
}
```

### Example

```java
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws Exception {
        Callable<String> task = () -> {
            return "Callable result";
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(task);

        String result = future.get(); // waits if necessary for the computation to complete
        System.out.println(result);

        executor.shutdown();
    }
}
```

---

## 🆚 Key Differences

| Feature        | Runnable           | Callable            |
|----------------|--------------------|---------------------|
| Return value   | ❌ No               | ✅ Yes (`V`)         |
| Exceptions     | ❌ Cannot throw     | ✅ Can throw checked |
| Lambda support | ✅ Yes              | ✅ Yes               |
| Used with      | Thread              | ExecutorService      |

---

## 📘 When to Use

- Use `Runnable` when you do **not** need to return a result or throw a checked exception.
- Use `Callable` when you need to **return a result** or **handle exceptions**.

---

> ✅ Callable is especially useful with `ExecutorService`, `Future`, and complex concurrent workflows.
