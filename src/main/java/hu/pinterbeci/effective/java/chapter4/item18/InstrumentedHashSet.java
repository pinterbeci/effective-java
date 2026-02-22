package hu.pinterbeci.effective.java.chapter4.item18;

import java.util.Collection;
import java.util.Set;
/*
Inheritance is appropriate only in circumstances where the subclass really is a
subtype of the superclass. In other words, a class B should extend a class A only
if an “is-a” relationship exists between the two classes. If you are tempted to
have a class B extend a class A, ask yourself the question: Is every B really an A?
If you cannot truthfully answer yes to this question, B should not extend A. If the
answer is no, it is often the case that B should contain a private instance of A and
expose a different API: A is not an essential part of B, merely a detail of its
implementation.
 */
public class InstrumentedHashSet<E> extends ForwardingSet<E> {
    // The number of attempted element insertions
    private int addCount = 0;

    public InstrumentedHashSet(Set<E> set) {
        super(set);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}
