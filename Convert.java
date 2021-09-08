import java.util.Map;
import java.util.TreeMap;

class Convert {

    private final static TreeMap < Integer, String > RomeString = new TreeMap<>();

    static {
        RomeString.put(1, "I");
        RomeString.put(4, "IV");
        RomeString.put(5, "V");
        RomeString.put(9, "IX");
        RomeString.put(10, "X");
        RomeString.put(40, "XL");
        RomeString.put(50, "L");
        RomeString.put(90, "XC");
        RomeString.put(100, "C");
    }

    static Number ParseAndValidate(String symbol) throws Exception {

        int value;
        ArabRome type;

        try {
            value = Integer.parseInt(symbol);
            type = ArabRome.ARAB;
        }catch (NumberFormatException e) {
            value = ToArabNumber(symbol);
            type = ArabRome.ROME;
        }

        if (value < 1 || value > 10) {
            throw new Exception("Используйте числа только от 1 до 10 включительно");
        }

        return new Number(value, type);
    }

    static Number ParseAndValidate(String symbol, ArabRome type) throws Exception {

        Number number = ParseAndValidate(symbol);
        if (number.getType() != type) {
            throw new Exception("Нельзя смешивать римские и арабские цифры");
        }

        return number;
    }

    private static int LetterToNumber(char letter) {

        int result = -1;

        for (Map.Entry < Integer, String > entry: RomeString.entrySet()) {
            if (entry.getValue().equals(String.valueOf(letter))) result = entry.getKey();
        }
        return result;
    }

    static String ToRomeNumber(int number) throws Exception {

        if (number < 0) throw new Exception("Вычисления с римскими цифрами не допускают результат меньше 0");

        int i = RomeString.floorKey(number);

        if (number == i) {
            return RomeString.get(number);
        }
        return RomeString.get(i) + ToRomeNumber(number - i);
    }

    static int ToArabNumber(String RomeString) throws Exception {
        int result = 0;

        int i = 0;
        while (i < RomeString.length()) {
            char letter = RomeString.charAt(i);
            int num = LetterToNumber(letter);

            if (num < 0) throw new Exception("Введён неверный символ");

            i++;
            if (i == RomeString.length()) {
                result += num;
            }else {
                int nextNum = LetterToNumber(RomeString.charAt(i));
                if(nextNum > num) {
                    result += (nextNum - num);
                    i++;
                }
                else result += num;
            }
        }
        return result;
    }
}
