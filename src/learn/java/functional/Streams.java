package learn.java.functional;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {
    Consumer<String> log=System.out::println;


    public static void main(String[] args) {

    }

    public void streamOperations()
    {
        /*----Terminal Operation -----
        -----Long count()
        ----Optional<T> min ()
        ----Optional<T> max ()
        ----boolean anyMatches(Predicate<T>) /noneMatches(Predicate<T>)/AllMatches(Predicate<T>)
        ----Optional<T> findFirst()/findAny()
        ---Optional<T> reduce(BinaryOperator<T,T>)
        ---R collect (Collector)
        --- void forEach(Consumer<R> )
         */

        /*------Intermediate operation---
        ----Stream<R> peek(Consumer<R>)
        ----Stream<R> map(Funcation<T,R>)
        ----Stream<T> sorted()/sorted(Comparator<T>)
        ----skip(n) --> skip first n items
        ----limit(n) --> limit to n items in stream
        ----Stream<T> distinct()--> uses equals() method
        ----stream<R> flatmap(Function <Stream<T>,Stream<R>>)
        ----Stream<T> filter(Predicate<T> )
         */

        //square the list of numbers and then filter out the numbers
        // greater than 100 and then find the
        // average of the remaining numbers

        OptionalDouble avg= Stream.of(1,2,3,4,55,23,12,8,9)
                .map(x->x*x)
                .filter(x->x<100)
                .mapToInt(x->(Integer)x)
                .average();

        // find the min and max in stream
        Stream.of(1,2,3,4,5,5,5,5).mapToInt(Integer::intValue).summaryStatistics();
        IntSummaryStatistics intfunc = IntStream.range(1,11).summaryStatistics();
        intfunc.getAverage();
        intfunc.getCount();
        intfunc.getMin();
        intfunc.getSum();
        intfunc.getMax();


        //to find the number of Strings in a list
        // whose length is greater than 5
        long greaterThan5chars=Stream.of("Satyesh","Amira","Sunil","Tripathi",
                        "nikhil","Alex")
                .filter(x->x.length()>5)
                .count();

        //program to concatenate two Streams?
        Stream<Integer> s1=Stream.of(1,2,3,4,44,4,2);
        Stream<Integer> s2=Stream.of(1,2,3,4,44,4,2);
        Stream.concat(s1,s2).distinct().forEach(System.out::println);



    }

    public void testStream()
    {
        Stream<Double> random= Stream.generate(Math::random);
        Stream<Integer> evenNumbers=Stream.iterate(2,i-> i* i);

        System.out.println("number::"+random.anyMatch((i)->((i>0) || (i<0))));

        //The skip(n) method is an intermediate operation that discards the first n elements of a stream.

        //The limit(n) method is another intermediate operation that returns a stream
        // not longer than the requested size
        evenNumbers.map(i->i+"\n")
                .peek(log)
                .skip(2)
                .limit(5).forEach(log);

        Stream<Integer> oddnumber=Stream.iterate(3,i->i+2);
        Stream<Integer> oddnumber2=Stream.iterate(3,i->i+2);
        Stream<Integer> oddnumber3=Stream.iterate(3,i->i+2);
        Stream<Integer> oddnumber4=Stream.iterate(3,i->i+2);
        Stream<Integer> oddnumber5=Stream.iterate(3,i->i+2);
        long f=oddnumber.limit(2).count();
        Optional<Integer> min = oddnumber2.limit(5).min(Integer::compareTo);
        Optional<Integer> max=oddnumber3.limit(5).max(Integer::compareTo);
        Optional<Integer> sum=oddnumber4.limit(2).reduce( (i, j)->i+j);

        Optional<Integer> min2=oddnumber5.limit(3).reduce((i, j)-> (i < j?i:j));
        log.accept("min is :"+min);
        log.accept("min is :"+max);
        log.accept("sum is :"+sum);
        log.accept("min2 is :"+min2);

        Stream<String> st=Stream.iterate("a",i->i+2);
        Optional<String> less=st.peek(log).limit(10).min(String::compareTo);
        log.accept("less :"+less.get());

        Integer [][]p={{1,2,3},{-1,-2,-4}};
        Optional<Long> min5= Stream.of(p).flatMap((i)-> Arrays.stream(i))
                .map(Long::valueOf)
                .min(Long::compareTo);
        log.accept("min5 is:"+min5);


    }
}
