import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Implement implements Optionals {
    private static boolean isNumeric(String str) {
        return str != null && str.matches("[0-9.]+");
    }

    // USER CAPABILITIES
    public void Register(int patientLimit1, int patientLimit2, int patientLimit3, int patientLimit4, int patientLimit5,
            int attempts1, int attempts2, int attempts3, int attempts4, int attempts5,
            String date1, String date2, String date3, String date4, String date5,
            String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4,
            String vaccinationSite5,
            String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
            String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
            String start1, String start2, String start3, String start4, String start5,
            String end1, String end2, String end3, String end4, String end5,
            Scanner input, Implement imp,
            LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2,
            LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4,
            LinkedHashMap<String, String> nameList5,
            LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2,
            LinkedHashMap<String, Integer> ageList3, LinkedHashMap<String, Integer> ageList4,
            LinkedHashMap<String, Integer> ageList5,
            LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,
            LinkedHashMap<String, String> mobileNum3,
            LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
            LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,
            LinkedHashMap<String, String> addresses3, LinkedHashMap<String, String> addresses4,
            LinkedHashMap<String, String> addresses5,
            LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3,
            LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
            LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2,
            LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4,
            LinkedHashMap<String, String> passList5,
            LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2,
            LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4,
            LinkedHashMap<String, String> middleName5,
            LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2,
            LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4,
            LinkedHashMap<String, String> timeList5,
            LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2,
            LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4,
            LinkedHashMap<String, String> dateList5,
            LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2,
            LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4,
            LinkedHashMap<String, String> doseName5,
            int choice, boolean setReserve) {
        System.out.println(
                "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        Calendar cal = Calendar.getInstance();
        DateTimeFormatter dtf = DateTimeFormatter
                .ofPattern("'Date:\u001B[33m 'yyyy-MM-dd " + "\n\t'\u001B[36mTime:\u001B[33m 'hh:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        SimpleDateFormat sdf = new SimpleDateFormat("'Date: 'yyyy-MM-dd 'Time: 7:00AM - 5:00PM'");
        cal.add(Calendar.DAY_OF_MONTH, 14);
        String dateR1 = sdf.format(cal.getTime());
        String timeR1 = dtf.format(now);
        Random random = new Random();
        String userMpin = String.format("%04d", random.nextInt(10000));
        int age;
        while (true) {
            try {
                System.out.print("\u001B[36mEnter the number of which dose phase would like to reserve: \u001B[37m");
                choice = input.nextInt();
                /*
                 * if (patientLimit1 == 0 && patientLimit2 == 0 && patientLimit3 == 0 &&
                 * patientLimit4 == 0 && patientLimit5 == 0 &&doctor1 == null&& doctor2 == null
                 * &&doctor3 == null &&doctor4 == null &&doctor5 == null &&vaccinationSite1 ==
                 * null && vaccinationSite2 == null&& vaccinationSite3 == null &&
                 * vaccinationSite4 == null && vaccinationSite5 == null && vaccinator1 == null
                 * && vaccinator2 == null&& vaccinator3 == null&& vaccinator4 == null&&
                 * vaccinator5 == null && date1 == null && date2 == null&& date3 == null&&
                 * date4== null&& date5== null && start1 == null && start2 == null&& start3 ==
                 * null&& start4 == null&& start5 == null && end1 == null && end2 == null &&
                 * end3 == null && end4== null && end5 == null)
                 * 
                 * 
                 * //Balik prompt
                 * while (true){
                 * System.out.println("\u001B[31mReservation list is empty.");
                 * try {
                 * System.out.
                 * print("\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: "
                 * );
                 * choice = input.nextInt();
                 * if (choice == 1) {
                 * System.out.print("\033[H\033[2J");
                 * System.out.flush();
                 * Prompts.Prompt(patientLimit1,patientLimit2,patientLimit3,patientLimit4,
                 * patientLimit5,attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                 * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                 * vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                 * doctor3, doctor4,vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                 * start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                 * imp, nameList1,nameList2, nameList3 , nameList4, nameList5, ageList1,
                 * ageList2, ageList3 , ageList4, ageList5, mobileNum1,mobileNum2, mobileNum3,
                 * mobileNum4,mobileNum5, addresses1,addresses2,addresses3,
                 * addresses4,addresses5, IDs1,IDs2,IDs3,IDs4,IDs5, passList1, passList2,
                 * passList3,passList4, passList5,middleName1,middleName2,
                 * middleName3,middleName4, middleName5, timeList1, timeList2, timeList3,
                 * timeList4, timeList5, dateList1,dateList2,dateList3,dateList4,dateList5,
                 * doseName1, doseName2,doseName3, doseName4,doseName5,0, false);
                 * }
                 * else {
                 * System.out.
                 * println("\u001B[31mInvalid input! Please enter number 1 only and press enter."
                 * );
                 * }
                 * }
                 * catch (InputMismatchException ex) {
                 * System.out.
                 * println("\u001B[31mInvalid input! Please enter a number and try again.");
                 * input.nextLine();
                 * }
                 * }
                 * }
                 */
                if (choice == 1) {
                    while (attempts1 <= patientLimit1) {
                        IDs1.put(userMpin, userMpin);
                        dateList1.put(userMpin, dateR1);
                        timeList1.put(userMpin, timeR1);
                        attempts1++;

                        // While loop for Wholle name.
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName = input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true) {
                                System.out.print(
                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                            } else if (fName != null || secondName != null) {
                                while (true) {
                                    System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                    String mName = input.next();
                                    String secondName2 = input.nextLine();
                                    if (isNumeric(mName) == true || isNumeric(secondName2) == true) {
                                        System.out.print(
                                                "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                    } else if (mName != null || secondName != null) {
                                        middleName1.put(userMpin, mName + secondName2);
                                        while (true) {
                                            System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                            String lName = input.next();
                                            String secondName3 = input.nextLine();
                                            if (isNumeric(lName) == true || isNumeric(secondName3) == true) {
                                                System.out.print(
                                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                            } else if (mName != null || secondName != null) {

                                                nameList1.put(userMpin,
                                                        fName + " " + secondName + " "
                                                                + middleName1.get(userMpin).charAt(0) + ". " + lName
                                                                + secondName3);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        // FOr age
                        while (true) {
                            try {
                                System.out.print("\u001B[36mEnter your Age: \u001B[37m");
                                age = input.nextInt();
                                ageList1.put(userMpin, age);
                                break;
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                        }

                        // For Mobile num
                        while (true) {
                            System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");
                            String mobileNumber = input.next();
                            if (mobileNumber.length() == 11) {
                                mobileNum1.put(userMpin, mobileNumber);
                                break;
                            }

                            else {
                                System.out.print(
                                        "\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");
                            }
                        }
                        // For address
                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String address = input.next();
                        String address1 = input.nextLine();
                        addresses1.put(userMpin, address + " " + address1);

                        // Forr password
                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList1.put(userMpin, pass);

                        if (age <= 17) {
                            String[] doses = { "1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)" };
                            System.out.print(
                                    "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                            for (String dose : doses) {
                                System.out.println(dose);
                            }
                            while (true) {
                                try {
                                    System.out.println(
                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, doses[0]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 2) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, doses[1]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    }
                                } catch (InputMismatchException ex) {
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                    input.nextLine();
                                }
                            }
                        }
                        if (age >= 18) {
                            String[] AdultDose = { "1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer",
                                    "5 - Sputnik V", "6 - Sinovac" };
                            System.out.print(
                                    "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                            for (String dose : AdultDose) {
                                System.out.println(dose);
                            }
                            while (true) {
                                try {
                                    System.out.println(
                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, AdultDose[0]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 2) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, AdultDose[1]);
                                        System.out
                                                .println("\u001B[36mChosen dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 3) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, AdultDose[2]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 4) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, AdultDose[3]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 5) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, AdultDose[4]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 6) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName1.put(userMpin, AdultDose[5]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName1.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    }
                                } catch (InputMismatchException ex) {
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                    input.nextLine();
                                }

                            }
                        }
                    }
                    // Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");
                    // Balik prompt
                    while (true) {
                        try {
                            System.out.print(
                                    "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                ;
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                        patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                        date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                        vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                        start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                                        nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                        mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,
                                        IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                        middleName1, middleName2, middleName3, middleName4, middleName5, timeList1,
                                        timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3,
                                        dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0,
                                        false);
                            } else {
                                System.out.println(
                                        "\u001B[31mInvalid input! Please enter number 1 only and press enter.");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }
                } else if (choice == 2) {
                    while (attempts2 <= patientLimit2) {
                        IDs2.put(userMpin, userMpin);
                        dateList2.put(userMpin, dateR1);
                        timeList2.put(userMpin, timeR1);
                        attempts2++;

                        // For name
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName = input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true) {
                                System.out.print(
                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                            } else if (fName != null || secondName != null) {
                                while (true) {
                                    System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                    String mName = input.next();
                                    String secondName2 = input.nextLine();
                                    if (isNumeric(mName) == true || isNumeric(secondName2) == true) {
                                        System.out.print(
                                                "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                    } else if (mName != null || secondName != null) {
                                        middleName2.put(userMpin, mName + secondName2);
                                        while (true) {
                                            System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                            String lName = input.next();
                                            String secondName3 = input.nextLine();
                                            if (isNumeric(lName) == true || isNumeric(secondName3) == true) {
                                                System.out.print(
                                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                                            } else if (mName != null || secondName != null) {

                                                nameList2.put(userMpin,
                                                        fName + " " + secondName + " "
                                                                + middleName2.get(userMpin).charAt(0) + ". " + lName
                                                                + secondName3);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        // For age
                        while (true) {
                            try {
                                System.out.print("\u001B[36mEnter your Age: \u001B[37m");
                                age = input.nextInt();
                                ageList2.put(userMpin, age);
                                break;
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                        }
                        // For MobileNum
                        while (true) {
                            System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");
                            String mobileNumber = input.next();
                            if (mobileNumber.length() == 11) {
                                mobileNum2.put(userMpin, mobileNumber);
                                break;
                            }

                            else {
                                System.out.print(
                                        "\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");
                            }
                        }
                        // For address, tanggalin yung parang exception

                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String address = input.next();
                        String address2 = input.nextLine();
                        addresses2.put(userMpin, address + " " + address2);

                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList2.put(userMpin, pass);

                        // For 6 months to 17 years old
                        if (age <= 17) {
                            String[] doses = { "1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)" };
                            System.out.print(
                                    "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                            for (String dose : doses) {
                                System.out.println(dose);
                            }
                            while (true) {
                                try {
                                    System.out.println(
                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName2.put(userMpin, doses[0]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }
                                        /*
                                         * else if (choice == 2) {
                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                         * patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                         * date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                         * vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                         * vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                         * end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                         * nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                         * mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                         * passList1, passList2, passList3, passList4, passList5, middleName1,
                                         * middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                         * timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                         * dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                         * setReserve);
                                         * }
                                         */
                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    } else if (choice == 2) {
                                        System.out.print(
                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                        + IDs1.get(userMpin)
                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(userMpin));
                                        System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                        System.out.println(
                                                "\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(userMpin));
                                        System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                        doseName2.put(userMpin, doses[1]);
                                        System.out.println(
                                                "\u001B[36mChoosen Dose: \u001B[33m" + doseName2.get(userMpin));
                                        System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                        System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                        System.out
                                                .println("\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                        + date2);
                                        System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                        System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                        System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                        System.out.println(
                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                        choice = input.nextInt();
                                        if (choice == 1) {
                                            System.out.print("\033[H\033[2J");
                                            System.out.flush();
                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                    doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3,
                                                    start4, start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                    nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                    ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                    mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                    addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                    passList2, passList3, passList4, passList5, middleName1,
                                                    middleName2, middleName3, middleName4, middleName5, timeList1,
                                                    timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                    dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                    doseName4, doseName5, 0, false);
                                        }

                                        else if (choice == 2) {
                                            EditReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                    patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                                    attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                                    vaccinationSite2, vaccinationSite3, vaccinationSite4,
                                                    vaccinationSite5, vaccinator1, vaccinator2, vaccinator3,
                                                    vaccinator4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                    doctor5, start1, start2, start3, start4, start5, end1, end2, end3,
                                                    end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4,
                                                    nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                                    mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                                    addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,
                                                    IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                    passList5, middleName1, middleName2, middleName3, middleName4,
                                                    middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                                    dateList1, dateList2, dateList3, dateList4, dateList5, doseName1,
                                                    doseName2, doseName3, doseName4, doseName5, choice, setReserve);
                                        }

                                        else {
                                            System.out.println("\u001B[31mInvalid input!.");
                                        }
                                    }
                                } catch (InputMismatchException ex) {
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                    input.nextLine();
                                }
                            }
                        }
                        if (age >= 18) {
                            String[] AdultDose = { "1 - Astrazeneca", "2 - Moderna ", "3 - Pfizer", "4 - Sputnik V",
                                    "5 - Sinovac" };
                            System.out.print(
                                    "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                            for (String dose : AdultDose) {
                                System.out.println(AdultDose);
                            }
                            while (true) {
                                try {
                                    System.out.println(
                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                    choice = input.nextInt();
                                    // Aztra
                                    if (choice == 1) {
                                        String[] compDose = { "1 - Astrazeneca", "2 - Sinovac" };
                                        while (true) {
                                            try {
                                                if (choice == 1) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[0]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } else if (choice == 2) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[1]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                else {
                                                    System.out.println("\u001B[31mInvalid input!.");
                                                }
                                            }

                                            catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }

                                        }
                                    }
                                    // Moderna
                                    else if (choice == 2) {
                                        String[] compDose = { "1 - Moderna", "2 - Sinovac" };
                                        while (true) {
                                            try {
                                                if (choice == 1) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[0]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } else if (choice == 2) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[1]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                else {
                                                    System.out.println("\u001B[31mInvalid input!.");
                                                }
                                            }

                                            catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }
                                        }
                                    }
                                    // Pfizer
                                    else if (choice == 3) {
                                        String[] compDose = { "1 - Pfizer", "2 - Sinovac" };
                                        while (true) {
                                            try {
                                                if (choice == 1) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[0]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } else if (choice == 2) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[1]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                else {
                                                    System.out.println("\u001B[31mInvalid input!.");
                                                }
                                            }

                                            catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }

                                        }
                                    }
                                    // Sputnik V
                                    else if (choice == 4) {
                                        String[] compDose = { "1 - Suptnik V", "2 - Sinovac" };
                                        while (true) {
                                            try {
                                                if (choice == 1) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[0]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } else if (choice == 2) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[1]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                else {
                                                    System.out.println("\u001B[31mInvalid input!.");
                                                }
                                            }

                                            catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }

                                        }
                                    }
                                    // Sinovac
                                    else if (choice == 5) {
                                        String[] compDose = { "1 - Sinovac", "2 - Pfizer" };
                                        while (true) {
                                            try {
                                                if (choice == 1) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[0]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } else if (choice == 2) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(userMpin)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                            + nameList2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAge: \u001B[33m" + ageList2.get(userMpin));
                                                    System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                            + mobileNum2.get(userMpin));
                                                    System.out.println(
                                                            "\u001B[36mAddress: \u001B[33m" + addresses2.get(userMpin));
                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName2.put(userMpin, compDose[1]);
                                                    System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                            + doseName2.get(userMpin));
                                                    System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                                    System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                                            + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                                    System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                            + vaccinationSite2);
                                                    System.out.println(
                                                            "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                    + date2);
                                                    System.out
                                                            .println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                                    System.out
                                                            .println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                                    System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(userMpin));
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                else {
                                                    System.out.println("\u001B[31mInvalid input!.");
                                                }
                                            }

                                            catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }

                                        }
                                    } else {
                                        System.out.println("\u001B[31mInvalid input!.");
                                    }
                                }

                                catch (InputMismatchException ex) {
                                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                    input.nextLine();
                                }

                            }
                        }

                    }
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");
                    // Balik prompt
                    while (true) {
                        try {
                            System.out.print(
                                    "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                ;
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                        patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                        date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                        vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                        start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                                        nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                        mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,
                                        IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                        middleName1, middleName2, middleName3, middleName4, middleName5, timeList1,
                                        timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3,
                                        dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0,
                                        false);
                            } else {
                                System.out.println(
                                        "\u001B[31mIncalid input! Please enter number 1 only and press enter.");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }

                    }
                } else if (choice == 3) {
                    while (attempts3 <= patientLimit3) {
                        IDs3.put(userMpin, userMpin);
                        dateList3.put(userMpin, dateR1);
                        timeList3.put(userMpin, timeR1);
                        attempts3++;
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName = input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true) {
                                System.out.print(
                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                            } else if (fName != null || secondName != null) {
                                while (true) {
                                    System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                    String mName = input.next();
                                    String secondName2 = input.nextLine();
                                    if (isNumeric(mName) == true || isNumeric(secondName2) == true) {
                                        System.out.print(
                                                "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                    } else if (mName != null || secondName != null) {
                                        middleName3.put(userMpin, mName + secondName2);
                                        while (true) {
                                            System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                            String lName = input.next();
                                            String secondName3 = input.nextLine();
                                            if (isNumeric(lName) == true || isNumeric(secondName3) == true) {
                                                System.out.print(
                                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                            } else if (mName != null || secondName != null) {

                                                nameList3.put(userMpin,
                                                        fName + " " + secondName + " "
                                                                + middleName3.get(userMpin).charAt(0) + ". " + lName
                                                                + secondName3);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        // For age
                        while (true) {
                            try {
                                System.out.print("\u001B[36mEnter your Age: \u001B[37m");
                                age = input.nextInt();
                                ageList3.put(userMpin, age);
                                break;
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                        }
                        // For MobileNum
                        while (true) {
                            System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");
                            String mobileNumber = input.next();
                            if (mobileNumber.length() == 11) {
                                mobileNum3.put(userMpin, mobileNumber);
                                break;
                            }

                            else {
                                System.out.print(
                                        "\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");
                            }
                        }
                        // For address, tanggalin yung parang exception

                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String address = input.next();
                        String address3 = input.nextLine();
                        addresses3.put(userMpin, address + " " + address3);

                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList3.put(userMpin, pass);

                        while (true) {
                            // For 6 months to 4 years old
                            if (age <= 17) {
                                String[] doses = { "1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)" };
                                System.out.print(
                                        "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                for (String dose : doses) {
                                    System.out.println(dose);
                                }
                                while (true) {
                                    try {
                                        System.out.println(
                                                "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            System.out.print(
                                                    "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                            + IDs1.get(userMpin)
                                                            + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                            System.out.println(
                                                    "\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                            System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                            doseName3.put(userMpin, doses[0]);
                                            System.out.println(
                                                    "\u001B[36mChoosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3
                                                    + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                            System.out.println(
                                                    "\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                            System.out.println(
                                                    "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                            + date3);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                            System.out.println(
                                                    "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                            choice = input.nextInt();
                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                        doctor5, start1, start2, start3, start4, start5, end1, end2,
                                                        end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                                        nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                                        ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                                        mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                                        addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                        passList3, passList4, passList5, middleName1, middleName2,
                                                        middleName3, middleName4, middleName5, timeList1, timeList2,
                                                        timeList3, timeList4, timeList5, dateList1, dateList2,
                                                        dateList3, dateList4, dateList5, doseName1, doseName2,
                                                        doseName3, doseName4, doseName5, 0, false);
                                            }
                                            /*
                                             * else if (choice == 2) {
                                             * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                             * patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                             * attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                             * vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                             * vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,
                                             * doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                             * start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                             * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                             * ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                             * addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                             * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                             * middleName1, middleName2, middleName3, middleName4, middleName5,
                                             * timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                                             * dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                             * doseName3, doseName4, doseName5, choice, setReserve);
                                             * }
                                             */
                                            else {
                                                System.out.println("\u001B[31mInvalid input!.");
                                            }
                                        } else if (choice == 2) {
                                            System.out.print(
                                                    "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                            + IDs1.get(userMpin)
                                                            + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                            System.out.println(
                                                    "\u001B[36mFull Name: \u001B[33m" + nameList3.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mAddress: \u001B[33m" + addresses3.get(userMpin));
                                            System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                            doseName3.put(userMpin, doses[1]);
                                            System.out.println(
                                                    "\u001B[36mChoosen Dose: \u001B[33m" + doseName3.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3
                                                    + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                            System.out.println(
                                                    "\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                            System.out.println(
                                                    "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                            + date3);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                            System.out.println(
                                                    "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                            choice = input.nextInt();
                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                        doctor5, start1, start2, start3, start4, start5, end1, end2,
                                                        end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                                        nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                                        ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                                        mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                                        addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                        passList3, passList4, passList5, middleName1, middleName2,
                                                        middleName3, middleName4, middleName5, timeList1, timeList2,
                                                        timeList3, timeList4, timeList5, dateList1, dateList2,
                                                        dateList3, dateList4, dateList5, doseName1, doseName2,
                                                        doseName3, doseName4, doseName5, 0, false);
                                            }
                                            /*
                                             * else if (choice == 2) {
                                             * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                             * patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                             * attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                             * vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                             * vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,
                                             * doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                             * start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                             * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                             * ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                             * addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                             * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                             * middleName1, middleName2, middleName3, middleName4, middleName5,
                                             * timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                                             * dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                             * doseName3, doseName4, doseName5, choice, setReserve);
                                             * }
                                             */
                                            else {
                                                System.out.println("\u001B[31mInvalid input!.");
                                            }
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println(
                                                "\u001B[31mInvalid input! Please enter a number and try again.");
                                        input.nextLine();
                                    }
                                }
                            } else if (age >= 18) {
                                String[] AdultDose = { "1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer",
                                        "5 - Sputnik V", "6 - Sinovac" };
                                System.out.print(
                                        "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                for (String dose : AdultDose) {
                                    System.out.println(dose);
                                }
                                while (true) {
                                    try {
                                        System.out.println(
                                                "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        // Aztra
                                        if (choice == 1) {
                                            System.out.print("List of Compatible Dose for Astrazenenca");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Moderna
                                        if (choice == 2) {
                                            System.out.print("List of Compatible Dose for Moderna");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Janssen
                                        if (choice == 3) {
                                            System.out.print("List of Compatible Dose for Janssen");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // pfizer
                                        if (choice == 4) {
                                            System.out.print("List of Compatible Dose for Pfizer");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Sputnik V
                                        if (choice == 5) {
                                            System.out.print("List of Compatible Dose for Sputnik V");
                                            String[] compDose = { "1 - Sputnik V", "2 - Sinovac" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Sinovac
                                        if (choice == 6) {
                                            System.out.print("List of Compatible Dose for Sinovac");
                                            String[] compDose = { "1 - Sinovac", "2 - Pfizer" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList3.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum3.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses3.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName3.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName3.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date3 + "\u001B[36m\n\tTime: \u001B[33m" + start3
                                                                + " - " + end3);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date3);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs3.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println(
                                                "\u001B[31mInvalid input! Please enter a number and try again.");
                                        input.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    // Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");
                    // Balik prompt
                    while (true) {
                        try {
                            System.out.print(
                                    "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                ;
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                        patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                        date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                        vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                        start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                                        nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                        mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,
                                        IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                        middleName1, middleName2, middleName3, middleName4, middleName5, timeList1,
                                        timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3,
                                        dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0,
                                        false);
                            } else {
                                System.out.println(
                                        "\u001B[31mIncalid input! Please enter number 1 only and press enter.");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }
                } else if (choice == 4) {
                    while (attempts4 <= patientLimit4) {
                        IDs4.put(userMpin, userMpin);
                        dateList4.put(userMpin, dateR1);
                        timeList4.put(userMpin, timeR1);
                        attempts4++;
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName = input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true) {
                                System.out.print(
                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                            } else if (fName != null || secondName != null) {
                                while (true) {
                                    System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                    String mName = input.next();
                                    String secondName2 = input.nextLine();
                                    if (isNumeric(mName) == true || isNumeric(secondName2) == true) {
                                        System.out.print(
                                                "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                    } else if (mName != null || secondName != null) {
                                        middleName4.put(userMpin, mName + secondName2);
                                        while (true) {
                                            System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                            String lName = input.next();
                                            String secondName3 = input.nextLine();
                                            if (isNumeric(lName) == true || isNumeric(secondName3) == true) {
                                                System.out.print(
                                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                            } else if (mName != null || secondName != null) {

                                                nameList4.put(userMpin,
                                                        fName + " " + secondName + " "
                                                                + middleName4.get(userMpin).charAt(0) + ". " + lName
                                                                + secondName);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        // For age
                        while (true) {
                            try {
                                System.out.print("\u001B[36mEnter your Age: \u001B[37m");
                                age = input.nextInt();
                                ageList4.put(userMpin, age);
                                break;
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                        }
                        // For MobileNum
                        while (true) {
                            System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");
                            String mobileNumber = input.next();
                            if (mobileNumber.length() == 11) {
                                mobileNum4.put(userMpin, mobileNumber);
                                break;
                            }

                            else {
                                System.out.print(
                                        "\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");
                            }
                        }
                        // For address, tanggalin yung parang exception

                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String address = input.next();
                        String address4 = input.nextLine();
                        addresses4.put(userMpin, address + " " + address4);

                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList4.put(userMpin, pass);

                        while (true) {
                            // for 5yrs old to 12 (dipa naayos)
                            if (age <= 17) {
                                String[] doses = { "1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)" };
                                System.out.print(
                                        "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                for (String dose : doses) {
                                    System.out.println(dose);
                                }
                                while (true) {
                                    try {
                                        System.out.println(
                                                "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            System.out.print(
                                                    "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                            + IDs1.get(userMpin)
                                                            + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                            System.out.println(
                                                    "\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                            System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                            doseName4.put(userMpin, doses[0]);
                                            System.out.println(
                                                    "\u001B[36mChoosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4
                                                    + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                            System.out.println(
                                                    "\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                            System.out.println(
                                                    "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                            + date4);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                            System.out.println(
                                                    "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                            choice = input.nextInt();
                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                        doctor5, start1, start2, start3, start4, start5, end1, end2,
                                                        end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                                        nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                                        ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                                        mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                                        addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                        passList3, passList4, passList5, middleName1, middleName2,
                                                        middleName3, middleName4, middleName5, timeList1, timeList2,
                                                        timeList3, timeList4, timeList5, dateList1, dateList2,
                                                        dateList3, dateList4, dateList5, doseName1, doseName2,
                                                        doseName3, doseName4, doseName5, 0, false);
                                            }
                                            /*
                                             * else if (choice == 2) {
                                             * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                             * patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                             * attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                             * vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                             * vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,
                                             * doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                             * start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                             * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                             * ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                             * addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                             * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                             * middleName1, middleName2, middleName3, middleName4, middleName5,
                                             * timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                                             * dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                             * doseName3, doseName4, doseName5, choice, setReserve);
                                             * }
                                             */
                                            else {
                                                System.out.println("\u001B[31mInvalid input!.");
                                            }
                                        } else if (choice == 2) {
                                            System.out.print(
                                                    "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                            + IDs1.get(userMpin)
                                                            + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                            System.out.println(
                                                    "\u001B[36mFull Name: \u001B[33m" + nameList4.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mAddress: \u001B[33m" + addresses4.get(userMpin));
                                            System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                            doseName4.put(userMpin, doses[1]);
                                            System.out.println(
                                                    "\u001B[36mChoosen Dose: \u001B[33m" + doseName4.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4
                                                    + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                            System.out.println(
                                                    "\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                            System.out.println(
                                                    "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                            + date4);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                            System.out.println(
                                                    "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                            choice = input.nextInt();
                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                        doctor5, start1, start2, start3, start4, start5, end1, end2,
                                                        end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                                        nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                                        ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                                        mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                                        addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                        passList3, passList4, passList5, middleName1, middleName2,
                                                        middleName3, middleName4, middleName5, timeList1, timeList2,
                                                        timeList3, timeList4, timeList5, dateList1, dateList2,
                                                        dateList3, dateList4, dateList5, doseName1, doseName2,
                                                        doseName3, doseName4, doseName5, 0, false);
                                            }
                                            /*
                                             * else if (choice == 2) {
                                             * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                             * patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                             * attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                             * vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                             * vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,
                                             * doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                             * start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                             * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                             * ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                             * addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                             * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                             * middleName1, middleName2, middleName3, middleName4, middleName5,
                                             * timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                                             * dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                             * doseName3, doseName4, doseName5, choice, setReserve);
                                             * }
                                             */
                                            else {
                                                System.out.println("\u001B[31mInvalid input!.");
                                            }
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println(
                                                "\u001B[31mInvalid input! Please enter a number and try again.");
                                        input.nextLine();
                                    }
                                }
                            } else if (age >= 18) {
                                String[] AdultDose = { "1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer",
                                        "5 - Sputnik V", "6 - Sinovac" };
                                System.out.print(
                                        "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                for (String dose : AdultDose) {
                                    System.out.println(dose);
                                }
                                while (true) {
                                    try {
                                        System.out.println(
                                                "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        // Aztra
                                        if (choice == 1) {
                                            System.out.print("List of Compatible Dose for Astrazenenca");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Moderna
                                        if (choice == 2) {
                                            System.out.print("List of Compatible Dose for Moderna");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite3);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Janssen
                                        if (choice == 3) {
                                            System.out.print("List of Compatible Dose for Janssen");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // pfizer
                                        if (choice == 4) {
                                            System.out.print("List of Compatible Dose for Pfizer");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Sputnik V
                                        if (choice == 5) {
                                            System.out.print("List of Compatible Dose for Sputnik V");
                                            String[] compDose = { "1 - Sputnik V", "2 - Sinovac" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Sinovac
                                        if (choice == 6) {
                                            System.out.print("List of Compatible Dose for Sinovac");
                                            String[] compDose = { "1 - Sinovac", "2 - Pfizer" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList4.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum4.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses4.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName4.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName4.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date4 + "\u001B[36m\n\tTime: \u001B[33m" + start4
                                                                + " - " + end4);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date4);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs4.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }
                                            }
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println(
                                                "\u001B[31mInvalid input! Please enter a number and try again.");
                                        input.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    // Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");
                    // Balik prompt
                    while (true) {
                        try {
                            System.out.print(
                                    "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                ;
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                        patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                        date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                        vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                        start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                                        nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                        mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,
                                        IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                        middleName1, middleName2, middleName3, middleName4, middleName5, timeList1,
                                        timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3,
                                        dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0,
                                        false);
                            } else {
                                System.out.println(
                                        "\u001B[31mIncalid input! Please enter number 1 only and press enter.");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }
                } else if (choice == 5) {
                    while (attempts5 <= patientLimit5) {
                        IDs5.put(userMpin, userMpin);
                        dateList5.put(userMpin, dateR1);
                        timeList5.put(userMpin, timeR1);
                        attempts5++;
                        while (true) {
                            System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                            String fName = input.next();
                            String secondName = input.nextLine();
                            if (isNumeric(fName) == true || isNumeric(secondName) == true) {
                                System.out.print(
                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                            } else if (fName != null || secondName != null) {
                                while (true) {
                                    System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                    String mName = input.next();
                                    String secondName2 = input.nextLine();
                                    if (isNumeric(mName) == true || isNumeric(secondName2) == true) {
                                        System.out.print(
                                                "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                    } else if (mName != null || secondName != null) {
                                        middleName5.put(userMpin, mName + secondName2);
                                        while (true) {
                                            System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                            String lName = input.next();
                                            String secondName3 = input.nextLine();
                                            if (isNumeric(lName) == true || isNumeric(secondName3) == true) {
                                                System.out.print(
                                                        "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                            } else if (mName != null || secondName != null) {

                                                nameList5.put(userMpin,
                                                        fName + " " + secondName + " "
                                                                + middleName5.get(userMpin).charAt(0) + ". " + lName
                                                                + secondName);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        // For age
                        while (true) {
                            try {
                                System.out.print("\u001B[36mEnter your Age: \u001B[37m");
                                age = input.nextInt();
                                ageList5.put(userMpin, age);
                                break;
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                        }
                        // For MobileNum
                        while (true) {
                            System.out.print("\u001B[36mEnter your Mobile number: \u001B[37m");
                            String mobileNumber = input.next();
                            if (mobileNumber.length() == 11) {
                                mobileNum5.put(userMpin, mobileNumber);
                                break;
                            }

                            else {
                                System.out.print(
                                        "\u001B[31mYou've entered a wrong length of digits, Please try again.\n\u001B[37m");
                            }
                        }
                        // For address, tanggalin yung parang exception

                        System.out.print("\u001B[36mEnter your Address: \u001B[37m");
                        String address = input.next();
                        String address1 = input.nextLine();
                        addresses5.put(userMpin, address);

                        System.out.print("\u001B[36mEnter your Password: \u001B[37m");
                        String pass = input.next();
                        passList5.put(userMpin, pass);

                        while (true) {
                            // for 5yrs old to 12 (dipa naayos)
                            if (age <= 17) {
                                String[] doses = { "1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)" };
                                System.out.print(
                                        "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                for (String dose : doses) {
                                    System.out.println(dose);
                                }
                                while (true) {
                                    try {
                                        System.out.println(
                                                "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            System.out.print(
                                                    "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                            + IDs1.get(userMpin)
                                                            + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                            System.out.println(
                                                    "\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                            System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                            doseName5.put(userMpin, doses[0]);
                                            System.out.println(
                                                    "\u001B[36mChoosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5
                                                    + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                            System.out.println(
                                                    "\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                            System.out.println(
                                                    "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                            + date5);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                            System.out.println(
                                                    "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                            choice = input.nextInt();
                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                        doctor5, start1, start2, start3, start4, start5, end1, end2,
                                                        end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                                        nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                                        ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                                        mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                                        addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                        passList3, passList4, passList5, middleName1, middleName2,
                                                        middleName3, middleName4, middleName5, timeList1, timeList2,
                                                        timeList3, timeList4, timeList5, dateList1, dateList2,
                                                        dateList3, dateList4, dateList5, doseName1, doseName2,
                                                        doseName3, doseName4, doseName5, 0, false);
                                            }
                                            /*
                                             * else if (choice == 2) {
                                             * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                             * patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                             * attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                             * vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                             * vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,
                                             * doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                             * start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                             * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                             * ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                             * addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                             * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                             * middleName1, middleName2, middleName3, middleName4, middleName5,
                                             * timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                                             * dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                             * doseName3, doseName4, doseName5, choice, setReserve);
                                             * }
                                             */
                                            else {
                                                System.out.println("\u001B[31mInvalid input!.");
                                            }
                                        } else if (choice == 2) {
                                            System.out.print(
                                                    "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                            + IDs1.get(userMpin)
                                                            + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                            System.out.println(
                                                    "\u001B[36mFull Name: \u001B[33m" + nameList5.get(userMpin));
                                            System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(userMpin));
                                            System.out.println(
                                                    "\u001B[36mAddress: \u001B[33m" + addresses5.get(userMpin));
                                            System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                            doseName5.put(userMpin, doses[1]);
                                            System.out.println(
                                                    "\u001B[36mChoosen Dose: \u001B[33m" + doseName5.get(userMpin));
                                            System.out.println("\u001B[36mReservation details: \n\t" + timeR1);
                                            System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5
                                                    + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                            System.out.println(
                                                    "\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                            System.out.println(
                                                    "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                            + date5);
                                            System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                            System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                            System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                            System.out.println(
                                                    "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                            choice = input.nextInt();
                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                        doctor5, start1, start2, start3, start4, start5, end1, end2,
                                                        end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                                        nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                                        ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                                        mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                                        addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                        passList3, passList4, passList5, middleName1, middleName2,
                                                        middleName3, middleName4, middleName5, timeList1, timeList2,
                                                        timeList3, timeList4, timeList5, dateList1, dateList2,
                                                        dateList3, dateList4, dateList5, doseName1, doseName2,
                                                        doseName3, doseName4, doseName5, 0, false);
                                            }
                                            /*
                                             * else if (choice == 2) {
                                             * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                             * patientLimit4, patientLimit5, attempts1, attempts2, attempts3, attempts4,
                                             * attempts5, date1, date2, date3, date4, date5, vaccinationSite1,
                                             * vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                             * vaccinator1, vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1,
                                             * doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                             * start5, end1, end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                             * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3, ageList4,
                                             * ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5,
                                             * addresses1, addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                             * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                             * middleName1, middleName2, middleName3, middleName4, middleName5,
                                             * timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                                             * dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                             * doseName3, doseName4, doseName5, choice, setReserve);
                                             * }
                                             */
                                            else {
                                                System.out.println("\u001B[31mInvalid input!.");
                                            }
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println(
                                                "\u001B[31mInvalid input! Please enter a number and try again.");
                                        input.nextLine();
                                    }
                                }
                            } else if (age >= 18) {
                                String[] AdultDose = { "1 - Astrazeneca", "2 - Moderna ", "3 - Janssen", "4 - Pfizer",
                                        "5 - Sputnik V", "6 - Sinovac" };
                                System.out.print(
                                        "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                for (String dose : AdultDose) {
                                    System.out.println(dose);
                                }
                                while (true) {
                                    try {
                                        System.out.println(
                                                "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                        choice = input.nextInt();
                                        // Aztra
                                        if (choice == 1) {
                                            System.out.print("List of Compatible Dose for Astrazenenca");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Moderna
                                        if (choice == 2) {
                                            System.out.print("List of Compatible Dose for Moderna");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Janssen
                                        if (choice == 3) {
                                            System.out.print("List of Compatible Dose for Janssen");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // pfizer
                                        if (choice == 4) {
                                            System.out.print("List of Compatible Dose for Pfizer");
                                            String[] compDose = { "1 - Astrazeneca", "2 - Pfizer", "3 - Moderna" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }
                                                    if (choice == 3) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[2]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Sputnik V
                                        if (choice == 5) {
                                            System.out.print("List of Compatible Dose for Sputnik V");
                                            String[] compDose = { "1 - Sputnik V", "2 - Sinovac" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite4);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }

                                                catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }

                                            }
                                        }
                                        // Sinovac
                                        if (choice == 6) {
                                            System.out.print("List of Compatible Dose for Sinovac");
                                            String[] compDose = { "1 - Sinovac", "2 - Pfizer" };
                                            for (String dose : compDose) {
                                                System.out.println(dose);
                                            }
                                            while (true) {
                                                try {
                                                    System.out.println(
                                                            "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[0]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    } else if (choice == 2) {
                                                        System.out.print(
                                                                "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                        + IDs1.get(userMpin)
                                                                        + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                        System.out.println("\u001B[36mFull Name: \u001B[33m"
                                                                + nameList5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mAge: \u001B[33m" + ageList5.get(userMpin));
                                                        System.out.println("\u001B[36mMobile Number: \u001B[33m"
                                                                + mobileNum5.get(userMpin));
                                                        System.out.println("\u001B[36mAddress: \u001B[33m"
                                                                + addresses5.get(userMpin));
                                                        System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                        doseName5.put(userMpin, compDose[1]);
                                                        System.out.println("\u001B[36mChoosen Dose: \u001B[33m"
                                                                + doseName5.get(userMpin));
                                                        System.out.println(
                                                                "\u001B[36mReservation details: \n\t" + timeR1);
                                                        System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m"
                                                                + date5 + "\u001B[36m\n\tTime: \u001B[33m" + start5
                                                                + " - " + end5);
                                                        System.out.println("\u001B[36mVaccination site: \u001B[33m"
                                                                + vaccinationSite5);
                                                        System.out.println(
                                                                "\u001B[36mRecommended date of taking second dose:  \u001B[33m"
                                                                        + date5);
                                                        System.out.println(
                                                                "\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                                        System.out.println(
                                                                "\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                                        System.out.println(
                                                                "\u001B[36mID: \u001B[33m" + IDs5.get(userMpin));
                                                        System.out.println(
                                                                "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                        choice = input.nextInt();
                                                        if (choice == 1) {
                                                            System.out.print("\033[H\033[2J");
                                                            System.out.flush();
                                                            Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                    patientLimit4, patientLimit5, attempts1, attempts2,
                                                                    attempts3, attempts4, attempts5, date1, date2,
                                                                    date3, date4, date5, vaccinationSite1,
                                                                    vaccinationSite2, vaccinationSite3,
                                                                    vaccinationSite4, vaccinationSite5, doctor1,
                                                                    doctor2, doctor3, doctor4, vaccinator5, doctor1,
                                                                    doctor2, doctor3, doctor4, doctor5, start1, start2,
                                                                    start3, start4, start5, end1, end2, end3, end4,
                                                                    end5, input, imp, nameList1, nameList2, nameList3,
                                                                    nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                    ageList4, ageList5, mobileNum1, mobileNum2,
                                                                    mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                                    addresses2, addresses3, addresses4, addresses5,
                                                                    IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                                                                    passList3, passList4, passList5, middleName1,
                                                                    middleName2, middleName3, middleName4, middleName5,
                                                                    timeList1, timeList2, timeList3, timeList4,
                                                                    timeList5, dateList1, dateList2, dateList3,
                                                                    dateList4, dateList5, doseName1, doseName2,
                                                                    doseName3, doseName4, doseName5, 0, false);
                                                        }
                                                        /*
                                                         * else if (choice == 2) {
                                                         * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                         * patientLimit4, patientLimit5, attempts1, attempts2,
                                                         * attempts3, attempts4, attempts5, date1, date2, date3, date4,
                                                         * date5, vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                         * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                         * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                         * doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                         * start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                         * nameList2, nameList3, nameList4, nameList5, ageList1,
                                                         * ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                         * mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                                         * addresses2, addresses3, addresses4, addresses5, IDs1, IDs2,
                                                         * IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                         * passList5, middleName1, middleName2, middleName3,
                                                         * middleName4, middleName5, timeList1, timeList2, timeList3,
                                                         * timeList4, timeList5, dateList1, dateList2, dateList3,
                                                         * dateList4, dateList5, doseName1, doseName2, doseName3,
                                                         * doseName4, doseName5, choice, setReserve);
                                                         * }
                                                         */
                                                        else {
                                                            System.out.println("\u001B[31mInvalid input!.");
                                                        }
                                                    }

                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                } catch (InputMismatchException ex) {
                                                    System.out.println(
                                                            "\u001B[31mInvalid input! Please enter a number and try again.");
                                                    input.nextLine();
                                                }
                                            }
                                        }
                                    } catch (InputMismatchException ex) {
                                        System.out.println(
                                                "\u001B[31mInvalid input! Please enter a number and try again.");
                                        input.nextLine();
                                    }
                                }
                            }
                        }
                    }
                    // Full
                    System.out.println("\u001B[31mThe Reservation list is already fulled. Please come back tommorow. ");
                    // Balik prompt
                    while (true) {
                        try {
                            System.out.print(
                                    "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                            choice = input.nextInt();
                            if (choice == 1) {
                                System.out.print("\033[H\033[2J");
                                System.out.flush();
                                ;
                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                        patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                        date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                        vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3,
                                        doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                        start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                                        nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4,
                                        mobileNum5, addresses1, addresses2, addresses3, addresses4, addresses5, IDs1,
                                        IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3, passList4, passList5,
                                        middleName1, middleName2, middleName3, middleName4, middleName5, timeList1,
                                        timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3,
                                        dateList4, dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0,
                                        false);
                            } else {
                                System.out.println(
                                        "\u001B[31mIncalid input! Please enter number 1 only and press enter.");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }

                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                input.nextLine();
            }
        }

    }

    public void CheckReservation(int patientLimit1, int patientLimit2, int patientLimit3, int patientLimit4,
            int patientLimit5,
            int attempts1, int attempts2, int attempts3, int attempts4, int attempts5,
            String date1, String date2, String date3, String date4, String date5,
            String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4,
            String vaccinationSite5,
            String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
            String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
            String start1, String start2, String start3, String start4, String start5,
            String end1, String end2, String end3, String end4, String end5,
            Scanner input, Implement imp,
            LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2,
            LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4,
            LinkedHashMap<String, String> nameList5,
            LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2,
            LinkedHashMap<String, Integer> ageList3, LinkedHashMap<String, Integer> ageList4,
            LinkedHashMap<String, Integer> ageList5,
            LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,
            LinkedHashMap<String, String> mobileNum3,
            LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
            LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,
            LinkedHashMap<String, String> addresses3, LinkedHashMap<String, String> addresses4,
            LinkedHashMap<String, String> addresses5,
            LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3,
            LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
            LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2,
            LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4,
            LinkedHashMap<String, String> passList5,
            LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2,
            LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4,
            LinkedHashMap<String, String> middleName5,
            LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2,
            LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4,
            LinkedHashMap<String, String> timeList5,
            LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2,
            LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4,
            LinkedHashMap<String, String> dateList5,
            LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2,
            LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4,
            LinkedHashMap<String, String> doseName5,
            int choice, boolean setReserve) {

        System.out.println(
                "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        while (true) {
            System.out.print(
                    "\u001B[36mEnter the number of which dose phase would like to check the reservation list: \u001B[37m");
            choice = input.nextInt();
            try {
                if (choice == 1) {
                    System.out.println(
                            "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST              ░▒▓██████████████████████████████████████████████████████████████████████████████████████████████████\n");
                    if (nameList1.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList1.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    while (true) {
                        System.out.print(
                                "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                        String id = input.next();

                        if (IDs1.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord = input.next();
                            if (passList1.containsValue(passWord)) {
                                System.out.print(
                                        "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                + IDs1.get(id)
                                                + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList1.get(id));
                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList1.get(id));
                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum1.get(id));
                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses1.get(id));
                                System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                System.out.println("\u001B[36m1st Dose: \u001B[33m" + doseName1.get(id));
                                System.out.println("\u001B[36mReservation details: \n\t" + timeList1);
                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date1
                                        + "\u001B[36m\n\tTime: \u001B[33m" + start1 + " - " + end1);
                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite1);
                                System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date2);
                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator1);
                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor1);
                                System.out.println("\u001B[36mID: \u001B[33m" + IDs1.get(id));
                                System.out.print(
                                        "Enter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();

                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }
                            }

                            else {
                                System.out.println("Invalid password! Please try again ");
                            }
                        }

                        else {
                            System.out.println("This user doesn't exists ");
                        }
                    }
                }

                if (choice == 2) {
                    System.out.println(
                            "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST              ░▒▓██████████████████████████████████████████████████████████████████████████████████████████████████\n");
                    if (nameList2.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList2.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    while (true) {
                        System.out.print(
                                "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                        String id = input.next();

                        if (IDs2.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord = input.next();
                            if (passList2.containsValue(passWord)) {
                                System.out.print(
                                        "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                + IDs1.get(id)
                                                + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList2.get(id));
                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList2.get(id));
                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum2.get(id));
                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses2.get(id));
                                System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                System.out.println("\u001B[36m2nd Dose: \u001B[33m" + doseName2.get(id));
                                System.out.println("\u001B[36mReservation details: \n\t" + timeList2);
                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date2
                                        + "\u001B[36m\n\tTime: \u001B[33m" + start2 + " - " + end2);
                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite2);
                                System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date2);
                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator2);
                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor2);
                                System.out.println("\u001B[36mID: \u001B[33m" + IDs2.get(id));
                                System.out.print(
                                        "Enter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();

                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }
                            }

                            else {
                                System.out.println("Invalid password! Please try again ");
                            }
                        }

                        else {
                            System.out.println("This user doesn't exists ");
                        }

                    }
                }
                if (choice == 3) {
                    System.out.println(
                            "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST              ░▒▓██████████████████████████████████████████████████████████████████████████████████████████████████\n");
                    if (nameList3.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList3.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    while (true) {
                        System.out.print(
                                "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                        String id = input.next();

                        if (IDs3.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord = input.next();
                            if (passList3.containsValue(passWord)) {
                                System.out.print(
                                        "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                + IDs1.get(id)
                                                + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList3.get(id));
                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList3.get(id));
                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum3.get(id));
                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses3.get(id));
                                System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                System.out.println("\u001B[36m1st Dose Booster: \u001B[33mP" + doseName3.get(id));
                                System.out.println("\u001B[36mReservation details: \n\t" + timeList3);
                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date3
                                        + "\u001B[36m\n\tTime: \u001B[33m" + start3 + " - " + end3);
                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite3);
                                System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date3);
                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator3);
                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor3);
                                System.out.println("\u001B[36mID: \u001B[33m" + IDs3.get(id));
                                System.out.print(
                                        "Enter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();

                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }
                            }

                            else {
                                System.out.println("Invalid password! Please try again ");
                            }
                        }

                        else {
                            System.out.println("This user doesn't exists ");
                        }

                    }
                }
                if (choice == 4) {
                    System.out.println(
                            "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST              ░▒▓██████████████████████████████████████████████████████████████████████████████████████████████████\n");
                    if (nameList4.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList4.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    while (true) {
                        System.out.print(
                                "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                        String id = input.next();

                        if (IDs4.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord = input.next();
                            if (passList4.containsValue(passWord)) {
                                System.out.print(
                                        "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                + IDs1.get(id)
                                                + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList4.get(id));
                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList4.get(id));
                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum4.get(id));
                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses4.get(id));
                                System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                System.out.println("\u001B[36m2nd Dose Booster: \u001B[33m" + doseName4.get(id));
                                System.out.println("\u001B[36mReservation details: \n\t" + timeList4);
                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date4
                                        + "\u001B[36m\n\tTime: \u001B[33m" + start4 + " - " + end4);
                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite4);
                                System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date4);
                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator4);
                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor4);
                                System.out.println("\u001B[36mID: \u001B[33m" + IDs4.get(id));
                                System.out.print(
                                        "Enter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();

                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }
                            }

                            else {
                                System.out.println("Invalid password! Please try again ");
                            }
                        }

                        else {
                            System.out.println("This user doesn't exists ");
                        }

                    }
                }
                if (choice == 5) {
                    System.out.println(
                            "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION LIST              ░▒▓██████████████████████████████████████████████████████████████████████████████████████████████████\n");
                    if (nameList5.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList5.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    while (true) {
                        System.out.print(
                                "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                        String id = input.next();

                        if (IDs5.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord = input.next();
                            if (passList1.containsValue(passWord)) {
                                System.out.print(
                                        "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                + IDs1.get(id)
                                                + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                System.out.println("\u001B[36mFull Name: \u001B[33m" + nameList5.get(id));
                                System.out.println("\u001B[36mAge: \u001B[33m" + ageList5.get(id));
                                System.out.println("\u001B[36mMobile Number: \u001B[33m" + mobileNum5.get(id));
                                System.out.println("\u001B[36mAddress: \u001B[33m" + addresses5.get(id));
                                System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                System.out.println("\u001B[36m3rd Dose Booster: \u001B[33m" + doseName5.get(id));
                                System.out.println("\u001B[36mReservation details: \n\t" + timeList5);
                                System.out.println("\u001B[36mSchedule:\n\tDate: \u001B[33m" + date5
                                        + "\u001B[36m\n\tTime: \u001B[33m" + start5 + " - " + end5);
                                System.out.println("\u001B[36mVaccination site: \u001B[33m" + vaccinationSite5);
                                System.out.println("\u001B[36mDate of taking second dose:  \u001B[33m" + date5);
                                System.out.println("\u001B[36mVaccinator: \u001B[33m" + vaccinator5);
                                System.out.println("\u001B[36mDoctor Assigned: \u001B[33m" + doctor5);
                                System.out.println("\u001B[36mID: \u001B[33m" + IDs5.get(id));
                                System.out.print(
                                        "Enter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                choice = input.nextInt();

                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }
                            }

                            else {
                                System.out.println("Invalid password! Please try again ");
                            }
                        }

                        else {
                            System.out.println("This user doesn't exists ");
                        }

                    }
                }

                else {
                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                }
            }

            catch (InputMismatchException ex) {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                input.nextLine();
            }
        }
    }

    public void EditReservation(int patientLimit1, int patientLimit2, int patientLimit3, int patientLimit4,
            int patientLimit5,
            int attempts1, int attempts2, int attempts3, int attempts4, int attempts5,
            String date1, String date2, String date3, String date4, String date5,
            String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4,
            String vaccinationSite5,
            String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
            String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
            String start1, String start2, String start3, String start4, String start5,
            String end1, String end2, String end3, String end4, String end5,
            Scanner input, Implement imp,
            LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2,
            LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4,
            LinkedHashMap<String, String> nameList5,
            LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2,
            LinkedHashMap<String, Integer> ageList3, LinkedHashMap<String, Integer> ageList4,
            LinkedHashMap<String, Integer> ageList5,
            LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,
            LinkedHashMap<String, String> mobileNum3,
            LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
            LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,
            LinkedHashMap<String, String> addresses3, LinkedHashMap<String, String> addresses4,
            LinkedHashMap<String, String> addresses5,
            LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3,
            LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
            LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2,
            LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4,
            LinkedHashMap<String, String> passList5,
            LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2,
            LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4,
            LinkedHashMap<String, String> middleName5,
            LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2,
            LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4,
            LinkedHashMap<String, String> timeList5,
            LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2,
            LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4,
            LinkedHashMap<String, String> dateList5,
            LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2,
            LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4,
            LinkedHashMap<String, String> doseName5,
            int choice, boolean setReserve) {

        System.out.println(
                "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out
                .println("\u001B[36m1 - Choosen Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");

        while (true) {
            System.out.print(
                    "\u001B[36mEnter the number of which dose phase would like to check the reservation list: \u001B[37m");
            choice = input.nextInt();
            try {
                if (choice == 1) {
                    System.out.println(
                            "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ EDIT RESERVATION LIST ░▒▓██████████████████████████████████████████████████████████████████████████████████████████████████\n");
                    if (nameList1.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                        }
                    }
                    for (Map.Entry e : nameList1.entrySet()) {
                        System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                    }
                    // Main function
                    while (true) {
                        System.out.print(
                                "\nEnter the ID that you want to edit the details (Enter B and press enter to go back): ");
                        String id = input.next();

                        if (IDs1.containsValue(id)) {
                            System.out.print("Enter your password: ");
                            String passWord = input.next();
                            if (passList1.containsValue(passWord)) {
                                System.out.println(
                                        "1 - Name:\n2 - Age & chosen dose \n3- Mobile No.\n4 - Address:\n5 - Password");
                                System.out.println(
                                        "Enter the number of which detail you want to edit. Otherwise, press 0 to exit edit mode: ");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    // While loop for Whole name.
                                    while (true) {
                                        System.out.print("\u001B[36mEnter your First name: \u001B[37m");
                                        String fName = input.next();
                                        String secondName = input.nextLine();
                                        if (isNumeric(fName) == true || isNumeric(secondName) == true) {
                                            System.out.print(
                                                    "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");
                                        } else if (fName != null || secondName != null) {
                                            while (true) {
                                                System.out.print("\u001B[36mEnter your Middle name: \u001B[37m");
                                                String mName = input.next();
                                                String secondName2 = input.nextLine();
                                                if (isNumeric(mName) == true || isNumeric(secondName2) == true) {
                                                    System.out.print(
                                                            "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                                } else if (mName != null || secondName != null) {
                                                    middleName1.put(id, mName + secondName2);
                                                    while (true) {
                                                        System.out.print("\u001B[36mEnter your Last name: \u001B[37m");
                                                        String lName = input.next();
                                                        String secondName3 = input.nextLine();
                                                        if (isNumeric(lName) == true
                                                                || isNumeric(secondName3) == true) {
                                                            System.out.print(
                                                                    "\t\t\t\t\t\tInvalid input! Please enter a number and press enter. \n\n");

                                                        } else if (mName != null || secondName != null) {

                                                            nameList1.replace(id,
                                                                    fName + " " + secondName + " "
                                                                            + middleName1.get(id).charAt(0) + ". "
                                                                            + lName + secondName3);
                                                            break;
                                                        }
                                                    }
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                    System.out.println("The patient's current name " + nameList1.get(id)
                                            + " has been edited into");
                                    System.out.println(nameList1.get(id) + ".");
                                    System.out.println(
                                            "If you want to edit another detail, press 9 to go back. Otherwise, press 0 to exit.");
                                    choice = input.nextInt();
                                }
                                // For age and dose
                                else if (choice == 2) {
                                    System.out.print("Enter your Age: ");
                                    int age = input.nextInt();
                                    System.out.println("The vacinee's age has been edited into" + ageList1.get(id));
                                    ageList1.replace(id, age);
                                    System.out.println(ageList1.get(id) + ".");
                                    // Age
                                    if (age <= 17) {
                                        String[] doses = { "1 - Pfizer (Most Compatible)", "2 - Moderna (Optional)" };
                                        for (String dose : doses) {
                                            System.out.println(dose);
                                        }
                                        while (true) {
                                            try {
                                                System.out.println(
                                                        "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();
                                                if (choice == 1) {
                                                    System.out.println("The vacinee's age has been edited into: "
                                                            + ageList1.get(id));
                                                    doseName1.put(id, doses[0]);
                                                    System.out.println(
                                                            "\u001B[36mChoosen Dose has been edited into: \u001B[33m"
                                                                    + doseName1.get(id));
                                                } else if (choice == 2) {
                                                    System.out.println("The vacinee's age has been edited into: "
                                                            + ageList1.get(id));
                                                    doseName1.put(id, doses[1]);
                                                    System.out.println(
                                                            "\u001B[36mChoosen Dose has been edited into: \u001B[33m"
                                                                    + doseName1.get(id));
                                                }

                                                else {
                                                    System.out.println("\u001B[31mInvalid input! PLease enter a .");
                                                }
                                            } catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }
                                        }
                                    }
                                    if (age >= 18) {
                                        String[] AdultDose = { "1 - Astrazeneca", "2 - Moderna ", "3 - Janssen",
                                                "4 - Pfizer", "5 - Sputnik V", "6 - Sinovac" };
                                        System.out.print(
                                                "\u001B[35m\n██████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ PREFERABLE DOSES ░▒▓████████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                        for (String dose : AdultDose) {
                                            System.out.println(dose);
                                        }
                                        while (true) {
                                            try {
                                                System.out.println(
                                                        "\nEnter the number of the vaccine name that you want to take: \u001B[37m");
                                                choice = input.nextInt();

                                                if (choice == 1) {
                                                    String[] compDose = { "1 - ", "2 - Moderna ", "3 - Janssen",
                                                            "4 - Pfizer", "5 - Sputnik V", "6 - Sinovac" };

                                                } else if (choice == 2) {

                                                } else if (choice == 3) {

                                                } else if (choice == 5) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(id)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                                    doseName1.put(id, AdultDose[4]);
                                                    System.out.println("\u001B[36mChosen dose: \u001B[33m1");
                                                } else if (choice == 6) {
                                                    System.out.print(
                                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                                    + IDs1.get(id)
                                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");

                                                    System.out.println("\u001B[36mNo. of taken doses: \u001B[33m1");
                                                    doseName1.put(id, AdultDose[5]);
                                                    System.out.println(
                                                            "\n\u001B[36mDo you want to confirm your entered details?\nPress 1 if yes or 2 if not: ");
                                                    choice = input.nextInt();
                                                    if (choice == 1) {
                                                        System.out.print("\033[H\033[2J");
                                                        System.out.flush();
                                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                                patientLimit4, patientLimit5, attempts1, attempts2,
                                                                attempts3, attempts4, attempts5, date1, date2, date3,
                                                                date4, date5, vaccinationSite1, vaccinationSite2,
                                                                vaccinationSite3, vaccinationSite4, vaccinationSite5,
                                                                doctor1, doctor2, doctor3, doctor4, vaccinator5,
                                                                doctor1, doctor2, doctor3, doctor4, doctor5, start1,
                                                                start2, start3, start4, start5, end1, end2, end3, end4,
                                                                end5, input, imp, nameList1, nameList2, nameList3,
                                                                nameList4, nameList5, ageList1, ageList2, ageList3,
                                                                ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                                mobileNum4, mobileNum5, addresses1, addresses2,
                                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3,
                                                                IDs4, IDs5, passList1, passList2, passList3, passList4,
                                                                passList5, middleName1, middleName2, middleName3,
                                                                middleName4, middleName5, timeList1, timeList2,
                                                                timeList3, timeList4, timeList5, dateList1, dateList2,
                                                                dateList3, dateList4, dateList5, doseName1, doseName2,
                                                                doseName3, doseName4, doseName5, 0, false);
                                                    }
                                                    /*
                                                     * else if (choice == 2) {
                                                     * EditReservation(patientLimit1, patientLimit2, patientLimit3,
                                                     * patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                     * attempts4, attempts5, date1, date2, date3, date4, date5,
                                                     * vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                     * vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                     * vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2, doctor3,
                                                     * doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                                     * end2, end3, end4, end5, input, imp, nameList1, nameList2,
                                                     * nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                                                     * ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                                     * mobileNum4, mobileNum5, addresses1, addresses2, addresses3,
                                                     * addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                                                     * passList2, passList3, passList4, passList5, middleName1,
                                                     * middleName2, middleName3, middleName4, middleName5, timeList1,
                                                     * timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                     * dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                     * doseName4, doseName5, choice, setReserve);
                                                     * }
                                                     */
                                                    else {
                                                        System.out.println("\u001B[31mInvalid input!.");
                                                    }
                                                }
                                            } catch (InputMismatchException ex) {
                                                System.out.println(
                                                        "\u001B[31mInvalid input! Please enter a number and try again.");
                                                input.nextLine();
                                            }

                                        }
                                    }

                                    System.out.println(
                                            "If you want to edit another detail, press 9 to go back. Otherwise, press 0 to exit.");
                                    choice = input.nextInt();
                                }
                                // For mobile num
                                else if (choice == 3) {
                                    System.out.print("Enter your Mobile number: ");
                                    String mobileNumber = input.next();
                                    System.out.println("The patient's current mobile number " + mobileNum1.get(id)
                                            + " has been edited into");
                                    mobileNum1.replace(id, mobileNumber);
                                    System.out.println(mobileNum1.get(id) + ".");
                                    System.out.println(
                                            "If you want to edit another detail, press 9 to go back. Otherwise, press 0 to exit.");
                                    choice = input.nextInt();
                                }
                                // Enter address
                                else if (choice == 4) {
                                    System.out.print("Enter your Address: ");
                                    String address = input.next();
                                    System.out.println("The patient's current mobile number " + addresses1.get(id)
                                            + " has been edited into");
                                    addresses1.replace(id, address);
                                    System.out.println(addresses1.get(id) + ".");
                                    System.out.println(
                                            "If you want to edit another detail, press 9 to go back. Otherwise, press 0 to exit.");
                                    choice = input.nextInt();
                                }
                                // Password
                                else if (choice == 5) {
                                    System.out.print("Enter your Password: ");
                                    String pass = input.next();
                                    passList1.replace(id, pass);
                                    System.out.println("Your password has been changed. Please remember it well.");
                                    System.out.println(
                                            "If you want to edit another detail, press 1 to go back. Otherwise, press 0 to exit.");
                                    choice = input.nextInt();
                                }
                            }
                        }

                        else {
                            System.out.println("Invalid password! Please try again ");
                        }
                    }

                }

                else {
                    System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                }
            }

            catch (InputMismatchException ex) {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                input.nextLine();
            }
        }
    }

    public void RemoveReservation(int patientLimit1, int patientLimit2, int patientLimit3, int patientLimit4,
            int patientLimit5,
            int attempts1, int attempts2, int attempts3, int attempts4, int attempts5,
            String date1, String date2, String date3, String date4, String date5,
            String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4,
            String vaccinationSite5,
            String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
            String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
            String start1, String start2, String start3, String start4, String start5,
            String end1, String end2, String end3, String end4, String end5,
            Scanner input, Implement imp,
            LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2,
            LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4,
            LinkedHashMap<String, String> nameList5,
            LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2,
            LinkedHashMap<String, Integer> ageList3, LinkedHashMap<String, Integer> ageList4,
            LinkedHashMap<String, Integer> ageList5,
            LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,
            LinkedHashMap<String, String> mobileNum3,
            LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
            LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,
            LinkedHashMap<String, String> addresses3, LinkedHashMap<String, String> addresses4,
            LinkedHashMap<String, String> addresses5,
            LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3,
            LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
            LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2,
            LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4,
            LinkedHashMap<String, String> passList5,
            LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2,
            LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4,
            LinkedHashMap<String, String> middleName5,
            LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2,
            LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4,
            LinkedHashMap<String, String> timeList5,
            LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2,
            LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4,
            LinkedHashMap<String, String> dateList5,
            LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2,
            LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4,
            LinkedHashMap<String, String> doseName5,
            int choice, boolean setReserve) {
        System.out.println(
                "\u001B[35m\n█████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ REMOVE RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out
                .println("\u001B[36m1 - Choosen Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        while (true) {
            try {
                System.out.print(
                        "\u001B[36mEnter the number of which dose phase would like to check the reservation list: \u001B[37m");
                choice = input.nextInt();
                if (choice == 1) {
                    if (nameList1.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList1.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                            // Main
                            while (true) {
                                System.out.print(
                                        "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                                String id = input.next();

                                for (Map.Entry e : nameList1.entrySet()) {
                                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                                }

                                if (IDs1.containsValue(id)) {
                                    System.out.print("Enter your password: ");
                                    String passWord = input.next();
                                    if (passList1.containsValue(passWord)) {
                                        System.out.print(
                                                "Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            nameList1.remove(id);
                                            ageList1.remove(id);
                                            mobileNum1.remove(id);
                                            addresses1.remove(id);
                                            timeList1.remove(id);
                                            dateList1.remove(id);
                                            passList1.remove(id);
                                            IDs1.remove(id);
                                            middleName1.remove(id);
                                            doseName1.remove(id);
                                            System.out.println(
                                                    "\u001B[35mVaccinee is already been removed on the reservation list.");
                                            System.out.print(
                                                    "Enter 0 and press enter to go back, .   Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                            choice = input.nextInt();

                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }

                                            else if (choice == 0) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                CheckReservation(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid password! Please try again ");
                                    }
                                }
                            }
                        }
                    }
                }
                if (choice == 2) {
                    if (nameList2.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList3.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                            // Main
                            while (true) {
                                System.out.print(
                                        "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                                String id = input.next();

                                for (Map.Entry e : nameList3.entrySet()) {
                                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                                }

                                if (IDs2.containsValue(id)) {
                                    System.out.print("Enter your password: ");
                                    String passWord = input.next();
                                    if (passList2.containsValue(passWord)) {
                                        System.out.print(
                                                "Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            nameList2.remove(id);
                                            ageList2.remove(id);
                                            mobileNum2.remove(id);
                                            addresses2.remove(id);
                                            timeList2.remove(id);
                                            dateList2.remove(id);
                                            passList2.remove(id);
                                            IDs2.remove(id);
                                            middleName2.remove(id);
                                            doseName2.remove(id);
                                            System.out.println(
                                                    "\u001B[35mVaccinee is already been removed on the reservation list.");
                                            System.out.print(
                                                    "Enter 0 and press enter to go back, .   Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                            choice = input.nextInt();

                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }

                                            else if (choice == 0) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                CheckReservation(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid password! Please try again ");
                                    }
                                }
                            }
                        }
                    }
                }
                if (choice == 3) {
                    if (nameList3.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList3.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                            // Main
                            while (true) {
                                System.out.print(
                                        "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                                String id = input.next();

                                for (Map.Entry e : nameList3.entrySet()) {
                                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                                }

                                if (IDs3.containsValue(id)) {
                                    System.out.print("Enter your password: ");
                                    String passWord = input.next();
                                    if (passList3.containsValue(passWord)) {
                                        System.out.print(
                                                "Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            nameList3.remove(id);
                                            ageList3.remove(id);
                                            mobileNum3.remove(id);
                                            addresses3.remove(id);
                                            timeList3.remove(id);
                                            dateList3.remove(id);
                                            passList3.remove(id);
                                            IDs3.remove(id);
                                            middleName3.remove(id);
                                            doseName3.remove(id);
                                            System.out.println(
                                                    "\u001B[35mVaccinee is already been removed on the reservation list.");
                                            System.out.print(
                                                    "Enter 0 and press enter to go back, .   Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                            choice = input.nextInt();

                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }

                                            else if (choice == 0) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                CheckReservation(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid password! Please try again ");
                                    }
                                }
                            }
                        }
                    }
                }
                if (choice == 4) {
                    if (nameList1.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList4.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                            // Main
                            while (true) {
                                System.out.print(
                                        "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                                String id = input.next();

                                for (Map.Entry e : nameList4.entrySet()) {
                                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                                }

                                if (IDs4.containsValue(id)) {
                                    System.out.print("Enter your password: ");
                                    String passWord = input.next();
                                    if (passList4.containsValue(passWord)) {
                                        System.out.print(
                                                "Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            nameList4.remove(id);
                                            ageList4.remove(id);
                                            mobileNum4.remove(id);
                                            addresses4.remove(id);
                                            timeList4.remove(id);
                                            dateList4.remove(id);
                                            passList4.remove(id);
                                            IDs4.remove(id);
                                            middleName4.remove(id);
                                            doseName4.remove(id);
                                            System.out.println(
                                                    "\u001B[35mVaccinee is already been removed on the reservation list.");
                                            System.out.print(
                                                    "Enter 0 and press enter to go back, .   Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                            choice = input.nextInt();

                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }

                                            else if (choice == 0) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                CheckReservation(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid password! Please try again ");
                                    }
                                }
                            }
                        }
                    }
                }
                if (choice == 5) {
                    if (nameList5.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList5.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                            // Main
                            while (true) {
                                System.out.print(
                                        "\nEnter the ID that you want to check the details (Enter B and press enter to go back): ");
                                String id = input.next();

                                for (Map.Entry e : nameList5.entrySet()) {
                                    System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                                }

                                if (IDs5.containsValue(id)) {
                                    System.out.print("Enter your password: ");
                                    String passWord = input.next();
                                    if (passList5.containsValue(passWord)) {
                                        System.out.print(
                                                "Would you like to cancel your reservation?.  Enter 1 and press enter to say yes and 2 if not ");
                                        choice = input.nextInt();

                                        if (choice == 1) {
                                            nameList5.remove(id);
                                            ageList5.remove(id);
                                            mobileNum5.remove(id);
                                            addresses5.remove(id);
                                            timeList5.remove(id);
                                            dateList5.remove(id);
                                            passList5.remove(id);
                                            IDs5.remove(id);
                                            middleName5.remove(id);
                                            doseName5.remove(id);
                                            System.out.println(
                                                    "\u001B[35mVaccinee is already been removed on the reservation list.");
                                            System.out.print(
                                                    "Enter 0 and press enter to go back, .   Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                            choice = input.nextInt();

                                            if (choice == 1) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }

                                            else if (choice == 0) {
                                                System.out.print("\033[H\033[2J");
                                                System.out.flush();
                                                CheckReservation(patientLimit1, patientLimit2, patientLimit3,
                                                        patientLimit4, patientLimit5, attempts1, attempts2, attempts3,
                                                        attempts4, attempts5, date1, date2, date3, date4, date5,
                                                        vaccinationSite1, vaccinationSite2, vaccinationSite3,
                                                        vaccinationSite4, vaccinationSite5, vaccinator1, vaccinator2,
                                                        vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                                        doctor3, doctor4, doctor5, start1, start2, start3, start4,
                                                        start5, end1, end2, end3, end4, end5, input, imp, nameList1,
                                                        nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                                                        ageList3, ageList4, ageList5, mobileNum1, mobileNum2,
                                                        mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                        addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                                        IDs5, passList1, passList2, passList3, passList4, passList5,
                                                        middleName1, middleName2, middleName3, middleName4, middleName5,
                                                        timeList1, timeList2, timeList3, timeList4, timeList5,
                                                        dateList1, dateList2, dateList3, dateList4, dateList5,
                                                        doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                                        false);
                                            }
                                        }
                                    } else {
                                        System.out.println("Invalid password! Please try again ");
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (InputMismatchException ex) {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                input.nextLine();
            }
        }
    }

    public void forgotPassword(int patientLimit1, int patientLimit2, int patientLimit3, int patientLimit4,
            int patientLimit5,
            int attempts1, int attempts2, int attempts3, int attempts4, int attempts5,
            String date1, String date2, String date3, String date4, String date5,
            String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4,
            String vaccinationSite5,
            String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
            String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
            String start1, String start2, String start3, String start4, String start5,
            String end1, String end2, String end3, String end4, String end5,
            Scanner input, Implement imp,
            LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2,
            LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4,
            LinkedHashMap<String, String> nameList5,
            LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2,
            LinkedHashMap<String, Integer> ageList3, LinkedHashMap<String, Integer> ageList4,
            LinkedHashMap<String, Integer> ageList5,
            LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,
            LinkedHashMap<String, String> mobileNum3,
            LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
            LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,
            LinkedHashMap<String, String> addresses3, LinkedHashMap<String, String> addresses4,
            LinkedHashMap<String, String> addresses5,
            LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3,
            LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
            LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2,
            LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4,
            LinkedHashMap<String, String> passList5,
            LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2,
            LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4,
            LinkedHashMap<String, String> middleName5,
            LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2,
            LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4,
            LinkedHashMap<String, String> timeList5,
            LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2,
            LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4,
            LinkedHashMap<String, String> dateList5,
            LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2,
            LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4,
            LinkedHashMap<String, String> doseName5,
            int choice, boolean setReserve) {

        System.out.println(
                "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out
                .println("\u001B[36m1 - Choosen Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");
        while (true) {
            try {
                System.out.print(
                        "\u001B[36mEnter the number of which dose phase would like to check the reservation list: \u001B[37m");
                choice = input.nextInt();
                if (choice == 1) {
                    if (nameList1.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList1.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    // Main
                    while (true) {
                        try {
                            System.out.print(
                                    "\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if (IDs1.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord = input.next();
                                if (middleName1.containsValue(passWord)) {
                                    System.out.print(
                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                    + passList1.get(id)
                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList1.get(id));

                                    System.out.print(
                                            "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }

                                    else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }
                                }

                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }

                            else {
                                System.out.println("This user doesn't exists ");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();

                        }
                    }
                }
                if (choice == 2) {
                    if (nameList2.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList2.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    // Main
                    while (true) {
                        try {
                            System.out.print(
                                    "\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if (IDs2.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord = input.next();
                                if (middleName2.containsValue(passWord)) {
                                    System.out.print(
                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                    + passList1.get(id)
                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList2.get(id));

                                    System.out.print(
                                            "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }

                                    else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }
                                }

                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }

                            else {
                                System.out.println("This user doesn't exists ");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();

                        }
                    }
                }
                if (choice == 3) {
                    if (nameList1.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList3.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    // Main
                    while (true) {
                        try {
                            System.out.print(
                                    "\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if (IDs3.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord = input.next();
                                if (middleName3.containsValue(passWord)) {
                                    System.out.print(
                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                    + passList1.get(id)
                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList3.get(id));

                                    System.out.print(
                                            "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }

                                    else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }
                                }

                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }

                            else {
                                System.out.println("This user doesn't exists ");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();

                        }
                    }
                }
                if (choice == 4) {
                    if (nameList4.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList4.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    // Main
                    while (true) {
                        try {
                            System.out.print(
                                    "\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if (IDs4.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord = input.next();
                                if (middleName4.containsValue(passWord)) {
                                    System.out.print(
                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                    + passList1.get(id)
                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList4.get(id));

                                    System.out.print(
                                            "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }

                                    else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }
                                }

                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }

                            else {
                                System.out.println("This user doesn't exists ");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();

                        }
                    }
                }
                if (choice == 5) {
                    if (nameList5.entrySet().isEmpty()) {
                        System.out.println("\u001B[31mReservation list is empty");
                        while (true) {
                            try {
                                System.out.print(
                                        "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1 and press enter to exit the cancel reservation mode: \u001B[37m");
                                choice = input.nextInt();
                                if (choice == 1) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                            doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4, doctor5,
                                            start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input,
                                            imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1,
                                            ageList2, ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3,
                                            mobileNum4, mobileNum5, addresses1, addresses2, addresses3, addresses4,
                                            addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2, passList3,
                                            passList4, passList5, middleName1, middleName2, middleName3, middleName4,
                                            middleName5, timeList1, timeList2, timeList3, timeList4, timeList5,
                                            dateList1, dateList2, dateList3, dateList4, dateList5, doseName1, doseName2,
                                            doseName3, doseName4, doseName5, 0, false);
                                }

                                else if (choice == 0) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    ;
                                    RemoveReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                            patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5, date1,
                                            date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                            vaccinationSite3, vaccinationSite4, vaccinationSite5, vaccinator1,
                                            vaccinator2, vaccinator3, vaccinator4, vaccinator5, doctor1, doctor2,
                                            doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1,
                                            end2, end3, end4, end5, input, imp, nameList1, nameList2, nameList3,
                                            nameList4, nameList5, ageList1, ageList2, ageList3, ageList4, ageList5,
                                            mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4,
                                            IDs5, passList1, passList2, passList3, passList4, passList5, middleName1,
                                            middleName2, middleName3, middleName4, middleName5, timeList1, timeList2,
                                            timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                                            dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, choice,
                                            setReserve);
                                }

                                else {
                                    System.out.println(
                                            "\u001B[31mInvalid input! Please enter 0 or 1 and and press enter.");
                                }
                            }

                            catch (InputMismatchException ex) {
                                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                                input.nextLine();
                            }
                            for (Map.Entry e : nameList5.entrySet()) {
                                System.out.println("\u001B[36m" + e.getKey() + " - " + e.getValue());
                            }
                        }
                    }
                    // Main
                    while (true) {
                        try {
                            System.out.print(
                                    "\nEnter the ID that you want to check your password(Enter B and press enter to go back): ");
                            String id = input.next();
                            if (IDs5.containsValue(id)) {
                                System.out.print("Enter your middle Name as an authentication: ");
                                String passWord = input.next();
                                if (middleName5.containsValue(passWord)) {
                                    System.out.print(
                                            "\u001B[35m\n███████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ VACINEE \u001B[36m#"
                                                    + passList1.get(id)
                                                    + "\u001B[35m'S DETAIL ░▒▓█████████████████████████████████████████████████████████████████████████████████████████████████████████\n\n\u001B[36m");
                                    System.out.println("\u001B[36mYour password is: \u001B[33m" + passList5.get(id));

                                    System.out.print(
                                            "\u001B[36mEnter 0 and press enter to go back. Otherwise, enter 1and press enter to exit the check reservation mode: ");
                                    choice = input.nextInt();

                                    if (choice == 1) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }

                                    else if (choice == 0) {
                                        System.out.print("\033[H\033[2J");
                                        System.out.flush();
                                        CheckReservation(patientLimit1, patientLimit2, patientLimit3, patientLimit4,
                                                patientLimit5, attempts1, attempts2, attempts3, attempts4, attempts5,
                                                date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                                                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2,
                                                doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                                                doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4,
                                                end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5,
                                                ageList1, ageList2, ageList3, ageList4, ageList5, mobileNum1,
                                                mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1, addresses2,
                                                addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5,
                                                passList1, passList2, passList3, passList4, passList5, middleName1,
                                                middleName2, middleName3, middleName4, middleName5, timeList1,
                                                timeList2, timeList3, timeList4, timeList5, dateList1, dateList2,
                                                dateList3, dateList4, dateList5, doseName1, doseName2, doseName3,
                                                doseName4, doseName5, 0, false);
                                    }
                                }

                                else {
                                    System.out.println("Invalid password! Please try again ");
                                }
                            }

                            else {
                                System.out.println("This user doesn't exists ");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();

                        }
                    }
                }
            }

            catch (InputMismatchException ex) {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                input.nextLine();
            }
        }
    }

    public void SetReservation(int patientLimit1, int patientLimit2, int patientLimit3, int patientLimit4,
            int patientLimit5,
            int attempts1, int attempts2, int attempts3, int attempts4, int attempts5,
            String date1, String date2, String date3, String date4, String date5,
            String vaccinationSite1, String vaccinationSite2, String vaccinationSite3, String vaccinationSite4,
            String vaccinationSite5,
            String vaccinator1, String vaccinator2, String vaccinator3, String vaccinator4, String vaccinator5,
            String doctor1, String doctor2, String doctor3, String doctor4, String doctor5,
            String start1, String start2, String start3, String start4, String start5,
            String end1, String end2, String end3, String end4, String end5,
            Scanner input, Implement imp,
            LinkedHashMap<String, String> nameList1, LinkedHashMap<String, String> nameList2,
            LinkedHashMap<String, String> nameList3, LinkedHashMap<String, String> nameList4,
            LinkedHashMap<String, String> nameList5,
            LinkedHashMap<String, Integer> ageList1, LinkedHashMap<String, Integer> ageList2,
            LinkedHashMap<String, Integer> ageList3, LinkedHashMap<String, Integer> ageList4,
            LinkedHashMap<String, Integer> ageList5,
            LinkedHashMap<String, String> mobileNum1, LinkedHashMap<String, String> mobileNum2,
            LinkedHashMap<String, String> mobileNum3,
            LinkedHashMap<String, String> mobileNum4, LinkedHashMap<String, String> mobileNum5,
            LinkedHashMap<String, String> addresses1, LinkedHashMap<String, String> addresses2,
            LinkedHashMap<String, String> addresses3, LinkedHashMap<String, String> addresses4,
            LinkedHashMap<String, String> addresses5,
            LinkedHashMap<String, String> IDs1, LinkedHashMap<String, String> IDs2, LinkedHashMap<String, String> IDs3,
            LinkedHashMap<String, String> IDs4, LinkedHashMap<String, String> IDs5,
            LinkedHashMap<String, String> passList1, LinkedHashMap<String, String> passList2,
            LinkedHashMap<String, String> passList3, LinkedHashMap<String, String> passList4,
            LinkedHashMap<String, String> passList5,
            LinkedHashMap<String, String> middleName1, LinkedHashMap<String, String> middleName2,
            LinkedHashMap<String, String> middleName3, LinkedHashMap<String, String> middleName4,
            LinkedHashMap<String, String> middleName5,
            LinkedHashMap<String, String> timeList1, LinkedHashMap<String, String> timeList2,
            LinkedHashMap<String, String> timeList3, LinkedHashMap<String, String> timeList4,
            LinkedHashMap<String, String> timeList5,
            LinkedHashMap<String, String> dateList1, LinkedHashMap<String, String> dateList2,
            LinkedHashMap<String, String> dateList3, LinkedHashMap<String, String> dateList4,
            LinkedHashMap<String, String> dateList5,
            LinkedHashMap<String, String> doseName1, LinkedHashMap<String, String> doseName2,
            LinkedHashMap<String, String> doseName3, LinkedHashMap<String, String> doseName4,
            LinkedHashMap<String, String> doseName5,
            int choice, boolean setReserve) {

        System.out.println(
                "\u001B[35m\n████████████████████████████████████████████████████████████████████████████████████████████████████████████▓▒░ SET RESERVATION ░▒▓███████████████████████████████████████████████████████████████████████████████████████████████████████████████\n");
        System.out.println("\u001B[36m1 - 1st Dose\n2 - 2nd Dose\n3 - 1st Booster\n4 - 2nd Booster\n5 - 3rd Booster");

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // Date format
        dateFormat.setLenient(false);

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa"); // 12 hour time format
        timeFormat.setLenient(true);

        while (true) {
            try {

                System.out.print(
                        "\u001B[36mEnter the number of which dose phase would like to set the reservation: \u001B[37m");
                choice = input.nextInt();
                input.nextLine();

                if (choice == 1) {
                    System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                    vaccinationSite1 = input.nextLine();

                    while (true) {
                        System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                        vaccinator1 = input.nextLine();
                        if (isNumeric(vaccinator1) == true) {
                            System.out.print("\u001B[36mPlease input letters only  \u001B[37m\n");
                        }

                        else if (vaccinator1 != null) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                        String fname1 = input.next();
                        String sname1 = input.nextLine();
                        doctor1 = fname1 + sname1;

                        if (isNumeric(doctor1) == true) {
                            System.out.println("\u001B[36mPlease input letters only \u001B[37m");
                        }

                        else if (doctor1 != null) {
                            break;
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");
                            patientLimit1 = input.nextInt();
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
                        date1 = input.next();
                        try {
                            Date dateParsed = dateFormat.parse(date1);
                            System.out.println("1st Dose Vaccine Schedule Date: " + date1);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out
                                .print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            start1 = inputs + " " + inputs2;
                            Date timeParsedStart = timeFormat.parse(start1);
                            System.out.println("Starting time: " + start1);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            end1 = inputs + " " + inputs2;
                            Date timeParsedEnd = timeFormat.parse(end1);

                            System.out.println("End time: " + end1);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1,
                            attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5,
                            vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                            doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                            doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                            nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                            ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                            passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3,
                            middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                            dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4,
                            doseName5, 0, true);
                    break;
                }

                if (choice == 2) {
                    System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                    vaccinationSite2 = input.nextLine();

                    while (true) {
                        System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                        vaccinator2 = input.nextLine();
                        if (isNumeric(vaccinator2) == true) {
                            System.out.print("\u001B[36mPlease input letters only  \u001B[37m\n");
                        }

                        else if (vaccinator2 != null) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                        String fname1 = input.next();
                        String sname1 = input.nextLine();
                        doctor2 = fname1 + sname1;

                        if (isNumeric(doctor2) == true) {
                            System.out.println("\u001B[36mPlease input letters only \u001B[37m");
                        }

                        else if (doctor2 != null) {
                            break;
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");
                            patientLimit2 = input.nextInt();
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
                        date2 = input.next();
                        try {
                            Date dateParsed = dateFormat.parse(date2);
                            System.out.println("1st Dose Vaccine Schedule Date: " + date2);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out
                                .print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            start2 = inputs + " " + inputs2;
                            Date timeParsedStart = timeFormat.parse(start2);
                            System.out.println("Starting time: " + start2);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            end2 = inputs + " " + inputs2;
                            Date timeParsedEnd = timeFormat.parse(end2);

                            System.out.println("End time: " + end2);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1,
                            attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5,
                            vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                            doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                            doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                            nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                            ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                            passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3,
                            middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                            dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4,
                            doseName5, 0, true);
                    break;
                }

                if (choice == 3) {
                    System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                    vaccinationSite3 = input.nextLine();

                    while (true) {
                        System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                        vaccinator3 = input.nextLine();
                        if (isNumeric(vaccinator3) == true) {
                            System.out.print("\u001B[36mPlease input letters only  \u001B[37m\n");
                        }

                        else if (vaccinator3 != null) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                        String fname1 = input.next();
                        String sname1 = input.nextLine();
                        doctor3 = fname1 + sname1;

                        if (isNumeric(doctor3) == true) {
                            System.out.println("\u001B[36mPlease input letters only \u001B[37m");
                        }

                        else if (doctor3 != null) {
                            break;
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");
                            patientLimit3 = input.nextInt();
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
                        date3 = input.next();
                        try {
                            Date dateParsed = dateFormat.parse(date3);
                            System.out.println("1st Dose Vaccine Schedule Date: " + date3);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out
                                .print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            start3 = inputs + " " + inputs2;
                            Date timeParsedStart = timeFormat.parse(start3);
                            System.out.println("Starting time: " + start3);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            end3 = inputs + " " + inputs2;
                            Date timeParsedEnd = timeFormat.parse(end3);

                            System.out.println("End time: " + end3);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1,
                            attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5,
                            vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                            doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                            doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                            nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                            ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                            passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3,
                            middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                            dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4,
                            doseName5, 0, true);
                    break;

                }

                if (choice == 4) {
                    System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                    vaccinationSite4 = input.nextLine();

                    while (true) {
                        System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                        vaccinator4 = input.nextLine();
                        if (isNumeric(vaccinator4) == true) {
                            System.out.print("\u001B[36mPlease input letters only  \u001B[37m\n");
                        }

                        else if (vaccinator4 != null) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                        String fname1 = input.next();
                        String sname1 = input.nextLine();
                        doctor4 = fname1 + sname1;

                        if (isNumeric(doctor4) == true) {
                            System.out.println("\u001B[36mPlease input letters only \u001B[37m");
                        }

                        else if (doctor4 != null) {
                            break;
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");
                            patientLimit4 = input.nextInt();
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
                        date4 = input.next();
                        try {
                            Date dateParsed = dateFormat.parse(date4);
                            System.out.println("1st Dose Vaccine Schedule Date: " + date4);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out
                                .print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            start4 = inputs + " " + inputs2;
                            Date timeParsedStart = timeFormat.parse(start4);
                            System.out.println("Starting time: " + start4);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            end4 = inputs + " " + inputs2;
                            Date timeParsedEnd = timeFormat.parse(end4);

                            System.out.println("End time: " + end4);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1,
                            attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5,
                            vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                            doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                            doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                            nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                            ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                            passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3,
                            middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                            dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4,
                            doseName5, 0, true);
                    break;

                }

                if (choice == 5) {
                    System.out.print("\u001B[36mEnter the address of the vaccination site: \u001B[37m");
                    vaccinationSite5 = input.nextLine();

                    while (true) {
                        System.out.print("\u001B[36mEnter the vaccinator's name: \u001B[37m");
                        vaccinator5 = input.nextLine();
                        if (isNumeric(vaccinator5) == true) {
                            System.out.print("\u001B[36mPlease input letters only  \u001B[37m\n");
                        }

                        else if (vaccinator5 != null) {
                            break;
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the name of the doctor(s): \u001B[37m");
                        String fname1 = input.next();
                        String sname1 = input.nextLine();
                        doctor5 = fname1 + sname1;

                        if (isNumeric(doctor5) == true) {
                            System.out.println("\u001B[36mPlease input letters only \u001B[37m");
                        }

                        else if (doctor5 != null) {
                            break;
                        }
                    }
                    while (true) {
                        try {
                            System.out.print("\u001B[36mEnter vacinees limit: \u001B[37m");
                            patientLimit5 = input.nextInt();
                            break;
                        } catch (InputMismatchException ex) {
                            System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                            input.nextLine();
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter a date using this format (MM/dd/yyyy): \u001B[37m");
                        date5 = input.next();
                        try {
                            Date dateParsed = dateFormat.parse(date5);
                            System.out.println("1st Dose Vaccine Schedule Date: " + date5);
                            break;
                            // Reserved Date:
                            // date1 - 5 for Scheduled date
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (dd/MM/yyyy): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out
                                .print("\u001B[36mEnter the Starting time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            start5 = inputs + " " + inputs2;
                            Date timeParsedStart = timeFormat.parse(start5);
                            System.out.println("Starting time: " + start5);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    while (true) {
                        System.out.print("\u001B[36mEnter the End time using this format (hh:mm AM/PM): \u001B[37m");
                        String inputs = input.next();
                        String inputs2 = input.next();

                        try {
                            end5 = inputs + " " + inputs2;
                            Date timeParsedEnd = timeFormat.parse(end5);

                            System.out.println("End time: " + end5);
                            break;
                        } catch (ParseException e) {
                            System.out.println(
                                    "\u001B[31mInvalid date format, please follow the format (hh:mm AM/PM): \u001B[0m");
                        }
                    }

                    Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1,
                            attempts2, attempts3, attempts4, attempts5, date1, date2, date3, date4, date5,
                            vaccinationSite1, vaccinationSite2, vaccinationSite3, vaccinationSite4, vaccinationSite5,
                            doctor1, doctor2, doctor3, doctor4, vaccinator5, doctor1, doctor2, doctor3, doctor4,
                            doctor5, start1, start2, start3, start4, start5, end1, end2, end3, end4, end5, input, imp,
                            nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2, ageList3,
                            ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                            addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1,
                            passList2, passList3, passList4, passList5, middleName1, middleName2, middleName3,
                            middleName4, middleName5, timeList1, timeList2, timeList3, timeList4, timeList5, dateList1,
                            dateList2, dateList3, dateList4, dateList5, doseName1, doseName2, doseName3, doseName4,
                            doseName5, 0, true);
                    break;
                }
            }

            catch (InputMismatchException ex) {
                System.out.println("\u001B[31mInvalid input! Please enter a number and try again.");
                input.nextLine();
            }
        }
        Prompts.Prompt(patientLimit1, patientLimit2, patientLimit3, patientLimit4, patientLimit5, attempts1, attempts2,
                attempts3, attempts4, attempts5, date1, date2, date3, date4, date5, vaccinationSite1, vaccinationSite2,
                vaccinationSite3, vaccinationSite4, vaccinationSite5, doctor1, doctor2, doctor3, doctor4, vaccinator5,
                doctor1, doctor2, doctor3, doctor4, doctor5, start1, start2, start3, start4, start5, end1, end2, end3,
                end4, end5, input, imp, nameList1, nameList2, nameList3, nameList4, nameList5, ageList1, ageList2,
                ageList3, ageList4, ageList5, mobileNum1, mobileNum2, mobileNum3, mobileNum4, mobileNum5, addresses1,
                addresses2, addresses3, addresses4, addresses5, IDs1, IDs2, IDs3, IDs4, IDs5, passList1, passList2,
                passList3, passList4, passList5, middleName1, middleName2, middleName3, middleName4, middleName5,
                timeList1, timeList2, timeList3, timeList4, timeList5, dateList1, dateList2, dateList3, dateList4,
                dateList5, doseName1, doseName2, doseName3, doseName4, doseName5, 0, true);
    }
}
