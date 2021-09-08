public class CalcService {

    public static String calculate(Number first, Number second, String action) throws Exception {

        int result = switch (action) {
            case "+" -> first.getValue() + second.getValue();
            case "-" -> first.getValue() - second.getValue();
            case "*" -> first.getValue() * second.getValue();
            case "/" -> first.getValue() / second.getValue();
            default -> throw new Exception("Используйте только +, -, *, /");
        };

        if (first.getType() == ArabRome.ROME) {
            return Convert.ToRomeNumber(result);
        } else return String.valueOf(result);
    }
}
