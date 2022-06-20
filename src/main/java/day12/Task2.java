package day12;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        fillUpList(0, 30, list);
        fillUpList(300, 350, list);
        System.out.println(list);
    }

    public static void fillUpList(int from, int to, List<Integer> list) {
        if (from % 2 != 0) from = from + 1;
        for (int i = from; i <= to; i += 2) list.add(i);
    }
}
