import java.util.ArrayList;



public class Target 
{
	public static final int TYPE = 8;
	
	private int count;  //number of targets that have been hit, used a variable to hold it for efficiency
	private byte [] target;
	
	public Target(int range)
	{
		this.target = new byte[range/TYPE + 1];
		this.count = 0;
	}
	
	/**
	 * @pre targetNum must be be a target in the range passed into this objects constructor
	 * @return returns true if the target at targetNum is now marked, returns false if it was allready marked    	
	 */
	public boolean mark(int targetNum){
		int byteIndex = targetNum/TYPE;
		int byteNum = (byte)Math.pow(2,targetNum%TYPE);
		byte byteAns = (byte)(target[byteIndex]|byteNum);
		if(target[byteIndex] != byteAns){
			target[byteIndex] = byteAns;
			count++;
			return true;
		}
		return false;
	}
	
	
	public int getTargetsMarked(){
		return count;
	}
	
}