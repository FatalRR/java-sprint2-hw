public class MonthlyRecord {
    String itemName;
    boolean isExpense;
    int quantity;
    int sumOfOne;
    int monthNum;

    public MonthlyRecord(String itemName, boolean isExpense, int quantity, int sumOfOne, int monthNum) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
        this.monthNum = monthNum;
    }
}