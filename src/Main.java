import java.util.Scanner;
public class Main {

    private enum Command {
        EXIT("Выход"),
        READ_MONTH("Считать все месячные отчеты"),
        READ_YEAR("Считать годовой отчет"),
        REVISE_REPORT("Сверить отчеты"),
        INF_MONTH_REPORT("Информация о всех месячных отчетах"),
        INF_YEAR_REPORT("Информация о годовом отчете");
        public final String itemName;
        Command(String aName) {
            this.itemName = aName;
        }

    }

    public static void main(String[] args) {
        final Command[] command = Command.values();
        Scanner scanner = new Scanner(System.in);
        Report report = new Report();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Revise revise = new Revise();
        printMenu();

        startLoop:
        while (true) {
            int userInput = scanner.nextInt();
            switch (command[userInput]) {
                case READ_MONTH:
                    report.readMonthReports();
                    report.checkReadMonth();
                    break;
                case READ_YEAR:
                    report.readYearReport();
                    report.checkReadYear();
                    break;
                case REVISE_REPORT:
                    revise.reviseReports(monthlyReport, yearlyReport, report);
                    break;
                case INF_MONTH_REPORT:
                    monthlyReport.printMonthlyReport(report);
                    break;
                case INF_YEAR_REPORT:
                    yearlyReport.printYearReport(report);
                    break;
                case EXIT:
                    System.out.println("Программа завершена");
                    break startLoop;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
            printMenu();
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать? \n " +
                "1 - Считать все месячные отчеты \n " +
                "2 - Считать годовой отчет \n " +
                "3 - Сверить отчеты \n " +
                "4 - Информация о всех месячных отчетах \n " +
                "5 - Информация о годовом отчете \n " +
                "0 - Выход");
    }
}

