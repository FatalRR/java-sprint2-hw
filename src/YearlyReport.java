public class YearlyReport {
    public int sumExpense(int num, Report report) {
        int sum = 0;
        for (YearlyRecord row : report.yearReport) {
            if (row.isExpense && row.month == num) {
                sum += row.amount;
            }
        }
        return sum;
    }

    public int sumIncome(int num, Report report) {
        int sum = 0;
        for (YearlyRecord row : report.yearReport) {
            if (!row.isExpense && row.month == num) {
                sum += row.amount;
            }
        }
        return sum;
    }

    public String avgExpense(Report report) {
        int sum = 0;
        int temp = 0;
        for (YearlyRecord row : report.yearReport) {
            if (row.isExpense) {
                sum += row.amount;
                temp++;
            }
        }
        return "Средний расход за год: " + sum / temp;
    }

    public String avgIncome(Report report) {
        int sum = 0;
        int temp = 0;
        for (YearlyRecord row : report.yearReport) {
            if (!row.isExpense) {
                sum += row.amount;
                temp++;
            }
        }
        return "Средний доход за год: " + sum / temp;
    }
    public void printYearReport(Report report) {
        if (report.checkYear) {
            System.out.println("Информация за " + report.year[0] + " год:");
            for (int i = 0; i < report.MONTH_COUNT; i++) {
                System.out.println("Прибыль за " + report.month[i] + ": " + (sumIncome(i + 1, report) - sumExpense(i + 1, report)));
            }
            System.out.println(avgExpense(report) + "\n" +
                    avgIncome(report));
        } else {
            System.out.println("Файл не считан!");
        }
    }
}