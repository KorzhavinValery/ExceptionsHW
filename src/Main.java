import domain.Account;
import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        try {
            Account.checkLogin(login);
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());;
        }
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        System.out.println("Повторите заданный пароль: ");
        String confirmPassword = scanner.nextLine();
        try {
            Account.checkPasswords(password, confirmPassword);

        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}