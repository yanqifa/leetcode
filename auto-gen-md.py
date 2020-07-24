#coding=utf-8
import os
import sys

reload(sys)

sys.setdefaultencoding('utf-8')

def genmdfile(files, dir):
    #gen empty md file
    for file in files:
        if file.endswith(".java") and file != "ListNode.java" and file != "TreeNode.java":
            mdfileName = file[:-5] + ".md"
            mdfilePath = dir + mdfileName
            if not os.path.exists(mdfilePath):
                f = open(mdfilePath, "w")
                f.close()

def genmdcontent(files, dir):
    for file in files:
        if file.endswith(".md"):
            mdfilePath = dir + file
            if os.path.getsize(mdfilePath) == 0:
                codeFilePath = dir + file[:-3] + ".java"
                f = open(codeFilePath)
                code = f.read()
                content = u"# Template\n\n## 地址\n\n" + "## 描述\n```\n\n```\n\n" + "## 思路\n\n" + "## 代码\n\njava\n\n```java\n" + code + "\n```\n"
                f = open(mdfilePath, "w")
                f.write(content.encode("utf-8"))


files = os.listdir("./problems")
genmdfile(files, "./problems/")
files = os.listdir("./coding-interviews")
genmdfile(files, "./coding-interviews/")

#gen md file content template
files = os.listdir("./problems")
genmdcontent(files, "./problems/")
files = os.listdir("./coding-interviews")
genmdcontent(files, "./coding-interviews/")

