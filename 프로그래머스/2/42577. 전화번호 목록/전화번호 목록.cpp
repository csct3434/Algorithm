#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

bool solution(vector<string> phone_book) {
    unordered_map<string, bool> prefixMap;

    for (string number : phone_book) {
        for (int i = 1; i < number.length(); i++) {
            prefixMap[number.substr(0, i)] = true;
        }
    }

    for (string number : phone_book) {
        if (prefixMap.find(number) != prefixMap.end()) {
            return false;
        }
    }
    return true;
}