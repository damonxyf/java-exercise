public class classDemo {
    int temp = 10;

    public static void tell(classDemo r2){
        r2.temp = 20;
    }

    public static void main(String[] args){
        classDemo r1 = new classDemo();
        System.out.println(r1.temp);
        tell(r1);
        System.out.println(r1.temp);
    }
}

class Rf1 {
     public static void main(String[] args){
         String n1 = "引用";
         System.out.println(n1);
         tell1(n1);
         System.out.println(n1);
     }
    public static void tell1(String n2){
         n2 = "引用传递";
    }
}

class Rf2 {
    public static void main(String[] args){
        int n1 = 1;
        System.out.println(n1);
        tell1(n1);
        System.out.println(n1);
    }
    public static void tell1(int n2){
        n2 = 2 ;
    }
}


 class Rf3 {
    String temp = "引用";
    public static void tell(Rf3 r2){
        r2.temp = "引用传递";
    }

    public static void main(String[] args){
        Rf3 r1 = new Rf3();
        System.out.println(r1.temp);
        tell(r1);
        System.out.println(r1.temp);
    }
}

