import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.*;

public class text
{
    public static void main(String[] args) throws IOException {
        // 加载词典
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        final BinTrie<CoreDictionary.Attribute> binTrie = new BinTrie<CoreDictionary.Attribute>(dictionary);//构建binTrie
        String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
        long start;
        double costTime;
        final int pressure = 10000;

        System.out.println("完全切分");
        start = System.currentTimeMillis();
        for (int i = 0; i < pressure; ++i)
        {
            segmentFully(text, binTrie);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);
    }
    public static List<String> segmentFully(final String text, BinTrie<CoreDictionary.Attribute> dictionary)
    {
        final List<String> wordList = new LinkedList<String>();
        dictionary.parseText(text, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>()
        {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value)
            {
                wordList.add(text.substring(begin, end));
            }
        });
        return wordList;
    }
}
