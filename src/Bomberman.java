
import java.awt.Graphics;
import javax.swing.ImageIcon;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author examen
 */
public class Bomberman {

    public static final int UP=0;
    public static final int RIGTH=1;
    public static final int DOWN=2;
    public static final int LEFT=3;
    public static final int NONE=-1;
    
    Animation[] animations;
    int x;
    int y;
    int vx;
    int vy;
    String path;
    int currentAnimation;
    int currentDirection;
    
    public Bomberman(int x, int y, int vx, int vy, String path){
        this.path=path;
        this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
        this.currentDirection=-1;
        animations=new Animation[4];
    }
    
    public void loadPics(String[] names)throws Exception{
        for (int j=0;j<4;j++) {
            String name=names[j];
            animations[j]=new Animation();
            for (int i = 1; i <= 5; i++) {
                System.out.println(path+"//"+name+i+".png");
                animations[j].addScene(
                new ImageIcon(getClass().getResource(path+"//"+name+i+".png")).getImage()        
                        , 100);
            }
        }
       
    }
    public void moveRigth(long time){
        x+=vx;
        currentAnimation=Bomberman.RIGTH;
        animations[Bomberman.RIGTH].update(time);
    }
    
    public void moveLeft(long time){
        x-=vx;
        currentAnimation=Bomberman.LEFT;
        animations[Bomberman.LEFT].update(time);
    }
    
     public void moveUp(long time){
        y-=vy;
        currentAnimation=Bomberman.UP;
        animations[Bomberman.UP].update(time);
    }
     
     public void moveDown(long time){
        y+=vy;
        currentAnimation=Bomberman.DOWN;
        animations[Bomberman.DOWN].update(time);
    }
     
     public void draw(Graphics g){
         g.drawImage(animations[currentAnimation].getImage(),x,y,null);
     }
}
