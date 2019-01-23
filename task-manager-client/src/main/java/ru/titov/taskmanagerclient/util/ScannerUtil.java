package ru.titov.taskmanagerclient.util;

import lombok.Getter;

import java.util.Scanner;

public enum  ScannerUtil {
    ;

    @Getter
    private static Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine().toLowerCase().trim();
    }

    public static Integer nextInt() {
        try {
            return Integer.parseInt(scanner.nextLine().toLowerCase().trim());
        } catch (Exception e) {
            return null;
        }
    }
}
