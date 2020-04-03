import com.hankcs.hanlp.collection.trie.ITrie;
import jdk.nashorn.internal.ir.BaseNode;
import jdk.nashorn.internal.ir.Expression;

import java.io.Externalizable;

public class BinTrie<V> extends BaseNode<V> implements ITrie<V>, Externalizable
{
    private int size;

    public BinTrie()
    {
        child = new BaseNode[65535 + 1];//(int)Character.Max_value
        size = 0;
        status = com.hankcs.hanlp.collection.trie.bintrie.BaseNode.Status.NOT_WORD_1;
    }

}