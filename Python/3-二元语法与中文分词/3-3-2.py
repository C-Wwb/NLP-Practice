from pyhanlp import *
from jpype import JClass
sents = CorpusLoader

def train_bigram(corpus_path, model_path):
    sents = CorpusLoader