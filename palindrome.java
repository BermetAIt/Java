public class Palindrome {

    public static void main(String[] args) {
    
        String input = "А роза упала на лапу Азора";

        System.out.println("Проверяем строку: " + input);

        if (isPalindrome(input)) {
            System.out.println("Это палиндром!");
        } else {
            System.out.println("Это не палиндром.");
        }
    }

    public static boolean isPalindrome(String str) {
    
        String cleanString = ""; // 

    
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                cleanString += Character.toLowerCase(ch); 
            }
        }

        
        int left = 0;
        int right = cleanString.length() - 1;

        while (left < right) {
            if (cleanString.charAt(left) != cleanString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
