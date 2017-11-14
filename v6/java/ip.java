public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if(s==null||s.length()<4||s.length()>12) return res;
        dfs(0,1,res,s,"");
        return res;
    }
    private void dfs(int start, int segment, ArrayList<String> res, String s, String item){
        if(start>=s.length()) return;
        if(segment==4){
            String str = s.substring(start);
            if(isValid(str)){
                res.add(item + "." + str);
            }
            return;
        }
        for(int i=1; segment<4 && (i+start)<=s.length();i++){
            String str = s.substring(start, start+i);
            if(isValid(str)){
                if(segment ==1){
                    dfs(start+i, segment+1,res, s, str);
                }else{
                    dfs(start+i, segment+1,res, s, item+"."+str);
                }
            }
        }
    }
    private boolean isValid(String str){
        if(str==null||str.length()>3||(str.charAt(0)=='0'&&str.length()>1)) return false;
        int code = Integer.parseInt(str);
        return (code>=0 && code<=255);
    }
}