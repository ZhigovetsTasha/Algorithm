import java.util.ArrayList;
import java.util.*;

public class BinaryTree {
	private Node root = null;

	public void add(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			addTo(root, value);
		}
	}

	Node findNode(int value) {
		return containsNode(root, value);
	}

	private void addTo(Node node, int value) {

		Node find = findNode(value);

		if (find != null) {
			System.out.println("Нельзя добавить данное значение, т.к. оно существует");
			return;
		}
		if (value < node.getKey()) {
			if (node.getLeft() == null) {
				Node temp = new Node(value);
				node.setLeft(temp);
				node.getLeft().setParent(node);
			} else
				addTo(node.getLeft(), value);
		} else if (node.getRight() == null) {
			Node temp = new Node(value);
			node.setRight(temp);
			node.getRight().setParent(node);
		} else
			addTo(node.getRight(), value);
	}

	private Node containsNode(Node node, int value) {
		if (node == null)
			return null;
		else if (node.getKey() == value)
			return node;
		if (value < node.getKey())
			return containsNode(node.getLeft(), value);
		else
			return containsNode(node.getRight(), value);
	}

	private void treeDirect(Node node) {
		if (node != null) {
			System.out.print(node.getKey() + " ");
			treeDirect(node.getLeft());
			treeDirect(node.getRight());
		}
	}

	private void treeReverse(Node node) {
		if (node != null) {
			treeReverse(node.getLeft());
			treeReverse(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}

	private void treeSymmetrical(Node node) {
		if (node != null) {
			treeSymmetrical(node.getLeft());
			System.out.print(node.getKey() + " ");
			treeSymmetrical(node.getRight());
		}
	}

	public void direct() {
		treeDirect(root);
		System.out.println();
	}

	public void reverse() {
		treeReverse(root);
		System.out.println();
	}

	public void symmetrical() {
		treeSymmetrical(root);
		System.out.println();
	}

	public int height(int value) {
		if (root == null) {
			System.out.println("Дерево пусто!");
			return -1;
		} else {
			Node node = findNode(value);
			if (node == null) {
				System.out.println("Такого узла нет");
				return -1;
			} else {
				int count = treeHeight(node);
				return count;
			}
		}
	}

	public int depth(int value) {
		if (root == null) {
			System.out.println("Дерево пусто!");
			return -1;
		}
		Node node = findNode(value);
		if (node == null) {
			System.out.println("Не существует такого элемента!");
			return -1;
		} else {
			int count = treeDepth(node);
			return count;
		}
	}

	public int level(int value) {
		if (root == null) {
			System.out.println("Дерево пусто!!");
			return -1;
		}
		Node node = findNode(value);
		if (node == null) {
			System.out.println("Не существует такого элемента!");
			return -1;
		} else {
			int count = treeHeight(root) - treeDepth(node);
			return count;
		}
	}

	private int treeDepth(Node node) {
		if (node.getParent() == null)
			return 0;
		return 1 + treeDepth(node.getParent());
	}

	private int treeHeight(Node node) {
		int x = 0, y = 0;
		if (node == null)
			return 0;
		if (node.getLeft() != null)
			x = 1 + treeHeight(node.getLeft());
		if (node.getRight() != null)
			y = 1 + treeHeight(node.getRight());
		if (x > y)
			return x;
		else
			return y;
	}

	public void print() {
		treePrint("", root, false, false, 1);
	}

	public void task() {
		ArrayList<Integer> list = new ArrayList<Integer>(); //§г§б§Ъ§г§а§Ь §г §Э§Ъ§г§д§о§с§Ю§Ъ

		ArrayList<String> one = new ArrayList<String>();   //§д§е§д §з§в§С§Я§Ъ§д§г§с §б§а§Э§е§й§С§Ц§Ю§н§Ы §б§е§д§о §Ю§Ц§Ш§Х§е §е§Щ§Э§С§Ю§Ъ
		ArrayList<Integer> two = new ArrayList<Integer>(); //§д§е§д §з§в§С§Я§Ъ§д§г§с §Х§Э§Ъ§Я§С §б§е§д§Ъ
		ArrayList<Integer> three = new ArrayList<Integer>();//§д§е§д §з§в§С§Я§Ъ§д§г§с §г§е§Ю§Ю§С §Ь§Э§р§й§Ц§Ы §У§Ц§в§к§Ъ§Я §б§е§д§Ъ

		ArrayList<String> routes= new ArrayList<String>();
		ArrayList<Integer> sizeRoute= new ArrayList<Integer>();
		ArrayList<Integer> sumNKeys= new ArrayList<Integer>();

		String route = "";
		int sizeR=0;
		int sumK=0;


		if (root != null) {
			printLeafNodes(root, list);

			for (int i = 0; i < list.size()-1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					route="";
					sizeR=0;
					sumK=0;

					one.clear();
					two.clear();
					three.clear();


					printPathBetweenNodes(root,list.get(i),list.get(j),one,two,three);
					route = one.get(0);
					sizeR=two.get(0);
					sumK=three.get(0);

					if(routes.size()>0){
						if(sizeR<sizeRoute.get(sizeRoute.size()-1)){
							routes.clear();
							sizeRoute.clear();
							sumNKeys.clear();


							routes.add(route);
							sizeRoute.add(sizeR);
							sumNKeys.add(sumK);
							continue;
						}
						if(sizeR>sizeRoute.get(sizeRoute.size()-1)){
							continue;
						}
						if(sizeR==sizeRoute.get(sizeRoute.size()-1)) {
							routes.add(route);
							sizeRoute.add(sizeR);
							sumNKeys.add(sumK);
						}
					}
					if(routes.size()==0){
						routes.add(route);
						sizeRoute.add(sizeR);
						sumNKeys.add(sumK);
					}

					}

				}
			}


		int max=0;
		int maxIndex=0;
		for(int i=0;i<sumNKeys.size();i++){
			if(sumNKeys.get(i)>max){
				max=sumNKeys.get(i);
				maxIndex=i;
			}
		}

		String[] minPath = routes.get(maxIndex).split(" ");

		ArrayList<Integer> shortestPath = new ArrayList<Integer>();

		for (int i = 0; i < minPath.length; i++) {
			if(minPath[i]==""){
				break;
			}
			shortestPath.add(Integer.parseInt( minPath[i] ));
		}

		int index = shortestPath.size() / 2;
		deleteRight(shortestPath.get(index));//§е§Х§С§Э§Ц§Я§Ъ§Ц §г§Ц§в§Ц§Х§Ъ§Я§н
		System.out.println("Прямой обход дерева:");
		direct();
		System.out.println("Вывод:");
		print();
	}



	void printLeafNodes(Node node, ArrayList<Integer> list) {
		if (root == null)
			return;

		if (node.getLeft() == null && node.getRight() == null) {
			list.add(node.getKey());
			return;
		}

		if (node.getLeft() != null)
			printLeafNodes(node.getLeft(), list);

		if (node.getRight() != null)
			printLeafNodes(node.getRight(), list);
	}

	static boolean getPath(Node node, Vector<Integer> arr, int x)
	{
		// if root is null
		if (node==null)
			return false;

		// push the node's value in 'arr'
		arr.add(node.getKey());

		// if it is the required node
		// return true
		if (node.getKey() == x)
			return true;

		// else check whether the required node lies
		// in the left subtree or right subtree of
		// the current node
		if (getPath(node.getLeft(), arr, x) || getPath(node.getRight(), arr, x))
			return true;

		// required node does not lie either in the
		// left or right subtree of the current node
		// Thus, remove current node's value from
		// 'arr'and then return false
		arr.remove(arr.size()-1);
		return false;
	}

	// Function to print the path between
// any two nodes in a binary tree
	static void printPathBetweenNodes(Node root, int n1, int n2,ArrayList<String> one,ArrayList<Integer> two,ArrayList<Integer> three)//String route,int sizeR,int sumK)
	{
		String route="";
		int size=0;
		int sum=0;
		//ArrayList<Integer> both= new ArrayList<Integer>();
		// vector to store the path of
		// first node n1 from root
		Vector<Integer> path1= new Vector<Integer>();

		// vector to store the path of
		// second node n2 from root
		Vector<Integer> path2=new Vector<Integer>();

		getPath(root, path1, n1);
		getPath(root, path2, n2);

		int intersection = -1;

		// Get intersection point
		int i = 0, j = 0;
		while (i != path1.size() || j != path2.size()) {

			// Keep moving forward until no intersection
			// is found
			if (i == j && path1.get(i) == path2.get(i)) {
				i++;
				j++;
			}
			else {
				intersection = j - 1;
				break;
			}
		}

		// Print the required path
		for ( i = path1.size() - 1; i > intersection; i--){
			route+=(path1.get(i)+" ");
			size++;
			sum+=path1.get(i);
		}


		for ( i = intersection; i < path2.size(); i++){
			route+=(path2.get(i)+" ");
			size++;
			sum+=path2.get(i);
		}

		one.add(route);
		two.add(size);
		three.add(sum);

	}

	private void treePrint(String s, Node node, boolean lefts, boolean temp, int l) {
		if (node != null) {
			if (node.getLeft() != null || node.getRight() != null)
				temp = true;
			else
				temp = false;
			System.out.print(s);
			if (lefts)
				System.out.println("|_L:" + node.getKey());
			else {
				if (l == 1) {
					System.out.println("-" + node.getKey());
					l++;
				} else
					System.out.println("|_R:" + node.getKey());
			}
			if (lefts) {
				treePrint(s + "|", node.getLeft(), true, temp, l);
				treePrint(s + "|", node.getRight(), false, temp, l);
			} else {
				treePrint(s + " ", node.getLeft(), true, temp, l);
				treePrint(s + " ", node.getRight(), false, temp, l);
			}
		} else {
			if (temp) {
				System.out.print(s);
				if (lefts)
					System.out.println("|_L:-");
				else
					System.out.println("|_R:-");
			}
		}
	}

	public void deleteRight(int value) {
		Node node = findNode(value);
		if (node == null) {
			System.out.println("Такого элемента нет!!!");
			return;
		}
		if (delete(node))// §б§в§а§У§Ц§в§с§Ц§Ю §с§У§Э§с§Ц§д§г§с §Э§Ъ §п§д§а §У§Ъ§г§с§л§Ц§Ы §У§Ц§в§к§Ъ§Я§а§Ы, §Ц§г§Э§Ъ §д§С§Ь, §д§а §б§в§а§г§д§а §е§Х§С§Э§с§Ц§Ю
			return;
		if (node.getRight() == null) {
			if (node.getParent().getLeft() == node)
				node.getParent().setLeft(node.getLeft());
			else
				node.getParent().setRight(node.getLeft());

			node.getLeft().setParent(node.getParent());

			node = null;
		} else {
			treeDeleteRight(node);
		}
		System.out.println("Элемент удален!");
	}

	private void treeDeleteRight(Node node) {
		Node temp = node.getRight();
		while (temp.getLeft() != null)
			temp = temp.getLeft();

		if (temp.getParent() != node) {
			if (temp.getRight() != null) {
				temp.getParent().setLeft(temp.getRight());

				temp.getRight().setParent(temp.getParent());
			}

			temp.setRight(node.getRight());
			node.getRight().setParent(temp);
			temp.getParent().setLeft(null);
		}

		temp.setLeft(node.getLeft());
		node.getLeft().setParent(temp);

		if (node.getParent() != null) {
			if (node.getParent().getLeft() == node)
				node.getParent().setLeft(temp);
			else
				node.getParent().setRight(temp);
		}

		temp.setParent(node.getParent());

		if (node == root) {
			root = null;
			root = temp;
		} else {
			node = null;
			node = temp;
		}
	}

	public void deleteLeft(int value) {
		Node node = findNode(value);
		if (node == null) {
			System.out.println("Такой элемент не найден!!!!");
		}
		if (delete(node))
			return;
		if (node.getLeft() == null) {
			if (node.getParent().getLeft() == node)
				node.getParent().setLeft(node.getRight());
			else
				node.getParent().setRight(node.getRight());

			node.getRight().setParent(node.getParent());
			node = null;
		} else {
			treeDeleteLeft(node);
		}
		System.out.println("Элемент удален!");
	}

	private void treeDeleteLeft(Node node) {
		Node temp = node.getLeft();
		while (temp.getRight() != null)
			temp = temp.getRight();

		if (temp.getParent() != node) {
			if (temp.getLeft() != null) {
				temp.getParent().setRight(temp.getRight());

				temp.getLeft().setParent(temp.getParent());
			}

			temp.setLeft(node.getLeft());
			node.getLeft().setParent(temp);
			temp.getParent().setRight(null);
		}

		temp.setRight(node.getRight());
		node.getRight().setParent(temp);

		if (node.getParent() != null) {
			if (node.getParent().getLeft() == node)
				node.getParent().setLeft(temp);
			else
				node.getParent().setRight(temp);
		}

		temp.setParent(node.getParent());

		if (node == root) {
			root = null;
			root = temp;
		} else {
			node = null;
			node = temp;
		}
	}

	private boolean delete(Node node) {
		if (node != null) {
			if (node.getLeft() == null && node.getRight() == null) {
				if (node != root)
					if (node.getParent().getLeft() == node)
						node.getParent().setLeft(null);
					else
						node.getParent().setRight(null);
				if (node == root) {
					root = null;
					node = null;
				}
				System.out.println("Элемент удален!");
				return true;
			}
		}
		return false;
	}

}
