import com.hankcs.hanlp.corpus.dictionary.NatureDictionaryMaker;
import com.hankcs.hanlp.corpus.document.CorpusLoader;
import com.hankcs.hanlp.corpus.document.sentence.word.IWord;

import java.util.List;

public class LoadCorpus
{
    public static String MY_CWS_CORPUS_PATH = "Y:/NLP/Hanlp/corpus/my_cws_corpus.txt";
    public static String MY_CWS_MODEL_PATH = "Y:/NLP/Hanlp/model/my_cws_model.txt";
    public static void main(String[] args)
    {
        List<List<IWord>> sentenceList = CorpusLoader.convert2SentenceList(MY_CWS_CORPUS_PATH);//语料库地址
        for (List<IWord> sentence : sentenceList)
        {
            System.out.println(sentence);
//            for (IWord word : sentence)
//            {
//                System.out.println(word);
//            }
//            System.out.println();
        }
    }

    /**
     * 训练二元语法模型
     *
     * @param corpusPath 语料库路径
     * @param modelPath 模型保存路径
     */
    public static void trainBigram(String corpusPath, String modelPath)
    {
        List<List<IWord>> sentenceList = CorpusLoader.convert2SentenceList(MY_CWS_CORPUS_PATH);
        for(List<IWord> sentence : sentenceList)
            for(IWord word : sentence)
                word.setLabel("n");//赋予每个单词一个虚拟的名词词性
        final NatureDictionaryMaker dictionaryMaker = new NatureDictionaryMaker();
        dictionaryMaker.compute(sentenceList);
        dictionaryMaker.saveTxtTo("Y:/NLP/Hanlp/model/my_cws_model.txt");
    }
}
