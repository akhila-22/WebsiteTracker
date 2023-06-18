
import java.io.IOException;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
public class Scheduler {
        public static void main(String[] args) {
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    // Place your code here that you want to execute every 5 minutes
                    System.out.println("Program is running...");

                    // Call the main method of another Java file
                   try {
                        Main.main(new String[0]);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                }
            };

            // Schedule the task to run every 5 minutes (300,000 milliseconds)
            timer.schedule(task, 0,60000 );

    }



}
