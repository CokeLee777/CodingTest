# 큰 수의 법칙

def lawOfLargeNumber(N,M,K):
    #결과 값
    result = 0

    #N개의 수를 공백으로 구분하여 입력받기
    number = list(map(int, input().split()))

    number.sort()

    firstnum = number[N-1] #첫번째로 큰 숫자
    secondnum = number[N-2] #두번째로 큰 숫자

    while True:
        for i in range(K):
            if M == 0:
                break
            result += firstnum
            M -= 1
        if M == 0:
            break
        result += secondnum
        M -= 1
    return result
        

#배열의 크기 N, 숫자가 더해지는 횟수 M, 연속해서 더해질 수 있는 횟수 K 를 공백을 기준으로 입력받기
N, M, K = map(int, input().split())

print(lawOfLargeNumber(N,M,K))





