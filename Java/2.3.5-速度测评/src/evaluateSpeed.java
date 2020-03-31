import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.util.TreeMap;

public class evaluateSpeed
{
    public static void evaluateSpeed(TreeMap<String, CoreDictionary.Attribute> dictionary)
    {
        String text = "我和阿杜在2019年10月18日在一起了，那天晚上很开心";
        long start;
        double costTime;
        final int pressure = 10000;

        start = System.currentTimeMillis();
        for(int i = 0; i < pressure; ++i)
        {
            segmentForwardLongest.segmentForwardLongest(text, dictionary);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("正向最长匹配：%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);

        start = System.currentTimeMillis();
        for(int i = 0; i < pressure; ++i)
        {
            segmentBackwardLongest.segmentBackLongest(text, dictionary);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("逆向最长匹配：%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);

        start = System.currentTimeMillis();
        for(int i = 0; i < pressure; ++i)
        {
            segmentBidirectional.segmentBidirectional(text, dictionary);
        }
        costTime = (System.currentTimeMillis() - start) / (double) 1000;
        System.out.printf("双向最长匹配：%.2f万字/秒\n", text.length() * pressure / 10000 / costTime);
    }
}
