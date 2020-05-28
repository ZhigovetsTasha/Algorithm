public class Queue {
	private int tail = -1;
	private int size;
	private int[] queue;

	Queue(int n) {
		queue = new int[n];
		size = n;
	}

	public void eneqeue(int x) {
		if (tail < size - 1) {
			tail++;
			queue[tail] = x;
		}
	}

	public int deqeue() {
		if(tail!=-1) {
		int a = queue[0];
		for(int i =0;i<tail;i++)
		queue[i]=queue[i+1];
		tail--;
		return a;
		}
		return -1;
	}

}
