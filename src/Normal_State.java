public class Normal_State extends IState{
    private static Normal_State instance;

    private Normal_State() {}

    public static  Normal_State getInstance() {
        if(instance == null) {
            instance = new Normal_State();
        }
        return instance;
    }
    public void attack(Monster fighter, Monster target){
        int injury = RNG.getInstance().nextInt(0,fighter.ap);
        target.receiveHurt(injury);

        if(target.isHurt()) {
            fighter.boostState();
        }
    }
    public void booster(Monster fighter)  {
        fighter.ap +=10;
        fighter.setPw_max(fighter.getPw_max() + 15);
        fighter.setCurrent_state(Super_State.getInstance());
    }
}
