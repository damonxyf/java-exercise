import java.util.Scanner;

public class test1 {
    public static void main (String[] args){
        int i = 0x1000001;
        float f = i;
        System.out.println(Integer.toBinaryString(i) + ":" + i);
        System.out.println(Integer.toBinaryString((int)f) +  ":" + f);
        long j = 0x20000000000001l;
        double d = j;
        System.out.println(Long.toBinaryString(j) + ":" + j);
        System.out.println(Long.toBinaryString((long) d) + ":" + d);
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a + b);
        Scanner scanner = new Scanner(System.in);
        System.out.println("姓名：");
        String name = scanner.next();
        System.out.println(name);
        System.out.println("性别：");
        char sex = scanner.next().charAt(0);
        System.out.println(sex);
        System.out.println("年龄：");
        int age = scanner.nextInt();
        System.out.println(age);
        System.out.println("身高：");
        int height = scanner.nextInt();
        System.out.println(height);
        System.out.println("性格：");
        String type = scanner.next();
        System.out.println(type);
    }

}
