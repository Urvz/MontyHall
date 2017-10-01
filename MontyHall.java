import java.util.Random;
import javax.swing.*;
public class MontyHall{
	Door one ;
	Door two ;
	Door three;
	Door x;
	Door y;
	Door z;
	Door a;
	Door b;
	Random test = new Random();
	Door[] list;
	Door[] allDoors;
	int doors;
	Statistics stats;
	
	public MontyHall(int numberOfDoors){
		doors=numberOfDoors;
		int count=0;
		int secondCount=0;
		String tmp;
		
		
		allDoors=new Door[doors];
		for (int i=0;i<doors;i++){
			secondCount+=1;
			 tmp=Integer.toString(secondCount);
			allDoors[i]=new Door(tmp);
		}

	}
	public void runGames(int number,boolean command){
		stats= new Statistics(doors);
		if (command==false){
			for(int i=0;i<number;i++){
			oneGame();
			}
			System.out.println(stats);
		}
		else{
			for(int i=0;i<number;i++){
			oneGame();

			}
			
			JOptionPane.showMessageDialog (null,stats.toString(), "Results", JOptionPane.INFORMATION_MESSAGE);
		

		}
		
		
	}
	public void oneGame(){
		
		for(int i=0;i<doors;i++){
			allDoors[i].reset();
		}
		x=pickADoor();
		x.choose();
		y=pickADoor();
		y.setPrize();
		//System.out.println(x.getName());
		//System.out.println(y.getName());
		openOtherDoors(x,y);
		
		stats.updateStatistics(allDoors);

		
	}
	private int rand(int min, int max){
		int randomNumber=test.nextInt((max-min)+1)+min;
		return randomNumber;
	}
	
	private Door pickADoor(){
		
		int randomNumber=test.nextInt(doors);
		return allDoors[randomNumber];
	}
	private void openOtherDoors(Door chosen,Door prize){
		int z=Integer.parseInt(chosen.door);
		if ((chosen.door).equals(prize.door)){
			
			int randomNumber=rand(1,doors);
			
			if (randomNumber==(z)){
				while (randomNumber==z){
				randomNumber=rand(1,doors);
			}
			
			}
			String tmp=Integer.toString(randomNumber);
			for (int i=0;i<doors;i++){
			if (allDoors[i].isChosen()==false && ((allDoors[i].door).equals(tmp))==false&&(tmp.equals("0"))==false){
				allDoors[i].open();

			}
		}

		}
		else{
			for (int i=0;i<doors;i++){
			if (allDoors[i].isChosen()==false && allDoors[i].hasPrize()==false){
				allDoors[i].open();

			}
		}

		}
		
		for (int i=0;i<doors;i++){
			if (allDoors[i].isOpen()==true){
				//System.out.println(allDoors[i].getName());
			}
		}
	}	
	
	
	public static void main(String[]args){
		
		int w=0;
		int numberOfSim;
		int numberOfDoors;
		boolean command=true;
		
		if (args.length==2){
			numberOfSim=Integer.parseInt(args[0]);
			numberOfDoors=Integer.parseInt(args[1]);
			command=true;
		}
		else{
			numberOfSim = Integer.parseInt(JOptionPane.showInputDialog("Input the number of games to play", "1000"));
			numberOfDoors = Integer.parseInt(JOptionPane.showInputDialog("Input the number of doors", "3"));
			command=false;
		}
		MontyHall game = new MontyHall(numberOfDoors);
		game.runGames(numberOfSim,command);

		
		
	}

}