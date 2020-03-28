import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Main
{
    public static List<String> segmentFully(String text, TreeMap<String, CoreDictionary.Attribute> dictionary)
    {
        List<String> wordList = new LinkedList<String>();
        for(int i = 0; i < text.length(); ++i)
        {
            for(int j = i + 1; j <= text.length(); ++j)
            {
                String word = text.substring(i, j);
                if(dictionary.containsKey(word))
                    wordList.add(word);
            }
        }
        return wordList;
    }

}
