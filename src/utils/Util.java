/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
* This is comment, do not delete 2021.11.30
 * and open the template in the editor.
 */
package utils;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 *
 * @author hd
 */
public class Util {

    /**
     * Nhập một chuỗi
     *
     * @param welcome : thong báo khi nhập chuỗi
     * @return Chuỗi
     */
    public static String getString(String welcome) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (result.isEmpty()) {
                System.out.println("Input text!!!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    public static String getString(String welcome, String parttern) {
        boolean check = true;
        String result = "";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            result = sc.nextLine();
            if (!result.matches(parttern)) {
                System.out.println("Input error parttern text!");
            } else {
                check = false;
            }
        } while (check);
        return result;
    }

    /**
     * Hiển thị ra màn hình câu thông báo nhap dữ liệu mới
     *
     * @param welcome : kiểu String dùng thông báo
     * @param oldData : kiểu String, dữ liệu cũ để người dùng theo dõi
     * @return Dữ liệu mới kiểu String
     */
    public static String updateString(String welcome, String oldData) {
        String result = oldData;
        Scanner sc = new Scanner(System.in);
        System.out.print(welcome);
        String tmp = sc.nextLine();
        if (!tmp.isEmpty()) {
            result = tmp;
        }
        return result;
    }

    public static String getString(String welcome, String parttern, String oldData) {
        boolean check = true;
        String result = oldData;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            String tmp = sc.nextLine();
            if (!tmp.isEmpty()) {
                check = false;
            } else if (!tmp.matches(parttern)) {
                System.out.print("Input error parttern text!!!");
            } else {
                result = tmp;
                check = false;
            }
        } while (check);
        return result;
    }

    /**
     * Hàm nhập một số nguyên trong 1 vùng giá trị
     *
     * @param welcome kiểu String: câu thông báo
     * @param min kiểu int: giá trị nhỏ nhất
     * @param max kiểu int: giá trị lớn nhất
     * @return giá trị int trong khoảng cho phép
     */
    public static int getInt(String welcome, int min, int max) {
        boolean check = true;
        int number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Integer.parseInt(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static int updateInt(String welcome, int min, int max, int oldData) {
        boolean check = true;
        int number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Integer.parseInt(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check || number > max || number < min);
        return number;
    }

    public static double getDouble(String welcome) {
        boolean check = true;
        double number = 0;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                number = Double.parseDouble(sc.nextLine());
                check = false;
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check);
        return number;
    }

    public static double updateDouble(String welcome, double oldData) {
        boolean check = true;
        double number = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    number = Double.parseDouble(tmp);
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check);
        return number;
    }

    public static boolean updateBoolean(String welcome, boolean oldData) {
        boolean check = true;
        boolean data = oldData;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(welcome);
                String tmp = sc.nextLine();
                if (tmp.isEmpty()) {
                    check = false;
                } else {
                    if ("Y".equalsIgnoreCase(tmp)) {
                        data = true;
                    } else if ("N".equalsIgnoreCase(tmp)) {
                        data = false;
                    }
                    check = false;
                }
            } catch (Exception e) {
                System.out.println("Input number!!!");
            }
        } while (check);
        return data;
    }

    public static boolean confirmYesNo(String welcome) {
        boolean result = false;
        String confirm = Util.getString(welcome);
        if ("Y".equalsIgnoreCase(confirm)) {
            result = true;
        }
        return result;
    }

    public static Date inputDate(String welcome, Date minDate, Date maxDate) {
        boolean check = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        Date result = null;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            String userInput = sc.nextLine();

            try {
                result = (Date) dateFormat.parse(userInput);

                if (result.before(minDate) || result.after(maxDate)) {
                    System.out.println("Input error! The date is out of range.");
                } else {
                    check = false;
                }
            } catch (ParseException e) {
                System.out.println("Input error! Please enter the date in the format HH:mm dd/MM/yyyy");
            }
        } while (check);

        return result;
    }
    
     public static Date inputDate(String welcome, Date minDate) {
        boolean check = true;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date result = null;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print(welcome);
            String userInput = sc.nextLine();

            try {
                result = (Date) dateFormat.parse(userInput);

                if (result.before(minDate)) {
                    System.out.println("Input error! The date is out of range.");
                } else {
                    check = false;
                }
            } catch (ParseException e) {
                System.out.println("Input error! Please enter the date in the format HH:mm dd/MM/yyyy");
            }
        } while (check);

        return result;
    }

}
