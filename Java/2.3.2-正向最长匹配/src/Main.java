import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main
{
    public static List<String> segmentForwardLongest(String text, Map<String,
            CoreDictionary.Attribute> dictionary)
    {
        List<String> wordList = new LinkedList<String>();
        for(int i = 0; i < text.length(); )
        {
            String longestWord = text.substring(i, i + 1);//储存以当前位置开头的最长单词
            // 然后在当前位置扫描结束后将其加入结果中
            for(int j = i + 1; j <= text.length(); ++j)
            {
                String word = text.substring(i, j);
                if(dictionary.containsKey(word))
                {
                    if(word.length() > longestWord.length())
                    {
                        longestWord = word;
                    }
                }
            }
            wordList.add(longestWord);
            i += longestWord.length();
        }
        return wordList;
    }
}
