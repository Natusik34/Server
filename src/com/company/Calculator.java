package com.company;
import java.util.Scanner;
public class Calculator {
    public static int calculator(String num) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        String example = scanner.nextLine();
        int number = Integer.parseInt(num.trim());
            if (example == "+") {
                number = a + b;
            }
            if (example == "-") {
                number = a - b;
            }
            if (example == "*") {
                number = a * b;
            }
            if (example == "/") {
                number = a / b;
            }else if (b ==0){
                System.out.println("Error");
        }

        return number;
    }
}
