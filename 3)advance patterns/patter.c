#include<stdio.h>
int main(){
    int n =3;
    int turn=0;
    for(int i = 1;i<=n;i++){
        for(int space=1;space<=n-i;space++){
            printf(" ");
        }
        for(int j=1;j<=2*i-1;j++){
            printf("%d",i+turn+1-j);
        }
        printf("\n");
        turn ++;
    }
    int turn2=n-2;//to satisfy i+turn2+1-j
    for(int i = n-1;i>=1;i--){
        for(int space=1;space<=n-i;space++){
            printf(" ");
        }
        for(int j=1;j<=2*i-1;j++){
            printf("%d",i+turn2+1-j);
        }
        printf("\n");
        turn2 --;
    }
}