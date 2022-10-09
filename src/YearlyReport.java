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
            for (int i = 0; i < report.MONTH_COUNT; i++) {
                System.out.println("Прибыль за " + report.month[i] + ": " +
                        (sumExpenseOrIncome(i + 1, false, report) -
                                sumExpenseOrIncome(i + 1, true, report)));
            }
            System.out.println("Средний расход " + avgExpenseOrIncome(true, report) + "\n" +
                    "Средний доход " + avgExpenseOrIncome(false, report));
        } else {
            System.out.println("Файл не считан!");
        }
    }
}