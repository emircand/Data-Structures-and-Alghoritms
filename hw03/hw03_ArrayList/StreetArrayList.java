import java.util.ArrayList;
import java.util.Iterator;

public class StreetArrayList {
	private ArrayList<Buildings> streetAL;
	private int streetLength;
	
	public ArrayList<Buildings> getStreetAL() {
		return streetAL;
	}
	
	public int getStreetLength() {
		return streetLength;
	}
	
	StreetArrayList(int streetLength){
		if(streetLength <= 0)
            throw new ArrayIndexOutOfBoundsException("ERROR: street length must be positive integer!!");
        else {
        	this.streetLength = streetLength;
            streetAL = new ArrayList<Buildings>();
        }
	}
	
	/**
     * Control method for Street
     * if street is full with buildings or buildings don't fit in Street
     * method returns true; return false in other conditions
     * @param that Building instance which will be checked by method
     * @return  true or false according to the method output
     */
	public boolean isStreetFull(Buildings that) {
		int sum = 0;
        
		if(streetAL.size() == 0) return false;
        for (int i = 0; i < streetAL.size(); i++) {
            if(streetAL.get(i).getSide() == that.getSide()){
                sum += streetAL.get(i).getLength();
                if(streetAL.get(i).getPosition() >= that.getPosition() &&
                	streetAL.get(i).getPosition() <= that.getPosition() + that.getLength()){
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
     * add method to add new Buildings class instances to the StreetAL
     * @param that instance of Buildings
     */
	public void Add(Buildings that) {
		if(that.getLength() > getStreetLength())
            throw new ArrayIndexOutOfBoundsException("ERROR: building couldn't fit in the street");
        else if(!isStreetFull(that)){
            streetAL.add(that);
            System.out.println(that.getName() + " Succesfully added to street"); 
        }
	}
	
	/**
     * delete Building from given location
     * @param position
     * @param side
     */
	public void Delete(int position, int side){
        int index = -1;
        if(position >= getStreetLength())
            throw new ArrayIndexOutOfBoundsException("entered position is not in bounds of street");
        for (int i = 0; i < streetAL.size(); i++) {
            if(streetAL.get(i).getPosition() <= position && 
            	streetAL.get(i).getPosition() + streetAL.get(i).getLength() >= position &&
            	streetAL.get(i).getSide() == side)
            	index = i;
        }
        if(index != -1){    
            String className = new String(streetAL.get(index).getName());
            streetAL.remove(index);
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
        for (int i = 0; i < streetAL.size(); i++) {
            if(streetAL.get(i).getSide() == 0)
                rightSum += streetAL.get(i).getLength();
            else if(streetAL.get(i).getSide() == 1)
                leftSum += streetAL.get(i).getLength();
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
            for (var element: getStreetAL()) {
                if(BuildingTypes[i].equals(element.getName()))
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
        for (int i = 0; i < streetAL.size(); i++){
            if(streetAL.get(i).getName().equals("Playground")){
                numberOfPlaygrounds++;
                lengthsOfPlaygrounds += streetAL.get(i).getLength();
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
        for (int i = 0; i < streetAL.size(); i++) {
            if(streetAL.get(i).getName().equals("House") ||
            streetAL.get(i).getName().equals("Office") ||
            streetAL.get(i).getName().equals("Market") ){
                sum += streetAL.get(i).getLength();
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
        for (Buildings element : streetAL)
            if(element.getHeight() >= maxHeight)
                maxHeight = element.getHeight();

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
                for (Buildings element : streetAL) {
                    if(element.getPosition() == j &&
                    element.getHeight() == silhouette.length - i - 1 )
                        silhouette[i][j] = "-";
                    else if(element.getPosition() + element.getLength() == j &&
                    element.getHeight() == silhouette.length - i - 1 )
                        silhouette[i][j] = "-";
                }
            }
        }
        
        for(int i = 1; i < silhouette.length-1; i++) {
        	boolean isCorner = false;
        	for(int j = 0; j < silhouette[i].length; j++) {
        		if(silhouette[i][j] == "-") {
        			isCorner = !isCorner;
        			if(silhouette[i-1][j] != "*" && silhouette[i][j+1] != "*")
        				silhouette[i+1][j] = "*";
        			
        		}
        		else if(isCorner)
        			silhouette[i][j] = "+";
        		
        		else if(silhouette[i][j] == " " && silhouette[i-1][j] == "*")
        			silhouette[i][j] = "*";
        			if(silhouette[i][j] == "*" && j > 0) {
	        			if(silhouette[i-1][j-1] == "-" || silhouette[i-1][j+1] == "-" )
	        				silhouette[i][j] = " ";
	        			else if(silhouette[i-1][j] != "-" &&
	        					(silhouette[i-1][j-1] == "+" || silhouette[i-1][j+1] == "+" ))
	        				silhouette[i][j] = " ";
        			}
        			
        		if(silhouette[i][j] == "+" && (silhouette[i][j-1] == " " &&
        				silhouette[i][j+1] == " ") && j > 0)
        			silhouette[i][j] = " ";
        	}
        }
        for(int i = 1; i < silhouette.length-1; i++) {
        	boolean isCorner = false;
        	for(int j = 0; j < silhouette[i].length-1; j++) {
        		if(silhouette[i][j] == "-") {
        			isCorner = !isCorner;
        		}
        		else if(isCorner) {
        			for(int k = i+1; k < silhouette.length-1; k++) {
        				silhouette[k+1][j] = " ";
        			}
        		}
        		
        	}
        }
        // print the silhouette view
        for(int i = 1; i < silhouette.length-1; i++) {
        	for(int j = 0; j < silhouette[i].length-1; j++) {
                System.out.printf(silhouette[i][j]);
            }
        	System.out.println();
        }
    }
}
