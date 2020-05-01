package ships;
/**
 * 
 * @author isaacplambeck
 * This class represents a TsarBomberShip
 */
import utils.Position;

public class TsarBombaShip extends BomberShip {
	public static final double EXPLOSION_RADIUS = 50;

  /**
   * Constructs a TsarBombaShip
   * @param p The initial position
   * @param armor The initial armor level
   */
        public TsarBombaShip(Position p, int armor) {
        	//constructor
        	super(p, armor);
	}
	
	@Override
	public String imgPath() {
		return "res/monster4.png";
	}
}

