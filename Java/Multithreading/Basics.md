
# 🚀 Java Multithreading Basics

Java multithreading allows concurrent execution of two or more parts of a program to maximize CPU utilization.

---

## 🧩 Process
- A **process** is an instance of a program being executed by the operating system.
- When a program runs, the OS creates a process to manage its execution.

---

## 🧵 Thread
- A **Thread** is the smallest unit of execution within a process.
- Multiple threads can exist within the same process, sharing resources but running independently.

> 🧠 **Example:** A browser like Chrome uses multiple threads for tabs — each tab may run in a separate thread.

---

## 🎯 Multitasking
- **Multitasking** allows the OS to run multiple **processes** simultaneously.
- On single-core CPUs: Time-sharing (context switching) is used.
- On multi-core CPUs: True parallelism is possible.

> 🖥️ **Example:** Browsing the web 🌐 while listening to music 🎵 and downloading a file 📥.

---

## 🧶 Multithreading
- **Multithreading** is the concurrent execution of multiple **threads** within a single process.
- Threads share the same memory and resources.

> 💡 **Example:** A browser might have threads for page rendering, JavaScript execution, and user input.

- Improves application performance and responsiveness.
- Makes better use of CPU capabilities.

---

## 🖥️ Single-Core vs Multi-Core Systems

### 🔸 Single-Core:
- OS and JVM use time-slicing to simulate concurrency.
- Threads **share the same core** — no real parallelism.

### 🔹 Multi-Core:
- JVM can distribute threads across multiple cores.
- Allows **true parallel execution**.

---

> ✅ Java supports multithreading through `java.lang.Thread` and `java.lang.Runnable`.

- The JVM starts with a **main thread** that runs the `main()` method.
- 🔍 Get current thread name using:
```java
System.out.println(Thread.currentThread().getName());
```

---

## 🔄 Lifecycle of a Thread

| State        | Description |
|--------------|-------------|
| 🆕 **New**       | Thread is created but not started. |
| 🏃 **Runnable**  | Thread is ready to run, waiting for CPU. |
| ⚙️ **Running**    | Thread is currently executing. |
| ⏸️ **Blocked/Waiting** | Thread is paused, waiting for resources or another thread. |
| 🛑 **Terminated** | Thread has completed execution. |

---

## 💻 Java Multithreading Code Examples

### 1️⃣ Extending the `Thread` class

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread using Thread class: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
```

### 2️⃣ Implementing the `Runnable` interface

```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread using Runnable interface: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
```

### ▶️ Main Class to Run Both Threads

```java
public class MultiThreadExample {
    public static void main(String[] args) throws InterruptedException {
        // Using Thread class
        MyThread t1 = new MyThread(); // NEW

        // Using Runnable interface
        MyRunnable myRunnable = new MyRunnable();
        Thread t2 = new Thread(myRunnable);

        t1.start(); // RUNNABLE
        t1.join();  // Waits for t1 to finish
        t2.start();
    }
}
```

---

## 📌 Summary

| Concept        | Description |
|----------------|-------------|
| 🧵 Thread      | Smallest unit of execution in a process |
| 🔁 Multithreading | Multiple threads in a single process |
| 🧠 Multitasking   | Multiple processes managed by OS |
| 🛠️ `Thread` / `Runnable` | Java classes to create threads |

Multithreading is a powerful feature for building high-performance and responsive applications in Java. ✅

---
