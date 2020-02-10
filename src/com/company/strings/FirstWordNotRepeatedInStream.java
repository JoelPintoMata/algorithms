package com.company.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * QUESTION  A
 * Coding exercise:
 * Find the first word in a stream in which it is not repeated in the rest of the stream.
 * Please note that you are being provided a stream as a source for the characters.
 * The stream is guaranteed to eventually terminate (i.e. return false from a call to the hasNext() method), though it could be very long.
 * You will access this stream through the provided interface methods.
 * A call to hasNext() will return whether the stream contains any more characters to process.
 * A call to getNext() will return the next character to be processed in the stream.
 * It is not possible to restart the stream.
 * <p>
 * Example:
 * Input:  The angry dog was red. And the cat was also angry.
 * Output: dog
 * In this example, the word ‘dog’ is the first word in the stream in which it is not repeated in the stream.
 * <p>
 * Use one of the following skeletons for your solution:
 */
public class FirstWordNotRepeatedInStream {

    public static void main(String[] args) {
        String input = new String("The angry dog was red. And the cat was also angry.");
        Stream stream = new StreamImpl(input);

        System.out.println(QuestionA.firstWord(stream));
    }

    public interface Stream {
        char getNext();

        boolean hasNext();
    }

    private static class StreamImpl implements Stream {
        private final String input;
        private int currentIndex;

        public StreamImpl(String input) {
            this.input = input;
            this.currentIndex = 0;
        }

        @Override
        public char getNext() {
            return input.charAt(currentIndex++);
        }

        @Override
        public boolean hasNext() {
            return currentIndex <= input.length() - 1;
        }
    }

    public static class QuestionA {
        public static String firstWord(final Stream input) {
            Set<String> stringSet = new HashSet<>();
            List<String> stringUniqueList = new ArrayList<>();
            String word = new String();
            do {
                char inputChar = input.getNext();
                if (inputChar == '.' || inputChar == ' ') {
                    word = word.toLowerCase();
//                    process this word
                    if (stringSet.contains(word)) {
                        stringUniqueList.remove(word);
                    } else {
                        stringUniqueList.add(word);
                    }
                    stringSet.add(word);
                    word = new String();
                    continue;
                }
                word = word + inputChar;
            } while (input.hasNext());
            return stringUniqueList.get(0);
        }
    }
}