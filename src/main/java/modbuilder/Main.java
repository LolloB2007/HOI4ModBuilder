package modbuilder;

import java.util.concurrent.CountDownLatch;

/**
 * main class needed just to start the project and display a save menu when trying to quit the application
 * @author lorenzobarbagelata
 */
public class Main {

    /**
     * latch that aids the save action close menu from controller
     */
    public static final CountDownLatch latch = new CountDownLatch(1);
    
    public static void main(String[]args) {
        
        Controller c = new Controller();
        
        /*
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                c.displaySaveMenu();
                try {
                    latch.await();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }));
        */
    }
    
}
