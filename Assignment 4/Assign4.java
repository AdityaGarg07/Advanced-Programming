package ass3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

//Name: Aditya Garg
//Roll no. : 2018124
//Assignment - 4 (used my assignment 3 for this)

class Hero {
	private int resetHP;
	private int hp;
	private int xp;
	private int attack;
	private int defense;
	private int level;
	private String username;
	private int id;
	private int special_power;
	private int location;
	private ArrayList<Integer> path;
	protected int moves;
	protected int supermoves;
	protected boolean isallow;
	protected int used;
	private ArrayList<sidekick> skicks;
	private int side_avl;

	public Hero() {
		this.resetHP = 100;
		this.hp = 100;
		this.xp = 0;
		this.level = 1;
		this.attack = 0;
		this.defense = 0;
		this.username = "";
		this.id = -1;
		path = new ArrayList<>();
		skicks = new ArrayList<>();
		this.moves = 0;
		this.supermoves = 0;
		this.isallow = true;
		this.used = 0;
		this.side_avl = 0;
	}

	public int getSide_avl() {
		return side_avl;
	}

	public void setSide_avl(int side_avl) {
		this.side_avl = side_avl;
	}

	public ArrayList<sidekick> getSkicks() {
		return skicks;
	}

	public sidekick side_return() {
		int val = -1;
		int it = -1;

		for (int i = 0; i < this.skicks.size(); i++) {
			if (skicks.get(i).getXp() > val) {
				val = skicks.get(i).getXp();
				it = i;
			}
		}

		return skicks.get(it);
	}

	public void attackdone(Monster m) {
		;
	}

	public void defensedone(Monster m) {
		;
	}

	public void activeSuper(Monster m) {
		;
	}

	public void resetHero() {

		this.setHp(this.getResetHP());
		this.moves = 0;
		this.supermoves = 0;
		this.isallow = true;
		this.used = 0;
		this.setSpecial_power(0);
//		System.out.println("-----------jjkkl------");
	}

	public void hero_L() {
		;
	}

	public void xp_up(Monster m) {
		this.setXp(this.getXp() + (m.getLevel() * 20));
		System.out.println("Monster Killed");
		System.out.println("XP awarded = " + (m.getLevel() * 20));
	}

	public void hero_w(Monster m) {
//		this.setXp(this.getXp() + (m.getLevel() * 20));
//		System.out.println("Monster Killed");
//		System.out.println("XP awarded = " + (m.getLevel() * 20));

		if (this.getXp() >= 60) {

			this.setAttack(this.getAttack() + (4 - this.getLevel()));
			this.setDefense(this.getDefense() + (4 - this.getLevel()));
			this.setResetHP(250);

			this.setLevel(4);
		} else if (this.getXp() >= 40) {

			this.setAttack(this.getAttack() + (3 - this.getLevel()));
			this.setDefense(this.getDefense() + (3 - this.getLevel()));
			this.setResetHP(200);

			this.setLevel(3);
		} else if (this.getXp() >= 20) {

			this.setAttack(this.getAttack() + (2 - this.getLevel()));
			this.setDefense(this.getDefense() + (2 - this.getLevel()));
			this.setResetHP(150);

			this.setLevel(2);

		}
		this.setHp(this.getResetHP());
	}

	////// Setters && Getters

	public int getResetHP() {
		return resetHP;
	}

	public void setResetHP(int resetHP) {
		this.resetHP = resetHP;
	}

	public ArrayList<Integer> getlist() {
		return this.path;
	}

	public int getSpecial_power() {
		return special_power;
	}

	public void setSpecial_power(int special_power) {
		this.special_power = special_power;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}

class Warrior extends Hero {

	public Warrior(String str, int givenid) {
		this.setAttack(10);
		this.setDefense(3);
		this.setUsername(str);
		this.setId(givenid);
		this.setSpecial_power(0);
		this.setLocation(-1);
	}

	@Override
	public void hero_L() {
		this.setLocation(-1);
		this.setLevel(1);
		this.setXp(0);
		this.setHp(100);
		this.setAttack(10);
		this.setDefense(3);
		this.getlist().clear();
		this.setResetHP(100);
		this.setSide_avl(0);
		this.getSkicks().clear();
		this.setSpecial_power(0);
	}

	@Override
	public void attackdone(Monster m) {
		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Attack and Defense Increased by 5 each");
			m.setHp(m.getHp() - this.getAttack() - 5);

			System.out.println("You attacked and inflicted " + (this.getAttack() + 5) + " damage to the monster.");
			this.moves++;
		} else {
			this.moves++;
			m.setHp(m.getHp() - this.getAttack());
			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void defensedone(Monster m) {

		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Attack and Defense Increased by 5 each");
			this.moves++;
		} else {
			this.moves++;

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void activeSuper(Monster m) {
		System.out.println("Special Power Activated");
		System.out.println("Performing Special Attack");
		System.out.println("Attack and Defense Increased by 5 each");
		this.setSpecial_power(1);
		this.used++;
		this.isallow = false;
	}

}

class Mage extends Hero {

	public Mage(String str, int id) {
		this.setAttack(5);
		this.setDefense(5);
		this.setUsername(str);
		this.setId(id);
		this.setSpecial_power(0);
		this.setLocation(-1);

	}

	@Override
	public void hero_L() {
		this.setLevel(1);
		this.setLocation(-1);
		this.setXp(0);
		this.setHp(100);
		this.setAttack(5);
		this.setDefense(5);
		this.getlist().clear();
		this.setResetHP(100);
		this.setSide_avl(0);
		this.getSkicks().clear();
		this.setSpecial_power(0);

	}

	@Override
	public void attackdone(Monster m) {
		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Opponent Hp reduced by 5%");
			m.setHp(m.getHp() - this.getAttack());
			m.setHp((int) (m.getHp() - 0.05 * m.getHp()));

			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");
			this.moves++;
		} else {
			this.moves++;
			m.setHp(m.getHp() - this.getAttack());
			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void defensedone(Monster m) {

		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Opponent Hp reduced by 5%");
			m.setHp((int) (m.getHp() - 0.05 * m.getHp()));
			this.moves++;
		} else {
			this.moves++;

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void activeSuper(Monster m) {
		System.out.println("Special Power Activated");
		System.out.println("Performing Special Attack");
		System.out.println("Opponent Hp reduced by 5% for next three moves");
		this.setSpecial_power(1);
		this.used++;
		this.isallow = false;
	}

}

class Theif extends Hero {

	public Theif(String str, int id) {
		this.setAttack(6);
		this.setDefense(4);
		this.setUsername(str);
		this.setId(id);
		this.setSpecial_power(0);
		this.setLocation(-1);
		this.getlist().clear();
	}

	@Override
	public void hero_L() {
		this.setLevel(1);
		this.setLocation(-1);
		this.setXp(0);
		this.setHp(100);
		this.setAttack(6);
		this.setDefense(4);
		this.setResetHP(100);
		this.setSide_avl(0);
		this.getSkicks().clear();
		this.setSpecial_power(0);

	}

	@Override
	public void attackdone(Monster m) {
		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Stolen 30% on Monster Hp");
			this.setHp((int) (this.getHp() + 0.3 * m.getHp()));
			m.setHp(m.getHp() - this.getAttack());

			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");
			this.moves++;
		} else {
			this.moves++;
			m.setHp(m.getHp() - this.getAttack());
			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void defensedone(Monster m) {

		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Stolen 30% on Monster Hp");
			this.setHp((int) (this.getHp() + 0.3 * m.getHp()));
			this.moves++;
		} else {
			this.moves++;
		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void activeSuper(Monster m) {
		System.out.println("Special Power Activated");
		System.out.println("Performing Special Attack");
		System.out.println("Steeling 30% of Monster Hp");

		this.setHp((int) (this.getHp() + 0.3 * m.getHp()));
		m.setHp((int) (m.getHp() - 0.3 * m.getHp()));

		this.used++;
	}

}

class Healer extends Hero {

	public Healer(String str, int id) {
		this.setAttack(4);
		this.setDefense(8);
		this.setUsername(str);
		this.setId(id);
		this.setSpecial_power(0);
		this.setLocation(-1);
	}

	@Override
	public void hero_L() {
		this.setLevel(1);
		this.setLocation(-1);
		this.setXp(0);
		this.setHp(100);
		this.setAttack(4);
		this.setDefense(8);
		this.getlist().clear();
		this.setResetHP(100);
		this.setSide_avl(0);
		this.getSkicks().clear();
		this.setSpecial_power(0);

	}

	@Override
	public void attackdone(Monster m) {
		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Incresed own HP by 5% of the total hp");
			this.setHp((int) (this.getHp() + this.getHp() * 0.05));
			m.setHp(m.getHp() - this.getAttack());

			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");
			this.moves++;

		} else {
			this.moves++;
			m.setHp(m.getHp() - this.getAttack());
			System.out.println("You attacked and inflicted " + this.getAttack() + " damage to the monster.");

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void defensedone(Monster m) {

		if (this.getSpecial_power() == 1) {
			this.supermoves++;
			System.out.println("Incresed own HP by 5% of the total hp");
			this.setHp((int) (this.getHp() + this.getHp() * 0.05));
			this.moves++;
		} else {
			this.moves++;

		}

		if (this.supermoves == 3) {
			this.isallow = true;
			this.setSpecial_power(0);
			this.supermoves = 0;
			System.out.println("Superpower Deactivated");
		}

	}

	@Override
	public void activeSuper(Monster m) {
		System.out.println("Special Power Activated");
		System.out.println("Performing Special Attack");
		System.out.println("Incresed own HP by 5% of the total hp for next three moves");
		this.setSpecial_power(1);
		this.used++;
		this.isallow = false;
	}

}

class Monster {
	private int hp;
	private int level;
	private int resetHp;

	public Monster() {
		this.hp = 0;
		this.level = -1;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getResetHp() {
		return resetHp;
	}

	public void setResetHp(int resetHp) {
		this.resetHp = resetHp;
	}

	public void resetMonster() {
		this.hp = this.resetHp;
		this.setHp(this.getResetHp());
	}

	public void makeAttack(Hero h, int jj, int checker) {
		Random r = new Random();
		double att = r.nextGaussian();
//		att = Math.abs(att / 5);
//		int finalx = (int) (att * this.getHp());

		while (att > 1 || att < -1) {
			att = r.nextGaussian();
		}
		int finalx = (int) (att * (this.getHp() / 8) + (this.getHp() / 8));

		if (h instanceof Warrior) {
			if (jj == 2 && h.getSpecial_power() == 1) {

				if (h.getDefense() + 5 - finalx <= 0) {
					h.setHp(h.getHp() - finalx + h.getDefense() + 5);
				} else {
					;
				}

			} else if (jj == 2) {
				if (h.getDefense() - finalx <= 0) {
					h.setHp(h.getHp() - finalx + h.getDefense());
				} else {
					;
				}
			} else if (jj == 3) {
				h.setHp(h.getHp() - finalx);
			} else {
				h.setHp(h.getHp() - finalx);
			}

		} else {
			if (jj == 2) {
				if (h.getDefense() - finalx <= 0) {
					h.setHp(h.getHp() - finalx + h.getDefense());
				} else {
					;
				}

			} else if (jj == 3) {
				h.setHp(h.getHp() - finalx);
			} else {
				h.setHp(h.getHp() - finalx);
			}

		}

		//// Attack on sidekick

		if (checker == 1) {
			sidekick myside2 = h.side_return();

			if (myside2.getSpecial() == 0) {
				myside2.setHp(myside2.getHp() - (int) ((1.5) * finalx));
				if (myside2.getHp() <= 0) {
					myside2.setHp(0);
				}
				System.out.println("sidekick hp: " + myside2.getHp());
			} else if (myside2.getSpecial() == 1) {

				myside2.setHp(myside2.getHp() - (int) ((1.5) * finalx));

				if (myside2.getHp() <= 0) {
					myside2.setHp(0);
				}
				System.out.println("sidekick hp: " + myside2.getHp());

				for (int i = 0; i < myside2.getClones().size(); i++) {
					myside2.getClones().get(i).setHp(myside2.getClones().get(i).getHp() - (int) ((1.5) * finalx));

					if (myside2.getClones().get(i).getHp() <= 0) {
						myside2.getClones().get(i).setHp(0);
					}

					System.out.println("sidekick hp: " + myside2.getClones().get(i).getHp());
				}
			}
		}

	}

}

class Goblins extends Monster {

	public Goblins() {
		this.setHp(100);
		this.setLevel(1);
		this.setResetHp(100);
	}

}

class Zombies extends Monster {

	public Zombies() {
		this.setHp(100);
		this.setLevel(2);
		this.setResetHp(100);
	}

}

class Fiends extends Monster {

	public Fiends() {
		this.setHp(200);
		this.setLevel(3);
		this.setResetHp(200);
	}

}

class Lionfang extends Monster {

	public Lionfang() {
		this.setHp(250);
		this.setLevel(4);
		this.setResetHp(250);
	}

	@Override
	public void makeAttack(Hero h, int jj, int checker) {
//		Random r = new Random();
//		double att = r.nextGaussian();
//		att = Math.abs(att/4);
//		int finalx = (int)(att*this.getHp());
//		h.setHp(h.getHp() - finalx);

		Random r = new Random();
		int ap = r.nextInt(10);

		if (ap == 3) {
			h.setHp((int) (h.getHp() * 0.5));

			if (checker == 1) {
				h.side_return().setHp((int) (h.side_return().getHp() * 0.5));
			}

		} else {
			super.makeAttack(h, jj, checker);
		}

	}
}

class sidekick implements Cloneable {
	private int hp;
	private int xp;
	private int special;
	private int attack;
	private boolean is_used;
	protected ArrayList<sidekick> clones;
	protected int bar;

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getSpecial() {
		return special;
	}

	public void setSpecial(int special) {
		this.special = special;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public sidekick() {
		this.hp = 100;
		this.xp = 0;
		this.special = 0;
		this.attack = 0;
		this.is_used = false;
		clones = new ArrayList<>();
		this.bar = 0;
	}

	public ArrayList<sidekick> getClones() {
		return clones;
	}

	public boolean isIs_used() {
		return is_used;
	}

	public void setIs_used(boolean is_used) {
		this.is_used = is_used;
	}

	public void side_attack(Monster m) {
		m.setHp(m.getHp() - this.attack);
		System.out.println("Sidekick attacked and inflicted " + this.getAttack() + " damage to the monster.");
	}

	public sidekick clone() {
		try {
			sidekick copy = (sidekick) super.clone();
			return copy;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

	public void activeclone(sidekick k) {
		;
	}

	public void resetmaster(Hero h, Monster m) {
		this.setHp(100);
		this.setXp(this.getXp() + (m.getLevel() * 2));

		int nn = (this.getXp() / 5);
		if ((nn - this.bar) > 0) {
			this.setAttack(this.getAttack() + 1);
			this.bar++;
		}
		this.setSpecial(0);
		h.setSide_avl(0);
	}

}

class minion extends sidekick {

	public minion() {
		this.setAttack(1);
	}

	@Override
	public void activeclone(sidekick k) {

		for (int h = 0; h < 3; h++) {
			this.clones.add(k.clone());
		}

	}

	@Override
	public void side_attack(Monster m) {
		if (this.getSpecial() == 0) {
			super.side_attack(m);
			System.out.println("Sidekick hp is " + this.getHp());
		} else if (this.getSpecial() == 1) {
			super.side_attack(m);
			System.out.println("Sidekick hp is " + this.getHp());

			for (int i = 0; i < clones.size(); i++) {
				super.side_attack(m);
				System.out.println("Sidekick hp is " + clones.get(i).getHp());
			}
		}
	}

}

class knight extends sidekick {

	public knight() {
		this.setAttack(2);
	}

}

class Game {

	Scanner s = new Scanner(System.in);
	private ArrayList<Hero> heroes;

	private HashMap<Integer, Monster> map;

	public Monster getMonster(int i) {
		return map.get(i);
	}

	public Game() {
		heroes = new ArrayList<>();
		map = new HashMap<>();

		Random r = new Random();

		for (int i = 0; i < 10; i++) {

			int mon = r.nextInt(3);
			if (mon == 1) {
				map.put(i, new Goblins());
			} else if (mon == 2) {
				map.put(i, new Zombies());
			} else {
				map.put(i, new Fiends());
			}
		}
		map.put(10, new Lionfang());
	}

	public void addhero(Hero h1) {
		heroes.add(h1);
	}

	public boolean istrue(String str) {
		boolean free = false;

//		heroes.contains(o);

		for (int i = 0; i < heroes.size(); i++) {
			if (heroes.get(i).getUsername().equals(str) == true) {
				free = true;
				break;
			}
		}
		return free;
	}

	public Hero gethero(String str) {
		int far = -1;

		for (int i = 0; i < heroes.size(); i++) {
			if (heroes.get(i).getUsername().equals(str) == true) {
				far = i;
				break;
			}
		}

		return heroes.get(far);
	}

	public void side_buy(Hero myhero) {
		System.out.println("Your current xp is " + myhero.getXp());

		System.out.println("If you want to buy a minion, press 1.\n" + "If you want to buy a knight, press 2.");

		int command = s.nextInt();
		System.out.println("XP to spend:");
		int userxp = s.nextInt();

		if (command == 1) {
			if (userxp < 5 || userxp > myhero.getXp()) {
				System.out.println("Invalid xp entered, sidekick shop closed");
				return;
			} else {
				sidekick s1 = new minion();
				int at = ((userxp - 5) * 1);
				// instead of 0.5 i have taken 1 as extra attack.
				s1.setAttack(s1.getAttack() + at);
				myhero.setXp(myhero.getXp() - userxp);
				myhero.getSkicks().add(s1);
				System.out.println("You bought a sidekick: minion\n" + "XP of sidekick is " + s1.getXp() + "\n"
				                   + "Attack of sidekick is " + s1.getAttack() + "\n");
			}
		} else if (command == 2) {
			if (userxp < 8 || userxp > myhero.getXp()) {
				System.out.println("Invalid xp entered, sidekick shop closed");
				return;
			} else {
				sidekick s1 = new knight();
				int at = ((userxp - 8) * 1);
				// instead of 0.5 i have taken 1 as extra attack.
				s1.setAttack(s1.getAttack() + at);
				myhero.setXp(myhero.getXp() - userxp);
				myhero.getSkicks().add(s1);
				System.out.println("You bought a sidekick: knight\n" + "XP of sidekick is " + s1.getXp() + "\n"
				                   + "Attack of sidekick is " + s1.getAttack() + "\n");
			}
		}

	}

}

public class Assign4 {

	public static HashMap<Integer, Boolean> random = new HashMap<>();

//	public static HashSet<Integer> set = new HashSet<>();

	public static int URandom(int length, ArrayList<Integer> aa) {
		Random r = new Random();
		int num = r.nextInt(length);
		while (random.containsKey(num) || aa.contains(num)) {
			num = r.nextInt(length);
		}
		random.put(num, true);
		return num;
	}

	public static void check(Hero myhero, Monster m) {
		if (m.getHp() < 0) {
			m.setHp(0);
		}
		if (myhero.getHp() < 0) {
			myhero.setHp(0);
		}
		if (myhero.getHp() > myhero.getResetHP()) {
			myhero.setHp(myhero.getResetHP());
		}
	}

	public static int full_attack(Hero myhero, Monster mymonster, int win, int var) {
		Scanner s = new Scanner(System.in);

		sidekick myside = null;
		int decision = myhero.getSide_avl();
		int decision2 = myhero.getSide_avl();
		int k_sp = 0;

		if (myhero.getSide_avl() == 1) {
			myside = myhero.side_return();

			if (myside instanceof minion) {
				System.out.println("You have a sidekick Minion with you. Attack of sidekick is" + myside.getAttack());
				if (myside.isIs_used() == false) {
					System.out.println("Press c to use cloning ability. Else press f to move to the fight");
					String dec = s.next();

					if (dec.equals("c")) {
						myside.setSpecial(1);
						myside.activeclone(myside);
						myside.setIs_used(true);
					}

				}
			} else if (myside instanceof knight) {
				System.out.println("You have a sidekick knight with you. Attack of sidekick is" + myside.getAttack());

				if (mymonster instanceof Zombies && mymonster.getLevel() == 2) {
					myhero.setDefense(myhero.getDefense() + 5);
					k_sp = 1;
				}
			}
		}

		while (true) {
			// Hero turn
			//// Error here Above while loop

			if ((myhero.moves / 3) - myhero.used > 0) {
				var = 1;
			}

			if (var == 1 && myhero.isallow == true) {
				System.out.println("Choose move:\n" + "1) Attack\n" + "2) Defense\n" + "3) Special Attack\n");

				int move = s.nextInt();

				if (move == 1) {
					System.out.println("You Choose to Attack");
					myhero.attackdone(mymonster);

					if (myhero.getSide_avl() == 1) {
						myside.side_attack(mymonster);
					}

					check(myhero, mymonster);
					System.out.println(" Your health " + myhero.getHp() + "/" + myhero.getResetHP() + " Monster Health "
					                   + mymonster.getHp() + "/" + mymonster.getResetHp());

				} else if (move == 2) {
					System.out.println("You Choose to defense");
					myhero.defensedone(mymonster);
					check(myhero, mymonster);
					System.out.println(" Your health " + myhero.getHp() + "/" + myhero.getResetHP() + " Monster Health "
					                   + mymonster.getHp() + "/" + mymonster.getResetHp());

				} else if (move == 3) {
					myhero.activeSuper(mymonster);
					var = 0;
					check(myhero, mymonster);
					System.out.println(" Your health " + myhero.getHp() + "/" + myhero.getResetHP() + " Monster Health "
					                   + mymonster.getHp() + "/" + mymonster.getResetHp());
				}

				if (mymonster.getHp() <= 0) {
					win = 1;
					break;
				}

				/// Monster Attack
				System.out.println("Monster attack");
				int init = myhero.getHp();
				mymonster.makeAttack(myhero, move, decision);
				check(myhero, mymonster);
				System.out.println("The monster attacked and inflicted " + (init - myhero.getHp()) + " damage to you.");

				System.out.println(" Your health " + myhero.getHp() + "/" + myhero.getResetHP() + " Monster Health "
				                   + mymonster.getHp() + "/" + mymonster.getResetHp());

				if (myhero.getHp() <= 0) {
					win = 0;
					break;
				}

				if (decision == 1) {
					if (myside.getHp() <= 0) {
						myhero.setSide_avl(0);
						decision = 0;
					}
				}

			} else {

				System.out.println("Choose move:\n" + "1) Attack\n" + "2) Defense\n");

				int move = s.nextInt();

				if (move == 1) {
					System.out.println("You Choose to Attack");
					myhero.attackdone(mymonster);

					if (myhero.getSide_avl() == 1) {
						myside.side_attack(mymonster);
					}

					check(myhero, mymonster);
					System.out.println("Your health " + myhero.getHp() + "/" + myhero.getResetHP() + "Monster Health "
					                   + mymonster.getHp() + "/" + mymonster.getResetHp());

				} else if (move == 2) {
					System.out.println("You Choose to defense");
					myhero.defensedone(mymonster);
					check(myhero, mymonster);
					System.out.println("Your health " + myhero.getHp() + "/" + myhero.getResetHP() + "Monster Health "
					                   + mymonster.getHp() + "/" + mymonster.getResetHp());

				}

				if (mymonster.getHp() <= 0) {
					win = 1;
					break;
				}

				//// Monster Attack

				System.out.println("Monster attack");
				int init = myhero.getHp();
				mymonster.makeAttack(myhero, move, decision);
				check(myhero, mymonster);
				System.out.println("The monster attacked and inflicted " + (init - myhero.getHp()) + " damage to you.");
				System.out.println("Your health " + myhero.getHp() + "/" + myhero.getResetHP() + "Monster Health "
				                   + mymonster.getHp() + "/" + mymonster.getResetHp());

				if (myhero.getHp() <= 0) {
					win = 0;
					break;
				}

				if (decision == 1) {
					if (myside.getHp() <= 0) {
						myhero.setSide_avl(0);
						decision = 0;
					}
				}

			}

		}

		if (k_sp == 1) {
			myhero.setDefense(myhero.getDefense() - 5);
		}

		if (win == 1) {
			if (decision2 == 1) {
				myside.resetmaster(myhero, mymonster);
			}

		}

		return win;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		int key = 1;
		Game g1 = new Game();

		boolean far = false;

		while (far == false) {
			System.out.println("Welcome to ArchLegends\n" + "Choose your option\n" + "1) New User\n"
			                   + "2) Existing User\n" + "3) Exit");

			int initial = s.nextInt();

			if (initial == 1) {
				System.out.println("Enter Username");
				String name = s.next();

				System.out.println("Choose a Hero\n" + "1) Warrior\n" + "2) Thief\n" + "3) Mage\n" + "4) Healer");
				int hero = s.nextInt();

				Hero w1;

				if (hero == 1) {
					w1 = new Warrior(name, key);
				} else if (hero == 2) {
					w1 = new Theif(name, key);
				} else if (hero == 3) {
					w1 = new Mage(name, key);
				} else {
					w1 = new Healer(name, key);
				}

				key++;
				g1.addhero(w1);
				System.out.println("User Creation done. Username: pan. Hero type:" + w1.getClass().getSimpleName()
				                   + ". Log in to play the game . Exiting");
			}

			else if (initial == 2) {
//				set = new HashSet<>();
				int islio = 10;

				System.out.println("Enter Username");
				String namenew = s.next();

				if (g1.istrue(namenew) == true) {
					System.out.println("User Found... logging in");
					System.out.println("Welcome " + namenew);

					Hero myhero;

					if (g1.gethero(namenew) instanceof Warrior) {
						myhero = (Warrior) g1.gethero(namenew);
					} else if (g1.gethero(namenew) instanceof Mage) {
						myhero = (Mage) g1.gethero(namenew);
					} else if (g1.gethero(namenew) instanceof Theif) {
						myhero = (Theif) g1.gethero(namenew);
					} else {
						myhero = (Healer) g1.gethero(namenew);
					}

					boolean game_end = false;

					while (game_end == false) {
						System.out.println("START MENU");
						System.out.println("You are a level " + myhero.getLevel() + " player");

						if (myhero.getlist().size() > 3) {
							islio = 11;
						}

						if (myhero.getlist().size() == 0) {

							int loc1 = URandom(islio, myhero.getlist());
							int loc2 = URandom(islio, myhero.getlist());
							int loc3 = URandom(islio, myhero.getlist());

							random = new HashMap<>();

							if (myhero.getLocation() == -1) {
								System.out.println("You are at the starting location. Choose path:\n"
								                   + "1) Go to Location " + loc1 + "\n" + "2) Go to Location " + loc2 + "\n"
								                   + "3) Go to Location " + loc3 + "\n" + "Enter -1 to exit");

							} else {
								System.out.println("You are at location" + myhero.getLocation() + "Choose path:\n"
								                   + "1) Go to Location " + loc1 + "\n" + "2) Go to Location " + loc2 + "\n"
								                   + "3) Go to Location " + loc3 + "\n" + "Enter -1 to exit");

							}

							int loc = s.nextInt();
							int by = -1;

							if (loc == 1) {
								by = loc1;
							} else if (loc == 2) {
								by = loc2;
							} else if (loc == 3) {
								by = loc3;
							} else {
								break;
							}

							myhero.getlist().add(by);
							myhero.setLocation(by);

							Monster mymonster = g1.getMonster(by);

							System.out.println("Moving to location " + by);
							System.out
							.println("Fight Started. Your fighting a Monster of Level" + mymonster.getLevel());

							int var = 0;
							int win = -1;

							if (myhero.getSkicks().size() > 0) {
//								sidekick myside = myhero.side_return();
								System.out.println("Type yes if you wish to use a sidekick, else type no.");
								String yes_no = s.next();

								if (yes_no.equals("yes")) {
									myhero.setSide_avl(1);
								}

							}

							int newwin = full_attack(myhero, mymonster, win, var);

//							System.out.println(newwin);

							if (newwin == 1) {
								System.out.println("You Win");
								myhero.resetHero();
								mymonster.resetMonster();
								int levelup = myhero.getLevel();
								myhero.xp_up(mymonster);

								System.out.println("\n");
								System.out.println(
								    "If you would you like to buy a sidekick, type yes. Else type no to upgrade level.");

								String soln = s.next();

								if (soln.equals("yes")) {
									g1.side_buy(myhero);
								}

								myhero.hero_w(mymonster);
								if (levelup != myhero.getLevel()) {
									System.out.println("Level up" + myhero.getLevel());
								}
								System.out.println("Proceed to next level");

							} else if (newwin == 0) {
								System.out.println("You loose");
								myhero.resetHero();
								mymonster.resetMonster();
								myhero.hero_L();
								System.out.println("Monster defeated hero, play from start");

							}

						} else if (myhero.getlist().size() > 0) {

							int loc1 = URandom(islio, myhero.getlist());
							int loc2 = URandom(islio, myhero.getlist());
							int loc3 = URandom(islio, myhero.getlist());

							random = new HashMap<>();

							if (myhero.getLocation() == -1) {
								System.out.println(
								    "You are at the starting location. Choose path:\n" + "1) Go to Location " + loc1
								    + "\n" + "2) Go to Location " + loc2 + "\n" + "3) Go to Location "
								    + loc3 + "\n" + "4) Go back" + "\n" + "Enter -1 to exit");

							} else {
								System.out.println("You are at the starting location" + myhero.getLocation()
								                   + "Choose path:\n" + "1) Go to Location " + loc1 + "\n" + "2) Go to Location "
								                   + loc2 + "\n" + "3) Go to Location " + loc3 + "\n" + "4) Go back" + "\n"
								                   + "Enter -1 to exit");

							}

							int loc = s.nextInt();
							int by = -1;

							if (loc == 1) {
								by = loc1;
							} else if (loc == 2) {
								by = loc2;
							} else if (loc == 3) {
								by = loc3;
							} else if (loc == 4) {
								by = myhero.getLocation();
							} else {
								break;
							}

							if (loc != 4) {
								myhero.getlist().add(by);
							}

							myhero.setLocation(by);

							Monster mymonster = g1.getMonster(by);

							System.out.println("Moving to location " + by);
							System.out
							.println("Fight Started. Your fighting a Monster of Level" + mymonster.getLevel());

							int var = 0;
							int win = -1;

							if (myhero.getSkicks().size() > 0) {
//								sidekick myside = myhero.side_return();
								System.out.println("Type yes if you wish to use a sidekick, else type no.");
								String yes_no = s.next();

								if (yes_no.equals("yes")) {
									myhero.setSide_avl(1);
								}

							}

							int newwin = full_attack(myhero, mymonster, win, var);

//							System.out.println(newwin);

							if (newwin == 1) {
								System.out.println("You Win");
								int levelup = myhero.getLevel();
								myhero.xp_up(mymonster);

								System.out.println("\n");
								System.out.println(
								    "If you would you like to buy a sidekick, type yes. Else type no to upgrade level.");

								String soln = s.next();

								if (soln.equals("yes")) {
									g1.side_buy(myhero);
								}

								myhero.hero_w(mymonster);
								myhero.resetHero();
								mymonster.resetMonster();
								if (levelup != myhero.getLevel()) {
									System.out.println("Level up " + myhero.getLevel());
								}
								System.out.println("Proceed to next level");

							} else if (newwin == 0) {
								System.out.println("You loose");
								myhero.resetHero();
								mymonster.resetMonster();
								myhero.hero_L();
								System.out.println("Monster defeated hero, play from start");

							}

							if (loc == 10 && newwin == 1) {
								System.out.println("Congratulations you won this tough Game");
								game_end = true;
							}
						}
					}
				}

				else {
					System.out.println("No Such User");
//					far = true;
				}

			} else if (initial == 3) {
				far = true;
			}

		}

	}
}
