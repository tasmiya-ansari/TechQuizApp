/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author tasmi
 */
public class ConnectionDetails {
    public static ArrayList<String>getConnectionDetails(){
        ArrayList <String> connDetails=new ArrayList<>();
        FileReader fr=null;
        try
        {
            fr=new FileReader("D:\\onlinecorejava\\TechQuizApp\\TechQuizApp\\dist\\ConnectionDetails.txt");
            File f=new File("D:\\onlinecorejava\\TechQuizApp\\TechQuizApp\\dist\\ConnectionDetails.txt");
            char []arr=new char[(int)f.length()];
            int count=fr.read(arr);
            String str=new String(arr);
            int pos_of_nextLine1=str.indexOf("\n");
            String url=str.substring(0,pos_of_nextLine1-1);
            connDetails.add(url);
            
            int pos_of_nextLine2=str.indexOf("\n",pos_of_nextLine1+1);
            String username=str.substring(pos_of_nextLine1+1, pos_of_nextLine2-1);
            connDetails.add(username);
            
            int pos_of_nextLine3=str.indexOf("\n",pos_of_nextLine2+1);
            String pwd=str.substring(pos_of_nextLine2+1,(int)f.length());
            connDetails.add(pwd);


        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("Cannot open the file.");
            fnf.printStackTrace();
        }
        catch(IOException io)
        {
            System.out.println("Cannot open the file.");
            io.printStackTrace();
        }
        finally
        {
            if(fr!=null)
            {
                try
                {
                    fr.close();
                }
                catch(IOException io)
                {
                System.out.println("Cannot open the file.");
                io.printStackTrace();
                }
            }
        }
        return connDetails;
    }
}
