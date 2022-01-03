package com.matt;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App 
{

    public static final int ORDERED    = 0x00000010;
    public static final int DISTINCT   = 0x00000081;
    public static final int SIZED      = 0x00000040;
    public static final int IMMUTABLE  = 0x00000400;


    public static  int characteristics() { return ORDERED + DISTINCT+ IMMUTABLE ; }

    // ---用与位运算判断 characteristics() & IMMUTABLE == IMMUTABLE
    static boolean hasCharacteristics(int characteristics) {
        return (characteristics() & characteristics) == characteristics;
    }


    enum Characteristics {
        CONCURRENT,
        UNORDERED,
        IDENTITY_FINISH
    }
    public  static Set<Characteristics> getcharacteristics() {
        return  Collections.unmodifiableSet( EnumSet.of(Characteristics.UNORDERED,
                Characteristics.IDENTITY_FINISH ));
    }


    public static void main( String[] args ) throws IOException, ClassNotFoundException {

        getcharacteristics().add(Characteristics.IDENTITY_FINISH);
        System.out.println(getcharacteristics().contains(Characteristics.IDENTITY_FINISH));

        System.out.println(App.hasCharacteristics(ORDERED));

          Double d=null;
        d=new Double(23);

        dosome();
//        //创建对象输出流
//        //创建对象输入流
//        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.bin"));
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.bin"))) {
//
//                /* 序列化java对象 */
//                oos.writeObject("23");
//                oos.flush();
//                System.out.println( ois.readObject());
//            }


        Comparator<Apple> appleComparable = Comparator.comparing(Apple::getWeight);
        Apple a1 =new Apple();
        a1.setWeight(23d);
        Apple a2=new Apple();
        List<Apple> list=new ArrayList<>();
        list.add(a1);
        list.add(a2);
        list.sort(appleComparable);
        Stream<Apple> sa=list.stream();

       //  list.forEach(System.out::println);
        // if(sa.anyMatch((a)-> a.getWeight()>2)){
             sa.forEach(System.out::println);
        // }


        List<Apple> lists  = Collections.emptyList();



    }


    public static void dosome() throws IOException {
        System.out.println();
    }

}
