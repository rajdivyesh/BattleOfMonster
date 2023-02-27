public class Monster {
    private String name;
    public int pw;
    private int pw_max;
    public int ap;
    public int luck;
    private IState current_state;

    public Monster(String name, int pw, int ap, int luck) {
        this.name = name;
        this.pw = pw;
        this.ap = ap;
        this.luck = luck;
        this.pw_max = pw;
        this.current_state = Normal_State.getInstance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPw_max() {
        return pw_max;
    }

    public void setPw_max(int pw_max) {
        this.pw_max = pw_max;
    }

    public IState getCurrent_state() {
        return current_state;
    }

    public void setCurrent_state(IState current_state) {
        this.current_state = current_state;
    }

    public void receiveHurt(int injury) {
        this.pw -=injury;
        System.out.println(this.name + " received " + injury+ " damage or injuries");
        if(this.pw<=0) {
            if(this.current_state instanceof Normal_State) {
                this.current_state = Hurt_State.getInstance();
                System.out.println(this.getName() + " is Dead");
            }
            if(this.current_state instanceof Super_State) {
                this.current_state = Normal_State.getInstance();
                this.heal();
            }
        }
    }
    public void heal() {
        this.pw = this.pw_max;
    }

    public boolean isLucky() {
        int random = RNG.getInstance().nextInt(0,100);
        return (random < this.luck);
    }

    public boolean isHurt() {
        // Is this Monster's state an object of Hurt_State class?
        // Java says wait I will check it
        // Java: I have a technique which I can test
        // where is the original class of the object
        // where this object comes from, this object created from which class
        // Do you have any guess? I have an Idea , it is Hurt_State
        // use instanceof sysntax to check the origin class for object
        // always the return answer is true or false
        return (this.current_state instanceof Hurt_State);
    }

    public void attackTarget(Monster target) {
        // this is an object from Monster own class
        this.current_state.attack(this, target);
    }

    public void boostState() {
        this.current_state.booster(this);
    }

    public String toString() {
        // function for show the message
        String state = "";
        if(this.current_state instanceof Normal_State) {
            state  = "Normal";
        } else if (this.current_state instanceof  Super_State) {
            state = "Supper";
        }else {
            state = "Hurt";
        }
        //Ternary  Version for if and else if
        // String state = (this.current_state instanceof Normal_State) ? "Normal" :
        //                (this.current_state instanceof Super_State) ? "Super" : " Hurt";
        String message = this.name + " | HP: " + this.pw;
        message += " | HP Max: " + this.pw_max;
        message += " | AP: " + this.ap;
        message += " | Luck: " + this.luck;
        message += " | State: " +  state;

        return message;
    }

}
