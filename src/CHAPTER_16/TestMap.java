package CHAPTER_16;

import java.util.HashMap;

public class TestMap {
    public void go() {
        HashMap<String, Integer> scores = new HashMap<String, Integer>();

        scores.put("Kathy", 42);
        scores.put("Bert", 343);
        scores.put("Skyler", 420);

        System.out.println(scores);
        System.out.println(scores.get("Bert"));
    }
}
