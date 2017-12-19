class Person{
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void tell(){
        System.out.println("姓名：" + getName());
        System.out.println("年龄：" + getAge());
    }

    public Person() {
        System.out.println("父类的构造方法" );
    }
    public void run(){
        System.out.println("父类的方法");
    }
}

class Student extends Person{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void tell1(){
        System.out.println("成绩：" + getScore());
    }
    public Student(){
        System.out.println("子类的构造方法");
    }
    public void run(){
        super.run();
        System.out.println("子类重写了父类的方法");
    }

}

public class extendsDemo {
   public static void main(String[] args){
       Student s = new Student();
       s.setScore(100);
       s.setAge(23);
       s.setName("Damon");
       s.tell();
       s.tell1();
       s.run();
   }
}


