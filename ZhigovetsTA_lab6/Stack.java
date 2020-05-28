public class Stack {

	private int top = -1;
	private int size;
	private int[] stack;

	Stack(int n) {
		stack = new int[n];
		size = n;
	}

	public boolean empty() {
		if (top == -1)
			return true;
		return false;
	}

	public void push(int x) {
		if (top < size - 1) {
			top++;
			stack[top] = x;
		}
	}

	public int pop() {
		if (empty()) {
			System.out.println("Стек пуст");
			return -1;
		} else {
			top--;
			return stack[top + 1];
		}
	}
}
