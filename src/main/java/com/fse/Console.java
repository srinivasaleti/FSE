package com.fse;

import java.util.Scanner;

public class Console {
    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    String readString(String message) {
        System.out.print(message+" :");
        return this.scanner.next();
    }

    int readInt(String message) {
        System.out.print(message+" :");
        return this.scanner.nextInt();
    }

    double readDouble(String message) {
        System.out.print(message+" :");
        return this.scanner.nextDouble();
    }
}
