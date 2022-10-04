public class Revise {
    MonthlyReport monthlyReport = new MonthlyReport();
    YearlyReport yearlyReport = new YearlyReport();
    String[] month = {"Январь", "Февраль", "Март"};

    public void reviseReports() {
        boolean check = true;
        for (int i = 0; i < month.length; i++) {
            System.out.println(monthlyReport.sumExpense(i + 1));
            System.out.println(yearlyReport.sumExpense(i + 1));
            System.out.println(monthlyReport.sumIncome(i + 1));
            System.out.println(yearlyReport.sumIncome(i + 1));

            if (monthlyReport.sumExpense(i + 1) != yearlyReport.sumExpense(i + 1)) {
                System.out.println("Данные по расходам за " + month[i] + " не верны!!!");
                check = false;
            }

            if (monthlyReport.sumIncome(i + 1) != yearlyReport.sumIncome(i + 1)) {
                System.out.println("Данные по доходам за " + month[i] + " не верны!!!");
                check = false;
            }

        }
        if (check) {
            System.out.println("Операция завершена успешно завершена.");
        } else {
            System.out.println("Данные не совпадают!!!");
        }
    }
}
