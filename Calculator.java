import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" ");
                if (symbols.length != 3) throw new Exception("Что-то пошло не так, попробуйте еще раз");

                Number firstNumber = Convert.ParseAndValidate(symbols[0]);
                Number secondNumber = Convert.ParseAndValidate(symbols[2], firstNumber.getType());
                String result;
                result = CalcService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    private static void startCalc() {
        System.out.println("Калькулятор работает только с арабскими и римскими цифрами от 1 до 10");
        System.out.println("Выполняет следующие операции:");
        System.out.println("Сложение(+), Вычитание(-), Умножение(*), Деление(/)");
        System.out.println("Формат ввода <Число1><пробел><знак операции><пробел><Число2>");
        System.out.println("Для завершения работы введите 'exit'");
    }

    private static void exitCalc() {

        System.out.println("Работа завершена");

    }
}


