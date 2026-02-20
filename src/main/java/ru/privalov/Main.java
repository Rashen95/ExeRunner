package ru.privalov;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
                "C:\\Program Files\\VMware\\VMware Horizon View Client\\vmware-view.exe",
                "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"
        };

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
