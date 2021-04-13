package algo;

import java.util.Scanner;

public class clock {
	private static final int CNT_CLOCK = 16, CNT_BUTTON = 10, MIN = 9999;
// int[버튼][시계] (1= 해당 버튼이 시계를 )
	private static int[][] button_clock = { { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 },
			{ 1, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0 },
			{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 },
			{ 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int loop = sc.nextInt();
		int[] clockArray = new int[CNT_CLOCK];
		int[] result = new int[loop];
		int tmp;

		while (loop-- > 0) {
			for (int i = 0; i < CNT_CLOCK; i++) {
				clockArray[i] = sc.nextInt();
			}
			tmp = solve(clockArray, 0);
// 크게 나온 값은 불가능하다 판단하고 -1을 반환
			result[loop] = tmp >= MIN ? -1 : tmp;
		}
		for (int i = result.length - 1; i >= 0; i--) {
			System.out.println(result[i]);
		}
	}

// 모든 시계가 12시이 판별하는 메소드
	private static boolean isAllClock12(int[] clockArray) {
		for (int i = 0; i < CNT_CLOCK; i++) {
			if (clockArray[i] != 12) {
				return false;
			}
		}
		return true;
	}

	private static void clickButton(int[] clockArray, int button) {
		for (int clock = 0; clock < CNT_CLOCK; clock++) {
			if (button_clock[button][clock] == 1) {
				clockArray[clock] += 3;
				if (clockArray[clock] == 15) {
					clockArray[clock] = 3;
				} // end of if
			} // end of if
		} // end of for
	}

	private static int solve(int[] clockArray, int button) {
// 0~9번 버튼에 대해 각각 times번 눌렀을 때, 12시인지 확인.
// 재귀 함수에 대해 헷갈렸던 부분.
// 4^10 완전 탐색을 하므로 10중 for문을 돌린다고 생각하면 좀 더 이해하기 쉽다.
		if (button == CNT_BUTTON) {
			return isAllClock12(clockArray) ? 0 : MIN;
		}
		int min = MIN;
// 아래 for문을 재귀 함수로 10중 for문을 만든다고 생각하면 된다.
// clickButton을 재귀 밑에 둠으로써 0번 눌렀을 때도 확인할 수 있으며,
// times가 3일때도 한 번 더 눌러 원상태로 만들어 다음 재귀 함수를 돌린다.
		for (int times = 0; times < 4; times++) {
			min = Math.min(min, times + solve(clockArray, button + 1));
			clickButton(clockArray, button);
		}
		return min;
	}
}
