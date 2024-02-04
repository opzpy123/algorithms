package easy;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

public class UniqueMorseRepresentations {
    public static void main(String[] args) throws IOException {
        File path = new File("/Users/opzpy/temq");
        path.mkdirs();
        File file = new File("/Users/opzpy/temq"+File.separator+"aaa.sh");
        file.setExecutable(true);
        file.setReadable(true);
        file.setWritable(true);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("echo 'hello'");
        fileWriter.flush();
        fileWriter.close();
    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            StringBuilder str = new StringBuilder();
            for (char aChar : chars) {
                str.append(table[aChar - 'a']);
            }
            set.add(str.toString());
        }
        return set.size();
    }
}
