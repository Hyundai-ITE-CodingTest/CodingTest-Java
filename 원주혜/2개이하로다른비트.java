class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
				//System.out.println(answer[i]);
			} else {
				long bit = 1;
	            while (true) {
	                if ((numbers[i] & bit) == 0) break;
	                bit *= 2;
	            }
	            bit = bit / 2;
	            answer[i] = (numbers[i] + bit);
	            //System.out.println(answer[i]);
        
          //		int zeros = Integer.numberOfTrailingZeros(~((int) numbers[i]));
          //		System.out.println("zeros " + zeros);
          //		if(zeros == 1) {
          //			int sum = (int) (numbers[i] + 1);
          //			answer[i] = sum ^ (1 << 0);
          //			System.out.println(answer[i]);
          //			continue;
          //		}
          //		int ones = (1 << (zeros-1)) - 1;
          //		System.out.println("ones " + Integer.toBinaryString(ones));
          //		int sum = (int) (numbers[i] + ones);
          //		answer[i] = sum ^ (1 << 0);
          //		System.out.println(Integer.toBinaryString(sum ^ (1 << 0)));
          //		System.out.println(answer[i]);
			}
		}
        return answer;
    }
}
