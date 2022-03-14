package com.matt;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class P1 {
    public static void main(String[] args) {
        Stream  is= Stream.of(1,4,6,8,9);

        HashSet hs=(HashSet)is.collect(Collectors.toCollection(LinkedHashSet::new));

        hs.stream().forEach(d -> System.out.println(d));

        System.out.println("Stream");

    }
}
