#1이 될 때까지

def to1(N,K,result):
    if N == 1:
        return result
    if not N % K == 0:
        return to1(N - 1,K,result + 1)
    return to1(N/K,K,result + 1)

        



#어떠한 수 N과 K를 입력받는다.
N, K = map(int, input().split())

print(to1(N,K,0))