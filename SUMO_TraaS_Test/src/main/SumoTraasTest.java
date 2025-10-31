package main;

import java.io.IOException;
import it.polito.appeal.traci.*;
import de.tudresden.sumo.cmd.*;
import de.tudresden.sumo.objects.SumoVehicleData;
import de.tudresden.sumo.util.SumoCommand;

public class SumoTraasTest {
    public static void main(String[] args) {
        
        System.out.println("Testing SUMO connection");
    
        try {
            // Add a small delay to ensure SUMO is fully started
            Thread.sleep(2000);
            
            SumoTraciConnection conn = new SumoTraciConnection(
                "sumo",  // sumo binary
                "/home/user/eclipse-workspace/Sumo_Traas_Test/src/config/config.sumocfg"  // config file, replace with your directory
            );
            
            // Connect
            conn.runServer();
            System.out.println("Connected successfully!");
            
            double vehicleCount = (double) conn.do_job_get(Vehicle.getAccel("1"));
            System.out.println(vehicleCount);
            
            conn.close();
            System.out.println("Connection closed!");
            
        } catch (IOException e) {
            System.out.println("IO Error");
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("General error");
            e.printStackTrace();
        }
    }
}
