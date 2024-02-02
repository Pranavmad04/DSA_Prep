import java.util.*;

public class TowerOfHanoi {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no.of Disks:");
        int numberOfDisks = sc.nextInt();
        char sourceRod = 'A';
        char targetRod = 'C';
        char auxiliaryRod = 'B';

        System.out.println("Tower of Hanoi "+ numberOfDisks +" disks: ");
        towerOfHanoi(numberOfDisks,sourceRod,targetRod,auxiliaryRod);
    }
    static void towerOfHanoi(int n, char source, char target, char auxiliary){
        if(n>0){
            towerOfHanoi(n-1,source,auxiliary,target);
            System.out.println("Move Disk"+n+" from rod"+source+" to rod"+target);
            towerOfHanoi(n-1,auxiliary,target,source);
        }
    }
}
