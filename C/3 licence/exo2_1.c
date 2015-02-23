#include <stdio.h>

#include <unistd.h>

#include <signal.h>

#include <wait.h>

/***************************************/

pid_t pid;

/***************************************/

void a(int sig){printf("A\n");}

/***/

void b(int sig){printf("B\n");kill(pid,SIGUSR2);}

/***/

void c(int sig){printf("C\n");kill(getppid(),SIGUSR1);}

/***/

void d(int sig){printf("D\n");kill(getpid(),SIGKILL);}

/***************************************/

int main()

{

int etat;

pid=fork();

switch(pid)

{

case -1:printf("Erreur\n");

break;

case  0:signal(SIGUSR1,c);

signal(SIGUSR2,d);

for(;;);

break;

default:sleep(1);

a(0);

kill(pid,SIGUSR1);

signal(SIGUSR1,b);

wait(&etat);

if(etat==SIGKILL)printf("Le processus fils termine normalement.\n");

else printf("Le processus fils termine normalement.\n");

break;

}

return 0;

}
