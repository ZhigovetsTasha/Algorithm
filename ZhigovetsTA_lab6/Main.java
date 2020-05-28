import java.util.concurrent.*;

public class Main {
	
	public static void main (String[] args) throws InterruptedException 
	{
	
		Stack stack1= new Stack(20);
		Stack stack2 = new Stack(20);
		Stack stack3 = new Stack(20);
		
		Queue queue= new Queue(5);
		Deque deque = new Deque();
		
		for(int i=1;i<6;i++)
			queue.eneqeue(i);
		
		while(true)
		{
			
			int products1 = (int)(2 + Math.random()*3);
			int products2 = (int)(2 + Math.random()*3);
			int products3 = (int)(2 + Math.random()*3);
			
			System.out.println("Добавляем продукты в контейнеры!");
			for(int i=0;i<products1;i++)
				stack1.push(1);
			
			for(int i=0;i<products2;i++)
				stack2.push(2);
			
			for(int i=0;i<products3;i++)
				stack3.push(3);
			
			System.out.println("Контейнеры заполнены!");
			
			TimeUnit.SECONDS.sleep(2);
			
			int pop1 = stack1.pop();
			int pop2 = stack2.pop();
			int pop3 = stack3.pop();
			
			if(pop1 == 1 && pop2==2 && pop3==3)
			{
				int robot = queue.deqeue();
				System.out.println("Робот "+robot+" смешивает продукты!!!");
				
				TimeUnit.SECONDS.sleep(2);
				
				int mesto = (int)(1+Math.random()*2);
				if(mesto==1)
				{
					deque.push_front(4);
					System.out.println("Салат попал на начало ленты");
				}else {
					deque.push_back(4);
					System.out.println("Салат попал в конец ленты");
				}
				
				System.out.println("Ждем пока робот вернется в конец очереди");
				TimeUnit.SECONDS.sleep(2);
				queue.eneqeue(robot);
				System.out.println(robot+"  вернулся в конец очереди");
			}else {
				System.out.println("Скорее всего какой-то контейнер был пуст");
			}
			
			int end = 1 + (int)(Math.random()*2);
			if(end==1 && deque.pop_front()==4 )
			{
				System.out.println("Салат забрали из начала дека");
			}else if (end==2 && deque.pop_back()==4)
			{
				System.out.println("Салат забрали из конца дека");
			}
			TimeUnit.SECONDS.sleep(2);
			System.out.println(" проход окончен");
			System.out.println("--------------------");
		}
	}
}
