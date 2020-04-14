from jpype import JClass

segment = JClass('com.hancks.hanlp.seg.Other.AhoCorasickDoubleArrayTrieSegment')()
print(segment.seg("江西鄱阳湖干涸，中国最大淡水湖变成草原"))