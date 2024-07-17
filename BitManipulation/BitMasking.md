## Get Bit

- Get bit means get the bit from the particular position. <br />
- Example: <br />
  Suppose we need to get bit at position 2 <br />
  n = 0101, pos = 2 <br />
  1 << pos = 0100 <br />
  0101 & 0100 = 0100 <br />
  if `n & (1 << pos) != 0`, then bit is 1

## Set Bit

- Set bit means to set bit 1 at a given position. If it is already 1 then leave it as it is, otherwise replace it with
  1 <br />
- Example: <br />
  Suppose we need to set a bit at position 1 <br />
  n = 0101, pos = 1 <br />
  1 << pos = 0010 <br />
  0101 | 0010 = 0111 <br />
  `n = n | (1 << pos)`

## Unset/Clear Bit

- Unset/Clear bit means to convert the bit to 0 at a given position. <br />
- Example: <br />
  Suppose we need to clear bit at position 2 <br />
  n = 0101, pos = 2 <br />
  1 << pos = 0100 <br />
  ~0100 = 1011 <br />
  0101 & 1011 = 0001 <br />
  `n = n & ~(1 << pos)`

## Update Bit (Clear Bit and then Set it)

- Update bit means we have to change the bit of the given position by given bit. <br />
- Example: <br />
  Suppose we need to update to the bit 1 at position 1 <br />
  n = 0101, pos = 1, updateBit = 1 <br />
  1 << pos = 0010 <br />
  ~0010 = 1101 <br />
  0101 & 1101 = 0101 <br />
  1 << pos = 0010 <br />
  0101 | 0010 = 0111 <br />
  `n = (n & ~(1 << pos)) | (updateBit << pos)`

## Toggle Bit

- Toggle bit means to convert the bit to 0 if it is 1 and vice versa. <br />
- Example: <br />
  Suppose we need to update a bit at position 1 <br />
  n = 1010, pos = 1 <br />
  1 << pos = 0010 <br />
  1010 ^ 0010 = 1000 <br />
  `n = n ^ (1 << pos)`

## 2's compliment

- 2's complement of 5 is: -5
- 2's complement of -3 is: 3 <br />
  `~n + 1`

### Lowest Set bit of a number

- if we AND the original number with its 2's complement, we get the lowest set bit. <br />
  `lowestSetBit = n & (-n);`
