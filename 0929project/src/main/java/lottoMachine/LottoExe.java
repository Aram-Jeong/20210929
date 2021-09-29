package lottoMachine;

import java.util.Scanner;
import java.util.Arrays;

public class LottoExe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean run = true;
		while (run) {
			System.out.println("* * * * * 로또 자동 구매 * * * * * ");
			System.out.println("금액을 입력하세요. (장당 1,000원)");
			int price = sc.nextInt();
			int[] lotto = new int[6]; // 6개의 정수를 담는 배열 선언
			for (int j = 0; j < price / 1000; j++) {
				System.out.println("\n" + (j + 1) + "번---------------");

				for (int i = 0; i < lotto.length; i++) {

					int num = (int) (Math.random() * 45) + 1; // 난수
					lotto[i] = num;

					for (int k = 0; k < i; k++) {
						if (lotto[i] == lotto[k]) {
							i--; // 중복제거
							break;
						}

					}
				}

				Arrays.sort(lotto); // 오름차순
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

