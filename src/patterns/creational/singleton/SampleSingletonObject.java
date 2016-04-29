package patterns.creational.singleton;

public class SampleSingletonObject {
    
    private static SampleSingletonObject data;
    
    private static Object                lock = new Object();
    
    private SampleSingletonObject() {
        
    }
    
    public static SampleSingletonObject getInstance() {
        /*-this is an optimization technique commonly know as double check locking 
         * the idea is to avoid acquiring the lock once object is initialized.
         */
        if (data == null) {
            synchronized (lock) {
                if (data == null) {
                    data = new SampleSingletonObject();
                }
            }
        }
        return data;
    }
}
