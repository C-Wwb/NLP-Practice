import com.hankcs.hanlp.collection.trie.bintrie.BinTrie;
import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.dictionary.CoreDictionary;

import java.io.IOException;
import java.util.*;

public class textTreeMapBinTrie
{
    public static void main(String[] args) throws IOException {//读取词典
        Scanner input = new Scanner(System.in);
        TreeMap<String, CoreDictionary.Attribute> dictionary
                = IOUtil.loadDictionary("Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt");
        final BinTrie<CoreDictionary.Attribute> binTrie = new BinTrie<CoreDictionary.Attribute>(dictionary);
        Map<String, CoreDictionary.Attribute> binTrieMap = new Map<String, CoreDictionary.Attribute>()
        {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return binTrie.containsKey((String) key);
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public CoreDictionary.Attribute get(Object key) {
                return null;
            }

            @Override
            public CoreDictionary.Attribute put(String key, CoreDictionary.Attribute value) {
                return null;
            }

            @Override
            public CoreDictionary.Attribute remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends CoreDictionary.Attribute> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<CoreDictionary.Attribute> values() {
                return null;
            }

            @Override
            public Set<Entry<String, CoreDictionary.Attribute>> entrySet() {
                return null;
            }
        };
        evaluateSpeed.evaluateSpeed((TreeMap<String, CoreDictionary.Attribute>) binTrieMap);
    }
}
