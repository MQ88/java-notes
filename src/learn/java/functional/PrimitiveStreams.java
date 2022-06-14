package learn.java.functional;

import java.util.IntSummaryStatistics;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {

    public static void main(String[] args) {
       OptionalDouble average= IntStream.of(1,2,3,4).average();
       Optional<Long> max= LongStream.of(1,2,3,4).boxed().max(Long::compareTo);
       IntSummaryStatistics iss= IntStream.of(1,2,3,4).summaryStatistics();
       LongSummaryStatistics lss= LongStream.of(1,2,3,4).summaryStatistics();
       IntStream.range(1,11);     // end is exclusive
       IntStream.rangeClosed(1,10); // end is inclusive

       // Convert Normal Stream to IntStream/LongStream/DoubleStream

        Stream.of(1,2,3,3,3,3).mapToInt(Integer::intValue)
                .mapToLong(i-> (long) i)
                .mapToDouble(i->(double)i);



    }
}
