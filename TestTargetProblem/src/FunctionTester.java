
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FunctionTester {

	
	/** @return a 2 elemeent int array where [0] = targets covered and [1] = total number of targets in set
	 */
	public int [] totalTargetsCovered(String inputFileName)
	{
		BufferedReader in = null;
		int count = 0;
		int targetRange = -1;
		try {
			String newLine  = System.getProperty("line.separator");
			in = new BufferedReader(new FileReader(inputFileName));
		
			String firstLine = in.readLine();
			int space = firstLine.indexOf(' ');
			int numTests = Integer.parseInt(firstLine.substring(0,space));
			targetRange = Integer.parseInt(firstLine.substring(space+1));
			byte [] target  = new byte[targetRange/8 + 1];
			for(int i = 0;i<numTests;i++)
			{
				String [] temp = in.readLine().split(" ");
				int [] splitArray = new int[temp.length];
				for(int ip = 0;ip<temp.length;ip++)
					splitArray[ip] = Integer.parseInt(temp[ip]); 
				for(int ip = 0;ip<splitArray[0];ip++)
				{
					int byteIndex = splitArray[ip+1]/8;
					int byteNum = (byte)Math.pow(2,splitArray[ip+1]%8);
					byte byteAns = (byte)(target[byteIndex]|byteNum);
					if(target[byteIndex] != byteAns){
						target[byteIndex] = byteAns;
						count++;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(in!=null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new int[]{count,targetRange};
	}
	
	
	public static void main(String[] args) 
	{
		FunctionTester tester = new FunctionTester();
		int [] targ = tester.totalTargetsCovered("inputPerc.txt");
		System.out.println(targ[0] + "/" + targ[1] + " targets covered");
	}

}