#coding=utf-8
import os
import sys

reload(sys)

sys.setdefaultencoding('utf-8')

files = os.listdir("./problems")
problems = []
#gen empty md file
for file in files:
    if file.endswith(".java"):
        mdfileName = file[:-5] + ".md"
        mdfilePath = "./problems/" + mdfileName
        if not os.path.exists(mdfilePath):
            f = open(mdfilePath, "w")
            f.close()

#gen md file content template
files = os.listdir("./problems")
mdfiles = []
for file in files:
    if file.endswith(".md"):
        mdfilePath = "./problems/" + file
        if os.path.getsize(mdfilePath) == 0:
            codeFilePath = "./problems/" + file[:-3] + ".java"
            f = open(codeFilePath)
            code = f.read()
            content = u"# Template\n\n## 地址\n\n" + "## 描述\n\n" + "## 思路\n\n" + "## 代码\n\njava\n\n```java\n" + code + "```\n"
            f = open(mdfilePath, "w")
            f.write(content.encode("utf-8"))

