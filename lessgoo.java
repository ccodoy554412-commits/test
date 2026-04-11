package test;

import java.util.Scanner;
public class lessgoo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

    double[][] grades = new double[3][3];
    String[] subs = {"Math","Science","English"};      

        for(int i = 0;i<grades.length;i++){
            System.out.printf("Enter grades for student %d: \n",i+1);
            for(int j = 0;j<grades[i].length;j++){
                grades[i][j] = scan.nextDouble();
            }
        }
        System.out.println("Students\tMath\tScience\tEnglish\t\tAvarege");
        for(int i = 0;i<grades.length;i++){
            System.out.printf("Student %d\t",i+1);
            for(int j = 0;j<grades[i].length;j++){
                System.out.printf("%.2f\t",grades[i][j]);
            }
            System.out.printf("\tAvarege: %.2f\n",avaregePerStudent(grades,i));
        }

    scan.close();       
    }
    //avarege per student(row)
    public static double avaregePerStudent(double[][] grades,int studentIndex){
        double sum = 0;
        for(int i = 0;i<grades[studentIndex].length;i++){
            sum+=grades[studentIndex][i];
        }
        return sum/grades[studentIndex].length;
    }
}