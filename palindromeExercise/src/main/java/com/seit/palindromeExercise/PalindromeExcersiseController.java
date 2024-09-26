package com.seit.palindromeExercise;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Controlador para verificar palíndromos.
 */
@RestController
public class PalindromeExcersiseController {

    /**
     * Endpoint para verificar si una palabra es un palíndromo.
     * @param text la palabra a verificar.
     * @return un mensaje  que indica si la palabra es palídromo o no.
     */
    @GetMapping("/palindrome/{text}")
    public String palindromeWorld(@PathVariable String text){

        String message =text;

       //boolean isPalindrome = validateWord(text);
       boolean isPalindrome = isPalindrome(text);

        if(isPalindrome){
            message +=" is a world palindrome";
        }else{

            message +=" is not a world palindrome";
        }
        return message;
    }

    /**
     *
     * @param text
     * @return
     */
    public boolean validateWord(String text){
        char[] cadence = text.toCharArray();
        int sizeMessage = cadence.length;
        ArrayList<String> leftArray= new ArrayList<>();
        ArrayList<String> rightArray= new ArrayList<>();
        int count=sizeMessage-1;
        for (int i=0;i<sizeMessage;i++){
            leftArray.add(String.valueOf(cadence[i]));
            rightArray.add(String.valueOf(cadence[count]));
            System.out.println("i " +i);
            count--;
        }

        return leftArray.toString().equals(rightArray.toString());


    }

    /**
     * 
     * @param world
     * @return
     */
    private boolean isPalindrome(String world){

        int length = world.length();
        for (int i=0; i<length / 2;i++){
            if(world.charAt(i)!= world.charAt(length-i-1)){
                return false;
            }
        }

        return true;
    }
}
