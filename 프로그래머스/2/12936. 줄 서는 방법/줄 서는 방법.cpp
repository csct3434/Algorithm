#include <vector>
using namespace std;

vector<int> solution(int n, long long k) {
    if (n == 1) {
        return {1};
    }

    vector<int> answer(n, 0);
    int index = 0;

    long long a = 1;
    vector<int> digits;
    for (int i = 1; i <= n; i++) {
        a *= i;
        digits.push_back(i);
    }

    while (n > 2) {
        a /= n--;

        int subSequence = static_cast<int>(1 + (k - 1) / a);

        answer[index++] = digits[subSequence - 1];
        digits.erase(digits.begin() + (subSequence - 1));

        k -= (subSequence - 1) * a;
    }

    if (k == 1) {
        answer[index++] = digits[0];
        answer[index] = digits[1];
    } else {
        answer[index++] = digits[1];
        answer[index] = digits[0];
    }

    return answer;
}
