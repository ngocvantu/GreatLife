/*
 ============================================================================
 Name        : ok2.upc
 Author      : tunv
 Version     :
 Copyright   : tunguyen copyright notice
 Description : UPC Hello world program
 ============================================================================
*/
#include <upc.h>

int main(int argc, char *argv[]) {
	printf("Hello, I am %d of %d.\n", MYTHREAD, THREADS);
	return 0;
}
