package com.io_programing.advanced_problems.encrypt_decrypt_csv_data;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptDecryptCSV {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            throw new RuntimeException("Error generating key", e);
        }
    }

    public static String encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Encryption error", e);
        }
    }

    public static String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
            return new String(decryptedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Decryption error", e);
        }
    }

    public static void writeEncryptedCSV(String fileName) {
        String[] employees = {
                "101,Muskan Gupta,IT," + encrypt("60000") + "," + encrypt("muskan@gmail.com"),
                "102,Nancy Mehra,HR," + encrypt("58000") + "," + encrypt("nancy@gmail.com"),
                "103,Pragya Sable,Finance," + encrypt("52000") + "," + encrypt("pragya@gmail.com")
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("ID,Name,Department,Salary,Email");
            writer.newLine();
            for (String emp : employees) {
                writer.write(emp);
                writer.newLine();
            }
            System.out.println("Encrypted CSV written successfully!");
        } catch (IOException e) {
            System.err.println("Error writing CSV: " + e.getMessage());
        }
    }

    public static void readDecryptedCSV(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    System.out.println(line);
                    isHeader = false;
                    continue;
                }

                String[] columns = line.split(",");
                String decryptedSalary = decrypt(columns[3]);
                String decryptedEmail = decrypt(columns[4]);

                System.out.println(columns[0] + " | " + columns[1] + " | " + columns[2] + " | " + decryptedSalary + " | " + decryptedEmail);
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "src/main/java/com/ioprogramming/encryptedEmployees.csv";

        writeEncryptedCSV(fileName);
        System.out.println("\nDecrypted Data:");
        readDecryptedCSV(fileName);
    }
}

