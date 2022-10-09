import java.util.ArrayList;

public class Report {
    ReadFiles readFiles = new ReadFiles();
    ArrayList<MonthlyRecord> monthReports = new ArrayList<>();
    ArrayList<YearlyRecord> yearReport = new ArrayList<>();
    String[] year = {"2021"};
    String[] month = {"Январь", "Февраль", "Март"};
    static final int MONTH_COUNT = 3;
    boolean checkMonth = false;
    boolean checkYear = false;

    public void readMonthReports() {
        if (monthReports.isEmpty()) {
            for (int month = 1; month <= MONTH_COUNT; month++) {
                String reportLine = readFiles.readFileContentsOrNull("resources/m.20210" + month + ".csv");
                if (reportLine == null) {
                    return;
                }
                System.out.println("Файл за " + this.month[month - 1] + " считан!");

                String[] lines = reportLine.split("\r?\n");
                for (int j = 1; j < lines.length; j++) {
                    String[] lineContents = lines[j].split(",");
                    String itemName = lineContents[0];
                    boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                    int quantity = Integer.parseInt(lineContents[2]);
                    int sumOfOne = Integer.parseInt(lineContents[3]);
                    monthReports.add(new MonthlyRecord(itemName, isExpense, quantity, sumOfOne, month));
                }
            }
            checkMonth = true;
        } else {
            System.out.println("Отчет уже загружен!");
        }
    }

    public void readYearReport() {
        if (yearReport.isEmpty()) {
            String yearFile = readFiles.readFileContentsOrNull("resources/y.2021.csv");
            if (yearFile == null) {
                return;
            }
            String[] lines = yearFile.split("\r?\n");
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                int month = Integer.parseInt(lineContents[0]);
                int amount = Integer.parseInt(lineContents[1]);
                boolean isExpense = Boolean.parseBoolean(lineContents[2]);
                yearReport.add(new YearlyRecord(month, amount, isExpense));
            }
            System.out.println("Файл за " + year[0] + " считан!");

        } else {
            System.out.println("Отчет уже загружен!");
        }
        checkYear = true;
    }

    public void checkReadMonth() {
        if (!checkMonth) {
            System.out.println("Файлы не считаны!");
        }
    }

    public void checkReadYear() {
        if (!checkYear) {
            System.out.println("Файл не считан!");
        }
    }

}