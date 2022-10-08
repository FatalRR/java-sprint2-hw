public class Revise {
    public void reviseReports(MonthlyReport monthlyReport, YearlyReport yearlyReport, Report report) {
        if (report.checkMonth && report.checkYear) {
            for (int i = 0; i < report.month.length; i++) {

                if (monthlyReport.sumExpense(i + 1, report) != yearlyReport.sumExpense(i + 1, report)) {
                    System.out.println("Данные по расходам за " + report.month[i] + " не верны!!!");
                }

                if (monthlyReport.sumIncome(i + 1, report) != yearlyReport.sumIncome(i + 1,report)) {
                    System.out.println("Данные по доходам за " + report.month[i] + " не верны!!!");
                }
            }
            System.out.println("Операция успешно завершена.");
        } else {
            System.out.println("Не считаны данные с файлов!");
        }
    }
}
