package chapter1.item5;

import java.util.Objects;

public class SpellChecker {

    // dependency
    private final Lexicon dictionary;

    //dependency injection
    public SpellChecker(final Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    //some methods....
}
