from jpype import JClass
from pyhanlp import *

class DoubleArrayTrie(object):
    def __init__(self, dic: dict) -> None:
        m = JClass('java.util.TreeMap')()
        for k, v in dic.items():
            m[k] = v
        dat = JClass('com.hankcs.hanlp.collection.trie.DoubleArrayTrie')(m)
        self.base = dat.base
        self.check = dat.check
        self.value = dat.value