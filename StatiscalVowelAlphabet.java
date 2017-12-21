import java.util.Scanner;

public class StatiscalVowelAlphabet {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String word = scanner.next();
        scanner.close();
        char[] vowels = {'a','e','i','o','u'};
        int nums = 0;
        int aNums = 0;
        int eNums = 0;
        int iNums = 0;
        int oNums = 0;
        int uNums = 0;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            for (int j = 0; j < vowels.length; j++){
                char vowel;
                if(character == vowels[j]){
                    nums = nums + 1;
                    vowel = character;
                    switch (vowel)
                    {
                        case('a'):aNums++;break;
                        case('e'):eNums++;break;
                        case('i'):iNums++;break;
                        case('o'):oNums++;break;
                        case('u'):uNums++;break;

                    }
                }
            }
        }
        System.out.println("元音字母的总个数：" + nums);
        System.out.println("元音字母a的个数：" + aNums);
        System.out.println("元音字母e的个数：" + eNums);
        System.out.println("元音字母i的个数：" + iNums);
        System.out.println("元音字母o的个数：" + oNums);
        System.out.println("元音字母u的个数：" + uNums);
    }
}
