import java.io.Reader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReaderA {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Reader r = new FileReader("file.txt");
        int c = r.read(); // returns an int containing the char value of next character read
        while (c != -1){
            System.out.print((char)c);
            c = r.read();
        }
        System.out.println();
    }
}

