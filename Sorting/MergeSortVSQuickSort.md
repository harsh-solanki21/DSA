## Merge Sort VS Quick Sort

| Merge sort                                                                                              | Quick sort                                                                                                          
---------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------
| Worst case and average case has the same complexities O(n * log n).                                     | Worst case complexity of quick sort is O(n^2) <br/>as there is need of a lot of comparisons in the worst condition. 
| Merge sort is more efficient and works faster than quick sort in case of larger array size or datasets. | Quick sort is more efficient and works faster than merge sort in case of smaller array size or datasets.            
| If the array is already sorted then also it will go till the very end of the process.                   | But this won't happen in the Quick sort.                                                                            
| Merge sort is preferred for linked lists.                                                               | Quick sort is preferred for arrays.                                                                                 

<br />

### Quick Sort is preferred for Arrays because:

1. Quick Sort in its general form is an in-place sort. <br />
   whereas merge sort requires O(N) extra storage, N denoting the array size which may be quite expensive.

- Allocating and de-allocating the extra space used for merge sort increases the running time of the algorithm.

2. Comparing average complexity we find that both type of sorts have O(N logN) average complexity but the constants
   differ. <br />
   For arrays, merge sort loses due to the use of extra O(N) storage space.
