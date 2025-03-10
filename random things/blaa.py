dic = [
    "zero",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine"
]

# line = 'sdpgz3five4seven6fiveh'
# sum = 0
# minn = 1000
# maxx = -1
# min_val = ''
# max_val = ''
# for i in dic:
#     if i in line:
#         print(f"for {i} : {line.index(i)}")
#         if min(line.index(i), minn) != minn:
#             if dic.index(i) > 9:
#                 min_val = str(int(dic.index(i)) - 10)
#             else:
#                 min_val = dic.index(i)
#             minn = line.index(i)
#         if max(line.index(i), maxx) != maxx:
#             if dic.index(i) > 9:
#                 max_val = str(int(dic.index(i)) - 10)
#             else:
#                 max_val = dic.index(i)
#             maxx = line.index(i)
# sum = int(min_val)*10+int(max_val)
# # print(sum)

import re

line = 'sdpgzfiveh'
match = re.findall(r'\d|one|two|three|four|five|six|seven|eight|nine', line)
min_val = match[0]
max_val = match[-1]
if min_val in ['one','two','three','four','five','six','seven','eight','nine']:
    min_val = dic.index(min_val)
if max_val in ['one','two','three','four','five','six','seven','eight','nine']:
    max_val = dic.index(max_val)
sum = int(min_val)*10+int(max_val)
print(sum)