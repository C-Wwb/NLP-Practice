import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class text
{
    public static void main(String[] args) throws IOException {//读取词典
        Scanner input = new Scanner(System.in);
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        for(int i = 0; i <= 100; i++)
        {
            System.out.println("Please enter a text: ");
            String text = input.next();
            if(text.equalsIgnoreCase("end"))
            {
                break;
            }
            else
            {
                System.out.println(segmentBidirectional.segmentBidirectional(text, dictionary) + "\n");
            }
        }
    }
}
