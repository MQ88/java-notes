package learn.java;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.function.*;
import java.util.stream.Stream;

public class FuntionalInterface {


    // Predicate<T> --> boolean test(T a);
    Predicate<String> startsWithCaps=(str) ->  Character.isUpperCase(str.charAt(0));

    Predicate<String> isEmpty=String::isEmpty;

    Predicate<String> is0Length =(j)->j.length()==0;

    // Supplier<T>--> T get ();
    Supplier<Double> getRandomNumber= Math::random;

    // Consumer<T> void accept(T a);
    Consumer<String> log=System.out::println;

    //BiConsumer<T,U> void accept(T Ba,U b);
    HashMap<Integer,String> map=new HashMap<>();
    BiConsumer<Integer,String> mapPut=map::put;

    //BiPredicate<T,U> void test(T a,u b)
    BiPredicate<String,String> startsWith=String::startsWith;
    BiPredicate<String,String> endsWith=String::endsWith;

    // Function <T,R> R apply (T a);
    Function<String,Integer> function=String::length;

    //BiFunction<T,U,R>  R apply (T a ,U b);s
    BiFunction<String,String,String> bifunction=String::concat;

    public static void main(String[] args) {
        FuntionalInterface f=new FuntionalInterface();
        f.testFunctions();
        f.testStream();
    }

    public void testFunctions()
    {

        //Predicate
        System.out.println(startsWithCaps.test("Satyesh"));
        System.out.println(startsWithCaps.negate().test("Satyesh"));
        System.out.println(isEmpty.or(startsWithCaps).test(""));
        System.out.println(isEmpty.and(is0Length).test(""));

        //BiPredicate
        System.out.println(startsWith.or(endsWith).test("Satyesh","h"));

        //Consumer
        log.andThen(log).accept("hello");

        //Supplier
        log.accept(getRandomNumber.get()+"");
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
        Optional<Integer> sum=oddnumber4.limit(2).reduce( (i,j)->i+j);

        Optional<Integer> min2=oddnumber5.limit(3).reduce((i,j)-> (i < j?i:j));
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
