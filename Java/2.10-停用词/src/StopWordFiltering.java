import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment;
import com.hankcs.hanlp.seg.Segment;
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

    public static String replaceStopWords(final String text, final String replacement,
                                          DoubleArrayTrie<String> trie)
    {
        final StringBuilder sbOut = new StringBuilder(text.length());
        final int[] offset = new int[]{0};
        trie.parseLongestText(text, new AhoCorasickDoubleArrayTrie.IHit<String>()
        {
            @Override
            public void hit (int begin, int end, String value)
            {
                if(begin > offset[0])
                    sbOut.append(text.substring(offset[0], begin));
                sbOut.append(replacement);
                offset[0] = end;
            }
        });
        if(offset[0] < text.length())
            sbOut.append(text.substring(offset[0]));
        return sbOut.toString();
    }
    public static void main(String[] args) throws IOException {
        DoubleArrayTrie<String> trie = loadStopWordFromFile(HanLP.Config.CoreStopWordDictionaryPath);
        final String text = "停用词的意义相对而言无关紧要吧";
        HanLP.Config.ShowTermNature = false;
        Segment segment = new DoubleArrayTrieSegment();
        List<Term> termList = segment.seg(text);
        System.out.println("分词结果:" + termList);
        removeStopWords(termList, trie);
        System.out.println("分词结果去掉停用词: " + termList);
        trie = loadStopWordFromWords("的", "相对而言", "吧");
        System.out.println("不分词去掉停用词: " + replaceStopWords(text, "**", trie));

    }
}
