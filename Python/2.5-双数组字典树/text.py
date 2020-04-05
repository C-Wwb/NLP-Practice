if __name__=='__main__':
    dic = {'自然': 'nature', '自然人': 'human', '自然语言': 'language', '自语':
    'talk to oneself', '入门': 'introduction'}
    dat = DoubleArrayTrie(dic)
    assert dat['自然'] == 'nature'
    assert dat['自然语言'] == 'language'
    assert dat['不存在'] is None