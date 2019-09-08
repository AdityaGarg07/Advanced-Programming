package ass4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class User {
	private String name;
	private int moves;
	private int sankebites;
	private int vulturebites;
	private int cricbites;
	private int tramp;
	private int current;

	public User(String name) {
		this.name = name;
		this.sankebites = 0;
		this.vulturebites = 0;
		this.cricbites = 0;
		this.tramp = 0;
		this.moves = 1;
		this.current = 1;
	}

	public int rolldice() {
		Random r = new Random();
		return 1 + r.nextInt(6);

	}

	public String getName() {
		return name;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getMoves() {
		return moves;
	}

	public void setMoves(int moves) {
		this.moves = moves;
	}

	public int getSankebites() {
		return sankebites;
	}

	public void setSankebites(int sankebites) {
		this.sankebites = sankebites;
	}

	public int getVulturebites() {
		return vulturebites;
	}

	public void setVulturebites(int vulturebites) {
		this.vulturebites = vulturebites;
	}

	public int getCricbites() {
		return cricbites;
	}

	public void setCricbites(int cricbites) {
		this.cricbites = cricbites;
	}

	public int getTramp() {
		return tramp;
	}

	public void setTramp(int tramp) {
		this.tramp = tramp;
	}
}

class SnakeBiteException extends Exception {

	public SnakeBiteException(String message) {
		super(message);
	}

}

class VultureBiteException extends Exception {

	public VultureBiteException(String message) {
		super(message);
	}

}

class CricketBiteException extends Exception {

	public CricketBiteException(String message) {
		super(message);
	}

}

class TrampolineException extends Exception {

	public TrampolineException(String message) {
		super(message);
	}

}

class GameWinnerException extends Exception {

	public GameWinnerException(String message) {
		super(message);
	}

}

abstract class Tile {

	public abstract void attack(int var, User user, int n) throws SnakeBiteException, VultureBiteException,
			CricketBiteException, GameWinnerException, TrampolineException;

	public int rand() {
		Random rx = new Random();
		return rx.nextInt(10) + 1;
	}

}

class White extends Tile {

	public void attack(int var, User user, int n) throws GameWinnerException {

		if (user.getCurrent() == n) {
			throw new GameWinnerException("\t\t" + "Congratulations! You win the game");
		} else {
			System.out.println("\t  " + "I am a White Tile");
		}
	}

}

class Snake extends Tile {

	public void attack(int var, User user, int n) throws SnakeBiteException {
		user.setSankebites(user.getSankebites() + 1);
		int reduce = super.rand();
		user.setCurrent(user.getCurrent() - reduce);
		if (user.getCurrent() < 1) {
			user.setCurrent(1);
		}

		throw new SnakeBiteException("\t  " + "Hiss...! I am a Snake, you go back " + reduce + " tiles!");
	}

}

class Vulture extends Tile {

	public void attack(int var, User user, int n) throws VultureBiteException {
		user.setVulturebites(user.getVulturebites() + 1);
		int reduce = super.rand();
		user.setCurrent(user.getCurrent() - reduce);
		if (user.getCurrent() < 1) {
			user.setCurrent(1);
		}

		throw new VultureBiteException("\t  " + "Yapping...! I am a Vulture, you go back " + reduce + " tiles!");
	}

}

class Cricket extends Tile {

	public void attack(int var, User user, int n) throws CricketBiteException {
		user.setCricbites(user.getCricbites() + 1);
		int reduce = super.rand();
		user.setCurrent(user.getCurrent() - reduce);
		if (user.getCurrent() < 1) {
			user.setCurrent(1);
		}

		throw new CricketBiteException("\t  " + "Chirp...! I am a Cricket, you go back " + reduce + " tiles!");
	}

}

class Trampoline extends Tile {

	public void attack(int var, User user, int n) throws TrampolineException {
		user.setTramp(user.getTramp() + 1);
		int inc = super.rand();
		user.setCurrent(user.getCurrent() + inc);
		if (user.getCurrent() > n) {
			user.setCurrent(n);
		}

		throw new TrampolineException("\t  " + "PingPong! I am a Trampoline, you advance " + inc + " tiles");
	}

}

class Game {
	private ArrayList<User> users;
	private Tile[] mytiles;
	public static HashMap<Integer, Boolean> random = new HashMap<>();
	private int n;
	private int Snakes;
	private int Vultures;
	private int Crickets;
	private int Trampolines;

	public Game(int n) {
		users = new ArrayList<>();
		mytiles = new Tile[n + 1];
		this.n = n;

		this.Snakes = 0;
		this.Vultures = 0;
		this.Crickets = 0;
		this.Trampolines = 0;

		Arrays.fill(mytiles, new White());
	}

	public void setTile() {
		Random r = new Random();

		for (int i = 0; i < n / 3; i++) {
			int TType = r.nextInt(4) + 1;

			int pos = 1 + URandom(n - 1);

			switch (TType) {
			case 1:
				mytiles[pos] = new Snake();
				Snakes++;
				break;
			case 2:
				mytiles[pos] = new Vulture();
				Vultures++;
				break;
			case 3:
				mytiles[pos] = new Cricket();
				Crickets++;
				break;
			case 4:
				mytiles[pos] = new Trampoline();
				Trampolines++;
				break;
			}

		}

	}

	public void startgame() {

		Scanner s = new Scanner(System.in);
		boolean move = true;

		System.out.println("Setting up the race track...");
		setTile();
		System.out.println("Danger: There are " + Snakes + ", " + Crickets + ", " + Vultures
				+ " numbers of Snakes, Cricket, and Vultures respectively on your track!");
		System.out.println("Good News: There are " + Trampolines + " number of Trampolines on your track!");
		System.out.println(
				"Good News: Each Trampoline can help you advance by D number of Tiles, where D is randomly generated");
		System.out.println("Enter the Player Name");

		String Name = s.nextLine();

		User user = new User(Name);
		users.add(user);

		System.out.println("Starting the game with " + user.getName() + " at Tile-" + user.getCurrent());
		System.out.println("Control transferred to Computer for rolling the Dice for " + user.getName());
		System.out.println("Hit enter to start the game");
		s.nextLine();
		System.out.println("Game Started ======================>");

		while (true) {
			try {
				while (user.getCurrent() == 1) {
					int roll = user.rolldice();
					if (roll == 6) {
						System.out.println("[Roll-" + user.getMoves() + "]:" + user.getName() + " rolled " + roll
								+ " at Tile-" + user.getCurrent() + ". You are out of the cage! You get a free roll");
						user.setMoves(user.getMoves() + 1);
						break;
					} else {
						System.out.println("[Roll-" + user.getMoves() + "]:" + user.getName() + " rolled " + roll
								+ " at Tile-" + user.getCurrent() + ", OOPs you need 6 to start");
						user.setMoves(user.getMoves() + 1);
					}
				}
				int roll = user.rolldice();

				int newpos = user.getCurrent() + roll;

				if (newpos < n) {
					System.out.println("[Roll-" + user.getMoves() + "]:" + user.getName() + " rolled " + roll
							+ " at Tile-" + user.getCurrent() + ", landed on Tile " + newpos + ".");
					user.setMoves(user.getMoves() + 1);
					user.setCurrent(newpos);

					System.out.println("\t  " + "Trying to shake the Tile-" + user.getCurrent());
					mytiles[user.getCurrent()].attack(user.getCurrent(), user, n);

				} else if (newpos == n) {
					System.out.println("[Roll-" + user.getMoves() + "]:" + user.getName() + " rolled " + roll
							+ " at Tile-" + user.getCurrent() + ", landed on Tile " + newpos + ".");
					user.setMoves(user.getMoves() + 1);
					user.setCurrent(newpos);
					mytiles[user.getCurrent()].attack(user.getCurrent(), user, n);

				} else {
					System.out.println("[Roll-" + user.getMoves() + "]:" + user.getName() + " rolled " + roll
							+ " at Tile-" + user.getCurrent() + ", landed on Tile " + user.getCurrent() + ".");
					user.setMoves(user.getMoves() + 1);
					move = false;

				}

			} catch (SnakeBiteException e) {
				System.out.println(e.getMessage());

			} catch (VultureBiteException e) {
				System.out.println(e.getMessage());

			} catch (CricketBiteException e) {
				System.out.println(e.getMessage());

			} catch (TrampolineException e) {
				System.out.println(e.getMessage());

			} catch (GameWinnerException e) {
				System.out.println(e.getMessage());

			}

			if (user.getCurrent() == n) {
				System.out.println();
				System.out.println("\t\tJosh wins the race in " + user.getMoves() + " rolls!\n"
						+ "\t\tTotal Snake Bites = " + user.getSankebites() + "\n" + "\t\tTotal Vulture Bites = "
						+ user.getVulturebites() + "\n" + "\t\tTotal Cricket Bites = " + user.getCricbites() + "\n"
						+ "\t\tTotal Trampolines = " + user.getTramp());
				break;
			} else {
				if (user.getCurrent() == 1) {
					System.out.println("\t  " + user.getName() + " moved to Tile-" + user.getCurrent()
							+ " as it can’t go back further");
				}
				if (move) {
					System.out.println("\t  " + user.getName() + " moved to Tile-" + user.getCurrent());
				}
			}

		}
	}

//	public void print() {
//		for (int i = 0; i < mytiles.length; i++) {
//			System.out.println(i + 1 + " = " + mytiles[i].getClass().getName());
//		}
//	}

	public static int URandom(int length) {
		Random r = new Random();
		int num = r.nextInt(length);
		while (random.containsKey(num)) {
			num = r.nextInt(length);
		}
		random.put(num, true);
		return num;
	}

}

public class Assign5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter total number of tiles on the race track");
		try {
			int n = s.nextInt();
			Game g = new Game(n);
			g.startgame();
		} catch (InputMismatchException e) {
			System.out.println("Wrong input entered");
		}

	}

}