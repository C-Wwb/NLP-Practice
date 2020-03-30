import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.List;
import java.util.TreeMap;

/**
 *
 * wordList 分词结果
 * return 单字数量
 */
public class Main
{
    public static int countSingleChar(List<String> wordList)
    {//
        int size = 0;
        for(String word : wordList)
        {
            if(word.length() == 1)
            {
                ++size;
            }
        }
        return size;
    }
    public static List<String> segmentBidirectional (String text, TreeMap<String,
            CoreDictionary.Attribute> dictionary)
    {
        List<String> forwardLongest = segmentForwardLongest.segmentForwardLongest(text, dictionary);
        List<String> backwardLongest = segmentBackwardLongest.segmentBackLongest(text, dictionary);
        if(forwardLongest.size() < backwardLongest.size())
        {
            return forwardLongest;
        }
        else if(forwardLongest.size() > backwardLongest.size())
        {
            return backwardLongest;
        }
        else
        {
            if(countSingleChar(forwardLongest) < countSingleChar(backwardLongest))
            {
                return forwardLongest;
            }
            else
            {
                return backwardLongest;
            }
        }
    }
}
