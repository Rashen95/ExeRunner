package ru.privalov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.print("Запускаем рабочие программы? (Y/N): ");
            String command = s.next().strip();
            if (command.equalsIgnoreCase("Y")) {
                break;
            } else if (command.equalsIgnoreCase("N")) {
                System.exit(1);
            } else {
                System.out.println("Тупорез введи Y или N");
            }
        }

        String[] exeFiles = {
                "C:\\Program Files\\Microsoft Office\\root\\Office16\\OUTLOOK.EXE",
                "C:\\Users\\Artem\\AppData\\Roaming\\Telegram Desktop\\Telegram.exe",
                "C:\\Program Files\\JetBrains\\IntelliJ IDEA 2025.3.2\\bin\\idea64.exe",
                "C:\\Program Files\\draw.io\\draw.io.exe",
                "C:\\Program Files\\Docker\\Docker\\Docker Desktop.exe",
                "C:\\Program Files\\DBeaver\\dbeaver.exe",
                "C:\\Program Files\\TrueConf\\Client\\TrueConf.exe",
                "C:\\Program Files (x86)\\CheckPoint\\Endpoint Connect\\TrGUI.exe",
                "C:\\Program Files\\VMware\\VMware Horizon View Client\\vmware-view.exe",
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
        };

        String[] services = {
                "Check Point Endpoint Client Watchdog",
                "Check Point Endpoint Security VPN"
        };

        runServices(services);
        runProgrammes(exeFiles);
        System.out.println("Сервисы и программы готовы к работе...");
        Thread.sleep(3000);
    }

    private static void runServices(String[] services) {
        System.out.println("Запуск сервисов:");
        for (String service : services) {
            try {
                new ProcessBuilder("net", "start", service)
                        .inheritIO()
                        .start()
                        .waitFor();
                Thread.sleep(500);
            } catch (Exception e) {
                System.err.println("Не удалось запустить: " + service);
            }
        }
    }

    private static void runProgrammes(String[] exeFiles) {
        System.out.println("Запуск программ:");
        for (String exePath : exeFiles) {
            try {
                new ProcessBuilder(exePath).start();
                System.out.println("Запущен: " + exePath);
                Thread.sleep(500);
            } catch (Exception e) {
                System.err.println("Не удалось запустить: " + exePath);
            }
        }
    }
}
