import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.seg.common.Vertex;
import com.hankcs.hanlp.seg.common.WordNet;

import java.util.LinkedList;

import static com.hankcs.hanlp.seg.Segment.quickAtomSegment;

/**
 * 生成一元词网
 *
 */
public class wordNet
{
    protected void generateWordNet(final WordNet wordNetStorage)
    {
        final char[] charArray = wordNetStorage.charArray;
        //核心词查询
        DoubleArrayTrie<CoreDictionary.Attribute>.Searcher searcher
                = CoreDictionary.trie.getSearcher(charArray, 0);
        while (searcher.next())
        {
            wordNetStorage.add(searcher.begin + 1,
                    new Vertex(new String(charArray, searcher.begin, searcher.length)
                            , searcher.value, searcher.index));
        }
        //原子分词，保证图连通
        LinkedList<Vertex>[] vertexes = wordNetStorage.getVertexes();
        for(int i = 1; i < vertexes.length; )
        {
            if(vertexes[i].isEmpty())
            {
                int j = i + 1;
                for(; j < vertexes.length- 1; ++j)
                {
                    if(!vertexes[j].isEmpty())
                        break;
                }
                wordNetStorage.add(i, quickAtomSegment(charArray, i - 1, j - 1));
                i = j;
            }
            else i += vertexes[i].getLast().realWord.length();
        }
    }
}