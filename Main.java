import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Это калькулятор\n" +
                "Для выхода нажми q");
        String [] history = new String[5];
            history = calc();
            System.out.println("История операций:");
            for (int i = 0; i < 5; i++) {
                System.out.println(history[i]);
            }
    }
     static String [] calc () {
        Scanner sc = new Scanner(System.in);
        double arg1 = 0, arg2 = 0, rez = 0;
        String rezult ="", oper ="";
        String [] history1 = new String[5];
         Arrays.fill(history1,"Нет операции");

        for (int i = 0; i < 5; i++) {
            System.out.println("Введи первое число");
            do {
                if (sc.hasNextDouble()) {
                    arg1 = sc.nextDouble();
                    break;
                } else if (!sc.next().equals("q")) {
                    System.out.println("Это не число! Введи число или 'q' для выхода");
                } else {
                    sc.close();
                    System.out.println("Выходим");
                    return history1;
                }
            } while (true);

            while (true) {
                System.out.println("Введи оператор");

                //if (sc.hasNextLine()) {
                    oper = sc.nextLine();
                    if (oper.equals("+") || oper.equals("-") || oper.equals("/") || oper.equals("*")) {
                        break;
                    } else if (oper.equals("q")) {
                        sc.close();
                        System.out.println("Выходим");
                        return history1;
                    } else {
                        System.out.println("Это не оператор! Введи + - / * или q для выхода");
                    }
                /*} else {
                        System.out.println("Пусто!");
                        continue;
                }*/
            }

            System.out.println("Введи второе число");
            do {
                if (sc.hasNextDouble()) {
                    arg2 = sc.nextDouble();
                    if (arg2 == 0 && oper == "/") {
                        System.out.println("Делить на 0 нельзя! Введи второе число");
                    } else {
                        break;
                    }
                } else if (sc.next().charAt(0) != 'q') {
                    System.out.println("Это не число! Введи число или 'q' для выхода");
                } else {
                    sc.close();
                    System.out.println("Выходим");
                    return history1;
                }
            } while (true);


            switch (oper) {
                case "+":
                    rez = arg1 + arg2;
                    break;
                case "-":
                    rez = arg1 - arg2;
                    break;
                case "*":
                    rez = arg1 * arg2;
                    break;
                case "/":
                    rez = arg1 / arg2;
                    break;
            }
            System.out.println("Результат: " + arg1 + " " + oper + " " + arg2 + " = " + " " + rez);
            history1 [i] = i+1 + "   " + arg1 + "" + "" + oper + "" + arg2 + " = " + rez;
        }
        sc.close();
        return history1;
    }
}