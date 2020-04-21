import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.seg.common.Term;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeMap;

public class StopWordFiltering
{
    /**
     *
     * @param path 词典路径
     * @return 双数组字典树
     * @throws IOException
     */
    static DoubleArrayTrie<String> loadStopWordFromFile(String path) throws IOException
    {
        TreeMap<String, String> map = new TreeMap<String, String>();
        IOUtil.LineIterator lineIterator = new IOUtil.LineIterator(path);
        for(String word : lineIterator)
        {
            map.put(word, word);
        }
        return new DoubleArrayTrie<String>(map);
    }

    /**
     *
     * @param words 停用词数组
     * @return 双数组字典树
     * @throws IOException
     */
    static DoubleArrayTrie<String> loadStopWordFromWords(String... words) throws IOException
    {
        TreeMap<String, String> map = new TreeMap<String, String>();
        for(String word : words)
        {
            map.put(word, word);
        }
        return new DoubleArrayTrie<String>(map);
    }

    /**
     * 去除粉刺结果中的停用词
     * @param termList 分词结果
     * @param trie 停用词词典
     */
    public static void removeStopWords(List<Term> termList, DoubleArrayTrie<String> trie)
    {

        ListIterator<Term> listIterator = termList.listIterator();
        while (listIterator.hasNext())
            if(trie.containsKey(listIterator.next().word))
                listIterator.remove();
    }
}
