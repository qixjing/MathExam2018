#include<stdio.h>
#include<stdlib.h>
#include<time.h>
int main(int argc,char** argv)
{
    int i,c1,t,d1,d2,d3,d4,d5,d6,d7,d8;                            
    int rand(); 
    srand((unsigned)time(NULL));
	printf("%d\n",argc);
	int a[1000];
	int b[1000];
    int c[1000];
	int d[1000];
	int e[1000];
	int f[1000];
	int g[1000];
	int h[1000];

    for(i=1;i<=10;i++)
    {
        d1=rand()%91+10,d2=rand()%91+10;
        d3=rand()%91+10,d4=rand()%91+10;                                                           
         if(d1<d2)
        {
            t=d2,d2=d1,d1=t;                                
        }
        if(d3<d4)
        {
            t=d4,d4=d3,d3=t;
         } 
      
		d5=d1+d2;d6=d3*d4;                                              
        d7=d1-d2;d8=d3/d4;
		a[i]=d1;
		b[i]=d2;
		c[i]=d3;
		d[i]=d4;
		e[i]=d5;
		f[i]=d6;
		g[i]=d7;
		h[i]=d8;


        
		printf("\n%d + %d = ",d1,d2);                                    
        printf("\n%d x %d = ",d3,d4);
		printf("\n%d - %d = ",d1,d2);
        printf("\n%d ¡Â%d = \n",d3,d4); 

		
	}
	printf("\n----------±ê×¼´ð°¸--------------\n");
	   for(i=1;i<=10;i++)
       
	   {

		printf("\n%d + %d = %d",a[i],b[i],e[i]);                                    
        printf("\n%d x %d = %d",c[i],d[i],f[i]);
		printf("\n%d - %d = %d",a[i],b[i],g[i]);
        printf("\n%d ¡Â%d = %d",c[i],d[i],h[i]); 

	   }
      
       
		
		

        return 0; 
    

}