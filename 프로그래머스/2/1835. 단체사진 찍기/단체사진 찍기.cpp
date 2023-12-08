#include <bits/stdc++.h> 

using namespace std;

bool checkCondition(string friends, string cond) {
    char op = cond[3];
    int requiredDistance = cond[4] - '0';
        
    int distance = abs(int(friends.find(cond[0]) - friends.find(cond[2]))) - 1;
        
    if(op == '=') {
        if(distance != requiredDistance) {
            return false;
        }
    } else if(op == '<') {
        if(!(distance < requiredDistance)) {
            return false;
        }
    } else {
        if(!(distance > requiredDistance)) {
            return false;
        }
    }
    return true;
}

bool isPossible(string friends, vector<string> data) {
    for(auto cond : data) {
        if(!checkCondition(friends, cond)) {
            return false;
        }
    }
    return true;
}

int solution(int n, vector<string> data) {
    string friends = "ACFJMNRT";
    int answer = 0;

    do {
        if(isPossible(friends, data)) {
            answer++;
        }
    } while(next_permutation(friends.begin(), friends.end()));
    
    return answer;
}