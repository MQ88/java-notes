package learn.java.functional;

import java.util.Optional;

public class Optionals {

    public static void main (String ... args)
    {
       // Optional<String> emptyString=Optional.of(null);// Null Pointer Exception
        Optional<String> emptyString=Optional.ofNullable(null);
        Optional<Integer> rank=Optional.ofNullable(123);
        System.out.println(emptyString.isPresent()); //false

        //T Optional.orElse(T )
        System.out.println(emptyString.orElse("default"));

        //T Optional.orElseGet(Supplier<T> get )
        System.out.println(emptyString.orElseGet(()->"satyesh"));

        //<X extends Exception> Optional.orElseThrow(Supplier<X>)
        try {
            emptyString.orElseThrow(RuntimeException::new);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }

        boolean isGreaterThan3=rank
                .map(x->x+"")
                .map(String::length).filter(x->x>2)
                .isPresent();

        System.out.println("is greater than 3->"+isGreaterThan3);




    }
}
