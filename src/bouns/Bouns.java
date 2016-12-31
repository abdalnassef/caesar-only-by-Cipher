package bouns;

import dictionary.DataB;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

class Bouns {

        static String alpha="abcdefghijklmnopqrstuvwxyz ";
        static char []Litter=alpha.toCharArray();
    public static void main(String[] args) {
        
//String ceaser="i play good";
        
//String ceaser="jaqmbzahppe";
String ceaser=JOptionPane.showInputDialog(null, "Enter Cipher");
ceaser=ceaser.trim();
String plain=check(crack(ceaser));
//System.out.println("\" "+plain +"\""+" >> Key : "+find_key(plain,ceaser));
JOptionPane.showMessageDialog(null, "\" "+plain +"\""+" >> Key : "+find_key(plain,ceaser));
        
////        System.out.println(check_for_word("hello"));
        
        
  }
    public static int find_key(String plain,String cipher){
       String MSG1=plain;
       String MSG2=cipher;
       int Index1=-1;
       int Index2=-1;
       int num = -1;
//        System.out.print("Key : ");
       for(int ii=0;ii<MSG1.length();ii++){
       for(int i=0;i<Litter.length;i++){
           if(MSG1.charAt(0)==Litter[i])Index1=i;
           if(MSG2.charAt(0)==Litter[i])Index2=i;
       }
       num=(Index2-Index1);
//       System.out.print(num+" ");
       }
       if(Index1==-1||Index2==-1){System.out.println("MSG Wrong");System.exit(-1);}
       for(;;){
           if(num<0)num+=Litter.length;
           else break;
       }
        System.out.println("");
      return num; 
    }
    public static String check(String []g){
        String y="";String word = null;
        for(int o=0;o<g.length;o++){
            y=g[o];
        y=y.trim();
        String insert=y+fasel;
        String x=sub(insert);
        if(x!=""){
            word=x;
//            System.out.println("Finished : "+x);
        }
        }
        return word;
    }
    public static String []crack(String ceaser){
        String[] all=new String[26];
        String h="";
        for(int i=0;i<all.length;i++){
            all[i]="";
            for(int x=0;x<ceaser.length();x++){
                for(int m=0;m<Litter.length;m++){
                    if(ceaser.charAt(x)==Litter[m]){
                        int u=m-i;if(u<0)u+=Litter.length;
                        all[i]+=Litter[u];
                    }
                }
            }
//            System.out.println(all[i]);
        }
        return all;
    }
    private static int count=0;
    public static String sub(String allword){
        String finish="";
        int num_words=0,cc;
        String st="";
        for(int i=0;i<allword.length();i++){
            
            if((cc=allword.indexOf(fasel, i))!=-1){
                num_words++;
                i=cc;
            }
        }
        for(int i=0;i<allword.length();i++){
             if(allword.charAt(i)==fasel)continue;
            int c=allword.indexOf(fasel, i);
//            System.out.println(c);
            if(c==-1)break;
            if(teststring(allword.substring(i,c))){
                count++;
                st+=allword.substring(i,c)+fasel;
//                System.out.println(allword.substring(i,c)+" ");
                i=c;
                
            }else {
                i=c;
            }
        }
//        System.out.println(" # words   : "+num_words);
//           System.out.println("word found : "+count);
        if(count==num_words){
//            System.out.print(num_words +" "+count+"  ");
            finish=st;
//            System.out.println(finish);
        }
        
//        System.out.println("The sentens is : "+st);
//        else System.out.println("Some thing wrong");
        return finish;
    }
    public static boolean teststring(String words){
        String x=words;
        char xx=x.charAt(0);
       
        dictionary.DataB m=new DataB(xx, x);
//        System.out.println(m.getTransed());
        boolean find=false;
        if(!m.getTransed().equals("")){
            find=true;
//            System.out.println("Found : "+words);
//            System.out.println("Word");
        }else {
//            System.out.println("not found "+words);
        }
        
    return find;} 
    static char fasel=' ';
//    izplayzgood
//            jaqmbzahppe
}
