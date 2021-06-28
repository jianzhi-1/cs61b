import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Main {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
            //br = new BufferedReader(new FileReader("input.txt"));
        }
 
        String next(){
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt(){return Integer.parseInt(next());}
 
        long nextLong(){return Long.parseLong(next());}
 
        double nextDouble(){return Double.parseDouble(next());}
 
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
 
    public static void main(String[] args)
    {
        FastReader s = new FastReader();
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        int n = s.nextInt();
        for (int i = 0; i < n; i++){
            String x = s.next();
            System.out.println(x);
        }
        System.out.println(n);
        //pw.println(x);
        //pw.close();
    }
}
