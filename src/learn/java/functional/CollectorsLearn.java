package learn.java.functional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsLearn {

    public static void main(String[] args) {

        //Collect to Collection
        Set<Integer> sets=IntStream.of(1,1,1,2,3,4,5,6).boxed()
                .collect(Collectors.toSet());

        System.out.println("hello:"+sets.toString());

        TreeSet<Integer> ts=IntStream.of(1,1,1,2,3,4,5,6).boxed()
                .collect(Collectors.toCollection(TreeSet::new));

        List<Integer> list=IntStream.range(1,10)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list2=IntStream.range(1,10)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> list3=IntStream.range(1,10)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        // Collect to Map
        // toMap(Function k, Function v)
        Map<Integer,Integer> map1=IntStream.range(1,10)
                .boxed()
                .collect(Collectors.toMap(x->x ,x->x));

        //toMap(Function k, Function v, BinaryOperator m)

        Map<Integer,Integer> map2=IntStream.of(5,4,3,2,1,1,2,3,4,5,6)
                .boxed()
                .collect(Collectors.toMap(x->x ,x->x,(x,y)->x+y));
        System.out.println("map 2:"+map2);


        //toMap(Function k, Function v, BinaryOperator m, Supplier s)

        Map<Integer,Integer> map3=IntStream.of(5,4,3,2,1,1,2,3,4,5,6)
                .boxed()
                .collect(Collectors.toMap(x->x ,x->x,(x,y)->x+y,TreeMap::new));
        System.out.println("map 3:"+map3);


        // Collectors.joining --> requires charsequence
        String rangeString=IntStream.range(1,10).boxed()
                .map(Object::toString)
                .collect(Collectors.joining(",")).toString();
        System.out.println("range :"+rangeString);

        //AveragingPrimetive --> averagingInt,averagingDouble,averagingLong
      Double od= IntStream.range(1,10).boxed().collect(Collectors.averagingInt(x->x));

       //SummerizingInt
        IntSummaryStatistics iss=IntStream.range(1,8).summaryStatistics();
        IntSummaryStatistics iss2=IntStream.range(1,8).boxed().collect(Collectors.summarizingInt(x->x));
      System.out.println("average:"+od);

      //Collectors.groupingBy

        //groupingBy(Function f);
        Map<Integer, List<Integer>> map=IntStream.of(1,1,2,2,3,3,4,4,4,5,5,5,6)
                .boxed().collect(Collectors.groupingBy(x->x));
        IntStream.of(1,1,2,2,3,3,4,4,4,5,5,5,6)
                .boxed().collect(Collectors.groupingBy(x->x));

        //groupingBy(Function f, Collector dc)
        IntStream.of(1,1,1,2,3,4,3,2,3,3,2,4,5,5).boxed()
                        .collect(Collectors.groupingBy(x->x,Collectors.toSet()));

        // groupingBy(Function f, Supplier s, Collector dc)
        IntStream.of(1,1,1,2,3,4,3,2,3,3,2,4,5,5).boxed()
                .collect(Collectors.groupingBy(x->x,TreeMap::new ,Collectors.toList()));

        //Collectors.partitioningBy(Predicate p)
        //partitioningBy(Predicate p, Collector dc)
        // takes predicate divides the stream into true and false list
        IntStream.of(1,1,1,2,3,4,3,2,3,3,2,4,5,5).boxed()
                .collect(Collectors.partitioningBy(x->(x%2)==0));


        System.out.println("map:"+map.toString());
        System.out.println("TreeSet"+ts.toString());
        System.out.println("Set"+sets.toString());

    }
}
