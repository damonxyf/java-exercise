import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lines = scanner.next();
        scanner.close();
        System.out.println("逆转前：" + lines);
        String reverseLines = " ";
        for(int i = 0; i < lines.length() ; i++){
            char line = lines.charAt(lines.length() - 1 - i );
            System.out.println(line);
            reverseLines += line;
        }
        System.out.println("逆转后：" + reverseLines);
    }
}
