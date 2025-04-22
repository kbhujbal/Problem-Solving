import math

MOD = 10**9 + 7

class Solution:
    def idealArrays(self, n: int, maxValue: int) -> int:
        # Precompute factorials and inverse factorials for combinations
        N = n + 100  # upper bound for factorial size
        fact = [1] * (N)
        invFact = [1] * (N)

        for i in range(1, N):
            fact[i] = fact[i - 1] * i % MOD

        invFact[N - 1] = pow(fact[N - 1], MOD - 2, MOD)
        for i in range(N - 2, -1, -1):
            invFact[i] = invFact[i + 1] * (i + 1) % MOD

        def comb(a, b):
            if b < 0 or b > a:
                return 0
            return fact[a] * invFact[b] % MOD * invFact[a - b] % MOD

        # Precompute smallest prime factors using Sieve of Eratosthenes
        spf = list(range(maxValue + 1))
        for i in range(2, int(maxValue**0.5) + 1):
            if spf[i] == i:
                for j in range(i * i, maxValue + 1, i):
                    if spf[j] == j:
                        spf[j] = i

        # Prime factorization function
        def get_prime_factors(x):
            pf = {}
            while x > 1:
                p = spf[x]
                pf[p] = pf.get(p, 0) + 1
                x //= p
            return pf

        result = 0
        for x in range(1, maxValue + 1):
            pf = get_prime_factors(x)
            ways = 1
            for exp in pf.values():
                ways = ways * comb(n - 1 + exp, exp) % MOD
            result = (result + ways) % MOD

        return result

if __name__ == "__main__":
    n = int(input("Enter the length of the array (n): "))
    maxValue = int(input("Enter the max value of any element (maxValue): "))

    sol = Solution()
    print("Number of ideal arrays:", sol.idealArrays(n, maxValue))
