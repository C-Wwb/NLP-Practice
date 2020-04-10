import com.hankcs.hanlp.algorithm.ahocorasick.trie.Emit;
import com.hankcs.hanlp.algorithm.ahocorasick.trie.Trie;

public class Main
{//TreeMap实现的AC自动机
    public static void main(String[] args)
    {
        String[] keyArray = new String[]{"hers", "his", "she", "he"};
        Trie trie = new Trie();//构建双数组字典树
        for(String key : keyArray)
            trie.addKeyword(key);
        for(Emit emit : trie.parseText("ushers"))
            System.out.printf("[%d:%d]=%s\n", emit.getStart(), emit.getEnd(), emit.getKeyword());
    }
}
