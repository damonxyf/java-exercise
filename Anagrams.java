import java.util.Scanner;

public class Anagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String word = scanner.next();
        scanner.close();
        StringBuffer reverseWord = new StringBuffer();
        for(int i = 0; i < word.length(); i++){
            char character = word.charAt(i);
            reverseWord.append(character);
        }
        reverseWord.reverse();
        System.out.println(reverseWord);
        boolean a = false;
        System.out.println("字符串：" + word + "是否为回文？");
        if(word.equals(reverseWord.toString())){
            System.out.println("是回文");
        }else{
            System.out.println("不是回文");
        }
    }
}
