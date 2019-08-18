package ass2;

import java.util.ArrayList;
import java.util.Scanner;

class Mercury implements mymenu {

	private double account;
	private ArrayList<String> categ;
	private ArrayList<Customer> customer;
	private ArrayList<Merchant> merchant;
	private ArrayList<item> allitems;
	private String address;

	public Mercury() {
		this.categ = new ArrayList<>();
		this.customer = new ArrayList<>();
		this.merchant = new ArrayList<>();
		this.allitems = new ArrayList<>();
		this.account = 0.0;
		this.address = "Mercury address is street 34, paschim vihar,delhi";
	}
	
	@Override
	public String getadd() {
		return this.address;
	}

	public ArrayList<Merchant> getMer() {
		return this.merchant;
	}

	public ArrayList<Customer> getcust() {
		return this.customer;
	}

	public ArrayList<String> getcat() {
		return this.categ;
	}

	public ArrayList<item> getfull() {
		return this.allitems;
	}

	public Merchant getm(int vv) {
		return merchant.get(vv);
	}

	public Customer getcus(int cc) {
		return customer.get(cc);
	}

	@Override
	public void mymenu() {
		System.out.println("Welcome to Mercury");
		System.out.println("1) Enter as Merchant");
		System.out.println("2) Enter as Customer");
		System.out.println("3) See user details");
		System.out.println("4) Company account balance");
		System.out.println("5) Exit");
	}

	public void mer_dis() {
		for (int i = 0; i < merchant.size(); i++) {
			System.out.println((i + 1) + " " + merchant.get(i).getname());
		}
	}

	public void cust_dis() {
		for (int i = 0; i < customer.size(); i++) {
			System.out.println((i + 1) + " " + customer.get(i).getnamec());
		}
	}

	public void cat_dis() {
		for (int i = 0; i < categ.size(); i++) {
			System.out.println((i + 1) + " " + categ.get(i));
		}
	}

	public void update(double val) {
		this.account += val;
	}

	public double getaccount() {
		return this.account;
	}

	public void category_up(String nn) {
		boolean bar = false;
		for (int i = 0; i < categ.size(); i++) {
			if (categ.get(i).equals(nn)) {
				bar = true;
			}
		}
		if (bar == false) {
			this.categ.add(nn);
		}
	}

	public void allitems_up(item aa) {
		this.allitems.add(aa);
	}

	public item masterget(int valx) {
		int ff = -1;

		for (int l = 0; l < this.allitems.size(); l++) {
			if (allitems.get(l).getid() == valx) {
				ff = l;
			}
		}

		return allitems.get(ff);
	}

}

class Node {
	item myitem;
	int quant;

	public Node(item myitem, int quant) {
		this.myitem = myitem;
		this.quant = quant;
	}

}

interface mymenu {
	void mymenu();
	String getadd();
}

class Merchant implements mymenu {
	private String namem;
	private int maxitem;
	private ArrayList<item> myitems;
	private double contribution;
	private int idm;
	private int freeturn;
	private String address;

	public Merchant(String namem, int idm,String ghar) {
		this.maxitem = 10;
		myitems = new ArrayList<>();
		this.contribution = 0;
		this.namem = namem;
		this.idm = idm;
		this.freeturn = 0;
		this.address = ghar;
	}
	
	public String getadd() {
		return this.address;
	}
	
	

	public boolean getfinal() {
		if (myitems.size() < (this.maxitem + this.freeturn)) {
			return true;
		}
		return false;
	}

	public int getidm() {
		return this.idm;
	}

	public void setcontri(double d) {
		this.contribution = this.contribution + d;
	}

	public double getcontri() {
		return this.contribution;
	}

	public ArrayList<item> getxx() {
		return this.myitems;
	}

	public void allproduct() {
		for (int i = 0; i < myitems.size(); i++) {
			myitems.get(i).details();
		}
	}

	public void adder(item a1) {
		myitems.add(a1);
	}

	public item particular(int code) {
		int free = -1;

		for (int i = 0; i < myitems.size(); i++) {
			if (this.myitems.get(i).getid() == code) {
				free = i;
			}
		}

		return this.myitems.get(free);
	}

	public String getname() {
		return this.namem;
	}

	@Override
	public void mymenu() {
		System.out.println("Merchant Menu\n" + "1) Add item\n" + "2) Edit item\n" + "3) Search by category\n"
				+ "4) Add offer\n" + "5) Rewards won\n" + "6) Exit");
	}

	public void reward() {
		System.out.println("Turns added " + this.freeturn);
		System.out.println("Total reward " + this.contribution);

	}

	public void rewared() {
		double tt = this.contribution / 100;

		this.freeturn = (int) tt;
	}
}

class Customer implements mymenu {
	private int purchase;
	private int totalp;
	private String namec;
	private int money;
	private ArrayList<item> cart;
	private ArrayList<Integer> cartquantity;
	private ArrayList<Node> buy;
	private int rewardmoney;
	private int tt; // total reward
	private int idcc;
	private String address;

	public Customer(String namec, int idcc,String ghar) {
		this.namec = namec;
		this.idcc = idcc;
		this.purchase = 0;
		this.money = 100;
		this.rewardmoney = 0;
		this.totalp = 0;
		cart = new ArrayList<>();
		buy = new ArrayList<>();
		cartquantity = new ArrayList<>();
		this.tt = 0;
		this.address = ghar;
	}

	public int getidcc() {
		return this.idcc;
	}
	
	public String getadd() {
		return this.address;
	}

	public void addquantity(int q) {
		this.cartquantity.add(q);
	}

	public void setpurchase() {
//		System.out.println("999999999999999999");
		this.totalp++;
		this.purchase += 1;
		if ((this.purchase / 5) == 1) {
			this.rewardmoney = this.rewardmoney + (10);
			this.tt = this.tt + (10);
			this.purchase = 0;

		}
	}

	public int returntt() {
		return this.tt;
	}

	public String getnamec() {
		return this.namec;
	}

	public void add_buy(item a2, int quantx) {
		buy.add(new Node(a2, quantx));
	}

	public void addcart(item a3) {
		cart.add(a3);
	}

	@Override
	public void mymenu() {
		System.out.println("Customer Menu\n" + "1) Search item\n" + "2) checkout cart\n" + "3) Reward won\n"
				+ "4) print latest orders\n" + "5) Exit");
	}

	public int getM() {
		return this.money;
	}

	public void updateM(int mon) {
		if (this.money >= mon) {
			this.money -= mon;
		} else if (this.money + this.rewardmoney >= mon) {
			this.rewardmoney = this.rewardmoney + this.money - mon;
			this.money = 0;
		}

	}

	public boolean check(double d) {
		if (this.money >= d) {
			return true;
		} else if (this.money + this.rewardmoney >= d) {
			return true;
		} else {
			return false;
		}
	}

	public ArrayList<item> ret() {
		return this.cart;
	}

	public ArrayList<Integer> ret2() {
		return this.cartquantity;
	}

	public ArrayList<Node> rettter() {
		return this.buy;
	}
}

class item {
	private String name;
	private int price;
	private int quantity;
	private String category;
	private int offer;
	private int id;
	private int mymer;

	public item(String name, int price, int quantity, String category, int id, int mymer) {
		this.category = category;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.offer = 0;
		this.id = id;
		this.mymer = mymer;

	}

	public int getmymer() {
		return this.mymer;
	}

	public int getprice() {
		return this.price;
	}

	public void chnquantity(int val) {

		this.quantity -= val;
	}

	public boolean alsocheck(int val) {
		int val_ = this.quantity - val;
		if (val_ < 0) {
			return false;
		} else {
			return true;
		}
	}

	public int getid() {
		return this.id;
	}

	public String getname() {
		return this.name;
	}

	public String getcategory() {
		return this.category;
	}

	public void details() {
		String aa = "";
		if (this.offer == 0) {
			aa = "None";
		} else if (this.offer == 2) {
			aa = "25%";
		} else if (this.offer == 1) {
			aa = "buy one get one";
		}
		System.out.println(
				this.id + " " + this.name + " " + this.price + " " + this.quantity + " " + aa + " " + this.category);
	}

	public void setoffer(int val) {
		this.offer = val;

	}

	public void edit(int newprice, int newquantity) {
		this.price = newprice;
		this.quantity = newquantity;
	}

	public int getquantity() {
		return this.quantity;
	}

	public int getoffer() {
		return this.offer;
	}

}

public class Assign2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);

		Mercury shop = new Mercury();
		shop.getMer().add(new Merchant("jack", 1,"jack lives at 34 becker street"));
		shop.getMer().add(new Merchant("john", 2,"john lives at 35 becker street"));
		shop.getMer().add(new Merchant("james", 3,"james lives at 36 becker street"));
		shop.getMer().add(new Merchant("jeff", 4,"jeff lives at 37 becker street"));
		shop.getMer().add(new Merchant("joseph", 5,"joseph lives at 38 becker street"));

		shop.getcust().add(new Customer("ali", 1,"ali lives at 24 prashant street"));
		shop.getcust().add(new Customer("nobby", 2,"nobby lives at 25 prashant street"));
		shop.getcust().add(new Customer("bruno", 3,"bruno lives at 26 prashant street"));
		shop.getcust().add(new Customer("borat", 4,"borat lives at 27 prashant street"));
		shop.getcust().add(new Customer("aladeen", 5,"aladeen lives at 28 prashant street"));
		
		ArrayList<String> extra = new ArrayList<>();
		extra.add("jack");
		extra.add("john");
		extra.add("james");
		extra.add("jeff");
		extra.add("joseph");

		boolean var = false;
		int far = 1;
		while (var == false) {
			shop.mymenu();
			int n = s.nextInt();

			if (n == 1) {
				System.out.println("choose merchant");
				shop.mer_dis();
				int mer = s.nextInt() - 1;
				boolean key = false;
				while (key == false) {
					System.out.println("Welcome " + shop.getm(mer).getname());
					shop.getm(mer).mymenu();

					int option = s.nextInt();
					shop.getm(mer).rewared();
					if (option == 1) {
						System.out.println("item name");
						String name = s.next();

						System.out.println("item price");
						int price = s.nextInt();

						System.out.println("item quantity");
						int quantity = s.nextInt();

						System.out.println("item category");
						String category = s.next();

						if (shop.getm(mer).getfinal() == true) {
							item free = new item(name, price, quantity, category, far, mer);
							far++;

							shop.getm(mer).adder(free);
							shop.category_up(category);
							shop.allitems_up(free);
							free.details();
						} else {
							System.out.println("max limit reached");
						}

					} else if (option == 2) {
						System.out.println("choose item by code");
						shop.getm(mer).allproduct();

						int code = s.nextInt();
//						int freeval = shop.getm(mer).particular(code);
						item now = shop.getm(mer).particular(code);

						System.out.println("Enter edit details");
						System.out.println("item price");
						int newprice = s.nextInt();

						System.out.println("item quantity");
						int newquantity = s.nextInt();

						now.edit(newprice, newquantity);
						now.details();

					} else if (option == 3) {
						System.out.println("Choose a category");
						shop.cat_dis();
						int type = s.nextInt();
						String nn = shop.getcat().get(type - 1);
//						System.out.println(nn);
//						System.out.println(shop.getfull());
						for (int k = 0; k < shop.getfull().size(); k++) {
							if (shop.getfull().get(k).getcategory().equals(nn)) {
//								System.out.println("----");
								shop.getfull().get(k).details();
							}
						}

					} else if (option == 4) {
						System.out.println("choose item by code");
						shop.getm(mer).allproduct();
						int kk = s.nextInt();

						System.out.println("choose offer\n" + "1) buy one get one\n" + "2) 25% off");
						int chn = s.nextInt();

						item change = shop.getm(mer).particular(kk);
						change.setoffer(chn);
						change.details();
					}

					else if (option == 5) {
						shop.getm(mer).reward();
					} else if (option == 6) {

						key = true;
					}

				}
			}

			if (n == 2) {
				System.out.println("choose Customer");
				shop.cust_dis();
				int cust = s.nextInt() - 1;
				boolean key2 = false;
				while (key2 == false) {
					System.out.println("Welcome " + shop.getcus(cust).getnamec());
					shop.getcus(cust).mymenu();
					int current = s.nextInt();

					if (current == 1) {
						System.out.println("Choose a category");
						shop.cat_dis();
						int type = s.nextInt();
						String nn = shop.getcat().get(type - 1);
						System.out.println("choose item by code");

						for (int k = 0; k < shop.getfull().size(); k++) {
							if (shop.getfull().get(k).getcategory().equals(nn)) {
								System.out.println("----");
								shop.getfull().get(k).details();
							}
						}

						System.out.println("Enter item code");
						int mark = s.nextInt();
						System.out.println("Enter item quantity");
						int quan = s.nextInt();

						item present = shop.masterget(mark);
//						present.chnquantity(quan);
						if (present.getquantity() - quan < 0) {
							System.out.println("Error: not enough items");
						} else {
							System.out.println("Choose method of transaction\n" + "1) Buy item\n"
									+ "2) Add item to cart\n" + "3) Exit");

							int work = s.nextInt();
							if (work == 1) {

								if (present.getoffer() == 0) {
									if (shop.getcus(cust).check(present.getprice() * quan) == true
											&& present.alsocheck(quan)) {
										shop.getcus(cust).updateM(present.getprice() * quan);
										present.chnquantity(quan);
										shop.getcus(cust).add_buy(present, quan);
										shop.getcus(cust).setpurchase();
										System.out.println("Items Succesfully bought");
										double incr = 0.01 * (present.getprice() * quan);
										shop.update(incr);
										shop.getm(present.getmymer()).setcontri(incr);
									} else {
										System.out.println("Error with order");
									}

								}

								else if (present.getoffer() == 1) {
									// one + one
									if (shop.getcus(cust).check((present.getprice() * quan)) == true
											&& present.alsocheck(quan * 2)) {
										shop.getcus(cust).updateM(present.getprice() * quan);
										present.chnquantity(quan * 2);
										shop.getcus(cust).add_buy(present, quan);
										shop.getcus(cust).setpurchase();
										System.out.println("Items Succesfully bought");
										shop.update(0.01 * (present.getprice() * quan));
										shop.getm(present.getmymer()).setcontri(0.01 * (present.getprice() * quan));
									} else {
										System.out.println("Error with order");
									}

								}

								else if (present.getoffer() == 2) {
									// 25%
									if (shop.getcus(cust).check((present.getprice() * quan) * (0.75)) == true
											&& present.alsocheck(quan)) {
										shop.getcus(cust).updateM((int) ((present.getprice() * quan) * (0.75)));
										present.chnquantity(quan);
										shop.getcus(cust).add_buy(present, quan);
										shop.getcus(cust).setpurchase();
										System.out.println("Items Succesfully bought");
										shop.update(0.01 * ((present.getprice() * quan) * (0.75)));
										shop.getm(present.getmymer())
												.setcontri(0.01 * ((present.getprice() * quan) * (0.75)));
									} else {
										System.out.println("Error with order");
									}

								}
							} else if (work == 2) {
								shop.getcus(cust).addcart(present);
								shop.getcus(cust).addquantity(quan);
							} else if (work == 3) {
								;
							}
						}

					} else if (current == 2) {
						ArrayList<item> demo = shop.getcus(cust).ret();
						ArrayList<Integer> quan_demo = shop.getcus(cust).ret2();
						for (int p = 0; p < demo.size(); p++) {
							System.out.println("oooooooooo");
							item present = demo.get(p);
							int quan = quan_demo.get(p);

							if (present.getoffer() == 0) {
								if (shop.getcus(cust).check(present.getprice() * quan) == true
										&& present.alsocheck(quan)) {
									System.out.println("---------");
									shop.getcus(cust).updateM(present.getprice() * quan);
									present.chnquantity(quan);
									shop.getcus(cust).add_buy(present, quan);
									shop.getcus(cust).setpurchase();
									System.out.println("Items Succesfully bought");
									double incr = 0.01 * (present.getprice() * quan);
									shop.update(incr);
									shop.getm(present.getmymer()).setcontri(incr);
								} else {
									System.out.println("Error with order");
									break;
								}

							}

							else if (present.getoffer() == 1) {
								// one + one
								if (shop.getcus(cust).check((present.getprice() * quan)) == true
										&& present.alsocheck(quan * 2)) {
									shop.getcus(cust).updateM(present.getprice() * quan);
									present.chnquantity(quan * 2);
									shop.getcus(cust).add_buy(present, quan);
									shop.getcus(cust).setpurchase();
									System.out.println("Items Succesfully bought");
									shop.update(0.01 * (present.getprice() * quan));
									shop.getm(present.getmymer()).setcontri(0.01 * (present.getprice() * quan));
								} else {
									System.out.println("Error with order");
									break;
								}

							}

							else if (present.getoffer() == 2) {
								// 25%
								if (shop.getcus(cust).check((present.getprice() * quan) * (0.75)) == true
										&& present.alsocheck(quan)) {
									shop.getcus(cust).updateM((int) ((present.getprice() * quan) * (0.75)));
									present.chnquantity(quan);
									shop.getcus(cust).add_buy(present, quan);
									shop.getcus(cust).setpurchase();
									System.out.println("Items Succesfully bought");
									shop.update(0.01 * ((present.getprice() * quan) * (0.75)));
									shop.getm(present.getmymer())
											.setcontri(0.01 * ((present.getprice() * quan) * (0.75)));
								} else {
									System.out.println("Error with order");
									break;
								}

							}

						}

					} else if (current == 3) {
						System.out.println(shop.getcus(cust).returntt());
					} else if (current == 4) {
						System.out.println("Items bought are as:");

						ArrayList<Node> demo2 = shop.getcus(cust).rettter();

						for (int ll = 0; ll < demo2.size(); ll++) {
							if (ll > 10) {
								break;
							}
							if (demo2.get(ll).myitem.getoffer() == 0) {
								System.out.println(demo2.get(ll).quant + " for Rs "
										+ demo2.get(ll).myitem.getprice() * demo2.get(ll).quant + " from Merchant "
										+ extra.get(demo2.get(ll).myitem.getmymer()));
							}
							else if(demo2.get(ll).myitem.getoffer() == 1) {
								System.out.println((demo2.get(ll).quant)*2 + " for Rs "
										+ demo2.get(ll).myitem.getprice() * demo2.get(ll).quant + " from Merchant "
										+ extra.get(demo2.get(ll).myitem.getmymer()));
							}
							else {
								System.out.println(demo2.get(ll).quant + " for Rs "
										+ (demo2.get(ll).myitem.getprice() * demo2.get(ll).quant)*(0.75) + " from Merchant "
										+ extra.get(demo2.get(ll).myitem.getmymer()));
							}

						}
					} else if (current == 5) {
						key2 = true;
					}

				}

			}

			else if (n == 3) {
				String type = s.next();
				int val = s.nextInt();
				int frre = -1;

				if (type.equals("M")) {
					for (int itr = 0; itr < shop.getMer().size(); itr++) {
						if (shop.getMer().get(itr).getidm() == val) {
							frre = itr;
						}
					}
					System.out.println("Name " + shop.getMer().get(frre).getname());
					System.out.println("Address " + shop.getMer().get(frre).getadd());
					System.out.println("Contribution " + shop.getMer().get(frre).getcontri());

				} else if (type.equals("C")) {
					for (int itr2 = 0; itr2 < shop.getcust().size(); itr2++) {
						if (shop.getcust().get(itr2).getidcc() == val) {
							frre = itr2;
						}
					}
					System.out.println("Name " + shop.getcust().get(frre).getnamec());
					System.out.println("Address " + shop.getcust().get(frre).getadd());
					System.out.println("Contribution " + shop.getcust().get(frre).returntt());
				}

			} else if (n == 4) {
				double gg = shop.getaccount();
				System.out.println("Balance " + gg);
			} else if (n == 5) {
				var = true;
			}
		}

	}

}
