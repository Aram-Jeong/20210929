package lottoMachine;

import java.util.Scanner;
import java.util.Arrays;

public class LottoExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		while (run) {
			System.out.println("* * * * * �ζ� �ڵ� ���� * * * * * ");
			System.out.println("�ݾ��� �Է��ϼ���. (��� 1,000��)");
			int price = sc.nextInt();
			int[] lotto = new int[6]; // 6���� ������ ��� �迭 ����
			for (int j = 0; j < price / 1000; j++) {
				System.out.println("\n" + (j + 1) + "��---------------");

				for (int i = 0; i < lotto.length; i++) {

					int num = (int) (Math.random() * 45) + 1; // ����
					lotto[i] = num;

					for (int k = 0; k < i; k++) {
						if (lotto[i] == lotto[k]) {
							i--; // �ߺ�����
							break;
						}

					}
				}

				Arrays.sort(lotto); // ��������
				for (int l = 0; l < lotto.length; l++) {
					System.out.print(lotto[l] + " ");

				}
				if ((j + 1) % 5 == 0) {
					System.out.println("\n");
					System.out.println("\n==================");
					System.out.println("\n");
				}

			} 
				
			}
		}

	}

