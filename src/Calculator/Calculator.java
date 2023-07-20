package Calculator;

import java.lang.annotation.*;
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@interface Operand {
    String value();
}
public class Calculator {
    /**
     * Даний клас представляє простий калькулятор, який може виконувати основні операції (+, -, *, /).
     */

    /**
     * Поле, що зберігає результат останньої операції.
     */
    private double result;

    /**
     * Конструктор класу калькулятора.
     */
    public Calculator() {
        result = 0;
    }

    /**
     * Метод для додавання двох чисел.
     *
     * @param num1 Перше число для додавання.
     * @param num2 Друге число для додавання.
     * @return Результат додавання num1 та num2.
     */
    public double add(@Operand("num1") double num1, @Operand("num2") double num2) {
        result = num1 + num2;
        return result;
    }

    /**
     * Метод для віднімання двох чисел.
     *
     * @param num1 Число, з якого віднімаємо.
     * @param num2 Число, яке віднімаємо.
     * @return Результат віднімання num2 від num1.
     */
    public double subtract(@Operand("num1") double num1, @Operand("num2") double num2) {
        result = num1 - num2;
        return result;
    }

    /**
     * Метод для множення двох чисел.
     *
     * @param num1 Перше число для множення.
     * @param num2 Друге число для множення.
     * @return Результат множення num1 та num2.
     */
    public double multiply(@Operand("num1") double num1, @Operand("num2") double num2) {
        result = num1 * num2;
        return result;
    }

    /**
     * Метод для ділення двох чисел.
     *
     * @param num1 Число, яке ділимо.
     * @param num2 Число, на яке ділимо.
     * @return Результат ділення num1 на num2.
     * @throws ArithmeticException Якщо num2 дорівнює 0.
     */
    public double divide(@Operand("num1") double num1, @Operand("num2") double num2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Ділення на нуль неможливе!");
        }
        result = num1 / num2;
        return result;
    }

    /**
     * Метод для отримання останнього результату операції.
     *
     * @return Останній результат операції.
     */
    public double getResult() {
        return result;
    }
}

