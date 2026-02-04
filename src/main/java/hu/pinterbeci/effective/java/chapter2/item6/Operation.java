package hu.pinterbeci.effective.java.chapter2.item6;

public class Operation {
    static long sum() {
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            //2^31 Long instance construct here, each time when add a new 'i' to the 'sum'
            sum += i;
        //returns the Autoboxed type, not the primitive another performance issue
        return sum;
    }
    static long sum2() {
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        return sum;
    }
}
