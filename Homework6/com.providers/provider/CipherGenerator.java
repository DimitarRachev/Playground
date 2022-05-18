package provider;

import cipher.Cipherable;

import java.util.HashSet;
import java.util.Set;

public class CipherGenerator {

    public static Result countDistinct(Cipherable cipher, int seed){
        Result result = new Result();
        Set<Character> count = new HashSet<>();

        char[] chars = cipher.getSecretChars(seed);
        for (char c : chars) {
            count.add(c);
        }

        result.setChars(chars);
        result.setData(count.size());
        return result;
    };
}
