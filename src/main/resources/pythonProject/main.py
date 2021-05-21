import jieba
import jieba.analyse
from wordcloud import WordCloud,ImageColorGenerator
import matplotlib.pyplot as plt
import imageio


# 对文本进行操作 转码成utf-8
with open('sentence.txt', 'r', encoding = 'utf-8') as sourceFile, open('target.txt', 'w+', encoding = 'utf-8') as targetFile:
    for line in sourceFile:
        seg = jieba.cut(line.strip(),cut_all=True)
        # 分好词之后之间用空格隔断
        output = ' '.join(seg)
        targetFile.write(output)
        targetFile.write('\n')

#定义停用词
stopwords = [line.strip() for line in open('stopword.txt',encoding='utf-8').readlines()]

# 提取关键词
with open('target.txt', 'r', encoding = 'utf-8') as file:
    text = file.readlines()
    keywords = jieba.analyse.extract_tags(str(text), topK = 25, withWeight=True)
    word = [i[0] for i in keywords]

#去停用词
    out = " "
    for words in word:
        if words not in stopwords:
            if words != '\t':
              out += words
              out += " "

back_img = imageio.imread("color.jpg")#读取背景图
color_img = imageio.imread("color.jpg")
wordcloud = WordCloud(background_color='white',scale=6,mask = back_img,prefer_horizontal=1.0).generate(out)#设定词云参数

image_colors = ImageColorGenerator(color_img)#设定词云颜色
plt.imshow(wordcloud.recolor(color_func=image_colors))

plt.axis('off')
plt.show()
wordcloud.to_file('D:/Code/Java/project/spring-board/src/main/resources/static/image/test.jpg')