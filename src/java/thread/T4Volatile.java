package java.thread;

/*
Volatile: mark variable as "store in main memory" (written to and read from main memory)
Every volatile variable is read from Computer's main memory, not from CPU Cache, and every write
to volatile variable will be written to main memory. not just CPU Cache.

If one threading is writing a variable, and other threads are just reading the variable, then
volatile keyword is enough to get visibility for reading threads.

If multiple threads are writing to variable, then volatile keyword is not enough. Have to use
synchronized block.

Full volatile visibility guarantee:
When ThreadA is reading/writing a volatile variable, then other variables visible to ThreadA is
also read from/written to main memory at that moment.

Disadvantage:
1. Reading from main memory is costly compared to CPU Cache memory.
2. volatile prevents instruction reordering by JVM, which is a performance enhancement technique.
*/
public class T4Volatile {
    private volatile int count = 0;


    private static class MyCalendar {
        private int years;
        private int months;
        private volatile int days;
        private boolean active;

        // write - along with volatile days, other visible variables (years and month) is also
        // written to main memory
        void update(int years, int months, int days) {
            this.years = years;
            this.months = months;
            // while writing days to main memory, values of years, and months will also be written.
            // But if this.days = days; is the first statement, then the old values would be written
            // with no guarantee of updated years and months value.
            this.days = days;
        }

        // read - along with days, years and months value is also read from main memory.
        int getTotalDays() {
            // While reading the value of volatile days, the value of months and years is also read
            // from main memory. But if we read days in the last statement, months and years could
            // be old value stored in CPU Cache.
            int total = days;
            total += months * 30;
            total += years * 365;
            return total;
        }
    }
}
