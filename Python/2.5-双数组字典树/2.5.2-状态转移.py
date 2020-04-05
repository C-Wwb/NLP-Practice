from jpype import JClass


def char_hash(c) -> int:
    return JClass('java.lang.Character')(c).hashCode()


def transition (self, c, b) -> int:
    """
    :param self: 
    :param c: 字符
    :param b: 初始状态
    :return: 转移后的状态，-1表示失败
    """

    p = self.base[b] + self.char_hash(c) + 1
    if self.base[b] == self.check[p]:
        return p
    else:
        return -1