package org.szeged;

import java.util.List;
import java.util.OptionalDouble;

public class Util {

    public final static Long LIMIT = 1200000L;

    public static double calculateAverage(List<Integer> marks) {
        Integer sum = 0;
        if(!marks.isEmpty()) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.size();
        }
        return sum;
    }

    public static double calculateAverage(Integer[] marks) {
        Integer sum = 0;
        if(marks != null) {
            for (Integer mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.length;
        }
        return sum;
    }

    public static double calculateAverage(Long[] marks) {
        Long sum = 0L;
        if(marks != null) {
            for (Long mark : marks) {
                sum += mark;
            }
            return sum.doubleValue() / marks.length;
        }
        return sum;
    }


    public static double calculateAvrageJava8(List<Integer> marks){
        OptionalDouble average = marks
                .stream()
                .mapToDouble(a -> a)
                .average();

        return average.isPresent() ? average.getAsDouble() : 0.0;

    }
}
