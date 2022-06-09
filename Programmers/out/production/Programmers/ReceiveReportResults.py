from collections import defaultdict

def solution(id_list, report, k):
    answer = []
    report = set(report)
    reporter_dict = defaultdict(set)
    busted_dict = defaultdict(set)
    
    for i in report:
        reporter, busted = i.split()
        reporter_dict[reporter].add(busted)
        busted_dict[busted].add(reporter)
    for _id in id_list:
        cnt = 0
        for j in reporter_dict[_id]:
            if len(busted_dict[j]) >= k:
                cnt += 1
        answer.append(cnt)
    
    return answer
