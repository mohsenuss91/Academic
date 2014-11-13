#include <stdio.h>

#include <unistd.h>

#include <signal.h>

#include <wait.h>

/***************************************/

void a(int sig){}

/***************************************/

int main()
{

int etat;

pid_t pid=fork();

switch(pid)

{

case -1:printf("Erreur\n");

break;

case  0:signal(SIGALRM,a);

pause();

printf("C\n");

kill(getppid(),SIGALRM);

pause();

printf("D\n");

break;

default:
signal(SIGALRM,a);

printf("A\n");

kill(pid,SIGALRM);

pause();

printf("B\n");

kill(pid,SIGALRM);

wait(&etat);

printf("Le processus fils termine par le signal %d\n",etat);

break;

}


return 0;


}