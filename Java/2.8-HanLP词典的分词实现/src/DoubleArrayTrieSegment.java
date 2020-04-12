import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.common.Term;

import java.io.IOException;

public class DoubleArrayTrieSegment
{
    public static void main(String[] args) throws IOException {
        HanLP.Config.ShowTermNature = false; //分词结果不显示词性
        com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment segment = new com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment();
        System.out.println(segment.seg("江西鄱阳湖干枯，中国最大淡水湖变成大草原"));

        String dict1 = "Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt";
        String dict2 = "Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/custom/上海地名.txt ns";
        segment = new com.hankcs.hanlp.seg.Other.DoubleArrayTrieSegment(dict1, dict2);
        System.out.println(segment.seg("上海市虹口区大连西路550号SISU, 北京市海淀区上庄镇"));
        //传入自己的词典路径，传入路径参数
        //以上数字和英文都被拆开，不符合实际要求

        segment.enablePartOfSpeechTagging(true); //激活数字和英文识别
        HanLP.Config.ShowTermNature = true; //分词结果显示词性
        System.out.println(segment.seg("上海市虹口区大连西路550号SISU, 北京市海淀区上庄镇"));

        for(Term term : segment.seg("上海市虹口区大连西路550号SISU"))
        {
            System.out.printf("单词:%s 词性:%s\n", term.word, term.nature);//分别获取分词结果中的词语与词性
        }
    }
}
