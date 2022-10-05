public class Revise {
    String[] month = {"Январь", "Февраль", "Март"};
    public void reviseReports(MonthlyReport monthlyReport, YearlyReport yearlyReport) {

        if (monthlyReport.check && yearlyReport.check) {
            for (int i = 0; i < month.length; i++) {

                if (monthlyReport.sumExpense(i + 1) != yearlyReport.sumExpense(i + 1)) {
                    System.out.println("Данные по расходам за " + month[i] + " не верны!!!");
                }

                if (monthlyReport.sumIncome(i + 1) != yearlyReport.sumIncome(i + 1)) {
                    System.out.println("Данные по доходам за " + month[i] + " не верны!!!");
                }
            }
            System.out.println("Операция успешно завершена.");
        } else {
            System.out.println("Не считаны данные с файлов!");
        }
    }
}
