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


def fully_segment(text, dic):
    word_list = []
    for i in range(len(text)):  # 遍历text中的所有位置下标
        for j in range(i + 1, len(text) + 1):  # 遍历[i + 1, len(text)]区间
            word = text[i:j]  # 取出连续区间[i, j]对应的字符串
            if word in dic:  # 如果存在于词典中，则认为是一个词
                word_list.append(word)
    return word_list


dic = load_dictionary()
print(fully_segment('项目的研究', dic))
