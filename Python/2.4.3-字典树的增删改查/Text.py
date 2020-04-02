from 字典树的增删改查 import Trie

if __name__ == '__main__':
    trie = Trie()
    # 增
    trie['自然'] = 'nature'
    trie['自然人'] = 'human'
    trie['自然语言'] = 'language'
    trie['自语'] = 'talk to oneself'
    trie['入门'] = 'introduction'
    assert '自然' in trie
    # 删
    trie['自然'] = None  # 将终点值设为None
    assert '自然' not in trie
    # 改
    trie['自然语言'] = 'human language'  # 将他的值邻设一个
    assert trie ['自然语言'] == 'human language'
    # 查
    assert trie ['入门'] == 'introduction'
    print(trie)