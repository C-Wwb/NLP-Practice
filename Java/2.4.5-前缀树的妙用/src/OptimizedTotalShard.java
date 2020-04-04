import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.LinkedList;
import java.util.List;

public class OptimizedTotalShard
{
    public static List<String> segmentFully(final String text, BinTrie<CoreDictionary.Attribute> dictionary)
    {
        final List<String> wordList = new LinkedList<String>();
        dictionary.parseText(text, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
            @Override
            public void hit(int begin, int end, CoreDictionary.Attribute value) {
                wordList.add(text.substring(begin, end));
            }
        });
        return wordList;
    }
}

