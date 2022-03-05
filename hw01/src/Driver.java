public class Driver {
    public static void main(String[] args) {
        /*String side, int position, int height, int length */
        House a = new House(3, "white", "emir", "right", 0, 7, 4);
        House b = new House(3, "black", "can", "left", 0, 3, 3);
        Office c = new Office("law", "demirel", "left", 4, 4, 6);
        Office d = new Office("agency", "demirel", "left", 11, 5, 4);
        Playground e = new Playground();
        Street obj = new Street(30);
        obj.add(a);
        obj.add(b);
        obj.add(c);
        obj.add(d);
        obj.add(e);
        /*obj.RemainingLength();
        obj.DisplayList();
        obj.DisplayPlaygrounds();
        obj.OccupiedByHMO();*/
        obj.DisplaySilhoutte();
    }
}
