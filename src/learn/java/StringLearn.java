package learn.java;

import java.nio.charset.Charset;

public class StringLearn {

    public static void main(String[] args) {

        String s=new String("Satyesh").intern();
        String s2=new String(s);

        String s3="Satyesh";
        String s4="Satyesh";
        System.out.println("S:"+s.hashCode());
        System.out.println("S2:"+s2.hashCode());
        System.out.println("S3:"+s3.hashCode());
        System.out.println("S4:"+s4.hashCode());
        System.out.println("S==s2:"+s==s2);
        System.out.println("S3==s2:"+s3==s2);
        System.out.println("S3==s4:"+s3==s4);

        // 1. char charAt(int index); --> index start with 0
        // s3=Satyesh
        System.out.println(s3.charAt(0)); // S
        //System.out.println(s3.charAt(9));  //java.lang.StringIndexOutOfBoundsException: String index out of range: 9


        //2. IntStream chars() --Returns a stream of int zero-extending the char values from this sequence.

        s3.chars().forEach(e->System.out.println((char)e));


        //3. int compareTo(String)
        // int compareToIgnoreCase(String );
        // String concat(String) or concat(CharSequence s);

        System.out.println(s3.concat(" Tripathi"));

        //4. String contains (CharSequence cs)
        //
        CharSequence cs="ty";
        System.out.println(s3.contains(cs));
        System.out.println("contains-->"+"tyESH".contains(cs));  // true
        System.out.println("contains-->"+"TYESH".contains(cs));  // false

        //5. boolean contentEquals(CharSequence cs);

    }
}
