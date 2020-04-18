def to_region(segmentation: str) -> list:
    """
    将分词结果转换为区间
    :param segmentation: 商品 和 服务
    :return: [(1, 2), (2, 2), （2， 3）]
    """
    region = []
    start = 0
    import re
    for word in re.compile("\\s+").split(segmentation.strip()):
        end = start + len(word)
        region.append((start, end))
        start = end
    return region

def prf(gold: str, pred: str, dic) -> tuple:
    """
    计算P\R\F1
    :param gold: 标准答案文件，比如“商品 和 服务”
    :param pred: 分词结束文件，比如“商品 和服 务”
    :param dic: 词典
    :return: （P, R, F1, OOV_R, IV_R）
    """
    A_size, B_size, A_cap_B_size, OOV, IV, OOV_R, IV_R = 0, 0, 0, 0, 0, 0, 0
    with open(gold) as gd, open(pred) as pd:
        for g, p in zip(gd, pd):
            A, B = set(to_region(g), set(to_region(p)))
            A_size += len(A)
            B_size += len(B)
            A_cap_B_size += len(A & B)
            import re
            text = re.sub("\\s+", "", g)
            for(start, end) in A:
                word = text[start: end]
                if dic.containsKey(word):
                    IV += 1
                else:
                    OOV += 1

            for (start, end) in A & B:
                word = text[start: end]
                if dic.containsKey(word):
                    IV_R += 1
                else:
                    OOV_R += 1
    p, r = A_cap_B_size / B_size * 100, A_cap_B_size / A_size * 100
    return p, r, 2 * p * r / (p + r), OOV_R / OOV * 100, IV_R / IV * 100