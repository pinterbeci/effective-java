package hu.pinterbeci.effective.java.chapter2.item5;

import static java.util.Objects.requireNonNull;

//Dependency Injection Pattern
//in short: dependencies must be injected when creating an object
public class SpellChecker {
    private final Lexicon dictionary;

    //assume that:
    //this breaks the testability; All the SpellCheckers initiate with same dependency
    //single dictionary for all time;
    //private final Lexicon dictionary = ...;

    //pass to all resources into the constructor when creating a new instance
    //it is important that when creating a new instance must initialize all resources

    //for example:
    //the 'dictionary' is a DEPENDENCY of 'SpellChecker' and INJECTED into the 'SpellChecker' when it is created
    public SpellChecker(final Lexicon dictionary) {
        this.dictionary = requireNonNull(dictionary);
    }
}
