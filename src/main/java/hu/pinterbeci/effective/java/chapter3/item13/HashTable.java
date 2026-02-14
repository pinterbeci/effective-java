package hu.pinterbeci.effective.java.chapter3.item13;

// Recursive clone method for class with complex mutable state
public class HashTable implements Cloneable {
    private Entry[] buckets;
    private int size;
    private static final int ENTRY_CAPACITY = 16;

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        // Recursively copy the linked list headed by this Entry
        //avoid this recursive copy, and then avoid the StackOverflow !!!!
        /*
        Entry deepCopy() {
            return new Entry(key, value, next == null ? null : next.deepCopy());
        }
        */

        //create a deep copy
        Entry deepCopy() {
            Entry result = new Entry(key, value, next);

            for (Entry p = result; p.next != null; p = p.next)
                p.next = new Entry(p.next.key, p.next.value, p.next.next);

            return result;
        }

    }

    public HashTable() {
        this.buckets = new Entry[ENTRY_CAPACITY];
    }

    //thread-safe clone
    @Override
    public synchronized HashTable clone() {
        try {
            HashTable result = (HashTable) super.clone();
            result.buckets = new Entry[buckets.length];

            //IMPORTANT DO NOT USE OVERRIDABLE METHOD IN CLONE
            //THE THE OVERRIDER SUBCLASS IMPLEMENTATION
            for (int i = 0; i < buckets.length; i++)
                if (buckets[i] != null) result.buckets[i] = buckets[i].deepCopy();

            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}