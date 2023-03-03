package utils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {

    public static List<String> sort(List<String> listToSort, int sortType) {
        switch (sortType) {
            case 0:
                return listToSort.stream().sorted().collect(Collectors.toList());
            case 1:
                return listToSort.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            case 2:
                return listToSort.stream().map(Double::parseDouble)
                        .sorted()
                        .map(Object::toString)
                        .collect(Collectors.toList());
            case 3:
                return listToSort.stream().map(Double::parseDouble)
                        .sorted(Comparator.reverseOrder())
                        .map(Object::toString)
                        .collect(Collectors.toList());
        }
        return listToSort;
    }
}
