package provider;

import cipher.Cipherable;

//Main class is only for testing, should not be included in the solution
public class Main {
    public static void main(String[] args) {
        //Hardcoded 15 for testing, change the value for different result
        Wrapper wrapper = new Wrapper(15);

        Cipherable cipher = wrapper.makeFixedRandom();
        //Hardcoded 5 for testing, change the value for different result
        Result result = CipherGenerator.countDistinct(cipher, 5);
        System.out.println(result);

        System.out.println();

        Cipherable cipher1 = wrapper.makeFixeSelection();
        //Hardcoded 5 for testing, change the value for different result
        Result result1 = CipherGenerator.countDistinct(cipher1, 5);
        System.out.println(result1);
    }
}
