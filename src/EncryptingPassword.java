import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EncryptingPassword {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile("^(.+)>(?<first>[\\d]{3})\\|(?<second>[a-z]{3})\\|(?<third>[A-Z]{3})\\|(?<fourth>[^<>]{3})<\\1$");
        while (n-- > 0){
            String toValidate = scanner.nextLine();
            Matcher matcher = pattern.matcher(toValidate);
            if (matcher.find()) {
                System.out.println("Password:");
                System.out.println(matcher.group("first") + matcher.group("second") + matcher.group("third") + matcher.group("fourth"));
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}
