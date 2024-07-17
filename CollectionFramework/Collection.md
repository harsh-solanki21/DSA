# Java Collections

- Collection is a framework.
- Framework is a set of classes and interfaces which provide a ready-made architecture.

## There are 6 Interfaces

### 1. Collection interface

### 2. List interface

- The List interface is an ordered collection that allows us to store and access elements sequentially. It extends the
  Collection interface.
- Since List is an interface, we cannot create objects from it.


- In order to use functionalities of the List interface, we
  can use these classes:
    - ArrayList
    - LinkedList
    - Vector
    - Stack

### 3. Queue interface

- The Queue interface of the Java collections framework provides the functionality of the queue data structure. It
  extends
  the Collection interface.


- In order to use the functionalities of Queue, we need to use classes that implement it:
    - ArrayDeque
    - LinkedList
    - PriorityQueue

### 4. Deque interface (Double-ended queue)

### 5. Set interface

- The Set interface of the Java Collections framework provides the features of the mathematical set in Java.
- It extends the collection interface. Unlike the List interface, sets cannot contain duplicate elements.


- In order to use functionalities of the Set interface, we can use these classes:
    - HashSet
    - LinkedHashSet
    - EnumSet
    - SortedSet
    - TreeSet

### 6. Map

- The Map interface of the Java collection framework provides the functionality of the map data structure.
- Since Map is an interface, we cannot create objects from it.


- In order to use functionalities of the Map interface, we can use these classes:
    - HashMap
    - EnumMap
    - LinkedHashMap
    - WeakHashMap
    - TreeMap
