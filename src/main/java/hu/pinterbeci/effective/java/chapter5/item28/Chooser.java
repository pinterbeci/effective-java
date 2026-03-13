package hu.pinterbeci.effective.java.chapter5.item28;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser<T> {
    //private final T[] choiceArray; prevent this; List is a generic type perfect for this scenario
    private final List<T> choiceList;

    public Chooser(Collection<T> choices) {
        //choiceArray = (T[]) choices.toArray(); get rid an error, but get a warning
        choiceList = new ArrayList<>(choices);
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}
