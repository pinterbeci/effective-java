package hu.pinterbeci.effective.java.chapter5.item31;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StackTest {

    /**
     * Illustrates how the Java compiler processes generic types
     * from source code to bytecode.
     *
     * <pre>
     * Your Code          Compiler Phase        Bytecode (JVM)
     * ─────────────────────────────────────────────────────────
     * List&lt;String&gt;  →   1. Invariance check → List (raw)
     *    │               2. Erase generics  →   │
     *    │               3. Insert casts    →   │ + (String) cast
     *    ▼                                      ▼
     * Compile-time safety              Runtime: ClassCastException
     *                                  (if heap pollution occurred)
     * </pre>
     *
     * <ul>
     *   <li><b>Phase 1:</b> Compiler enforces invariance — type mismatches are rejected</li>
     *   <li><b>Phase 2:</b> Generic type info is erased — {@code List<String>} becomes {@code List}</li>
     *   <li><b>Phase 3:</b> Silent {@code (String)} casts are injected into bytecode</li>
     *   <li><b>Runtime:</b> JVM has no knowledge of generics — may throw {@link ClassCastException}</li>
     * </ul>
     */
    @Test
    void should_push_all_to_stack(){
        Stack<Number> stack = new Stack<>();
        Iterable<Integer> integers =  List.of(1,2,222);
        stack.pushAll(integers);

        assertThat(stack.isEmpty()).isFalse();
    }
}