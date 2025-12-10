
# ☕ Java 8 - Essential Concepts

Java 8 introduced powerful new features for **functional programming**, **stream processing**, **datetime API**, and more.
These changes made Java more concise, readable, and expressive.

---

## 🧠 Key Java 8 Concepts

### ✅ 1. Lambda Expressions
- Enable functional-style code using anonymous functions.
- Syntax: `(parameters) -> expression`

```java
List<String> names = Arrays.asList("Harsh", "Nisarg", "Rohan");
names.forEach(name -> System.out.println(name));
```

<br />

### ✅ 2. Functional Interfaces
- An interface with a **single abstract method**.
- Annotated with `@FunctionalInterface`.
- Examples: `Runnable`, `Callable`, `Comparator`, `Predicate`.

```java
@FunctionalInterface
interface MyFunc {
    void run();
}
```

<br />

### ✅ 3. Method References
- Short-hand for lambda expressions.
- Syntax: `ClassName::methodName`

```java
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(System.out::println); // Method reference
```

<br />

### ✅ 4. Default & Static Methods in Interface
- Java 8 allows default implementations.

```java
interface MyInterface {
    default void show() {
        System.out.println("Default method");
    }
    static void log() {
        System.out.println("Static method");
    }
}
```

<br />

### ✅ 5. Streams API
- Process collections in a functional, declarative way.
- Supports operations like `map`, `filter`, `reduce`, etc.

```java
// Intermediate operations transform a stream into another stream.
// They are lazy, meaning they don;t execute until a terminal operations is invoked.

// Filter
List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
nums.stream().forEach(x -> System.out.println(x));
System.out.println(nums.stream().filter(x -> x % 2 == 0).count());

// Map
List<String> list = Arrays.asList("Akshit", "Ram", "Shyam", "Ramesh");
Stream<String> stringStream = list.stream().map(String::toUpperCase);
System.out.println(stringStream.toList());

// Sorted
Stream<String> sortedStream = list.stream().sorted();
System.out.println(sortedStream.toList());

// Distinct
System.out.println(list.stream().filter(x -> x.startsWith("A")).distinct().count());

// Limit
System.out.println(Stream.iterate(1, x -> x + 1).limit(100).count());

// Skip
System.out.println(Stream.iterate(1, x -> x + 1).skip(10).limit(100).count());

// Filtering anf Collecting
System.out.println(list.stream().filter(x -> x.length() > 3).toList());

System.out.println(nums.stream().map(x -> x * x).sorted().toList());

System.out.println(nums.stream().reduce(Integer::sum));

// Counting occurrences of a character
String str = "Hello world";
System.out.println(str.chars().filter(x -> x == 'l').count());

// Stateful & Stateless operations
// Stateful: Map (It takes one element at a time, doesn't know about others)
// Stateless: Sorted, Distinct (Need to know about all the elements to sort or to find distinct)

List<String> list = Arrays.asList("A", "B", "C", "D");
list.stream()
    .filter(s -> !s.equals("B"))
    .map(String::toLowerCase)
    .forEach(System.out::println);
```

### Parallel Streams

```java
public static void main(String[] args) {

    // Parallel Stream
    // A type of stream that enables parallel processing of elements
    // Allowing multiple threads to process parts of the stream simultaneously
    // This can significantly improve performance for large data set
    // Workload is distributed across multiple threads

    long startTime = System.currentTimeMillis();
    List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
    List<Long> factorialList = list.stream().map(Main::factorial).toList();
    long endTime = System.currentTimeMillis();
    System.out.println("Time taken with sequential stream: " + (endTime - startTime) + "ms");

    startTime = System.currentTimeMillis();
    factorialList = list.parallelStream().map(Main::factorial).toList();
//        factorialList = list.parallelStream().map(Main::factorial).sequential().toList();
    endTime = System.currentTimeMillis();
    System.out.println("Time taken with parallel stream: " + (endTime - startTime) + "ms");

    // Parallel streams are most effective for CPU-intensive or large dataset where tasks are independent
    // They may add overhead for simple tasks or small datasets

}

private static long factorial(int n) {
    long result = 1;
    for (int i = 2; i <= n; i++) {
        result *= i;
    }
    return result;
}
```

<br />

### ✅ 6. Optional Class
- A container object which may or may not contain a non-null value.
- Avoids `NullPointerException`.

```java
Optional<String> name = Optional.of("Java");
name.ifPresent(System.out::println);
```

<br />

### ✅ 7. Date and Time API (`java.time`)
- New immutable classes: `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `Period`, `Duration`, etc.

```java
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1999, Month.JULY, 29);
Period age = Period.between(birthday, today);
System.out.println("Age: " + age.getYears());
```

<br />

### ✅ 8. Collectors API
- Terminal operation to convert stream to list, set, map, etc.

```java
List<String> names = Arrays.asList("a", "bb", "ccc");
List<String> upper = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

<br />

### ✅ 9. Predicate, Function, Consumer, Supplier
- Functional interfaces in `java.util.function`

```java
Predicate<String> checkLength = str -> str.length() > 5;
Consumer<String> printer = System.out::println;
Function<String, Integer> toLength = String::length;
Supplier<Double> random = Math::random;
```

<br />

### ✅ 10. Nashorn JavaScript Engine
- Allows executing JS code inside Java.

```java
ScriptEngineManager manager = new ScriptEngineManager();
ScriptEngine engine = manager.getEngineByName("nashorn");
engine.eval("print('Hello from JS!')");
```

---

## 🧠 Summary Table

| Feature                | Purpose                                      |
|------------------------|----------------------------------------------|
| Lambda Expressions     | Anonymous functions                         |
| Functional Interface   | Interface with one abstract method          |
| Method Reference       | Short-hand for lambdas                      |
| Default/Static Methods | Extend interface capabilities               |
| Stream API             | Functional-style operations on collections  |
| Optional               | Null-safe container                         |
| Date-Time API          | Modern date/time handling                   |
| Collectors             | Convert streams to collections              |
| Predicate/Function/etc.| Built-in functional interfaces              |
| Nashorn                | JS engine within Java                       |

---

## 🎯 Use Cases in Interviews
- Explain how you improved code using streams or lambdas.
- Null safety: Use of `Optional` over null checks.
- Functional vs imperative code comparison.
- Parallel stream vs sequential stream.
- How default methods improve interface evolution.
