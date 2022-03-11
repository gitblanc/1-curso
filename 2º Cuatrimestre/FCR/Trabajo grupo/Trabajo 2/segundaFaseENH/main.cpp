#include <iostream>

#include "comms.h"
#include "stages.h"


using std::cout;
using std::cin;
using std::endl;

int main()
{
	ConnectToCommandAndControlServer();

	Stage1();

	cout << "Stage 1 disabled" << endl;

	Stage2();

	cout << "Stage 2 disabled" << endl;

	Stage3();

	cout << "Stage 3 disabled" << endl;

	BombDisabled();
	cout << "Wow, you've just saved the Earth!" << endl;
	return 1;
}