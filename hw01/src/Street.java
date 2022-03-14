import java.io.IOException;

/**
 * Street is a seperated class from the others which contain instances of Buildings 
 */
public class Street {
    private Buildings[] streetArray;
    private int streetLength;
    private int numberOfBuildings;

    /**
     * Class constructor
     */
    Street(){
        streetLength = 30;
        streetArray = new Buildings[1];
        numberOfBuildings = 0;
    }

    /**
     * Class constructor specifying length of all sides for Street
     * @param streetLength set by user 
     */
    Street(int streetLength){
        if(streetLength <= 0)
            throw new ArrayIndexOutOfBoundsException("ERROR: street length must be positive integer!!");
        else this.streetLength = streetLength;
        
        streetArray = new Buildings[1];
        numberOfBuildings = 0;
    }

    /**
     * getter method for streetLength variable
     * @return length of the street
     */
    public int getStreetLength() {
        return streetLength;
    }

    /**
     * set method for streetLength variable
     * @param streetLength
     */
    public void setStreetLength(int streetLength) {
        this.streetLength = streetLength;
    }

    /**
     * get method for streetArray
     * @return Buildings Array
     */
    public Buildings[] getStreetArray() {
        return streetArray;
    }

    /**
     * set method for streetArray
     * @param streetArray
     */
    public void setStreetArray(Buildings[] streetArray) {
        this.streetArray = streetArray;
    }
    
    /**
     * add method to add new Buildings class instance to the streetArray
     * @param that instance of Buildings
     */
    public void add(Buildings that){
        if(that.getLength() > getStreetLength())
            throw new ArrayIndexOutOfBoundsException("ERROR: building couldn't fit in the street");
        else if(!isStreetFull(that)){
            numberOfBuildings++;
            Buildings[] temp = new Buildings[numberOfBuildings];
            for (int j = 0; j < streetArray.length; j++) {
                temp[j] = streetArray[j];
            }
            setStreetArray(temp);
            streetArray[numberOfBuildings - 1] = that;
            System.out.println(that.getClass().getName() + " Succesfully added to street"); 
        }
    }

    /**
     * Control method for Street Class
     * if street is full with buildings or buildings don't fit in Street
     * method returns false; return true in other conditions
     * @param that Building instance which will be checked by method
     * @return  true or false according to the method output
     */
    public Boolean isStreetFull(Buildings that){
        int sum = 0;
        if(numberOfBuildings == 0) return false;
        for (int i = 0; i < streetArray.length; i++) {
            if(streetArray[i].getSide() == that.getSide()){
                sum += streetArray[i].getLength();
                if(streetArray[i].getPosition() >= that.getPosition() &&
                streetArray[i].getPosition() <= that.getPosition() + that.getLength()){
                    System.err.println("ERROR: position is full!!");
                    return true;
                }
            }
            if(streetLength - sum < that.getLength()){
                System.err.println("ERROR: street is full!!");
                return true;
            }
        }
        return false;
    }

    /**
     * choose an object an delete from the Street
     * @param that Buildings instance which will be deleted
     */
    public void delete(Buildings that){
        int index = -1;
        for (int i = 0; i < streetArray.length; i++) {
            if(that.equals(streetArray[i]))
                index = i;
        }
        if(index != -1){    
            Buildings[] temp = new Buildings[--numberOfBuildings];
            for (int i = 0; i < streetArray.length; i++) {
                if(i < index)
                    temp[i] = streetArray[i];
                if(i >= index && i < numberOfBuildings)
                    temp[i] = streetArray[i+1]; 
            }
            setStreetArray(temp);
            System.out.println(that.getClass().getName() + " Succesfully deleted");
        }

    }

    /**
     * overloaded method version of delete method
     * @param position
     * @param side
     */
    public void delete(int position, int side){
        int index = -1;
        if(position >= getStreetLength())
            throw new ArrayIndexOutOfBoundsException("entered position is not in bounds of street");
        for (int i = 0; i < streetArray.length; i++) {
            if(streetArray[i].getPosition() <= position && 
            streetArray[i].getPosition() + streetArray[i].getLength() >= position &&
            streetArray[i].getSide() == side)
                index = i;
        }
        if(index != -1){    
            Buildings[] temp = new Buildings[--numberOfBuildings];
            String className = new String(streetArray[index].getClass().getName());
            for (int i = 0; i < streetArray.length; i++) {
                if(i < index)
                    temp[i] = streetArray[i];
                if(i >= index && i < numberOfBuildings)
                    temp[i] = streetArray[i+1]; 
            }
            setStreetArray(temp);
            System.out.println(className + " Succesfully deleted");
        }
        else System.err.println("ERROR: the position is already empty!!!");
    }

    /**
     * display the total remaining length of lands on the street
     * 
     * total lengths of both sides subtracting the sum of occupied lengths on both sides of the street  
     */
    public void RemainingLength(){
        System.out.println("-------the total remaining length of lands on the street-------");
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 0; i < streetArray.length; i++) {
            if(streetArray[i].getSide() == 0)
                rightSum += streetArray[i].getLength();
            else if(streetArray[i].getSide() == 1)
                leftSum += streetArray[i].getLength();
        }
        int sum = rightSum + leftSum;
        System.out.println(2 * getStreetLength() - sum + " is the total remaining length of lands on the street.");
    }

    /**
     * display the list of buildings on the street
     */
    public void DisplayList(){
        String[] BuildingTypes = {"House", "Market", "Office", "Playground"};
        System.out.println("-------List of Buildings On The Street-------");
        for (int i = 0; i < BuildingTypes.length; i++) {
            int typeFrequency = 0;
            for (int j = 0; j < streetArray.length; j++) {
                if(BuildingTypes[i] == streetArray[j].getClass().getName())
                    typeFrequency++;
            }
            if(typeFrequency != 0)
                System.out.println(typeFrequency + "-" + BuildingTypes[i]);
        }
    }

    /**
     * display the number and ratio of length of playgrounds in the street
     */
    public void DisplayPlaygrounds(){
        int numberOfPlaygrounds = 0;
        int lengthsOfPlaygrounds = 0;
        System.out.println("-------the number and ratio of length of playgrounds on the street-------");
        for (int i = 0; i < streetArray.length; i++){
            if(streetArray[i].getClass().getName().equals("Playground")){
                numberOfPlaygrounds++;
                lengthsOfPlaygrounds += streetArray[i].getLength();
            }
        }
        System.out.println("Number of Playgrounds: " + numberOfPlaygrounds);
        System.out.println("The ratio length of playgrounds on the street: %" + (lengthsOfPlaygrounds * 100) / (2 * streetLength));

    }

    /**
     * calculate the total length of street occupied by the markets, houses or offices
     * @return total length of markets, houses and offices
     */
    public void OccupiedByHMO(){
        System.out.println("-------total length of street occupied by the markets, houses or offices-------");
        int sum = 0;
        for (int i = 0; i < streetArray.length; i++) {
            if(streetArray[i].getClass().getName().equals("House") ||
            streetArray[i].getClass().getName().equals("Office") ||
            streetArray[i].getClass().getName().equals("Market") ){
                sum += streetArray[i].getLength();
            }
        }
        System.out.println("total lengths of HMO's: " + sum);
    }

    /**
     * Display the skyline silhouette of the street
     */
    public void DisplaySilhoutte(){
        System.out.println("-------street silhouette-------");
        int maxHeight = 0;
        for (int t = 0; t < streetArray.length; t++) {
            if(streetArray[t].getHeight() >= maxHeight)
                maxHeight = streetArray[t].getHeight();
        }

        Fill(maxHeight);
        
    }

    /**
     * helper method for DisplaySilhoutte method
     * which converts street view to the 2D array
     * that includes top corner of every Building instance
     * @param maxHeight to create 2D array
     */
    public void Fill(int maxHeight){
        String[][] silhouette = new String[maxHeight+2][getStreetLength()+2];

        for (int i = 0; i < silhouette.length; i++) {
            for (int j = 0; j < silhouette[i].length; j++) {
                silhouette[i][j] = " ";
            }
        }

        for (int i = 0; i < silhouette.length; i++) {
            for (int j = 0; j < silhouette[i].length; j++) {
                for(int k = 0; k < streetArray.length; k++){
                    if(streetArray[k].getPosition() == j &&
                    streetArray[k].getHeight() == silhouette.length - i - 1 )
                        silhouette[i][j] = "*";
                    else if(streetArray[k].getPosition() + streetArray[k].getLength() == j &&
                    streetArray[k].getHeight() == silhouette.length - i - 1 )
                        silhouette[i][j] = "*";
                }
            }
        }


        Draw(silhouette);

        for (int i = 0; i < silhouette.length; i++) {
            for (int j = 0; j < silhouette[i].length; j++) {
                System.out.printf(silhouette[i][j]);
            }
            System.out.println();
        }


    }

    /**
     * helper method for DisplaySilhoutte method
     * that completes silhouette view
     * @param silhouette 2D array which includes corners of Buildings
     */
    public void Draw(String[][] silhouette){
        
        for (int i = 0; i < silhouette.length; i++) {
            boolean flag = false;
            for (int j = 0; j < silhouette[i].length; j++) {
                if( i > 0 && i < silhouette.length - 1 &&
                j > 0 && j < silhouette[i].length - 1){
                    if(silhouette[i][j] == "*" && 
                    silhouette[i][j-1] == " " && silhouette[i][j+1] == " ")
                        flag = false;
                    if(silhouette[i][j+1] == "*" && 
                    silhouette[i][j-1] == "*" && !flag){
                        silhouette[i][j] = "*";
                        flag = true;
                    }
                    if(silhouette[i][j+1] == " " && 
                    silhouette[i][j-1] == "*" && !flag)
                        silhouette[i][j] = "*";
                }
            }
        }

        for (int i = 0; i < silhouette.length; i++) {
            for (int j = 0; j < silhouette[i].length; j++) {
                if( i > 0 && i < silhouette.length - 1 &&
                j > 0 && j < silhouette[i].length - 1){
                    if(silhouette[i-1][j] == "*" && (silhouette[i-1][j-1] == " " ||
                    silhouette[i-1][j+1] == " "))
                        silhouette[i][j] = "*";
                }
                for (int k = i-1; k >= 0; k--) {
                    if(silhouette[i][j] == "*" && j == 0 && i < silhouette.length-2){
                        silhouette[i+1][j] = "*";
                    }
                    if(silhouette[i][j] == "*" &&
                    silhouette[i-1][j] == " " && silhouette[k][j] == "*")
                        silhouette[i][j] = " ";
                }
            }
        }
    }


}
