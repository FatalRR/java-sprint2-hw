public class MonthlyReport {
    public int sumExpense(int num, Report report) {
        int sum = 0;
        for (MonthlyRecord row : report.monthReports) {
            if (row.isExpense && row.monthNum == num) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }
    public int sumIncome(int num, Report report) {
        int sum = 0;
        for (MonthlyRecord row : report.monthReports) {
            if (!row.isExpense && row.monthNum == num) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }
    public String maxExpense(int num, Report report) {
        int max = 0;
        String name = "";
        for (MonthlyRecord row : report.monthReports) {
            if (row.isExpense && row.monthNum == num) {
                int res = row.quantity * row.sumOfOne;
                if (res > max) {
                    max = res;
                    name = row.itemName;
                }
            }
        }
        return "Самая большая трата: " + name + ", на сумму: " + max;
    }
    public String maxIncome(int num, Report report) {
        int max = 0;
        String name = "";
        for (MonthlyRecord row : report.monthReports) {
            if (!row.isExpense && row.monthNum == num) {
                int res = row.quantity * row.sumOfOne;
                if (res > max) {
                    max = res;
                    name = row.itemName;
                }
            }
        }
        return "Самый прибыльный товар: " + name + ", на сумму: " + max;
    }

    public void printMonthlyReport(Report report) {
        if (report.checkMonth) {
            for (int i = 0; i < report.MONTH_COUNT; i++) {
                System.out.println(
                        "Отчет за " + report.month[i] + ":\n" +
                                maxExpense(i + 1, report) + "\n" +
                                maxIncome(i + 1, report));
            }
        } else {
            System.out.println("Файлы не считаны!");
        }
    }
}