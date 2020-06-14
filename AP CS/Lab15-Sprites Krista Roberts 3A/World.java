import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class World
{
    public static void main(String[] args)
    {
        Display display = new Display(500, 500);
        display.run();
    }

    private List<Sprite> sprites;
    private int width;
    private int height;

    /** make a World with a default size 500 x 500 */
    public World()
    {
        this(500, 500);
    }

    public World(int width, int height)
    {
        this.width = width;
        this.height = height;

        this.sprites = new ArrayList<>();
        StationarySprite block = new StationarySprite(100, 100, 20, 50,"asteroid.png", true, false);
        StationarySprite obstacle = new StationarySprite(400, 300, 50, 50,"asteroid.png", true, false);
        sprites.add(block);
        sprites.add(obstacle);
        
        MobileSprite zoom = new MobileSprite(75, 130, 20, 60,"circle.png", 10, 20, true, false);
        MobileSprite yeet = new MobileSprite(200, 300, 70, 50,"circle.png", 40, 5, true, false);
        sprites.add(zoom);
        sprites.add(yeet);
        
        HeavySprite chub = new HeavySprite(94.0, 328.0, 30, 40,"triangle.png", 5, 10, true, false);
        HeavySprite down = new HeavySprite(499, 300, 50, 25,"triangle.png", 40, 5, true, false);
        sprites.add(chub);
        sprites.add(down);
        
        DiesSprite alien = new DiesSprite(499, 499, 50, 50,"ship.png", 15, 10, true, 5000, false);
        DiesSprite ufo = new DiesSprite(2, 67, 66, 40,"ship.png", 30, 15, true, 500, false);
        sprites.add(alien);
        sprites.add(ufo);
        
    }

    public void stepAll()
    {
        for (int i = 0; i < sprites.size(); i++)
        {
            Sprite s = sprites.get(i);
            s.step(this);
            if(sprites.get(i).getAlive() == false){
                sprites.remove(i);
            }
        }
    }

    public List<Sprite> getSprites(){
        return sprites;
    }
    
    
    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getNumSprites()
    {
        return sprites.size();
    }

    public Sprite getSprite(int index)
    {
        return sprites.get(index);
    }

    public void mouseClicked(int x, int y)
    {
        System.out.println("mouseClicked:  " + x + ", " + y);
    }

    /**
     * the display instructs the World (which contains all the Sprites)
     * which key has been pressed
     */
    public void keyPressed(int key)
    {
        System.out.println("key pressed: " + key);
    }

    public void keyReleased(int key)
    {
        System.out.println("key released: " + key);
    }

    public String getTitle()
    {
        return "World";
    }

    public void paintComponent(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);
        for (int i = 0; i < sprites.size(); i++)
        {
            Sprite sprite = sprites.get(i);
            g.drawImage(Display.getImage(sprite.getImage()),
                    (int)sprite.getLeft(), (int)sprite.getTop(),
                    sprite.getWidth(), sprite.getHeight(), null);
        }
    }
}
