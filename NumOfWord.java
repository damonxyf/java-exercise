import java.io.*;

public class NumOfWord {
     public static void main(String[] args){
         int count = 0;
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印， 也可以throw

            /*  读入TXT文件 */
            String pathname = "C://test.txt"; //绝对路径或相对路径都可以，这里是绝对路径
            File filename = new File(pathname); //读取以上路径的test.txt文件
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); //建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); //建立一个对象， 它把文件内容转换成计算机能读懂的语言
            String line = "";
            while (line != null){
                line = br.readLine(); // 一次读入一行数据
                if (line != null){
                    System.out.println(line);
                }
                for(int i = 0; i < line.length(); i++){
                    if (line.charAt(i) != ' ' && line.charAt(i) != ','&& line.charAt(i) != '.' && line.charAt(i) != '?' && line.charAt(i) != '!' && line.charAt(i) != ';' && line.charAt(i) != ':'&& line.charAt(i) != '"'&& line.charAt(i) != '"'){
                        count++;
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(count);
     }
}
