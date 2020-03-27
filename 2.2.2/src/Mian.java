import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.TreeMap;

public class Mian
{
    public static void main(String[] args) throws IOException {//读取词典
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        System.out.printf("词典大小: %d个词条\n", dictionary.size());
        System.out.println(dictionary.keySet().iterator().next());
    }
}
