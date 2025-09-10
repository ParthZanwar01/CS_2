public class InchWorm {

    private int position;
    private int direction;

    public InchWorm(){
        this.position = 0;
        this.direction = 1;
    }

    public InchWorm (int initialPosition){
        position = initialPosition;
        direction = 1;
    }

    public void turn(){
        direction = -direction;
    }

    public void move(){
        this.position += this.direction;
    }

    public int getPosition(){
        return this.position;
    }
}
