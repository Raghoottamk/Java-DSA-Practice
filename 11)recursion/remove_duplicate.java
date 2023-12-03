/*remove duplicates from the string */
public class remove_duplicate {
    public static void removeDuplicate(String str,int idx,StringBuilder newstr,boolean[] map){
        //note boolean by default value is true
        //base
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }
        //work
        char currentChar = str.charAt(idx);
        if(map[currentChar-'a']== true){
            //duplicate 
            removeDuplicate(str, idx+1, newstr, map);
        }
        else{
            map[currentChar-'a'] = true;
            newstr.append(currentChar);
            removeDuplicate(str, idx+1, newstr, map);
        }
    }
    public static void main(String[] args) {
        String str = "apnacollege";
        removeDuplicate(str, 0, new StringBuilder(""),new boolean[26]);
    }
}
