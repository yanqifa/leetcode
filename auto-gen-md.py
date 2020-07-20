import os

files = os.listdir("./problems")
problems = []
for file in files:
    if file.endswith(".java"):
        mdfileName = file[:-5] + ".md"
        mdfilePath = "./problems/" + mdfileName
        if not os.path.exists(mdfilePath):
            f = open(mdfilePath, "w")
            f.close()
