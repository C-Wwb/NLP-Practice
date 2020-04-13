from pyhanlp import HanLP, DoubleArrayTrieSegment

HanLP.Config.ShowTermNature = False #分词结果不显示词性
segment = DoubleArrayTrieSegment()
print(segment.seg('江西鄱阳湖干涸，中国最大的淡水湖变成大草原'))

dict1 = "Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/CoreNatureDictionary.mini.txt"
dict2 = "Y:/NLP/Anaconda/Install/Lib/site-packages/pyhanlp/static/data/dictionary/custom/上海地名.txt ns"
segment = DoubleArrayTrieSegment(dict1, dict2)
print(segment.seg('上海市虹口区大连西路550号SISU'))

segment.enablePartOfSpeechTagging(True)
HanLP.Config.ShowTermNature = True
print(segment.seg('上海市虹口区大连西路550号SISU'))

for term in segment.seg('上海市虹口区大连西路550号SISU'):
    print("单词:%s 词性:%s\n" % (term.word, term.nature))