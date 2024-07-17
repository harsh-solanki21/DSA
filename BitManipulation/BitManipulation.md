## ADD

Just simply perform standard addition

```
  101
+ 111
-------
 1100
```

## SUBTRACT

Perform 2's compliment (Invert all bits and then add one)

For Example, <br />
If we want to perform 12 - 5 (12 + (-5)) <br />
Then first perform 2's compliment of 5 and then add it to 12

```
  1100  (12)
+ 1011  (2's compliment of 5)   (101 -> 010 + 1 = 011)
--------
  0111  (7)
```

I've put 1 in front of 011 because there will be 32 or 64 bits, and they will become 1 when we invert all the bits to
perform 2's compliment.
<br />
So internally we are doing addition. There is no such thing called subtraction (in computer).

## BITWISE OPERATORS

| and | or | xor | inverse | right shift | left shift |
|-----|----|-----|---------|-------------|------------|
| &   | \| | ^   | ~       | \>>         | <<         |

<br />

- Inverse operator will inverse all the bits. Basically, it will perform 1's compliment. <br />
  12 >> 2  (It will right shift 12, 2 times) <br />
  1100 >> 2 &nbsp;&nbsp;=>&nbsp;&nbsp; 0011 (12 becomes 3)


- When you right shift a number by 1 (5 >> 1), the number will be divided by 2. <br />
  n << 1 = 2n  <br />
  a << b = a*2^b


- When you left shift a number by 1 (3 <<1 ), the number will be multiplied by 2. <br />
  n >> 1 = n/2 <br />
  a >> b = a/2^b

<br />

### Odd - Even numbers

* When you perform & operation with 1, and it returns output 1 (a&1 == 1), then that number is odd.
* When you perform & operation with 1, and it returns output 0 (a&1 == 0), then that number is even.

- All the even numbers have their last bit 0.
- All the odd numbers have their last bit 1.

<br />

### Swap two numbers

```java
int a = 5, b = 7;
a =a ^b;  // 2
b =a ^b;  // 5
a =a ^b;  // 7
// output : a = 7, b = 5
```

<br />

> To convert the int to binary string: <br />
> ```Integer.toBinaryString(n);```

> To find whether the number is power of 2: <br />
> ```return (n & (n - 1)) == 0;```

> 7's bitwise complement (~7) = -8 <br />
> -8's bitwise complement (~ -8) = 7
