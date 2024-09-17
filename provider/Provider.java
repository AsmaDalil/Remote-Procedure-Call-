package RAT_HM2.provider;
import javax.xml.ws.Endpoint;


public class Provider {
    //define the address where the server/service will be reachable
    // we add remoteControl to specify which service, since the server might be exposing multiple services

    private static final String URL = "http://localhost:8080/remoteAccess";
    public static void main(String[] args) {
        
       
        RemoteAccess remoteAccess = new RemoteAccess();

        System.out.println("Publishing the remote access system");
        Endpoint.publish(URL, remoteAccess);
        System.out.println("Remote access system Published");
    }
}




