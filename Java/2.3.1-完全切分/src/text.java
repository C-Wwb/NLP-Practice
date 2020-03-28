import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.TreeMap;

public class text
{
    public static void main(String[] args) throws IOException {//读取词典
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        System.out.println(Main.segmentFully("我和杜玉洁就读于北京信息科技大学", dictionary));

    }
}
//text 待分词的文本
//dictionary 词典，一定要先加载词典
//return 单词列表