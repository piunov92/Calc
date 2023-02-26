import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
                System.out.println(Calc(scanner.nextLine()));
        scanner.close();
    }
    public static String Calc(String input) {
        int digitOne = 0;
        int digitTwo = 0;
        int res = 0;
        String[] words = input.split(" ");
        try {
            if(words.length > 3)
                throw new IllegalArgumentException("the format of the mathematical operation does not satisfy the task");
            else if (words.length < 3)
                throw new IllegalArgumentException("a string is not a mathematical operation");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return "";
        }
        if(isNumeric(words[0]) && isNumeric(words[2])) {
            digitOne = Integer.parseInt(words[0]);
            digitTwo = Integer.parseInt(words[2]);
            try {
                if(!overflowDigit(digitOne, digitTwo)) {
                    res = operations(words[1], digitOne, digitTwo);
                } else
                    throw new IOException("the allowed input interval has been exceeded [1 - 10] or [I - X]");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                return "";
            }
        } else {
            try {
                digitOne = romanToArabic(words[0]);
                digitTwo = romanToArabic(words[2]);
                if(!overflowDigit(digitOne, digitTwo)) {
                    res = operations(words[1], digitOne, digitTwo);
                    if (res <= 0)
                        throw new RomanException("there are no negative numbers in the Roman system");
                    else
                        return arabicToRoman(res);
                } else
                    throw new IOException("the allowed input interval has been exceeded [1 - 10] or [I - X]");
            } catch (IllegalArgumentException ex) {
                System.out.println("the string is not a mathematical operation or incompatible number systems");
                return "";
            } catch (RomanException | IOException ex) {
                System.out.println(ex.getMessage());
                return "";
            }
        }
        return Objects.toString(res, null);
    }
    public static boolean overflowDigit(int digitOne, int digitTwo) {
        if(digitOne > 10 || digitTwo > 10)
            return true;
        return false;
    }
    public static int romanToArabic(String string) {
        int digit = 0;
        try {
            digit = Roman.valueOf(string).getVal();
        } catch (IllegalArgumentException ex) {
            String[] string_split = string.split("(?!^)");
            for(int i = 0; i < string_split.length; ++i) {
                int number = Roman.valueOf(string_split[i]).getVal();
                digit += number;
            }
        }
        return digit;
    }
    public static String arabicToRoman(int digit) {
        int i = 0;
        List<Roman> romanVal = Roman.reversVal();
        StringBuilder roman = new StringBuilder();
        while (i < romanVal.size()) {
            if (romanVal.get(i).getVal() <= digit) {
                roman.append(romanVal.get(i).name());
                digit -= romanVal.get(i).getVal();
            } else
                i++;
        }
        return roman.toString();
    }
    /*public static void testRevers() {
        for(Roman revers : Roman.reversVal())
            System.out.println(revers.getVal());
    }*/
    public static boolean isNumeric(String string) {
        for (char ch : string.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }return true;
    }
    public static int operations(String op, int arg1, int arg2) {
        int res = 0;
        switch (op) {
            case "+" :
                res = arg1 + arg2;
                break;
            case "-" :
                res = arg1 - arg2;
                break;
            case "*" :
                res = arg1 * arg2;
                break;
            case "/" :
                res = arg1 / arg2;
                break;
            default:
                System.out.println("a string is not a mathematical operation");
        }
        return res;
    }
}