import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReaderB {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Reader r = new FileReader("file.txt");
        char[] charr = new char[128];
        int c = r.read(charr, 0, charr.length);
        while (c != -1){
            System.out.println(new String(charr, 0, c));
            c = r.read(charr, 0, charr.length);
        }
    }
}

