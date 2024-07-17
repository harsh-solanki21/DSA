# ArrayList

- Creating an ArrayList:

```java
ArrayList<Integer> list = new ArrayList<>();
// we can initialize initial capacity of the ArrayList in the ()

ArrayList<Integer> list = new ArrayList<>(Arrays.asList(4, 5, 1, 1, 3, 5)); // to add initial values
```

### Methods of ArrayList

```java
public static void main(String[] args) {
    Collections.sort(al); // to sort arraylist

    add(element)  // to append an element at the end of the array
    list.add(12);

    add(index, element)  // to insert element at the particular position
    list.add(2, 18);

    addAll(collection)  // to add all the elements of list1 into list2
    list1.addAll(list2);

    get(index)  // to return the element at the given index
    list.get(2);

    set(index, value)  // to change the value at the particular index
    list.set(2, 12);

    indexOf(element)  // to return the index of a particular element
    list.indexOf(20);

    remove(index)  // to remove an element at the particular index
    list.remove(1);

    remove(element)  // to remove an element from the array
    list.remove(new Integer(100));

    removeAll(Collection)  // to remove all the elements of an array
    list1.removeAll(list2); // this will remove all the elements of list2

    clear()  // to remove all the elements from the list
    list.clear();

    size()  // returns the size of the array
    list.size();

    firstIndexOf(element)  // returns the first index of an element
    list.firstIndexOf(10);

    lastIndexOf(element)  // returns the last index of an element
    list.lastIndexOf(10);

    contains()  // to check if the array contains a particular value or not
    list.contains(12); // returns true or false

    isEmpty()  // to check if the array is empty or not
    list.isEmpty(); // returns true or false

    removeIf()  // to remove elements from the array which satisfies the condition
    list.removeIf(n -> (n % 3 == 0));

    removeRange(fromIndex, toIndex)  // to remove elements between the specified range
    list.removeRange(0, 2);

    retainAll(collection)  // it will remove all the elements of list1 that are not present in list2
    list1.retainAll(list2);

    subList()  // to retrieve sublist
    ArrayList<Integer> list2 = list1.subList(2, 4);

    trimToSize()  // like shrink to fit in c++
    list.trimToSize();

    toArray()  // to convert ArrayList into Array
    Integer[] arr = new Integer[list.size()];
    arr = list.toArray(arr);
    for (Integer i : arr) {
        System.out.print(i + " ");
    }

    // 2D Array
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    // initialization
    for (int i = 0; i < 3; i++) {
        list.add(new ArrayList<>());
    }

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            list.get(i).add(sc.nextInt());
        }
    }
}
```

<br />

# LinkedList

```java
public static void main(String[] args) {
    LinkedList<String> ll = new LinkedList<>(); // String example

    ll.add("A"); // to add an element at the end
    ll.add(2, "B"); // to add an element at a specific index
    ll.addLast("C"); // add element to the last index
    ll.addFirst("D"); // add element to first index

    ll.remove(); // remove the head element
    ll.remove("B"); // to simply remove B from linked list
    ll.remove(3); // to remove element at index 3
    ll.removeFirst();
    ll.removeLast();
    ll.removeFirstOccurrence("Geeks");
    ll.removeLastOccurrence("Geeks");

    ll.set(1, "For"); // to change the element at the index 1
    ll.clear(); // to empty the list
    ll.size(); // returns size of linked list

    // to clone/copy the linked list into another linked list
    LinkedList copyList = new LinkedList();
    copyList = (LinkedList) ll.clone();

    ll.contains("a"); // returns boolean

    ll.get(index); // to get element at a particular index
    ll.getFirst(); // go get first element
    ll.getLast(); // to get last element

    ll.indexOf("b"); // go get the index of an element
    ll.lastIndexOf("b"); // to get the last index of an element


    // Setting the ListIterator at a specified position
    ListIterator iter = list.listIterator(2);
    // Iterating through the created list from the position
    System.out.println("The list is as follows:");
    while (iter.hasNext()) {
        System.out.println(iter.next());
    }
}
```

<br />

# Stack

```java
public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();

    s.size(); // returns the size of the stack
    st.push(value); // to add element into the stack
    st.peek(); // to fetch the top element of the stack
    st.pop(); // to remove the element from the stack
    st.empty(); // returns boolean

    st.search(element);
    // returns the position of the element if it is successfully found in the stack
    // (taking the count as base 1) 
    // else -1 is returned
}
```

- If the inner loop is dependent on outer loop(j depends on i) then try to think of stack to optimize the solution
