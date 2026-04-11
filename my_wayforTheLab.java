package test;

import java.util.Scanner;
//idk what to say this is soooooooooo assss bro like WUT
public class my_wayforTheLab {
    public static void main(String[]args){
        Scanner scan = new Scanner(System.in);

        int hotel[][] = new int[7][5];

        System.out.println("=== HOTEL RESERVATION SYSTEM ===");
        while (true) { 
           System.out.println("1.View Rooms"); 
           System.out.println("2.Check In"); 
           System.out.println("3.Check Out"); 
           System.out.println("4.Exit"); 
           System.out.print("Enter choice: ");
           int choice = scan.nextInt();

           switch(choice){
            case 1:
                viewRooms(hotel);
                break;
            case 2:
                System.out.print("Enter floor (1-7): ");
                int floor = scan.nextInt();
                System.out.print("Enter room number (1-5): ");
                int room = scan.nextInt();
                int roomNumber = getRoomNumber(floor, room);
                checkIn(hotel, roomNumber,scan);
                break;
            
            case 3:
                System.out.print("Enter floor (1-7): ");
                floor = scan.nextInt();
                System.out.print("Enter room number (1-5): ");
                room = scan.nextInt();
                roomNumber = getRoomNumber(floor, room);
                checkOut(hotel, roomNumber,scan);
                break;

            case 4:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
           }
        }
        

    }
    public static void viewRooms(int hotel[][]){
        for (int i = 0; i < hotel.length; i++) {
            for (int j = 0; j < hotel[i].length; j++) {
                if (hotel[i][j] == 0) {
                    System.out.print("Room " + (i * hotel[i].length + j + 1) + " is available. ");
                } else {
                    System.out.print("Room " + (i * hotel[i].length + j + 1) + " is occupied. ");
                }
            }
            System.out.println();
        }
    }
    public static void checkIn(int hotel[][], int roomNumber,Scanner scan) {
        
        System.out.println("Enter floor (1-7): ");
        int floor = scan.nextInt();
        System.out.print("Enter room number (1-5): ");
        int room = scan.nextInt();
        if (hotel[floor - 1][room - 1] == 0) {
            hotel[floor - 1][room - 1] = 1; 
            System.out.println("Checked in to room " + roomNumber);
        } else {
            System.out.println("Room " + roomNumber + " is already occupied.");
        }
    }
    public static void checkOut(int hotel[][], int roomNumber,Scanner scan) {
        System.out.println("Enter floor (1-7): ");
        int floor = scan.nextInt();
        System.out.print("Enter room number (1-5): ");
        int room = scan.nextInt();
        if (hotel[floor - 1][room - 1] == 1) {
            hotel[floor - 1][room - 1] = 0; 
            System.out.println("Checked out of room " + roomNumber);
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }
    public static int getRoomNumber(int floor, int room) {
        return (floor - 1) * 5 + room;
    }
}