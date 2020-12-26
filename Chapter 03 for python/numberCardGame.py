# 숫자 카드 게임

def numberCardGame(N, M, result):
    #각 카드에 적인 숫자가 주어진다.
    for i in range(N):
        cardlist = list(map(int, input().split()))
        #현재 행에서 가장 작은 수 찾기
        if result < min(cardlist):    
            result = min(cardlist)
        
    return result

#숫자 카드들이 놓인 행의 개수 N 과 열의갯수 M 이 공백을 기준으로 각각 자연수로 주어짐
N, M = map(int, input().split())

print(numberCardGame(N,M,0))
