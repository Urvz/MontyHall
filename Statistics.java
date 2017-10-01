public class Statistics{
	int switchWin=0;
	int switchLose=0;
	int totalGames=0;
	int[][] list;
	int doors;
	int prizeIndex;
	int selectIndex;
	int totalChosen;
	int totalOpen;
	int totalPrize;

		public Statistics(int numberOfDoors){
			doors=numberOfDoors;
			list= new int[doors][];
			for (int i=0;i<doors;i++){
				list[i]=new int[3];
				
			}
		}
		public void updateStatistics(Door[] doorArray){
					
			for (int i=0;i<doors;i++){		
				int z=Integer.parseInt((doorArray[i]).door);
				if(doorArray[i].isChosen()==true&&doorArray[i].hasPrize()==true){
					
					list[z-1][0]+=1;
					list[z-1][2]+=1;
					switchLose+=1;
					totalChosen+=1;
					totalPrize+=1;
					
				}
				else if(doorArray[i].isChosen()==true){
					
					list[z-1][0]+=1;
					selectIndex=z;
					totalChosen+=1;
					
				}

				else if(doorArray[i].isOpen()==true){
					
					list[z-1][1]+=1;
					totalOpen+=1;
					
				}

				else if(doorArray[i].hasPrize()==true){
					
					list[z-1][2]+=1;
					prizeIndex=z;
					totalPrize+=1;
					
				}				
				
			}
			totalGames+=1;
			switchWin=totalGames-switchLose;
			
		}
		public String toString(){
			String []output= new String [4];
			output[0]="Number of Games Played: "+totalGames+"\n";
			output[0]=output[0]+"Staying strategy won "+ switchLose+" times "+ (switchLose*100/totalGames)+"%\n";
			output[0]=output[0]+"Switching strategy won "+ switchWin+" times "+ (switchWin*100/totalGames)+"%\n";
			output[1]=("Chosen Doors\n");
			
			for (int i=0;i<(list).length;i++){
				output[1]=output[1]+"Door "+(i+1)+": "+ list[i][0]+ " "+ ((list[i][0])*100/totalChosen)+"%\n";
			}
			output[2]=("Opened Doors\n");
			for (int i=0;i<(list).length;i++){
				output[2]=output[2]+"Door "+(i+1)+": "+ list[i][1]+" "+ ((list[i][1])*100/totalOpen)+"%\n";
			}
			output[3]=("Prize Doors\n");
			for (int i=0;i<(list).length;i++){
				output[3]=output[3]+"Door "+(i+1)+": "+ list[i][2]+" "+ ((list[i][2])*100/totalPrize)+"%\n";
			}
			
			output[0]=output[0]+output[1]+output[2]+output[3];
			return output[0];
		}
		
			
		public String toCSV(){
			String []output= new String[4];
			output[0]="Number of Games "+ totalGames+"\nNumber of Doors "+ doors+"\n,Wins,Losses\n"+"Staying strategy "+switchWin+","+switchLose+"\nStaying strategy "+ switchLose+ ", " +switchWin+"\n";
			output[1]=",Selected doors, Winning doors, Open doors\n";
			output[2]="";
			for (int i=0;i<(list).length;i++){
				output[2]=output[2]+"Door "+ (i+1)+","+list[i][0]+","+list[i][1]+","+list[i][2]+"\n";

				}
			
			output[0]=output[0]+output[1]+output[2];
			return output[0];
		}
		
		
		

}
