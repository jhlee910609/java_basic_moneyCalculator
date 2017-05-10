package FirstExam;

public class CalCount {

	public void calcChange(int money, int price) {

		int change = money - price;
		System.out.println("change = " + change + " won");

		int c5000 = change / 5000;
		System.out.println("5000 won = " + c5000);

		int c1000 = (change - c5000 * 5000) / 1000;
		System.out.println("1000 won = " + c1000);

		int c500 = (change - (c5000 * 5000 + c1000 * 1000)) / 500;
		System.out.println("500 won = " + c500);

		int c100 = (change - (c5000 * 5000 + c1000 * 1000 + c500 * 500)) / 100;
		System.out.println("100 won = " + c100);

		int c50 = (change - (c5000 * 5000 + c1000 * 1000 + c500 * 500 + c100 * 100)) / 50;
		System.out.println("50 won = " + c50);

		int c10 = (change - (c5000 * 5000 + c1000 * 1000 + c500 * 500 + c100 * 100 + c50 * 50)) / 10;
		System.out.println("10 won = " + c100);

	}

	public void calCount2(int money, int price) {
		int change = money - price;
		System.out.println("change = " + change + " won");

		// shorten code used by method, eachPrice();
		change = eachPrice(change, 5000);
		change = eachPrice(change, 1000);
		change = eachPrice(change, 500);
		change = eachPrice(change, 100);
		change = eachPrice(change, 50);
		change = eachPrice(change, 10);
		/*
		 * // 5000 won int c5000 = change / 5000; change = change -
		 * (c5000*5000); System.out.println("5000 won = " + c5000);
		 * 
		 * // 1000 won int c1000 = change / 1000; change = change -(c1000*1000);
		 * System.out.println("1000 won = " + c1000);
		 * 
		 * // 500 won int c500 = change / 500; change = change - (c500*500);
		 * System.out.println("500 won = " + c500);
		 * 
		 * // 100 won int c100 = change / 100; change = change - (c100*100);
		 * System.out.println("100 won = " + c100);
		 * 
		 * // 50 won int c50 = change / 50; change = change - (c50*50);
		 * System.out.println("50 won = " + c50);
		 * 
		 * // 10 won int c10 = change / 10; change = change - (c10*10);
		 * System.out.println("10 won = " + c10);
		 * 
		 */
	}

	public void calCount3(int money, int price) {
		int change = money - price;
		System.out.println("change = " + change + " won");

		// shorten code used by method, eachPrice();
		// using advanced For();
		int units[] = { 5000, 1000, 500, 100, 50, 10 };
		for (int unit : units) {
			change = eachPrice(change, unit);
		}
	}
	//각 화폐 별, 거스름돈 개수 산출하는 메소드 
	public int eachPrice(int change, int unit) {
		int count = change / unit;
		change = change - (unit * count);
		System.out.println(unit + " won = " + count);
		return change;
	}

}
