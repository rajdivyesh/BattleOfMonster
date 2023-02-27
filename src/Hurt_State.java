public class Hurt_State extends IState{
    private static Hurt_State instance;

    private Hurt_State() {

    }
    public static Hurt_State getInstance() {
        if(instance == null) {
            instance = new Hurt_State();
        }
        return instance;
    }

    public void attack(Monster fighter, Monster target){
        System.out.println("I can not attack, I am hurt");
    }

    public void booster(Monster fighter) {
        System.out.println("I can not Boost, I am hurt");
    }
}
