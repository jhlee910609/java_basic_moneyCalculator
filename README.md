### First Access
- 아래와 같은 원초적인 코드를 짬
- 초기 코드에서 공통적인 부분, 반복적인 부분을 매개변수(parameter)로 치환하려는 노력을 함

```
public class CalCount {

	public void calcChange() {
    
		int money = 10000; int price = 2750;
		int change = money - price;
		System.out.println("change = " + change + " won");
		
        // 5000 won
		int c5000 = change/5000;
		System.out.println("5000 won = " + c5000);
		
        // 1000 won
		int c1000 = (change - c5000*5000)/1000;
		System.out.println("1000 won = " + c1000);
		
        // 500 won
		int c500 = (change - (c5000*5000 + c1000*1000))/500;
		System.out.println("500 won = " + c500);
		
        // 100 won
		int c100 = (change - (c5000*5000 + c1000*1000 + c500*500))/100;
		System.out.println("100 won = " + c100);
		
        // 50 won
		int c50 = (change - (c5000*5000 + c1000*1000 + c500*500 + c100*100))/50;
		System.out.println("50 won = " + c50);
		
        // 10 won
		int c10 = (change - (c5000*5000 + c1000*1000 + c500*500 + c100*100 + 			c50*50))/10;
		System.out.println("10 won = " + c110);		
		
	}
```

### Second Access
- 공통적인 부분 : 'change = change - (직전 금액 매수*직전 금액);' 수식 찾아냄

```
public void calcount2(int money, int price) {

		int change = money - price;
		System.out.println("change = " + change + " won");

		// 5000 won
		int c5000 = change / 5000;
		change = change - (c5000*5000);
		System.out.println("5000 won = " + c5000);
		
		// 1000 won
		int c1000 = change / 1000;
		change = change -(c1000*1000);
		System.out.println("1000 won = " + c1000);
		
		// 500 won
		int c500 = change / 500;
		change = change - (c500*500);
		System.out.println("500 won = " + c500);
		
		// 100 won
		int c100 = change / 100;
		change = change - (c100*100);
		System.out.println("100 won = " + c100);
		
		// 50 won
		int c50 = change / 50;
		change = change - (c50*50);
		System.out.println("50 won = " + c50);
		
		// 10 won
		int c10 = change / 10;
		change = change - (c10*10);
		System.out.println("10 won = " + c10);
		

	}

```

### Third Access
- 각 금액별 공통적인 부분 추출해냄
- 메소드화 돌입 (eachPrice();)

```
public void calcount2(int money, int price) {

		int change = money - price;
		System.out.println("change = " + change + " won");

		// shorten code used by method, eachPrice();
		change = eachPrice(change, 5000);
		change = eachPrice(change, 1000);
		change = eachPrice(change, 500);
		change = eachPrice(change, 100);
		change = eachPrice(change, 50);
		change = eachPrice(change, 10);
	}
	
    // using this method for shortening upper method.
    public int eachPrice (int change, int unit) {
		int count = change / unit;
		change = change - (unit*count);
		System.out.println(unit + " won = " + count);
		return change;
	}
```
### Fourth Access

* eachPrice(int chage, int unit) { } - 메소드 생성
* change = eachPrice(change, unit) - 메소드 for문 사용하여 자동 반복

		public void calcount2(int money, int price) {

			int change = money - price;
			System.out.println("change = " + change + " won");

			*// shorten code used by method, eachPrice();*
			change = eachPrice(change, 5000);
			change = eachPrice(change, 1000);
			change = eachPrice(change, 500);
			change = eachPrice(change, 100);
			change = eachPrice(change, 50);
			change = eachPrice(change, 10);
		} 
* 완성된 소스 코드 전문
* 'change = eachPrice(int change, int unit);' * 6개 > 배열 + for문 사용하여 코드 간단하게 만듬


		public void calCount3 (int money, int price) {
			int change = money - price;
			System.out.println("change = " + change + " won");
	
			// shorten code used by method, eachPrice();
			// using advanced For();
			int units[] = {5000, 1000, 500, 100, 50, 10};
			for (int unit : units) {
				change = eachPrice(change, unit);
			}
		}
	
		public int eachPrice (int change, int unit) {
	
			int count = change / unit;
			change = change - (unit*count);
			System.out.println(unit + " won = " + count);
			return change;
		}



		
		

# moneyCalculator
