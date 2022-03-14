//import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        /*last 4: String side, int position, int height, int length */
        House a = new House(3, "white", "emir", "right", 0, 7, 4);
        House b = new House(3, "black", "can", "left", 7, 3, 3);
        Office c = new Office("law", "demirel", "left", 11, 4, 6);
        Office d = new Office("finance", "demirel", "left", 17, 5, 4);
        Playground e = new Playground("right", 22, 0, 2);
        Playground h = new Playground("left", 25, 0, 5);
        Market f = new Market("09:30", "21:30", "migros", "right", 14, 2, 7);
        Market g = new Market("09:00", "22:00", "carrefour", "left", 20, 2, 7);
        Street mainStreet = new Street(30);

        
        System.out.println("----------test with ----------");
        mainStreet.add(a);
        mainStreet.add(b);
        mainStreet.add(c);
        mainStreet.add(d);
        mainStreet.add(e);
        mainStreet.add(f);
        mainStreet.add(g);
        mainStreet.add(h);
        mainStreet.RemainingLength();
        mainStreet.DisplayList();                    
        mainStreet.DisplayPlaygrounds();                    
        mainStreet.OccupiedByHMO();                    
        mainStreet.DisplaySilhoutte();
        System.out.println("--------------------");
        for(var i: mainStreet.getStreetArray())
            i.Focusing();

        /*Scanner scanner = new Scanner(System.in);
        int inputInt;
        System.out.println("Set Street Length: ");
        inputInt = scanner.nextInt();
        Street mainStreet = new Street(inputInt);
        boolean exitValue = false;


        
        do {
            System.out.println("--------------------");
            System.out.println("1 - Editing Mode");
            System.out.println("2 - Viewing Mode");
            System.out.println("3 - exit");
            System.out.println("enter: ");
            String inputStr = new String();
            inputStr = scanner.next();
            

            switch (inputStr) {
                case "1":
                    System.out.println("--------------------");
                    System.out.println("1 - Add Building to the street");
                    System.out.println("2 - Delete Building from the street");
                    System.out.println("enter: ");
                    inputStr = scanner.next();
                        switch (inputStr) {
                            case "1":
                                System.out.println("enter side:");
                                String side = scanner.next();
                                System.out.println("enter position: ");
                                int position = scanner.nextInt();
                                System.out.println("enter length: ");
                                int length = scanner.nextInt();
                                System.out.println("enter height: ");
                                int height = scanner.nextInt();
                                System.out.println("---Choose Building Type---");
                                System.out.println("1 - House");
                                System.out.println("2 - Office");
                                System.out.println("3 - Market");
                                System.out.println("4 - Playground");
                                System.out.println("enter: ");
                                inputStr = scanner.next();
                                switch (inputStr) {
                                    case "1":
                                        System.out.println("enter number of rooms:");
                                        inputStr = scanner.next();
                                        int numberOfRooms = Integer.parseInt(inputStr);
                                        System.out.println("enter colour:");
                                        String colour = scanner.next();
                                        System.out.println("enter owner:");
                                        String ownerHouse = scanner.next();
                                        mainStreet.add(new House(numberOfRooms, colour, ownerHouse, side, position, height, length));
                                        break;
                                    case "2":
                                        System.out.println("enter job type:");
                                        String jobType = scanner.next();
                                        System.out.println("enter owner:");
                                        String ownerOffice = scanner.next();
                                        mainStreet.add(new Office(jobType, ownerOffice, side, position, height, length));
                                        break;
                                    case "3":
                                        System.out.println("enter opening time:");
                                        String openingTime = scanner.next();
                                        System.out.println("enter closing time:");
                                        String closingTime = scanner.next();
                                        System.out.println("enter owner:");
                                        String ownerMarket = scanner.next();
                                        mainStreet.add(new Market(openingTime, closingTime, ownerMarket, side, position, height, length));
                                        break;
                                    case "4":
                                        mainStreet.add(new Playground(side, position, height, length));
                                        break;     
                                    default:
                                        System.err.println("invalid input!!! returning the menu");
                                        break;
                                }
                                break;
                            case "2":
                                String sideDelete = " ";
                                int sideNum = 0;
                                do{
                                    System.out.println("enter side:");
                                    sideDelete = scanner.next();
                                    if(sideDelete.equals("right")) sideNum = 0;
                                    else if(sideDelete.equals("left")) sideNum = 1;
                                    else System.err.println("invalid side input.. try again");
                                }while(!sideDelete.equals("right") && !sideDelete.equals("left"));
                                System.out.println("enter position: ");
                                int positionDelete = scanner.nextInt();
                                System.out.println(positionDelete);
                                mainStreet.delete(positionDelete, sideNum);
                                break;
                            default:
                                System.err.println("invalid input returning to menu..");
                                break;
                        }
                    break;
                case "2":
                    System.out.println("--------------------");
                    System.out.println("1 - display the total remaining length of lands");
                    System.out.println("2 - display the list of buildings");
                    System.out.println("3 - display the number and ratio of lenth of playgrounds");
                    System.out.println("4 - calculate the total length of street occupied by the markets, houses or offices");
                    System.out.println("5 - display the skyline silhouette");
                    System.out.println("6 - Focusing Buildings");
                    System.out.println("enter: ");
                    inputStr = scanner.next();
                    switch (inputStr) {
                        case "1":
                            mainStreet.RemainingLength();
                            break;
                        case "2":
                            mainStreet.DisplayList();
                            break;
                        case "3":
                            mainStreet.DisplayPlaygrounds();
                            break;
                        case "4":
                            mainStreet.OccupiedByHMO();
                            break;
                        case "5":
                            mainStreet.DisplaySilhoutte();
                            break;
                        case "6":
                            System.out.println("--------------------");
                            for(var i: mainStreet.getStreetArray())
                                i.Focusing();
                            break;
                        default:
                            System.err.println("invalid input returning to menu..");
                            break;
                    }
                    break;
                case "3":
                    exitValue = true;
                    break;
                default:
                    System.err.println("invalid input!! please try again");
                    break;
            }
            
        } while (!exitValue);
        scanner.close();*/


    }
}
