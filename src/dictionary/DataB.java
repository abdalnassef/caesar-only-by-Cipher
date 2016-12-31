package dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdalnasf
 */
public class DataB {
    private String Transed="";
    private Connection connection ;
    private Statement stmt;
    private  ResultSet result;
    private  String sql1;
    private String word;
           
    public DataB(char TableName,String word) {
        this.word=word;
        String h;char ch='a';
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Dictionary");
            stmt=connection.createStatement();
           
           boolean found=false;
           while(ch<'z'){
            if(TableName<'a' || TableName>'z'){
                                sql1="select english from "+ch+" where arabic=\'"+word+"\' or arabic=\'"+word.substring(2,word.length())+"\'or arabic=\'"+"ال"+word+"\';";
                     result=stmt.executeQuery(sql1);
                                if(result.next()){
                                     h=result.getString(1);
                                     if(Transed.equals(""))  Transed=h;
                                     else {  Transed+=","+h; } //For Search By Arabic
                                     found=true;
                                }
            
            while(result.next()){
                 h=result.getString(1);
                 Transed+=","+h;
            }
            
            }else{
                            sql1="select arabic  from "+TableName+" where english=\'"+word+"\';";
                 
                            //If Use it only cant find all English Words
                     result=stmt.executeQuery(sql1);
                            if(result.next()){
                                 h=result.getString(1);
                                 Transed=h;
                            found=true;
                            }
            
            while(result.next()){
                 h=result.getString(1);
                 Transed+=","+h;
            }
            
            }
            
            ch++;
           }
           //insert Words That Not Translate 
           Notfounded(found);
               stmt.close();
               connection.close();
            }catch( Exception e){//System.out.println(e.getMessage());
            }
//        System.out.println(Transed);
    }

    private void Notfounded(boolean found) throws SQLException{
        if(found==false){
               connection = DriverManager.getConnection("jdbc:sqlite:Unfound");
               stmt=connection.createStatement();
               stmt.executeUpdate("insert into words values(\'"+word+"\');");
               Transed="Not Founded";
           }
    }
    
    public String getTransed() {
        return Transed;
    }

    public void setTransed(String Transed) {
        this.Transed = Transed;
    }

}
