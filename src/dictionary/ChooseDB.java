/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import javax.swing.JOptionPane;
import org.apache.commons.lang.StringUtils;
import org.hsqldb.lib.StringUtil;

/**
 *
 * @author Dream
 */
public class ChooseDB {
    private String word=null;
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word.trim();
    }

    public String search(){
        
        setWord(getWord().toLowerCase());
        char x=getWord().charAt(0);
        if(x<'a' || x>'z'){
             word=word.replace('إ','ا');
             word=word.replace('آ','ا');
             word=word.replace('أ','ا');
             word=word.replace('ى','ي');
             word=word.replace('ه','ة');
           }
        word=word.replace("\'","\'\'");     //To insert single(') in database must be dual('')
        DataB DB=new DataB(x, getWord());
        
//        String f=StringUtils.substringAfter(DB.getTransed(), ",");
        int xxxx=StringUtils.countMatches(DB.getTransed(), ",");
        //System.out.println(DB.getTransed());
        return DB.getTransed();
    }

   
    
    
    
}
