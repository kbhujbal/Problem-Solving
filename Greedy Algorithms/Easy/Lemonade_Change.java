public class Lemonade_Change{
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20};

        boolean isPossible = lemonadeChange(bills);
        
        if(isPossible) System.out.println("Possible");
        else System.out.println("Not Possible");
    }

    private static boolean lemonadeChange(int[] bills){
        int five = 0, ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            else if (bill == 10) {
                if(five <= 0) return false;

                five--;
                ten++;
            }
            else{
                if(five > 0 && ten > 0){
                    five--;
                    ten--;
                }
                else if (five >= 3) {
                    five -= 3;
                }
                else return false;
            }
        }
        return true;
    }
}