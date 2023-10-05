#include<stdio.h>

int main(int argc, char *argv[]) {

    for (int i = 1; i < argc; i++) {
        int j = 0;
        while (argv[i][j] != '\0') {
            j++;
        }
        printf("\nArgumento numero %d (%s) possui %d carateres!", i, argv[i], j);
        
    }
    
    return 0;
}