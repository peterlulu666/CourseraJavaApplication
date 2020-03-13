package BabyApplication;

import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyBirths {
    public static void main(String[] args) {
//        var fileResource = new FileResource();
//        for (CSVRecord rec : fileResource.getCSVParser(false)) {
//            if (Integer.parseInt(rec.get(2)) <= 100) {
//                System.out.println("Name " + rec.get(0) + " " +
//                        "Gender " + rec.get(1) + " " +
//                        "num of born " + rec.get(2));
//
//            }
//
//        }

        var fileResource = new FileResource("/Users/YanzhiWang/IdeaProjects/CourseraJavaApplication/src/us_babynames_testing/yob2012short.csv");
        totalBirths(fileResource);
        System.out.println(getRank(2012, "Mason", "M"));

    }

    public static void totalBirths(FileResource fileResource) {
        int total = 0;
        int totalBoy = 0;
        int totalGirl = 0;
        int numOfBoysName = 0;
        int numOfGirlsName = 0;
        for (CSVRecord rec : fileResource.getCSVParser(false)) {
            int numOfBorn = Integer.parseInt(rec.get(2));
            total = total + numOfBorn;
            if (rec.get(1).equals("M")) {
                totalBoy = totalBoy + numOfBorn;
                numOfBoysName = numOfBoysName + 1;

            } else {
                totalGirl = totalGirl + numOfBorn;
                numOfGirlsName = numOfGirlsName + 1;

            }

        }
        System.out.println("The total birth is " + total);
        System.out.println("The total boy is " + totalBoy);
        System.out.println("The total girl is " + totalGirl);
        System.out.println("The number of girls names is " + numOfGirlsName);
        System.out.println("The number of boys names is " + numOfBoysName);
        System.out.println("The total names in the file is " + (numOfBoysName + numOfGirlsName));

    }

    static long getRank(int year, String name, String gender) {
        var fileResource = new FileResource("/Users/YanzhiWang/IdeaProjects/CourseraJavaApplication/src/us_babynames_testing/yob" + year + "short.csv");
        long countGirlName = 0;
        for (CSVRecord rec : fileResource.getCSVParser(false)) {
            if (rec.get(1).equals("F")) {
                countGirlName++;

            }
            if (name.equals(rec.get(0)) && gender.equals(rec.get(1))) {
                return rec.getRecordNumber() - countGirlName;

            }

        }


        return -1;
    }

}

