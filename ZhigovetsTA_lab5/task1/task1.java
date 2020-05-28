import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class task1 {

	static int j = 0;
	static int step = 0;
	static long time = 0;
	static int compare = 0;
	static int file = 0;
	static int quantity = 0;
	static int length = 0;
	static int size = 0;

	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);

		System.out.println("Введите количество элементов массива:");
		size = in.nextInt();
		System.out.println("Выберите 1-рандом;\n" + "2- по возврастанию:\n" + "3- по убыванию");

		String choice = in.next();
		switch (choice) {
		case "1":
			random(size);
			break;
		case "2":
			above(size);
			break;
		case "3":
			below(size);
			break;
		}
		long begin = System.currentTimeMillis();
		sort(size);
		time = System.currentTimeMillis() - begin;
		System.out.println("Сортировка окончена!");
		System.out.println("Затраченное время: " + time + " миллисекунд");
		System.out.println("Количество обращений к файлу: " + file);
		System.out.println("Количество сравнений: " + compare);
		in.close();
	}

	public static void random(int size) throws IOException {
		FileWriter writer = new FileWriter("text.txt");

		for (int i = 0; i < size; i++) {
			int temp = (int) (Math.random() * 1000);
			writer.write(Integer.toString(temp));
			writer.write(" ");
		}
		writer.close();
	}

	public static void above(int size) throws IOException {
		FileWriter writer = new FileWriter("text.txt");

		for (int i = 1; i <= size; i++) {
			writer.write(Integer.toString(i));
			writer.write(" ");
		}
		writer.close();
	}

	public static void below(int size) throws IOException {

		FileWriter write = new FileWriter("text.txt");

		for (int i = size; i > 0; i--) {
			write.write(Integer.toString(i));
			write.write(" ");
		}
		write.close();
	}

	public static void sort(int size) throws IOException {
		
		FileWriter f1 = new FileWriter("f1.txt");
		FileWriter f2 = new FileWriter("f2.txt");
		FileWriter f3 = new FileWriter("f3.txt");
		FileReader f = new FileReader("text.txt");

		Scanner sc = new Scanner(f);
		while (sc.hasNext()) {
			f1.write(Integer.toString(sc.nextInt()));
			f1.write(" ");
			file += 2;
			if (sc.hasNext()) {
				f2.write(Integer.toString(sc.nextInt()));
				f2.write(" ");
				file += 2;
			}
			if (sc.hasNext()) {
				f3.write(Integer.toString(sc.nextInt()));
				f3.write(" ");
				file += 2;
			}
		}
		sc.close();
		f.close();
		f1.close();
		f2.close();
		f3.close();

		FileReader f12 = new FileReader("f1.txt");
		FileReader f22 = new FileReader("f2.txt");
		FileReader f32 = new FileReader("f3.txt");

		FileWriter f42 = new FileWriter("f4.txt");
		FileWriter f52 = new FileWriter("f5.txt");
		FileWriter f62 = new FileWriter("f6.txt");

		Scanner sc1 = new Scanner(f12);
		Scanner sc2 = new Scanner(f22);
		Scanner sc3 = new Scanner(f32);

		step = size / 3;
		if (size % 3 != 0)
			step++;
		length = 1;
		quantity = 3;

		outputFile(sc1, sc2, sc3, f42, f52, f62);

		sc1.close();
		sc2.close();
		sc3.close();

		f12.close();
		f22.close();
		f32.close();
		f42.close();
		f52.close();
		f62.close();

		quantity = 9;
		length = 3;

		while (true) {
			File file1 = new File("f1.txt");
			File file2 = new File("f2.txt");
			File file3 = new File("f3.txt");

			FileWriter f13 = new FileWriter(file1);
			FileWriter f23 = new FileWriter(file2);
			FileWriter f33 = new FileWriter(file3);

			FileReader f43 = new FileReader("f4.txt");
			FileReader f53 = new FileReader("f5.txt");
			FileReader f63 = new FileReader("f6.txt");

			Scanner sc43 = new Scanner(f43);
			Scanner sc53 = new Scanner(f53);
			Scanner sc63 = new Scanner(f63);

			step = size / quantity;
			if (size % quantity != 0)
				step++;

			j = 0;

			outputFile(sc43, sc53, sc63, f13, f23, f33);
			sc43.close();
			sc53.close();
			sc63.close();

			f13.close();
			f23.close();
			f33.close();
			f43.close();
			f43.close();
			f53.close();
			f63.close();

			if (file2.length() == 0 && file3.length() == 0) {
				System.out.println("Смотри в файле №1");
				break;
			}

			quantity *= 3;
			step = size / quantity;
			if (size % quantity != 0)
				step++;

			length *= 3;
			j = 0;

			FileReader f14 = new FileReader("f1.txt");
			FileReader f24 = new FileReader("f2.txt");
			FileReader f34 = new FileReader("f3.txt");

			File file4 = new File("f4.txt");
			File file5 = new File("f5.txt");
			File file6 = new File("f6.txt");

			FileWriter f44 = new FileWriter(file4);
			FileWriter f54 = new FileWriter(file5);
			FileWriter f64 = new FileWriter(file6);

			Scanner sc14 = new Scanner(f14);
			Scanner sc24 = new Scanner(f24);
			Scanner sc34 = new Scanner(f34);

			outputFile(sc14, sc24, sc34, f44, f54, f64);

			sc14.close();
			sc24.close();
			sc34.close();

			f14.close();
			f24.close();
			f34.close();
			f44.close();
			f54.close();
			f64.close();

			if (file5.length() == 0 && file6.length() == 0) {
				System.out.println("Смотри в файле №4");
				break;
			}
			quantity *= 3;
			length *= 3;
		}
	}

	static void outputFile(Scanner sc14, Scanner sc24, Scanner sc34, FileWriter f44, FileWriter f54, FileWriter f64)
			throws IOException {
		for (int i = 0; i < step; i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();

			int k = 0;
			while (k < length && sc14.hasNext()) {
				list.add(sc14.nextInt());
				k++;
				file++;
			}

			k = 0;
			while (k < length && sc24.hasNext()) {
				list.add(sc24.nextInt());
				k++;
				file++;
			}

			k = 0;
			while (k < length && sc34.hasNext()) {
				list.add(sc34.nextInt());
				k++;
				file++;
			}

			Collections.sort(list);

			if (list.size() != 1)
				compare += list.size();

			if (j == 0) {
				for (int temp : list) {
					f44.write(Integer.toString(temp));
					f44.write(" ");
					file++;
				}
			} else if (j == 1) {
				for (int temp : list) {
					f54.write(Integer.toString(temp));
					f54.write(" ");
					file++;
				}
			} else {
				for (int temp : list) {
					f64.write(Integer.toString(temp));
					f64.write(" ");
					file++;
				}
			}
			j++;
			if (j == 3)
				j = 0;

		}
	}
}
