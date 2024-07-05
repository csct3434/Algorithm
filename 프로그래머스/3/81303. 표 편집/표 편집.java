import java.util.Stack;

class Solution {

    private static class Node {
        Node front;
        Node back;
        int value;

        public Node(int value) {
            this.value = value;
        }
        public Node moveUp(int count) {
            Node node = this;
            for(int i=0; i<count; i++) {
                node = node.front;
            }
            return node;
        }
        public Node moveDown(int count) {
            Node node = this;
            for(int i=0; i<count; i++) {
                node = node.back;
            }
            return node;
        }
    }

    public String solution(int n, int k, String[] cmd) {
        Node cursor, head, trash;
        head = cursor = new Node(0);
        Stack<Node> recycleBin = new Stack<>();
        int distance;
        for(int i=1; i<n; i++) {
            Node node = new Node(i);
            cursor.back = node;
            node.front = cursor;
            cursor = node;
        }
        cursor = head.moveDown(k);
        for(String command : cmd) {
            String[] tokens = command.split(" ");
            if(tokens.length == 2) {
                distance = Integer.parseInt(tokens[1]);
                if(tokens[0].equals("U")) cursor = cursor.moveUp(distance);
                else cursor = cursor.moveDown(distance);
            } else if(tokens[0].equals("C")) {
                recycleBin.push(cursor);
                if(cursor.front != null) cursor.front.back = cursor.back;
                if(cursor.back != null) cursor.back.front = cursor.front;
                if(cursor.back == null) {
                    cursor = cursor.front;
                } else {
                    cursor = cursor.back;
                }
            } else {
                trash = recycleBin.pop();
                if(trash.front != null) trash.front.back = trash;
                if(trash.back != null) trash.back.front = trash;
            }
        }
        boolean[] exists = new boolean[n];
        if(cursor != null) {
            while (cursor.front != null) cursor = cursor.moveUp(1);
        }
        while(cursor != null) {
            exists[cursor.value] = true;
            cursor = cursor.back;
        }
        StringBuilder sb = new StringBuilder();
        for (boolean e : exists) sb.append(e ? "O" : "X");
        return sb.toString();
    }

}
