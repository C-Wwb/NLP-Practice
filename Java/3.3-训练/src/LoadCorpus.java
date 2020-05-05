import com.hankcs.hanlp.corpus.document.CorpusLoader;
import com.hankcs.hanlp.corpus.document.sentence.word.IWord;

import java.util.List;

public class LoadCorpus
{
    public static String MY_CWS_CORPUS_PATH = "data/test/my_cws_corpus.txt";
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
}
