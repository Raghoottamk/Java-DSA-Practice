public class Q_2_compress_string {
    public static StringBuilder compress(String str){
        StringBuilder newstr = new StringBuilder("");
        //String newstr = "";
        for(int i = 0;i<str.length();i++){
            Integer count = 1;//so that integer can be converted to string later
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            newstr.append(str.charAt(i));
            //newstr += str.charAt(i);
            if(count>1){
                newstr.append(count.toString());
                //newstr += count.toString();
            }
        }
        return newstr;
    }
    public static void main(String[] args) {
        String str = "abbbbbbbbbbbbbb";
        System.out.println(compress(str));
    }
}
