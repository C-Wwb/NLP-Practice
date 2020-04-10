from pyhanlp import *
from jpype import JClass

words = ["hers", "his", "she", "he"]
Trie = JClass('com.hancks.hanlp.algorithm.ahocorasick.trie.Trie')
trie = Trie()
for w in words:
    trie.addKeyword(w)

for emit in trie.parseText("ushers"):
    print("[%d:%d]=%s" % (emit.getStrat(), emit.getEnd(), emit.getKeyword()))