from docutils.nodes import term
from jpype import JClass, JString
from pyhanlp import *

def load_from_file(path):
    """
    从词典文件中加载DoubleArrayTrie
    :param path: 词典路径
    :return: 双数组字典树
    """

    map = JClass('java.util.TreeMap')() #创建treemap实例
    with open(path) as src:
        for word in src:
            word = word.strip() #去掉python读入的\n
            map[word] = word
    return JClass('com.hancks.hanlp.collection.trie.DoubleArrayTrie')(map)

def load_from_words(*words):
    """
    从词汇构造双数组字典树
    :param words: 一系列词语
    :return:
    """
    map = JClass('java.util.TreeMap')() #创建treemap实例
    for word in words:
        map[word] = word
    return JClass('com.hancks.hanlp.collection.trie.DoubleArrayTrie')(map)

def remove_stopwords_termlist(termlist, trie):
    return [term.word for term in termlist if not trie.containsKey(term.word)]

def replace_stropwords_text(text, replacement, trie):
    searcher = trie.getLongestSearcher(JString(text), 0)
    offset = 0
    result = ''
    while searcher.next():
        begin = searcher.begin
        end = begin + searcher.length
        if begin > offset:
            result += text[offset: begin]
        result += replacement
        offset = end
    if offset < len(text):
        result += text[offset]
    return result

