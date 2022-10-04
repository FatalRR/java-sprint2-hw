import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<MonthlyRecord> monthReports = new ArrayList<>();
    String[] month = {"Январь", "Февраль", "Март"};

    public String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public void readMonthReports() {
        for (int i = 1; i <= 3; i++) {
            String reportLine = readFileContentsOrNull("resources/m.20210" + i + ".csv");
            String[] lines = reportLine.split("\n");
            int month = i;
            for (int j = 1; j < lines.length; j++) {
                String[] lineContents = lines[j].split(",");
                String itemName = lineContents[0];
                boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                int quantity = Integer.parseInt(lineContents[2]);
                int sumOfOne = Integer.parseInt(lineContents[3]);
                monthReports.add(new MonthlyRecord(itemName, isExpense, quantity, sumOfOne, month));
            }
            System.out.println("Файл за " + this.month[i - 1] + " считан!");
        }
    }

    public int sumExpense(int num) {
        int sum = 0;
        for (MonthlyRecord row : monthReports) {
            if (row.isExpense && row.monthNum == num) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }

    public int sumIncome(int num) {
        int sum = 0;
        for (MonthlyRecord row : monthReports) {
            if (!row.isExpense && row.monthNum == num) {
                sum += row.quantity * row.sumOfOne;
            }
        }
        return sum;
    }

    public int maxExpense(int num) {
        int max = 0;
        for (MonthlyRecord row : monthReports) {
            if (row.isExpense && row.monthNum == num) {
                if (row.quantity * row.sumOfOne > max) {
                    max = row.quantity * row.sumOfOne;
                }
            }
        }
        return max;
    }

    public String maxNameExpense(int num) {
        int max = 0;
        String name = "";
        for (MonthlyRecord row : monthReports) {
            if (row.isExpense && row.monthNum == num) {
                if (row.quantity * row.sumOfOne > max) {
                    max = row.quantity * row.sumOfOne;
                    name = row.itemName;
                }
            }
        }
        return name;
    }

    public int maxIncome(int num) {
        int max = 0;
        for (MonthlyRecord row : monthReports) {
            if (!row.isExpense && row.monthNum == num) {
                if (row.quantity * row.sumOfOne > max) {
                    max = row.quantity * row.sumOfOne;
                }
            }
        }
        return max;
    }

    public String maxNameIncome(int num) {
        int max = 0;
        String name = "";
        for (MonthlyRecord row : monthReports) {
            if (!row.isExpense && row.monthNum == num) {
                if (row.quantity * row.sumOfOne > max) {
                    max = row.quantity * row.sumOfOne;
                    name = row.itemName;
                }
            }
        }
        return name;
    }

    public void printMonthlyReport() {
        for (int i = 0; i < month.length; i++) {
            System.out.println(sumExpense(i + 1));
            System.out.println(sumIncome(i + 1));
            System.out.println("Отчет за месяц: " + month[i]);
            System.out.println("Самый прибыльный товар: " + maxNameExpense(i + 1) + ", на сумму: " + maxExpense(i + 1));
            System.out.println("Самая большая трата: " + maxNameIncome(i + 1) + ", на сумму: " + maxIncome(i + 1));

        }
    }
}