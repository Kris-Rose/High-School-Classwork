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

		/*
		 * Student code here
		 */
	}

	public void stepAll()
	{
		for (int i = 0; i < sprites.size(); i++)
		{
			Sprite s = sprites.get(i);

			s.step(this);
		}
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
