## Convert n to n - 1

- We can convert n to n-1 using bits of n, <br />
  Take the rightmost set bit and flip it, then flip all the bits to the right of that bit.
- n = 6 = 0110 => n-1 = 5 = 0101
- n = 8 = 1000 => n-1 = 7 = 0111

<br />

## n & n - 1

- (n & n-1) has same bits as n except the rightmost set bit. <br />
    - 0110 & 0101 = 0100
    - 1000 & 0111 = 0000


- **Find number of 1s in binary representation of a number**

```java
int numberOfOnes(int n) {
    int count = 0;
    while (n != 0) {
        n = n & (n - 1);
        count++;
    }
    return count;
}
```

- **Check if a number is power of 2**
  `return (n && !(n & n-1));`

- **to find number of bits in binary representation of a number**
  `(logn base2) + 1`

- **to find number of digits in decimal representation**
  `(logn base10) + 1`

- **We can generate all the possible subset of a set.**

<br />

## XOR Properties

1. n ^ n = 0
2. 0 ^ n = n

- We can find the unique number when all the numbers in the array are occurring twice except one.


- LSB (Least Significant Bit) tells us whether the number is even or odd.


- MSB (Most Significant Bit) tells us whether the number is positive(0) or negative(1).
