package step3;

import java.io.*;

public class Input {

    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static Character getCharacter(String prompt) {
        Character value;
        System.out.print(prompt);
        try {
            value = Input.input.readLine().charAt(0);
        } catch (Exception error) {
            // error condition
            value = null;
        }
        return value;
    }

    public static Double getDouble(String prompt) {
        Double value;
        System.out.print(prompt);
        try {
            value = Double.parseDouble(Input.input.readLine());
        } catch (Exception error) {
            // error condition
            throw new NumberFormatException();
        }
        return value;
    }

    public static Integer getInteger(String prompt) {
        Integer value;
        System.out.print(prompt);
        try {
            value = Integer.parseInt(Input.input.readLine());
        } catch (Exception error) {
            // error condition
            throw new NumberFormatException();
        }
        return value;
    }

    public static String getString(String prompt) throws Exception {
        String string;
        System.out.print(prompt);
        try {
            string = Input.input.readLine();
            if(string.length()==0 || containsNumberDigit(string)){
                return getString(prompt);
            }
        } catch (Exception error) {
            // error condition
            string = null;
        }
        return string;
    }

    public static String getRegNo(String prompt){
        String string;
        System.out.println(prompt);
        try {
            string = Input.input.readLine();
            if(string.length()==0 || !correctRegNo(string)){
                return getRegNo(prompt);
            }

        } catch (Exception error) {
            // error condition
            string = null;
            return getRegNo(prompt);
        }
        return string;
    }

    public static boolean correctRegNo(String string){
        for(int i = 0; i< string.length();i++){
            if(Character.isDigit(string.charAt(2))&&Character.isDigit(string.charAt(3))&&Character.isWhitespace(string.charAt(4))){
                return true;
            }

        }
        return false;
    }


    public static boolean containsNumberDigit(String string){
        for(int i = 0; i< string.length();i++){
            if(Character.isDigit(string.charAt(i))){
                return true;
            }

        }
        return false;
    }


}
