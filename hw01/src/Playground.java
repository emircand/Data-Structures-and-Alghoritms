public class Playground extends Buildings{
    Playground(){
        length = 6;
        height = 1;
        position = 5;
        side = 0;
    }

    Playground(int Length){
        length = Length;
        height = 1;
    }

    public void Focusing(){
        System.out.println("length of the playground: " + getLength());
    }
}
