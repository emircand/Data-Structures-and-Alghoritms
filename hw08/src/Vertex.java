public class Vertex{
    private int index;
    private String label;
    private double weight;
    private String color;

    /**
     * Constructor of Vertex Class
     * @param label
     * @param weight
     * @param index
     */
    public Vertex(String label, double weight, int index){
        this.label = label;
        this.weight = weight;
        this.index = index;
    }

    /**
     * setColor method assign color to the Vertex
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * getter method for index data field of Vertex class
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * getter method for color data field of Vertex class
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * getter method for label data field of Label class
     * @return label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Overridden toString method of Vertex class
     * @return "[Node index] color" format
     */
    @Override
    public String toString() {
        return "[Node " + index + "] " + color;
    }
}
