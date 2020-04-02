class Node(object):
    def __init__(self, value) -> None:  # None表示节点不对应词语
        self._children = {}
        self._value = value


def _add_child(self, char, value, overwrite=False):
    child = self._children.get(char)  # 检查是否已经存在字符char对应的child
    if child is None:
        child = Node(value)
        self._children[char] = child
    elif overwrite:  # 根据overwrite来决定是否覆盖child值
        child._value = value
        return child
