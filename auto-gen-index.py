import os
files = os.listdir("./problems")
problems = []
for file in files:
    if file.endswith(".md"):
        problems.append(file)

print(problems)
#1. sort problem

#2. gen index

#3. replace old index
f = open("./README.md")
#todo backup
iter_f = iter(f)
for line in iter_f:
    if line.startswith("["):
        print(line + "\n")