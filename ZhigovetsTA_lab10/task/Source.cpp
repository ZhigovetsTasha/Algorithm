#include <iostream>
#include <queue>      

using namespace std;

int main(){
	setlocale(LC_ALL, "Russian");
	int N;
	int m;
	cout << "Введите число шестерёнок: ";
	cin >> N;
	int* pickedPoints = new int[N]; //Массив меток,0-вращение по часовой,1- вращение против часовой,-1-не вращается
	for (int i = 0; i < N; i++) {
		pickedPoints[i] = -1;
	}
	int** matrix = new int*[N];
	for (int i = 0; i < N; i++) //матрица смежности,т.е. тут я указываю соединены ли шестерёнки между собой
		matrix[i] = new int[N];
	for (int i = 0; i < N; i++) {  //0- шестерёнки не соединены,1- шестерёнки соединены
		for (int j = 0; j < N; j++)
			matrix[i][j] = 0;
	}
	cout << "Введите число пар шестерёнок: ";
	cin >> m;
	int i, j;
	
	for (int z = 0; z < m; z++) {
		cout << "i: ";
		cin >> i;
		cout << "j: ";
		cin >> j;
		cout << endl;
		matrix[i - 1][j - 1] = 1;
		matrix[j - 1][i - 1] = 1;
	}

	queue <int> queuePoints;

	bool status = true;

	pickedPoints[0] = 1;

	queuePoints.push(0);

	while (queuePoints.size() > 0 && status == true) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i == j) { //шестерёнка не может быть сединена сама с собой
					continue;
				}
				if (matrix[i][j] == 1) { 
					if (pickedPoints[i] == pickedPoints[j]) {   //если соединённые шестерёнки одного цвета,то бросаем ошибку,значит шестерни не могут приходить в движение
						status = false;
						break;
					}
					if ((pickedPoints[j] == 0 || pickedPoints[j] == 1) && pickedPoints[i] != pickedPoints[j]) { //если шестерни уже помечены,но направление вращения разное,то пропускаем
						continue;
					}
					if (pickedPoints[i] == 0 && pickedPoints[j] == -1) { //если шестерня вращается по часовой,то устанавливаем направление вращения соединённой,но ещё не помеченной шестерни,обратное
						pickedPoints[j] = 1;
						queuePoints.push(j);
					}
					else if (pickedPoints[i] == 1 && pickedPoints[j] == -1) { //если шестерня вращается против часовой,то устанавливаем направление вращения соединённой,но ещё не помеченной шестерни,обратное
						pickedPoints[j] = 0;
						queuePoints.push(j);
					}
				}
			}
			queuePoints.pop();
		}
	}

	if (status == false) {
		cout << "Первую шестерню нельзя повернуть" << endl;
	}
	else {

		int counter = 0;

		for (int i = 0; i < N; i++) {
			if (pickedPoints[i] == 0 || pickedPoints[i] == 1) {
				counter++;
			}
		}

		cout << counter << " шестерёнок пришло в движение" << endl;
	}
	
	system("pause");
	return 0;
}