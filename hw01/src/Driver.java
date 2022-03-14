import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {
        /*String side, int position, int height, int length */
        House a = new House(3, "white", "emir", "right", 0, 7, 4);
        House b = new House(3, "black", "can", "left", 0, 3, 3);
        Office c = new Office("law", "demirel", "left", 4, 4, 6);
        Office d = new Office("finance", "demirel", "left", 11, 5, 4);
        Playground e = new Playground("right", 0, 0, 2);
        Playground h = new Playground("left", 25, 0, 5);
        Market f = new Market("09:30", "21:30", "migros", "right", 14, 2, 7);
        Market g = new Market("09:00", "22:00", "carrefour", "left", 20, 2, 7);
        Street obj = new Street(30);
        
        System.out.println("----------test of add method----------");
        obj.add(a);
        obj.add(b);
        obj.add(c);
        obj.add(d);
        obj.add(e);
        obj.add(f);
        obj.add(g);
        obj.add(h);
        /*System.out.println("----------test of delete method----------");
        obj.delete(24,1);
        obj.delete(1, 0);
        System.out.println("----------test of focusing method----------");
        for(var i : obj.getStreetArray())
            i.Focusing();

        obj.RemainingLength();
        obj.DisplayList();
        obj.DisplayPlaygrounds();
        obj.OccupiedByHMO();
        obj.DisplaySilhoutte();


        System.out.println("-------------------\nMenu");
        System.out.println("1 - Editing Mode");
        System.out.println("2 - Viewing Mode");
        System.out.println("your choice: ");
        */
        
        /*switch (key) {
            case value:
                
                break;
        
            default:
                break;
        }*/



    }
}
