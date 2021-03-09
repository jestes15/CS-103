import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class programmingAssign2 {
    public static HashMap<String, Integer> Q1(Reader fileObj) throws IOException {
        HashMap<String, Integer> mainHash = new HashMap<>();
        BufferedReader bufferdFileObj = new BufferedReader(fileObj);
        String main = bufferdFileObj.readLine();
        // String main = "James while John had had great had had had had had had had had had a better effect on the teacher.";
        ArrayList<String> mainArrayList = new ArrayList<>(Arrays.asList(main.split(" ")));

        for (String word : mainArrayList) {
            if (mainHash.containsKey(word)) {
                int val = mainHash.get(word);
                val++;
                mainHash.replace(word, val);
            }
            else {
                mainHash.put(word, 1);
            }
        }
        return mainHash;
    }
}
