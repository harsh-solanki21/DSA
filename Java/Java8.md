
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

### ✅ 3. Method References
- Short-hand for lambda expressions.
- Syntax: `ClassName::methodName`

```java
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(System.out::println); // Method reference
```

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

### ✅ 5. Streams API
- Process collections in a functional, declarative way.
- Supports operations like `map`, `filter`, `reduce`, etc.

```java
List<String> list = Arrays.asList("A", "B", "C", "D");
list.stream()
    .filter(s -> !s.equals("B"))
    .map(String::toLowerCase)
    .forEach(System.out::println);
```

### ✅ 6. Optional Class
- A container object which may or may not contain a non-null value.
- Avoids `NullPointerException`.

```java
Optional<String> name = Optional.of("Java");
name.ifPresent(System.out::println);
```

### ✅ 7. Date and Time API (`java.time`)
- New immutable classes: `LocalDate`, `LocalTime`, `LocalDateTime`, `ZonedDateTime`, `Period`, `Duration`, etc.

```java
LocalDate today = LocalDate.now();
LocalDate birthday = LocalDate.of(1999, Month.JULY, 29);
Period age = Period.between(birthday, today);
System.out.println("Age: " + age.getYears());
```

### ✅ 8. Collectors API
- Terminal operation to convert stream to list, set, map, etc.

```java
List<String> names = Arrays.asList("a", "bb", "ccc");
List<String> upper = names.stream()
    .map(String::toUpperCase)
    .collect(Collectors.toList());
```

### ✅ 9. Predicate, Function, Consumer, Supplier
- Functional interfaces in `java.util.function`

```java
Predicate<String> checkLength = str -> str.length() > 5;
Consumer<String> printer = System.out::println;
Function<String, Integer> toLength = String::length;
Supplier<Double> random = Math::random;
```

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
