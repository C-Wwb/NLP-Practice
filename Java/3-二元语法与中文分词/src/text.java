import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.Segment;

public class text
{
    public static void main(String[] args)
    {
        Segment segment = new DijkstraSegment();
        final String sentence = "我宝贝是臭猪";
        segment.enableCustomDictionary(false);
        System.out.println("不挂载词典: " + segment.seg(sentence));
        CustomDictionary.insert("臭猪", "nz 100");
        segment.enableCustomDictionary(true);
        System.out.println("低优先级词典: " + segment.seg(sentence));
        segment.enableCustomDictionaryForcing(true);
        System.out.println("高优先级词典: " + segment.seg(sentence));
    }
}
