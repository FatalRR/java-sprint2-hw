import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean startLoop = true;
        Scanner scanner = new Scanner(System.in);
        MonthlyReport monthlyReport = new MonthlyReport();
        YearlyReport yearlyReport = new YearlyReport();
        Revise revise = new Revise();
        printMenu();
        int userInput = scanner.nextInt();
        loop:
        while (startLoop) {
            switch (userInput) {
                case 1:
                    monthlyReport.readMonthReports();
                    monthlyReport.checkRead();
                    break;
                case 2:
                    yearlyReport.readYearReport();
                    yearlyReport.checkRead();
                    break;
                case 3:
                    revise.reviseReports(monthlyReport, yearlyReport);
                    break;
                case 4:
                    monthlyReport.printMonthlyReport();
                    break;
                case 5:
                    yearlyReport.printYearReport();
                    break;
                case 453:
                    System.out.println("Программа завершена");
                    startLoop = false;
                    break loop;
                default:
                    System.out.println("Извините, такой команды пока нет.");
                    break;
            }
            printMenu();
            userInput = scanner.nextInt();
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

