import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Game_manager {
    public int Battle_Duration = 50; //milliseconds
    // How we define datatype for time  date
    // in C# private DateTime birthdate;
    //public LocalTime start_time = LocalTime.now();
    List <Monster> list_of_monsters = new ArrayList<Monster>();

    public void startGame() {
        Monster monster1 = new Monster("Golbin",100,56,7);
        Monster monster2 = new Monster("Agora", 145,75,12);
        Monster monster3 = new Monster("Reno",256,69,90);
        list_of_monsters.add(monster1);
        list_of_monsters.add(monster2);
        list_of_monsters.add(monster3);
    }
 public boolean isGameOver() {
        return (list_of_monsters.size() == 1);
 }
public boolean isTimeOut(LocalTime start_time) {
      Duration battleDuration = Duration.between(start_time , LocalTime.now());
      return battleDuration.toMillis() >= Battle_Duration;
}
public void battle() {
        int round = 1;
        LocalTime start_time = LocalTime.now();
        while(!isGameOver() && !isTimeOut(start_time)) {
            System.out.println("-------------------Battle Round"+ round +" ------------------");
            int index1 = RNG.getInstance().nextInt(0, list_of_monsters.size());
            int index2 = RNG.getInstance().nextInt(0,list_of_monsters.size());

            while(index1 == index2) {
                index2 = RNG.getInstance().nextInt(0,list_of_monsters.size());
            }

            Monster fighter = list_of_monsters.get(index1);
            Monster target = list_of_monsters.get(index2);

            System.out.println("Fighter : "+fighter.toString());
            System.out.println("Target : "+target.toString());

            while(!fighter.isHurt() && !target.isHurt()) {
                if(fighter.isLucky()) {
                    fighter.boostState();
                }
                fighter.attackTarget(target);
                if(target.isHurt()) {
                    list_of_monsters.remove(target);
                    System.out.println(fighter.getName() + "wins the DUAL FIGHT!");
                    Monster temp = fighter;
                    fighter = target;
                    target = temp;
                }
                round++;
            }
        }
    System.out.println("********************************* LIST OF WINNERS ********************************* ");
    //Display the winners
    for(Monster obj : list_of_monsters) {
        System.out.println(obj.getName() + " Win the battle");
    }
}
}
