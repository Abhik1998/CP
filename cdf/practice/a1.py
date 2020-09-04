MOD = 998244353
p = [1] * 200005
for i in range(1, 200005):
    p[i] = (p[i - 1] * 10) % MOD

n = int(input())
for i in range(1, n):
    res = 2 * 10 * 9 * p[n - i - 1]
    res += (n - 1 - i) * 10 * 9 * 9 * p[n - i - 2]
    print(res % MOD, end = ' ')
print(10)                                                                                                                                                                                   rt[]\