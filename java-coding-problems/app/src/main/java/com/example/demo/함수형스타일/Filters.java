package com.example.demo.함수형스타일;

import java.util.ArrayList;
import java.util.List;

public class Filters {

    public static List<Melon> filterByType(List<Melon> melons, String type) {
        ArrayList<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType())) {
                result.add(melon);
            }
        }

        return result;
    }

    public static List<Melon> filterByWeight(List<Melon> melons, int weight) {
        ArrayList<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }


    public static List<Melon> filterByTypeAndWeight(List<Melon> melons,
            String type, int weight) {
        ArrayList<Melon> result = new ArrayList<>();

        for (Melon melon : melons) {
            if (melon != null && type.equalsIgnoreCase(melon.getType())
                    && melon.getWeight() == weight) {
                result.add(melon);
            }
        }

        return result;
    }
}
