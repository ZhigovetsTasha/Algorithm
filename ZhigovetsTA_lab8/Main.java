import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		BinaryTree bTree = new BinaryTree();
		menu(bTree);
	}

	static void menu(BinaryTree bTree) {
		Scanner in = new Scanner(System.in);
		String choice = "";
		while (!choice.equals("14")) {
			System.out.println("1-�������� ������� � ������\n" + 
					"2 - ����� ��������\n" + "3 - ������ ��������\n"
					+ "4 - ����� ��������\n" + "5 - ������ �����\n" + "6 - �������� �����\n"
					+ "7 - ������������ �����\n" + "8 - �������\n" + "9 - ������\n" + "10 - ������� ����\n"
					+ "11 - ����� ����������� ����� ����� �������� ������� ���,\n"
					+ "� �������� ����� ������ ���� ��� ������ ����������,\n"
					+ "� ������� (������ ���������) ����������� ������� ����� ����.\n"
					+ "��������� ������ (�����) ����� ����������� ������.\n" +
					"12 - ����� ������\n"+
					"13 - ��������� ������ ��������� ����������\n"+
					"14 - �����");
			choice = in.next();
			switch (choice) {
			case "1": {
				System.out.print("������� �������: ");
				int value = in.nextInt();
				bTree.add(value);
				break;
			}
			case "2": {
				System.out.print("������� �������, ������� ����� �����: ");
				int value = in.nextInt();
				if (bTree.findNode(value) != null)
					System.out.println("����� ������� ������!");
				else
					System.out.println("������� �� ������!");
				break;
			}
			case "3":{
				System.out.print("������� ����� �������� ����� �������:");
				int value = in.nextInt();
				bTree.deleteRight(value);
				break;
			}
			case "4":{
				System.out.print("������� ����� �������� ����� �������:");
				int value = in.nextInt();
				bTree.deleteLeft(value);
				break;
			}
			case "5": {
				System.out.println("������ ����� ������:");
				bTree.direct();
				break;
			}
			case "6": {
				System.out.println("�������� ����� ������:");
				bTree.reverse();
				break;
			}
			case "7": {
				System.out.println("������������ ����� ������:");
				bTree.symmetrical();
				break;
			}
			case "8": {
				System.out.println("������� �������� ����:");
				int value = in.nextInt();
				System.out.println("�������:");
				int depth = bTree.depth(value);
				if(depth!=-1)
					System.out.println(depth);
				break;
			}
			case "9":
			{
				System.out.println("������� �������� ����:");
				int value = in.nextInt();
				int height = bTree.height(value);
				System.out.println("������:");
				if(height!=-1)
					System.out.println(height);
				break;
			}
			case "10":{
				System.out.println("������� �������� ����:");
				int value = in.nextInt();
				int level = bTree.level(value);
				System.out.println("�������:");
				if(level!=-1)
					System.out.println(level);
				break;
			}
			case "11":
				bTree.task();
				break;
			case "12":
				bTree.print();
				break;
			case "13":{
				bTree.add(8);
				bTree.add(3);
				bTree.add(2);
				bTree.add(1);
				bTree.add(5);
				bTree.add(4);
				bTree.add(6);
				bTree.add(10);
				bTree.add(9);
				break;
			}
			}
		}
		in.close();
	}
}
