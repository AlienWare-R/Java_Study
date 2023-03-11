package Base.My_Study.File;
import java.io.*;
import java.util.stream.IntStream;
import java.io.FileInputStream;


public class my_File {
    public static void main(String[] args) throws IOException {
        System.out.println("***************");
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath()); // 打印绝对路径
        System.out.println(f.getCanonicalPath()); // 打印规范路径
        File f1 = new File("IO.txt");
        if (f1.createNewFile()) {
            System.out.println("The New File IO.txt success to crate");
            if (f1.delete()) {
                System.out.println("The File delete success");
            }
        }
        System.out.println(f1.getAbsolutePath());
    }
} //这一行应该也要注释

   /* public void readFile() throws IOException {
        IntStream input = null;
        try {
            input = new FileInputStream("IO.txt");
            int n;
            while ((n = input.read()) != -1) {
                System.out.println(n);
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}*/

