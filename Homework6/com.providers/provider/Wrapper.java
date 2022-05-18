package provider;

import cipher.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size) {
        this.size = size;
    }

    public Wrapper() {
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    //Name should be makeFixedSelection() ?
    public Cipherable makeFixedRandom() {
        FixedSelection selection = new FixedSelection();
        selection.setArrSize(this.size);
        return selection;
    }

    //Name should be makeFixedRandom() ?
    public Cipherable makeFixeSelection() {
        FixedRandom fixedRandom = new FixedRandom();
        fixedRandom.setArrSize(this.size);
        return fixedRandom;
    }

    private class FixedRandom implements Cipherable {
        int arrSize;

        @Override
        public char[] getSecretChars(int seed) {

            //Removed the seed, to simulate random result every time
            //I'm pretty sure something else has to be done here
            Random random = new Random();

            char[] result = new char[arrSize];
            for (int i = 0; i < result.length; i++) {
                result[i] = (char) (random.nextInt(26) + 65);
            }

            return result;
        }


        public void setArrSize(int size) {
            arrSize = size;
        }
    }

    private class FixedSelection implements Cipherable {
        int arrSize;

        public void setArrSize(int arrSize) {
            this.arrSize = arrSize;
        }

        // Result is always the same for same seed
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random(seed);

            char[] result = new char[arrSize];
            for (int i = 0; i < result.length; i++) {
                result[i] = (char) (random.nextInt(26) + 65);
            }

            return result;
        }
    }
}
