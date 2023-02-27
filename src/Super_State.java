public class Super_State extends IState{

    private static Super_State instance;

    private Super_State() {}

    public static Super_State getInstance() {
        if(instance == null) {
            instance = new Super_State();
        }
        return instance;
    }

    public void attack(Monster fighter, Monster target) {
        int injury = RNG.getInstance().nextInt(fighter.ap, 2*fighter.ap);
        target.receiveHurt(injury);
        if(target.isHurt()) {
            fighter.boostState();
        }
    }
    public void booster(Monster fighter) {
        fighter.ap += 10;
        fighter.setPw_max(fighter.getPw_max() + 15);
    }
}
