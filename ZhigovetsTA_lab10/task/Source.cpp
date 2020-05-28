#include <iostream>
#include <queue>      

using namespace std;

int main(){
	setlocale(LC_ALL, "Russian");
	int N;
	int m;
	cout << "������� ����� ���������: ";
	cin >> N;
	int* pickedPoints = new int[N]; //������ �����,0-�������� �� �������,1- �������� ������ �������,-1-�� ���������
	for (int i = 0; i < N; i++) {
		pickedPoints[i] = -1;
	}
	int** matrix = new int*[N];
	for (int i = 0; i < N; i++) //������� ���������,�.�. ��� � �������� ��������� �� ��������� ����� �����
		matrix[i] = new int[N];
	for (int i = 0; i < N; i++) {  //0- ��������� �� ���������,1- ��������� ���������
		for (int j = 0; j < N; j++)
			matrix[i][j] = 0;
	}
	cout << "������� ����� ��� ���������: ";
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
				if (i == j) { //��������� �� ����� ���� �������� ���� � �����
					continue;
				}
				if (matrix[i][j] == 1) { 
					if (pickedPoints[i] == pickedPoints[j]) {   //���� ���������� ��������� ������ �����,�� ������� ������,������ �������� �� ����� ��������� � ��������
						status = false;
						break;
					}
					if ((pickedPoints[j] == 0 || pickedPoints[j] == 1) && pickedPoints[i] != pickedPoints[j]) { //���� �������� ��� ��������,�� ����������� �������� ������,�� ����������
						continue;
					}
					if (pickedPoints[i] == 0 && pickedPoints[j] == -1) { //���� �������� ��������� �� �������,�� ������������� ����������� �������� ����������,�� ��� �� ���������� ��������,��������
						pickedPoints[j] = 1;
						queuePoints.push(j);
					}
					else if (pickedPoints[i] == 1 && pickedPoints[j] == -1) { //���� �������� ��������� ������ �������,�� ������������� ����������� �������� ����������,�� ��� �� ���������� ��������,��������
						pickedPoints[j] = 0;
						queuePoints.push(j);
					}
				}
			}
			queuePoints.pop();
		}
	}

	if (status == false) {
		cout << "������ �������� ������ ���������" << endl;
	}
	else {

		int counter = 0;

		for (int i = 0; i < N; i++) {
			if (pickedPoints[i] == 0 || pickedPoints[i] == 1) {
				counter++;
			}
		}

		cout << counter << " ��������� ������ � ��������" << endl;
	}
	
	system("pause");
	return 0;
}