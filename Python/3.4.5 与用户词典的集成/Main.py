from pyhanlp import *
segment = ViterbiSegment()
sentence = "社会摇摆简称社会摇"
segment.enableCustomDictionary(False)
print("不挂载词典：", segment.seg(sentence))
CustomDictionary.insert("社会摇", "nz 100")
segment.enableCustomDictionary(True)
print("低优先级词典：", segment.seg(sentence))
segment.enableCustomDictionaryForcing(True)
print("高优先级词典：", segment.seg(sentence))
