# Math

- To calculate the sum of n natural numbers: <br />
  `n (n + 1) / 2`


- Number of sub arrays of an array with n elements: <br />
  `nC2 + n = n (n + 1) / 2`


- Number of subsequences of an array with n elements: <br />
  `2^n`


- Number of all possible subsets of a set: <br />
  `2^n - 1`


- Every sub array is a subsequence but every subsequence is not a sub array.


- To find nth term in Arithmetic Progression: <br />
  `a + (n - 1) * d`


- To find nth term in Geometric Progression: <br />
  `a * r ^ (n - 1)`


- To find no. of digits of a number: <br />
  `(int)(Math.log10(n)) + 1`

## GCD (HCF)

### Traditional Method

To find the GCD of 24 and 42:

- 24 = 2^3 * 3
- 42 = 2 * 3 * 7

  Common prime factors are 2 and 3 (take the lowest power of common factors) <br />
  So, the GCD is 2 * 3 = 6

### Subtraction Method

42 - 24 = 18 <br />
24 - 18 = 6 <br />
18 - 6 = 12 <br />
12 - 6 = 6 <br />
6 - 6 = 0 <br />

The last number before we got 0 is 6. So, GCD = 6

### Euclid's Algorithm

42 % 24 = 18 <br />
24 % 18 = 6 <br />
18 % 6 = 0 <br />

The last number before we got 0 is 6. So, GCD = 6

- In the last two methods, we are making numbers smaller to find GCD because it's easier to find the GCD of smaller
  numbers.

- Time Complexity: O(log(min(a, b)))

## LCM

### Traditional Method

To find the LCM of 12 and 18:

- 12 = 2^2 * 3
- 18 = 2 * 3^2

  Common prime factors are 2^2 and 3^2 (take the highest power of common factors)
  So, the LCM is 2^2 * 3^2 = 36

### Relation between GCD and LCM

**Formula:** (a * b) / GCD = LCM

## Additional Concepts

### Finding Minimum Fraction

12 / 18 = 6 / 9 = 2 / 3

`a / b => (a / gcd(a,b)) / (b / gcd(a,b))`


> How many numbers should be added in "a" to make it a divisible by "b"
>
> ```java
> int count = a % b;
> return b -count;
> ```
