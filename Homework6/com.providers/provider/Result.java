package provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result {
    private char[] chars;
    private int data;

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        List<String> list = new ArrayList<>();
        for (char c : chars) {
            list.add(String.valueOf((char) c));
        }

        return
                "Chars: " + String.join( " ", list) + System.lineSeparator() +
                "Result: " + data ;
    }
}
