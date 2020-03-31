import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class segmentBackwardLongest
{
    public static List<String> segmentBackLongest(String text, Map<String,
            CoreDictionary.Attribute> dictionary)
    {
        List<String> wordList = new LinkedList<String>();
        for(int i = text.length() - 1; i >= 0; )
        {
            String longestWord = text.substring(i, i + 1);//储存以当前位置开头的最长单词
            // 然后在当前位置扫描结束后将其加入结果中
            for(int j = 0; j <= i; ++j)
            {
                String word = text.substring(j, i + 1);
                if(dictionary.containsKey(word))
                {
                    if(word.length() > longestWord.length())
                    {
                        longestWord = word;
                    }
                }
            }
            wordList.add(0, longestWord);
            i -= longestWord.length();
        }
        return wordList;
    }
}
