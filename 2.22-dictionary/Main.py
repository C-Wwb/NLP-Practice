from jpype import JClass
from pyhanlp import *

def load_dictionary():
    '''
    加载HanLP中的mini库
    :return: 一个set语句
    '''

    IOUtil = JClass('com.hankcs.hanlp.corpus.io.IOUtil')#利用JClass取得了HanLP中的IOUtil类
    path = HanLP.Config.CoreDictionaryPath.replace('.txt', '.mini.txt')#取得了HanLP中的词典路径
    dic = IOUtil.loadDictionary([path])#调用了IOUtil类的静态方法
    return set(dic.keyset())