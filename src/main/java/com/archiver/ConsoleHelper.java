package com.archiver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

  private ConsoleHelper() {
  }

  private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

  public static void writeMessage(String message) {
    System.out.println(message);
  }

  public static String readString() throws IOException {
    return bis.readLine();
  }

  public static int readInt() throws IOException {
    String text = readString();
    return Integer.parseInt(text.trim());
  }
}