public class Best_time_to_buy_stock{
    public  static void main(String[] args){
        int [] prices = {7, 1, 5, 3, 6, 4};

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){
            if (price < minPrice){
                minPrice = price;
            }
            else if(price - minPrice > maxProfit){
                maxProfit = price - minPrice;
            }
        }
        System.out.println("Maximum profit which can be achieved is " + maxProfit);
    }
}