public class Deque {
	private int head =1000;
	private int tail =1000;
	private int[] deque = new int[2000];
	
	public void push_front(int x) 
	{
		head--;
		deque[head]=x;
	}
	public void push_back(int x) 
	{
		deque[tail]=x;
		tail++;
	}
	public int pop_front() 
	{
		if(head!=tail)
		{
			head++;
			return deque[head-1];
		}
		else {
			System.out.println("ошибка извлечение элемента из пустого элемента");
			return -1;
		}
	}
	int pop_back() 
	{
		if(head!=tail)
		{
			tail--;
			return deque[tail];
		}else 
		{
			System.out.println("Ошибка извлечения элемента и пустого стека");
			return -1;
		}
	}
	boolean is_empty() 
	{
		return head==tail;
	}
	
}
