#include<stdio.h>
#include<stdlib.h>
#include<Windows.h>
void main(){
	STARTUPINFO SI;HANDLE hp;
	PROCESS_INFORMATION PI;DWORD id;
	GetStartupInfo(&SI);
	CreateProcess(L"c://windows//notepad.exe",NULL,NULL,NULL,FALSE,NORMAL_PRIORITY_CLASS,NULL,NULL,&SI,&PI);
	WaitForSingleObject(PI.hProcess,INFINITE);//so we can let the program wait more till the console continue
	//if we want to start the process of notepad put not active it
	//CreateProcess(L"c://windows//notepad.exe",NULL,NULL,NULL,FALSE,CREATE_SUSPENDED,NULL,NULL,&SI,&PI);
	//ResumeThread(PI.hThread);//resume
	//SuspendThread(PI.hThread);//pause
	printf("%d\n",PI.dwProcessId);//get the id of the process of notepad 
	id=GetCurrentProcessId();//get the id of the process of cmd of our program
	printf("%d",id);
	hp=GetCurrentProcess();//get the handel of the process of cmd of our program
	//TerminateProcess(PI.hProcess,0);// exit the notepad it should be before exitprocess 
	//ExitProcess(0);//exit the current (cmd)
	


}