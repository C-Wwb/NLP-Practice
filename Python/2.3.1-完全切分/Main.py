
from jpype import JClass
def fully_segment(text, dic):
    word_list = []
    for i in range(len(text)):  # 遍历text中的所有位置下标
        for j in range(i + 1, len(text) + 1):  # 遍历[i + 1, len(text)]区间
            word = text[i:j]  # 取出连续区间[i, j]对应的字符串
            if word in dic:  # 如果存在于词典中，则认为是一个词
                word_list.append(word)
    return word_list

