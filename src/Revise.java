public class Revise {
    public void reviseReports(MonthlyReport monthlyReport, YearlyReport yearlyReport, Report report) {
        if (report.checkMonth && report.checkYear) {
            for (int month = 0; month < report.month.length; month++) {

                if (monthlyReport.sumExpenseOrIncome(month + 1, true, report) != yearlyReport.sumExpenseOrIncome(month + 1, true, report)) {
                    System.out.println("Данные по расходам за " + report.month[month] + " не верны!!!");
                }

                if (monthlyReport.sumExpenseOrIncome(month + 1, false, report) != yearlyReport.sumExpenseOrIncome(month + 1, false, report)) {
                    System.out.println("Данные по доходам за " + report.month[month] + " не верны!!!");
                }
            }
            System.out.println("Операция успешно завершена.");
        } else {
            System.out.println("Не считаны данные с файлов!");
        }
    }
}
