import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.Iterator;
import java.util.TreeMap;

public class TheEffectOfWordLengthOnMatchingSpeed
{//限制字典中词语的长度
    public static void main(String[] args){//读取词典

    }
    public static TreeMap<String, CoreDictionary.Attribute> loadDictionary(int minLength) throws IOException
    {
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        Iterator<String> iterator = dictionary.keySet().iterator();
        while(iterator.hasNext())
        {
            if(iterator.next().length() < minLength)
                iterator.remove();
        }
        return dictionary;
    }
}
