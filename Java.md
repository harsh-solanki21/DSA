# Final

### 1. final variables

- If a variable is declared with the final keyword, its value cannot be changed once initialized.

### 2. final parameters

- If you ever see the final keyword with a parameter variable, it means that the value of this variable cannot be
  changed anywhere in the function.


- Example:

```java
class finalParameter {
    public static void example(final int parameter) {
        parameter = 4;  // compilation error
    }
}
```

### 3. final methods

- A method declared with the final keyword, cannot be overridden or hidden by subclasses.


- Example:

```java
class Base {
    public final void finalMethod() {
        System.out.print("Base");
    }
}

class Derived extends Base {
    public final void finalMethod() { // Overriding the final method throws an error
        System.out.print("Derived");
    }
}
```

### 4. final classes

- A class declared as a final class, cannot be subclassed.


- Example:

```java
// declaring a final class
final class FinalClass {
//...
}

class Subclass extends FinalClass { //attempting to subclass a final class throws an error
//...
}
```

# TLE (Time Limit Exceeded)

***10^8 operations*** <br />
Most of the modern machines and online judges can perform `10^8 operations/sec`

 Input Size (n) | Time Complexity 
----------------|-----------------
| 10..11         | O(n!), O(n^6)   
| 15..18         | O(2^n * n^2)    
| 100            | O(n^4)          
| 400            | O(n^3)          
| 2000           | O(n^2 * logn)   
| 10^4           | O(n^2)          
| 10^6           | O(n logn)       
| 10^8           | O(n)            

<br />

## Time Complexity

- Time complexity is a measure of how the runtime of an algorithm grows with respect to the input size.


- Common complexities (from fastest to slowest):
    - O(1): Constant time
    - O(log n): Logarithmic time
    - O(n): Linear time
    - O(n log n): Linearithmic time
    - O(n^2), O(n^3): Polynomial time
    - O(2^n): Exponential time
    - O(n!): Factorial time


- **O(Log n)** <br />
  Time Complexity of a loop is considered as O(Log n) if the loop variables is divided / multiplied by a constant
  amount.


- **O(Log Log n)** <br />
  Time Complexity of a loop is considered as O(Log Log n) if the loop variables is reduced / increased exponentially by
  a constant amount.

## Space Complexity

- Auxiliary Space is the extra space or temporary space used by an algorithm.

- Space Complexity of an algorithm is total space taken by the algorithm with respect to the input size. Space
  complexity includes both Auxiliary space and space used by input.
