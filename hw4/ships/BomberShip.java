package ships;

/**
 * 
 * @author isaacplambeck
 * This class represents a BomberShip
 */

import projectiles.Bomb;
import projectiles.Projectile;
import utils.Position;

public class BomberShip extends InvaderShip {
	public static final double EXPLOSION_RADIUS = 10;

  /**
   * Constructs a BomberShip
   * @param p The initial position
   * @param armor The initial armor level
   */
	
	//fix
	public BomberShip(Position p, int armor) {
		//constructor
		super(p, armor);
	}

  /**
   * Drops a single bomb
   * @return An array containing a single bomb
   */
        public Projectile[] fire() {
        	
        	if (!canFire()) {
    			return null;
    		}
    		
    		
    		lastShotTime = System.currentTimeMillis();
    		
    		Bomb[] out = new Bomb[1];
    		
    		Position p = new Position(pos.getX(), pos.getY());
    		
    		//Bomb(Position initial, double xSpeed, double ySpeed, double yAcceleration, double explosionRadius)
    		out[0] = new Bomb(p, 0, PROJECTILE_SPEED * -1, Projectile.GRAVITY, EXPLOSION_RADIUS);
    		

    		return out;
	}

	@Override
	public String imgPath() {
		return "res/monster2.png";
	}

	@Override
	public int getPoints() {
		return 100;
	}
}
