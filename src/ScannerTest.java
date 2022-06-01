import java.util.ArrayList;
import java.util.List;

public class ScannerTest {
    public static void main(String[] args) {

        //Choose hardcoded input line here
        List<String> test = getCommandTokens("/append \"m1\" \"Test station 1\"");
//        List<String> test = getCommandTokens("/append m1 Renes-Gare");
//        List<String> test = getCommandTokens("/connect Hammersmith-and-City Hammersmith Metro-Railway \"Edgver road\"");
        System.out.println();
    }

    private static List<String> getCommandTokens(String command) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean hasFoundQuotes = false;
        for (char c : command.toCharArray()) {
            if (c == '"' && !hasFoundQuotes) {
                hasFoundQuotes = true;
            } else if (c == '"' && hasFoundQuotes) {
                result.add(sb.toString());
                sb.setLength(0);
                hasFoundQuotes = false;
            } else if (c == ' ' && !hasFoundQuotes && sb.length() > 0) {
                result.add(sb.toString());
                sb.setLength(0);
            } else if (c == ' ' && !hasFoundQuotes && sb.length() == 0) {
                // if true just continue with next symbol
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0) {
            result.add(sb.toString());
        }


        return result;
    }
}
