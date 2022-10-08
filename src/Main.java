import java.util.Scanner;
public class Main {

//    enum command {
//        EXIT,
//        READ_MONTH,
//        READ_YEAR,
//        REVISE_REPORT,
//        INF_MONTH_REPORT,
//        INF_YEAR_REPORT
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Report report = new Report();
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Revise revise = new Revise();
        printMenu();

        startLoop:
        while (true) {    // 3 дня бился над Enum, не смог разобраться, не очень понятно как это использовать вместе со свитчем, не понятно как вызвать
            // испробывал values(), ordinal(), 10 статей про него, так и не дошло, если поможете разобраться как им пользоваться именно со switch и вводом с клавиатуры, будет шикарно
            int userInput = scanner.nextInt();
            switch (userInput) {
                case 1:
                    report.readMonthReports();
                    report.checkReadMonth();
                    break;
                case 2:
                    report.readYearReport();
                    report.checkReadYear();
                    break;
                case 3:
                    revise.reviseReports(monthlyReport, yearlyReport, report);
                    break;
                case 4:
                    monthlyReport.printMonthlyReport(report);
                    break;
                case 5:
                    yearlyReport.printYearReport(report);
                    break;
                case 453:
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
                "453 - Выход");
    }
}

