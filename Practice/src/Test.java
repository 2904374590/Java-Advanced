import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test {


    public static void main(String[] args) throws IOException {
        //定义文件流
        String fileName = "E:\\hello.txt";
        File file = new File(fileName);

        InputStream in=new FileInputStream(file);
        byte[] b=new byte[(int)file.length()];
        in.read(b);
        System.out.println("文件长度为："+file.length());
        in.close();
        System.out.println(new String(b));
    }
}
