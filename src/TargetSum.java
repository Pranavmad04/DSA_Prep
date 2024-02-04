import java.util.*;

class TargetSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Length of the array:");
        int n =sc.nextInt();
        System.out.println("Enter the Elements for the Array:");
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i]  = sc.nextInt();
        }
        System.out.println("Enter the Target Sum:");
        int targetSum = sc.nextInt();
        int[] result = twoNumberSum(array,targetSum);
        if(result.length==2){
            System.out.println("Two Numbers Found: "+result[0]+" and "+result[1]);
        }
        else{
            System.out.println("No two numbers are found with the target sum");
        }
    }
    public static int[] twoNumberSum(int[] array, int targetSum) {
        int n = array.length;
        for(int i=0;i<n-1;i++){
            int firstNum = array[i];
            for(int j=i+1;j<n;j++){
                int secondNum = array[j];
                if(firstNum+secondNum == targetSum){
                    return new int[] {firstNum,secondNum};
                }
            }
        }
        return new int[0];
    }

}
