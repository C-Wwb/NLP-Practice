import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.TreeMap;

public class text
{
    public static void main(String[] args) throws IOException {//读取词典
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        System.out.println(Main.segmentForwardLongest("研究生命起源", dictionary));

    }
}
