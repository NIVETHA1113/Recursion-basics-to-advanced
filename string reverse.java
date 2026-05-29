import java.util.*; 
class Main{
    static String reverse (String word,int ind,String res){
        if(ind<0)
            return res;
        res+= word.charAt(ind);
        return reverse(word,ind-1,res);
    }
    public static void main(String[]arg){
    Scanner sc = new Scanner(System.in);
    String word = sc.nextLine();
    String res = reverse(word,word.length()-1,"");
    System.out.print(res);
    sc.close();
    }
}