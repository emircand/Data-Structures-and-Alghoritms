
/**
 * Playground subclass extends Buildings superclass
 */
public class Playground extends Buildings{
    Playground(){
        length = 6;
        height = 1;
        position = 5;
        side = 0;
    }

    /**
     * class constructor specified by parameters
     * @param side  location side on the street
     * @param position  location position on the street
     * @param height height of Playground
     * @param length length of Playground
     */
    Playground(String side, int position, int height, int length){
        try {
            if(!side.equals("right") && !side.equals("left"))
                throw new Exception("invalid side string side automatically initialized as right");
            else{
                if(side == "right")
                    this.side = 0;
                else if(side == "left")
                    this.side = 1;
            }
        } catch (Exception e) {
            System.err.println(e);
            this.side = 0;
        }
        this.height = height;
        this.length = length;
        this.position = position;
    }

    /**
     * Overridden abstract Focusing method
     * give the information of length of Playground
     */
    @Override
    public void Focusing(){
        System.out.println("length of the playground: " + getLength());
    }
}
