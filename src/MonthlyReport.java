public class MonthlyReport {
    public int sumExpenseOrIncome(int num, boolean isExpense, Report report) {
        int sum = 0;
        for (MonthlyRecord row : report.monthReports) {
            if (row.isExpense == isExpense && row.monthNum == num) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }

    public String maxExpenseOrIncome(int num, boolean isExpense, Report report) {
        int max = 0;
        String name = "";
        for (MonthlyRecord row : report.monthReports) {
            if (row.isExpense == isExpense && row.monthNum == num) {
                int res = row.quantity * row.sumOfOne;
                if (res > max) {
                    max = res;
                    name = row.itemName;
                }
            }
        }
        return name + ", на сумму: " + max;
    }

    public void printMonthlyReport(Report report) {
        if (report.checkMonth) {
            for (int month = 0; month < report.MONTH_COUNT; month++) {
                System.out.println(
                        "Отчет за " + report.month[month] + ":" + System.lineSeparator() +
                                "Самая большая трата: " + maxExpenseOrIncome(month + 1, true, report) + System.lineSeparator() +
                                "Самый прибыльный товар: " + maxExpenseOrIncome(month + 1, false, report));
            }
        } else {
            System.out.println("Файлы не считаны!");
        }
    }
}