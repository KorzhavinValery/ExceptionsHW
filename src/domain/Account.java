package domain;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class Account {
    public static void checkLogin(String login) throws WrongLoginException {
        if(login.length() >= 20){
            throw new WrongLoginException("Ошибка! \nПревышена длина логина.");
        }

        CharacterIterator symbol = new StringCharacterIterator(login);
        while (symbol.current() != CharacterIterator.DONE)
        {
            if(symbol.current() < '0' | symbol.current() > '9' & symbol.current() < 'A' |
                    symbol.current() > 'Z' & symbol.current() < 'a' & symbol.current() != '_' | symbol.current() > 'z'){
                throw new WrongLoginException();
            }
            symbol.next();
        }
    }
    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException{

        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Ошибка! \nПароли не одинаковые.");
        }

        if(password.length() >= 20){
            throw new WrongPasswordException("Ошибка! \nПревышена длина пароля.");
        }

        char[] character = password.toCharArray();
        for (char sign: character) {
            if(sign < '0' | sign > '9' & sign < 'A' |
                    sign > 'Z' & sign < 'a' & sign != '_' | sign > 'z'){
                throw new WrongPasswordException();
            }
        }

    }
}
