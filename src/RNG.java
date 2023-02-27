import java.util.Random;

public class RNG extends Random {
    private static RNG instance;
    private RNG() {}

    public static RNG getInstance() {
        if(instance == null){
            instance = new RNG();
        }
        return instance;
    }
}
