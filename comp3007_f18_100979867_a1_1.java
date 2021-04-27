/**
 * Coded by Michal Debicki
 * 100979867
 */

import java.util.ArrayList;
import java.util.Scanner;

public class comp3007_f18_100979867_a1_1 {

    public static char convertToLower(char k){

        if(k > 64 && k < 91) {
            k += 32;
        }

        return k;
    }

    public static char convertToUpper(char k){

        if(k > 96 && k < 124) {
            k -= 32;
        }

        return k;
    }

    public static String fixCaseOfString(String input){

        char fixedCase;

        if(input.length() == 1){
            return convertToUpper((input.charAt(0))) + "";
        }
        else{
            fixedCase = convertToLower(input.charAt(input.length() - 1));
            return fixCaseOfString(input.substring(0, input.length() - 1)) + fixedCase;

        }
    }

    public static String camelCaseSentence(ArrayList<String> sentence){
        String fixedWord;
        if(sentence.size() == 1){
            fixedWord = fixCaseOfString(sentence.get(0));
            return convertToLower(fixedWord.charAt(0)) + fixedWord.substring(1,fixedWord.length());
        }
        else{
            fixedWord = fixCaseOfString(sentence.get(sentence.size() - 1));
            sentence.remove(sentence.size() - 1);
            return camelCaseSentence(sentence) + fixedWord;
        }
    }

    public static String onlyCapitalLetters(String input){

        String newWord;
        if(input.length() > 1) {
            if (input.charAt(input.length() - 1) == convertToUpper(input.charAt(input.length() - 1))) {
                newWord = input.charAt(input.length() - 1) + "";
                return onlyCapitalLetters(input.substring(0, input.length() - 1)) + newWord;
            } else {
                return onlyCapitalLetters(input.substring(0, input.length() - 1));
            }
        }
        else if(input.charAt(0) == convertToUpper(input.charAt(0))){
            return input.charAt(0) + "";
        }
        return "";
    }

    public static boolean menu(){
        System.out.println("Please enter a sentence separated by spaces");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine() + " ";

        String word = "";
        ArrayList<String> sentence = new ArrayList<String>();
        for(int i = 0; i < input.length(); i += 1){
            if(input.charAt(i) != ' '){
                word = word + input.charAt(i);
            }
            else{
                if(word != "") {
                    sentence.add(word);
                }
                word = "";
            }
        }

        System.out.println(camelCaseSentence(sentence));

        System.out.println("If you would like to convert another Sentence please enter y");
        System.out.println("Otherwise please enter anything else to Quit");

        String answer = keyboard.next();
        if(convertToLower(answer.charAt(0)) == 'y'){
            return true;
        }
        else {
            return false;
        }

    }


    public static void main(String[] args){
        boolean progRunning = true;
        while(progRunning == true){
            progRunning = menu();
        }
        System.out.println("Done");



    }

}
