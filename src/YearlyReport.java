import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class YearlyReport {
    ArrayList<YearlyRecord> yearReport = new ArrayList<>();
    String[] year = {"2021"};
    String[] month = {"Январь", "Февраль", "Март"};
    boolean check = false;

    public String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с годовым отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }

    public void readYearReport() {
        String yearFile = readFileContentsOrNull("resources/y.2021.csv");
        String[] lines = yearFile.split("\n");
        for (int i = 1; i < lines.length; i++) {
            String[] lineContents = lines[i].split(",");
            int month = Integer.parseInt(lineContents[0]);
            int amount = Integer.parseInt(lineContents[1]);
            boolean isExpense = Boolean.parseBoolean(lineContents[2]);
            yearReport.add(new YearlyRecord(month, amount, isExpense));
        }
        check = true;
    }

    public void checkRead() {
        if (check == true) {
            System.out.println("Файл за " + year[0] + " год считан!");
        } else {
            System.out.println("Файл не считан!");
        }
    }

    public int sumExpense(int num) {
        int sum = 0;
        for (YearlyRecord row : yearReport) {
            if (row.isExpense && row.month == num) {
                sum += row.amount;
            }
        }
        return sum;
    }

    public int sumIncome(int num) {
        int sum = 0;
        for (YearlyRecord row : yearReport) {
            if (!row.isExpense && row.month == num) {
                sum += row.amount;
            }
        }
        return sum;
    }

    public int avgExpense() {
        int sum = 0;
        int temp = 0;
        for (YearlyRecord row : yearReport) {
            if (row.isExpense) {
                sum += row.amount;
                temp++;
            }
        }
        return sum / temp;
    }

    public int avgIncome() {
        int sum = 0;
        int temp = 0;
        for (YearlyRecord row : yearReport) {
            if (!row.isExpense) {
                sum += row.amount;
                temp++;
            }
        }
        return sum / temp;
    }


    public void printYearReport() {
        if (check) {
            System.out.println("Информация за " + year[0] + " год:");
            for (int i = 0; i < month.length; i++) {
                System.out.println("Прибыль за " + month[i] + ": " + (sumIncome(i + 1) - sumExpense(i + 1)));
            }
            System.out.println("Средний доход за год: " + avgExpense() + "\n" +
                    "Средний расход за год: " + avgIncome());
        } else {
            System.out.println("Файл не считан!");
        }
    }
}