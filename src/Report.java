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
        for (int i = 1; i <= MONTH_COUNT; i++) {
            String reportLine = readFiles.readFileContentsOrNull("resources/m.20210" + i + ".csv");
            if (reportLine == null) {
                break;
            }
            System.out.println("Файл за " + this.month[i - 1] + " считан!");

            String[] lines = reportLine.split("\r?\n"); // при использовании System.lineSeparator() перевод строки не осуществляется, данные не считываются, потому что файлы были созданы на mfc/linux, у меня win, поменял на регулярное выражение для кроссплатформености
            for (int j = 1; j < lines.length; j++) {
                String[] lineContents = lines[j].split(",");
                String itemName = lineContents[0];
                boolean isExpense = Boolean.parseBoolean(lineContents[1]);
                int quantity = Integer.parseInt(lineContents[2]);
                int sumOfOne = Integer.parseInt(lineContents[3]);
                monthReports.add(new MonthlyRecord(itemName, isExpense, quantity, sumOfOne, i));
            }
        }
        checkMonth = true;
    }
    public void readYearReport() {
        String yearFile = readFiles.readFileContentsOrNull("resources/y.2021.csv");
        if (yearFile == null) {
            checkYear = false;
        } else {

            String[] lines = yearFile.split("\r?\n");
            for (int i = 1; i < lines.length; i++) {
                String[] lineContents = lines[i].split(",");
                int month = Integer.parseInt(lineContents[0]);
                int amount = Integer.parseInt(lineContents[1]);
                boolean isExpense = Boolean.parseBoolean(lineContents[2]);
                yearReport.add(new YearlyRecord(month, amount, isExpense));
            }
            checkYear = true;
        }
    }
    public void checkReadMonth() {
        if (!checkMonth) {
            System.out.println("Файлы не считаны!");
        }
    }
    public void checkReadYear() {
        if (checkYear) {
            System.out.println("Файл за " + year[0] + " год считан!");
        } else {
            System.out.println("Файл не считан!");
        }
    }

}

