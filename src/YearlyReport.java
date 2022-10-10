public class YearlyReport {
    public int sumExpenseOrIncome(int num, boolean isExpense, Report report) {
        int sum = 0;
        for (YearlyRecord row : report.yearReport) {
            if (row.isExpense == isExpense && row.month == num) {
                sum += row.amount;
            }
        }
        return sum;
    }

    public String avgExpenseOrIncome(boolean isExpense, Report report) {
        int sum = 0;
        int temp = 0;
        for (YearlyRecord row : report.yearReport) {
            if (row.isExpense == isExpense) {
                sum += row.amount;
                temp++;
            }
        }
        return " за год: " + sum / temp;
    }

    public void printYearReport(Report report) {
        if (report.checkYear) {
            System.out.println("Информация за " + report.year[0] + " год:");
            for (int month = 0; month < report.MONTH_COUNT; month++) {
                System.out.println("Прибыль за " + report.month[month] + ": " +
                        (sumExpenseOrIncome(month + 1, false, report) -
                                sumExpenseOrIncome(month + 1, true, report)));
            }
            System.out.println("Средний расход " + avgExpenseOrIncome(true, report) + "\n" +
                    "Средний доход " + avgExpenseOrIncome(false, report));
        } else {
            System.out.println("Файл не считан!");
        }
    }
}