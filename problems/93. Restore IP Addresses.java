import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> ret = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12) return ret;
        coreRetoreIp(s, 0, 0, "", ret);
        return ret;
    }

    public void coreRetoreIp(String s, int index, int section, String ip, List<String> ret){
        if(section == 4 && index == s.length()){
            ret.add(ip);
        }
        for(int i = 0; i < 3; i++){
            int end = index + i + 1;
            if(end > s.length())return;
            String sub = s.substring(index, end);
            if(isIpSection(sub)){
                //注意要用临时变量保存，避免影响for循环的下一次
                int nextIndex = index + i + 1;
                int nextSection = section + 1;
                String nextIp = ip;
                if(section != 0){
                    nextIp += ".";
                }
                nextIp += sub;
                coreRetoreIp(s, nextIndex, nextSection, nextIp, ret);
            }
        }
    }

    public boolean isIpSection(String s){
        //还要注意头部为0的情况
        if(s.length() > 1 && s.substring(0, 1).equals("0"))return false;
        if(s.length() > 2 && s.substring(0, 2).equals("00"))return false;
        int i = Integer.parseInt(s);
        if(i >=0 && i <= 255)return true;
        else return false;
    }
}

