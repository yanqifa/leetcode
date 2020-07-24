import java.util.*;

class Solution {
    class Node{
        char c;
        int index;
        Node(char c, int index){
            this.c = c;
            this.index = index;
        }
    }
    public String customSortString(String S, String T) {
        Map map = new HashMap<Character, Integer>();
        int i = 1;
        for(char c : S.toCharArray()){
            map.put(c, i++);
        }
        List<Node> list = new LinkedList<>();

        for(char c : T.toCharArray()){
            Integer indexWrapper = (Integer)map.get(c);
            int index = 0;
            if(indexWrapper != null) index = indexWrapper.intValue();
            Node node = new Node(c , index);
            list.add(node);
        }

        Collections.sort(list, new Comparator<Node>(){
            @Override
            public int compare(Node a, Node b){
                return a.index - b.index;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Node node : list){
            sb.append(node.c);
        }

        return sb.toString();
    }
}