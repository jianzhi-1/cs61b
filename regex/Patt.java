import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Patt {
    public static void main(String[] args){
        String patn = “(jz\\d+)”;
        String S = “jz”;
        Matcher m = Pattern.compile(patn).matcher(S);
        System.out.println(m.matches());
        if (m.matches()){
            System.out.println(m.group(1));
        }
    }
}
        
