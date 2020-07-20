import os

def compare(xstr, ystr):
    xstrlist = xstr.split('.')
    ystrlist = ystr.split('.')
    return int(xstrlist[0]) - int(ystrlist[0])

files = os.listdir("./problems")
problems = []
for file in files:
    if file.endswith(".md"):
        problems.append(file)

print(problems)
#1. sort problems
problems=sorted(problems, cmp=compare) 

#2. gen index
indexlist = []
for problem in problems:
    print(problem + '\n')
    index = "[" + problem[:-3] + "](./problems/" + problem.replace(" ", "%20") + ")"
    print(index + "\n")
    indexlist.append(index)

#3. replace old index
f = open("./README.md")
iter_f = iter(f)
content = ""
for line in iter_f:
    content += line
    if line.__contains__("## list"):
        break

content += "\n"

for index in indexlist:
    content += index + "\n\n"

f = open("./README.md", "w")
f.write(content)
