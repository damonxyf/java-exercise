import java.util.Scanner;

public class LatinPig {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个单词：");
        String word = scanner.next();
        scanner.close();
        char[] vowels = {'a','e','i','o','u'};
        StringBuffer latinPigWord = new StringBuffer();
        StringBuffer oldWord = new StringBuffer();
        for (int i = 0; i < word.length() ;i++) {
            char character = word.charAt(i);
            latinPigWord.append(character);
        }
        for (int i = 0; i < word.length() ;i++) {
                char character = word.charAt(i);
                int a = 0 ;
                boolean b = true;
            for (int j = 0; j < 5; j++) {
                if (character != vowels[j] && b == true){
                    a = a + 1;
                }
                if (a == 5){
                    b = false;
                    latinPigWord.delete( i , i + 1);
                    latinPigWord.append("-" + character + "ay");
                    break;
                }
            }
            if (b == false){
                break;
            }

        }
        System.out.println("拉丁猪文字：" + latinPigWord);
    }

}

