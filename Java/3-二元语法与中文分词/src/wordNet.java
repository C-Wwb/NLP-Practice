import com.hankcs.hanlp.collection.trie.DoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreBiGramTableDictionary;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.other.CharType;
import com.hankcs.hanlp.seg.NShort.Path.AtomNode;
import com.hankcs.hanlp.seg.common.Vertex;
import com.hankcs.hanlp.seg.common.WordNet;

import java.util.LinkedList;
import java.util.List;

import static com.hankcs.hanlp.utility.Predefine.*;


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
    protected List<AtomNode> quickAtomSegment(char[] charArray, int start, int end)
    {
        List<AtomNode> atomNodeList = new LinkedList<AtomNode>();
        int offsetAtom = start;
        int preType = CharType.get(charArray[offsetAtom]);
        int curType;
        while (++offsetAtom < end)
        {
            curType = CharType.get(charArray[offsetAtom]);
            if (curType != preType)
            {
                //浮点数识别
                if (preType == CharType.CT_NUM && "，,.·".indexOf(charArray[offsetAtom]) != -1)
                {
                    if (offsetAtom + 1 < end)
                    {
                        int nextType = CharType.get(charArray[offsetAtom + 1]);
                        if (nextType == CharType.CT_NUM)
                        {
                            continue;
                        }
                    }
                }
                atomNodeList.add(new AtomNode(
                        new String(charArray, start, offsetAtom - start), preType));
                start = offsetAtom;
            }
            preType = curType;
        }
        if(offsetAtom == end)
            atomNodeList.add(new AtomNode(
                    new String(charArray, start, offsetAtom - start), preType));

        return atomNodeList;
    }

    /**
     *
     * @param from 前面的词
     * @param to 后面的词
     * @return 分数
     */
    public static double calculateWeight(Vertex from, Vertex to)
    {
        int frequency = from.getAttribute().totalFrequency;
        int nTwoWordsFreq = CoreBiGramTableDictionary.getBiFrequency(from.wordID, to.wordID);
        double value = -Math.log(dSmoothingPara * frequency / (MAX_FREQUENCY)
                + ((1 - dSmoothingPara) * (1 - dTemp) * nTwoWordsFreq / frequency + dTemp));
        return value;
    }
    private static List<Vertex> viterbi(WordNet wordNet)
    {
        //避免生成对象，优化速度
        LinkedList<Vertex> nodes[] = wordNet.getVertexes();
        LinkedList<Vertex> vertexList = new LinkedList<Vertex>();
        for(Vertex node : nodes[1])
        {
            node.updateFrom(nodes[0].getFirst());
        }
        for(int i = 1; i < nodes.length - 1; ++i)
        {
            LinkedList<Vertex> nodeArray = nodes[i];
            if(nodeArray == null) continue;
            for(Vertex node : nodeArray)
            {
                if(node.from == null) continue;
                for(Vertex to : nodes[i + node.realWord.length()])
                {
                    to.updateFrom(node);
                }
            }
        }
        Vertex from = nodes[nodes.length - 1].getFirst();
        while(from != null)
        {
            vertexList.add(from);
            from = from.from;
        }
        return vertexList;
    }
}