class Solution {
    public String solution(String[] id_pw, String[][] db) {
        boolean idMatched = false;
        for(int i=0; i<db.length; i++) {
            if(id_pw[0].equals(db[i][0])) {
                idMatched = true;
                if(id_pw[1].equals(db[i][1])) return "login";
            }
        }
        return idMatched ? "wrong pw" : "fail";
    }
}