# HashMap
How HashMap works internally

HashMap can store null values, is not synchronized and can store key value pairs.

HashMap works on the principle of hashing. HashMap has two methods: put(Key, Value) and get(Key) for storing and retrieving the objects from HashMap.

Internally, HashMap is implemented as an array. Each index of the array is like a bucket which has enteries for the nodes. Each Node in the bucket has three entries: int hash, Object Key, Object value. When the put(key, value) is called, internally hashcode method on the Key Object is called to determine the bucket location to store the Entry Object. Key and Value of the Entry Object is stored in the bucket.

It is quite possible that two different objects can have the same hashcode resulting in collision. Hence, the bucket is internally implemented as LinkedList. 

When calling the get(Key) method, HashMap calculates the hashcode on the Key Object to determine the location of the bucket. Since two different Values are stored for the same hashcode in the same bucket, you need to traverse the LinkedList to retrieve the Value Object by calling the keys.equals() method. equals() comes into the picture only in case of retrieving a value object from HashMap in Java.

String, Integer, and other wrapper classes are natural candidates of the HashMap key, and String is the most frequently used key as well because String is immutable and final, and overrides equals and hashcode() method. Other wrapper class also shares similar property. 

Immutability is required, in order to prevent changes on fields used to calculate hashCode() because if a key object returns different hashCode during insertion and retrieval then it won't be possible to get an object from HashMap. 

Since a poor hash function e.g. which always return the location of the same bucket, can turn a HashMap into a linked list, like converting the get() method to perform in O(n) instead of O(1) and someone can take advantage of this fact, Java now internally replace linked list to a binary true once a certain threshold is breached. This ensures performance or order O(log(n)) even in the worst case where a hash function is not distributing keys properly.

Does not overriding hashCode() method have any performance implications?

A poor hash code function will result in the frequent collision in HashMap which eventually increases the time for adding an object into Hash Map.

From Java 8 onwards though collision will not impact performance as much as it does in earlier versions because after a threshold the linked list will be replaced by a binary tree, which will give you O(logN) performance in the worst case as compared to O(n) of a linked list.

When do you override hashCode() and equals()?

Default implementation of equals() class provided by java.lang.Object compares memory location and only returns true if two reference variables are pointing to the same memory location i.e. essentially they are the same object. 

String overrides equals,  whose implementation of equals() method returns true if the content of two String objects is exactly the same. Integer wrapper class overrides equal to perform numerical comparison etc.

Since HashMap and Hashtable in Java rely on the equals() and hashCode() method for comparing keys and values, Java provides the following rules to override the equals method Java. 

1) Reflexive: Object must be equal to itself.

2) Symmetric : if a.equals(b) is true then b.equals(a) must be true.

3) 3) Transitive : if a.equals(b) is true and b.equals(c) is true then c.equals(a) must be true.

4) Consistent: multiple invocations of equals() method must return the same value until any of the properties are modified. So if two objects are equals in Java they will remain equals until any of their property is modified.

https://javarevisited.blogspot.com/2011/02/how-to-write-equals-method-in-java.html#axzz80meeT94E
