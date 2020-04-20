import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.corpus.io.IOUtil;

import java.io.IOException;
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
}
