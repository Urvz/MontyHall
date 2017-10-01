public class Door{
	boolean open=false;
	boolean selection=false;
	boolean prize=false;
	String door;
	
	Door (String identity){				
		door=identity;
	}
	public void reset(){
		open=false;
		selection=false;
		prize=false;
		
	}
	public void open(){
		open=true;
		//System.out.println("Door "+door +" is open");
		

	}
	public boolean isOpen(){
		if (open==true){

		}
		return (open);

	}
	public boolean hasPrize(){
		
		return prize;
			
	}
	public boolean isChosen(){
		if (selection==true){

		}
		return(selection);
	}
	public void choose(){
		selection=true;
		//System.out.println("Door " + door+" is chosen by the player");
	}
	public void setPrize(){
		prize=true;
		//System.out.println("Door " + door+" has the prize");
	}
	public String getName(){
		
		return (door);
	}

	
}