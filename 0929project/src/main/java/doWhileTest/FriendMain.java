package doWhileTest;

import java.util.Scanner;

public class FriendMain {
	private Scanner sc = new Scanner(System.in);

	private static FriendMain singleton = new FriendMain();
	private Friend[] friends;

	private FriendMain() {
		friends = new Friend[50];
		friends[0] = new SchoolFriend("����Ȳ", "333-4444", "��ϴ�");
		friends[1] = new CompFriend("�ڳ��", "555-6666", "����");

	}

	public static FriendMain getInstance() {
		return singleton;
	}

	private void mainMenu() {
		System.out.println("-------------------------------");
		System.out.println("1.��� | 2. ��ȸ | 3.���� | 4. ����");
		System.out.println("-------- �޴��� �����ϼ���. --------");

	}

	private void firstMenu() {
		System.out.println(" 1.�б�ģ�� 2.ȸ��ģ��");
		int choice = readInt("�޴� ���� >>");
		String name = readStr("�̸� �Է�");
		String phone = readStr("����ó �Է� ");
		Friend friend = null;
		if (choice == 1) {
			String school = readStr("�б� �Է�");
			friend = new SchoolFriend(name, phone, school);

		} else if (choice == 2) {
			String company = readStr("ȸ�� �Է�");
			friend = new CompFriend(name, phone, company);

		}

		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;

			}
		}
		System.out.println("��� ����");
	}

	private void secondMenu() {
		System.out.println("ģ����ȸ �޴��Դϴ�.");
		String name = readStr("��ȸ�� ģ���� �̸��� �Է��ϼ���. (SKIP: ENTER)");
		String phone = readStr("��ȸ�� ����ó�� �Է��ϼ���. (SKIP: ENTER)");
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
		System.out.println("ģ�� ���� �޴��Դϴ�.");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null)
				System.out.println("[" + i + "]" + friends[i].toString());
		}
		int num = readInt("������ ģ���� �����ϼ���.");
		String phone = readStr("������ ����ó�� �Է��ϼ���.");
		if (!phone.equals(""))
			friends[num].setPhone(phone);
		if (friends[num] instanceof SchoolFriend) {
			String school = readStr("������ �б��� �Է��ϼ���");
			if (!school.equals(""))
				((SchoolFriend) friends[num]).setSchool(school);
		} else if (friends[num] instanceof CompFriend) {
			String company = readStr("������ ȸ�縦 �Է��ϼ���");
			if (!company.equals(""))
				((CompFriend) friends[num]).setCompany(company);

		}
		System.out.println("�����Ϸ�");

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
				System.out.println("�߸��� ���� �Է��߽��ϴ�. �ٽ� �Է��ϼ���.");

			}
		}
		return result;
	}

}
