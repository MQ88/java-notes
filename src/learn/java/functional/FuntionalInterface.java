package learn.java.functional;


import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/*** Pending Primitive Streams **/
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




}
