/*
 * @author Marcelo Sanchez
 * @Version 12/5/2017
 */
public class LifeDriver {

	public static void main(String[] args) {
		/*
		 * creates a gameOfLife object called game.
		 * invokes the run method on game for 200 ticks.
		 */
		gameOfLife game = new gameOfLife();
		game.run(200);
	}

}
