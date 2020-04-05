def __getitem__(self, key: str):
    b = 0
    for i in range(0, len(key)): #len(key)次状态转移
        p = self.transition(key[i], b)
        if p is not -1:
            b = p
        else:
            return None

    p = self.base[b] #按字符‘\0’进行状态转移
    n = self.base[p] #查询base
    if p == self.check[p] and n < 0: # 状态转移成功且对应词语结尾
        index = - n - 1 #取得字典序
        return self.value[index]
    return None