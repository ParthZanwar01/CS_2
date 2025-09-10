
public class FlowerViewer
{
   public static void main(String[] args)
   {
   	   Flower[]ary = new Flower[10];
   	   for(int i=0; i<ary.length; i++){
   	   	   ary[i] = new Flower(40*i,30);
   	   	   ary[i].draw();
   	   }
   }
}
