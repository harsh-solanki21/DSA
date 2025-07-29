
# 🧵 Multithreading in Java Using Lambda Expressions

Java 8 introduced **lambda expressions**, which allow us to write cleaner and more concise code — especially useful in multithreading.

## 💡 Why Use Lambda in Multithreading?
- Reduces boilerplate code (no need to create separate classes).
- Improves readability.
- Great for short tasks or anonymous implementations of `Runnable`.

---

## 🧪 Example: Thread with Lambda Expression

```java
public class LambdaThreadExample {
    public static void main(String[] args) {

        // Thread using lambda for Runnable
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Running thread using lambda: " + i);
                try {
                    Thread.sleep(500); // sleep for 0.5 second
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        thread.start();
    }
}
```

---

## 📌 Points to Remember

- The lambda expression replaces the need for an anonymous inner class that implements `Runnable`.
- Lambda expressions are only possible with functional interfaces (interfaces with a single abstract method). `Runnable` is a functional interface with a single method `run()`.

---

## 🧠 Summary

| Feature                  | Traditional Runnable           | Lambda Runnable              |
|--------------------------|-------------------------------|------------------------------|
| Verbosity               | High                          | Low                          |
| Readability             | Lower                         | Higher                       |
| Boilerplate             | More                          | Less                         |
| Functional Style        | ❌                            | ✅                          |

---

> ✅ **Lambda expressions make multithreading in Java more concise and elegant, especially for short-lived tasks.**
