public class SpeedTest {
    public static void main(String[] args){
        AList<Integer> L = new AList<Integer>();
        int i = 0;
        while (i < 10000000){
            L.addLast(i);
            i++;
        }
        System.out.println("DONE");
        System.out.println(1/2);
    }
}
