import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;

import java.util.TreeMap;

public class ACDAT<S> {
    public static void main(String[] args)
    {
        String[] keyArray = new String[]{"hers", "his", "she", "he"};
        TreeMap<String, String> map = new TreeMap<String, String>();
        for(String key : keyArray)
            map.put(key, key.toUpperCase());
        AhoCorasickDoubleArrayTrie<String> acdat = new AhoCorasickDoubleArrayTrie<String>(map);
        for(AhoCorasickDoubleArrayTrie<String>.Hit<String> hit : acdat.parseText("ushers"))
        {
            System.out.printf("[%d:%d]=%s\n", hit.begin, hit.end, hit.value);
        }
    }
}
