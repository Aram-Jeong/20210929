package doWhileTest;

import java.util.Scanner;

public class FriendMain {
	private Scanner sc = new Scanner(System.in);

	private static FriendMain singleton = new FriendMain();
	private Friend[] friends;

	private FriendMain() {
		friends = new Friend[50];
		friends[0] = new SchoolFriend("최주황", "333-4444", "경북대");
		friends[1] = new CompFriend("박노랑", "555-6666", "예담");

	}

	public static FriendMain getInstance() {
		return singleton;
	}

	private void mainMenu() {
		System.out.println("-------------------------------");
		System.out.println("1.등록 | 2. 조회 | 3.수정 | 4. 종료");
		System.out.println("-------- 메뉴를 선택하세요. --------");

	}

	private void firstMenu() {
		System.out.println(" 1.학교친구 2.회사친구");
		int choice = readInt("메뉴 선택 >>");
		String name = readStr("이름 입력");
		String phone = readStr("연락처 입력 ");
		Friend friend = null;
		if (choice == 1) {
			String school = readStr("학교 입력");
			friend = new SchoolFriend(name, phone, school);

		} else if (choice == 2) {
			String company = readStr("회사 입력");
			friend = new CompFriend(name, phone, company);

		}

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;

			}
		}
		System.out.println("등록 성공");
	}

	private void secondMenu() {
		System.out.println("친구조회 메뉴입니다.");
		String name = readStr("조회할 친구의 이름을 입력하세요. (SKIP: ENTER)");
		String phone = readStr("조회할 연락처를 입력하세요. (SKIP: ENTER)");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				if (!name.equals("") && !phone.equals("")) {
					if (friends[i].getName().indexOf(name) != -1 && friends[i].getPhone().indexOf(phone) != -1) {
						System.out.println(friends[i].toString());
					}
				} else if (!phone.equals("")) {
					if (friends[i].getPhone().indexOf(phone) != -1) {
						System.out.println(friends[i].toString());
					}
				} else if (!name.equals("")) {
					if (friends[i].getName().indexOf(name) != -1) {
						System.out.println(friends[i].toString());
					}
				} else {
					System.out.println(friends[i].toString());

				}
			}
		}
	}

	private void thirdMenu() {
		System.out.println("친구 수정 메뉴입니다.");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null)
				System.out.println("[" + i + "]" + friends[i].toString());
		}
		int num = readInt("수정할 친구를 선택하세요.");
		String phone = readStr("수정할 연락처를 입력하세요.");
		if (!phone.equals(""))
			friends[num].setPhone(phone);
		if (friends[num] instanceof SchoolFriend) {
			String school = readStr("수정할 학교를 입력하세요");
			if (!school.equals(""))
				((SchoolFriend) friends[num]).setSchool(school);
		} else if (friends[num] instanceof CompFriend) {
			String company = readStr("수정할 회사를 입력하세요");
			if (!company.equals(""))
				((CompFriend) friends[num]).setCompany(company);

		}
		System.out.println("수정완료");

	}

	private void endMenu() {
		System.out.println("----- Good Bye -----");

	}

	void doWhileMenu() {
		boolean b = true;
		do {
			mainMenu();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				firstMenu();
				break;
			case 2:
				secondMenu();
				break;
			case 3:
				thirdMenu();
				break;
			case 4:
				endMenu();
				b = false;
				break;
			}
		} while (b);

	}

	public void run() {
		doWhileMenu();
		sc.close();
	}

	public String readStr(String msg) {
		System.out.println(msg);
		return sc.nextLine();
	}

	public int readInt(String msg) {
		System.out.println(msg);
		int result = 0;
		while (true) {
			String val = sc.nextLine();
			try {
				result = Integer.parseInt(val);
				break;

			} catch (Exception e) {
				System.out.println("잘못된 값을 입력했습니다. 다시 입력하세요.");

			}
		}
		return result;
	}

}
