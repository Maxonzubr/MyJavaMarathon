package day8;

public class Task1 {
    public static void main(String[] args) {

        long startTime1 = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i <= 20000; i++)
            str += i + " ";
        System.out.println(str);
        long stopTime1 = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 20000; i++)
            sb.append(i + " ");
        System.out.println(sb);
        long stopTime2 = System.currentTimeMillis();

        System.out.printf("Run time 1, ms: %d\nRun time 2, ms: %d", (stopTime1 - startTime1), (stopTime2 - startTime2));
    }
}
