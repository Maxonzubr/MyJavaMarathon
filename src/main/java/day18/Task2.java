package day18;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(717771237));
        System.out.println(newCount7(717771237));
    }

    public static int count7(int number) {
        if (number == 0) {
            return 0;
        }
        double numberDivTen = (double) number / 10;
        int digit = (int) Math.round(((numberDivTen - (int) numberDivTen) * 10));
        if (digit % 7 == 0) {
            return 1 + count7((int) numberDivTen);
        } else {
            return count7((int) numberDivTen);
        }
    }

    public static int newCount7(int number) {
        String numberString = String.valueOf(number);
        if (numberString.contains("7")) {
            numberString = numberString.replaceFirst("7", "0");
            return 1 + newCount7(Integer.parseInt(numberString));
        } else {
            return 0;
        }
    }
}
