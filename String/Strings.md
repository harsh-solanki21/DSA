# Strings

## Two ways to initialize strings in Java:-

1. Initialization by literals <br />
   `String name = "Harsh";`


2. Initialization by object <br />
   `String name = new String("Harsh");`

## String Pool

- **Purpose:** It's used to store unique string literals and optimize memory usage.

- **How it works:**
    - When a string literal is created, Java first checks the string pool.
    - If an identical string exists, Java returns a reference to that string.
    - If not, a new string is created and added to the pool.

- **Memory efficiency:** This mechanism allows multiple references to point to a single string object, saving memory.

- **Immutability:** Strings in the pool are immutable, ensuring thread safety and consistency.

- **Comparison:**
    - `==` compares references, often true for pooled strings.
    - `equals()` compares content, always reliable for string comparison.

- **Performance:** Can improve performance in scenarios with many duplicate strings.

- **Garbage collection:** Pooled strings can be garbage collected if no longer referenced.

## Heap area

- String initialization by object will initialize string in the Heap area because this string will be treated as an
  object and objects are always gets stored in heap memory.
- If we create multiple strings with the same values then multiple objects will be created for the same string value. It
  won't reassign.

## Immutable strings:

- Strings are immutable in Java.
- We can make mutable string by using StringBuffer and StringBuilder.

#### Difference between StringBuilder and StringBuffer

| String Builder                                                                                                                     | String Buffer                                                                                                              
------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------
| StringBuilder is non-synchronized i.e. not thread safe. It means two threads can call the methods of StringBuilder simultaneously. | StringBuffer is synchronized i.e. thread safe. It means two threads can't call the methods of StringBuffer simultaneously. 
| StringBuilder is more efficient than StringBuffer.                                                                                 | StringBuffer is less efficient than StringBuilder.                                                                         



#### EXAMPLE:

- String created using **String literal**
```java
String s1 = "TAT";
String s2 = "TAT";
```
s1 and s2 will point to the same memory. There will be only one TAT created in the string pool which will be reassigned to s2.


- String created using **Object**
```java
String s3 = new String("TAT");
String s4 = new String("TAT");
```

Two different TAT will be created for s3 and s4 in the heap memory because it is an object.


## String Functions:
```java
String name = "Harsh Solanki";  // by literal
String name2 = new String("Harsh Solanki");  // by object

name.equals(name2); // true (check by values)
return name == name2 // false (check by reference)
// because name is initialized in string pool and name2 initialized in heap

name.charAt(1); // a
name.length(); // 13
name.substring(4); // h Solanki
name.substring(4, 8); // h So
name.contains("Harsh"); // true
name.contains("Dhruv"); // false
name.isEmpty();
name.replace('H', 'A'); // Aarsh Solanki
name.indexOf('r'); // 2
name.toLowerCase();
name.toUpperCase();
name.trim();
```

## String Comparison:
- The String `compareTo()` method compares values `lexicographically` and returns an integer value that describes if first string is less than, equal to or greater than second string.
```java
String s1 = "Sachin";  
String s2 = "Sachin";  
String s3 = "Ratan";  
System.out.println(s1.compareTo(s2)); // 0  
System.out.println(s1.compareTo(s3)); // 1 (because s1 > s3)  
System.out.println(s3.compareTo(s1)); // -1 (because s3 < s1 )
```

## String Builder Functions:
```java
StringBuilder sb = new StringBuilder("hello");

sb.charAt(0); // h
sb.setCharAt(0, 's'); // sello
sb.insert(2, 'y'); // seyllo
sb.deleteCharAt(2); // sello
sb.append('g'); // sellog
sb.length(); // 6
```
