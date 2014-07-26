import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;


public class ProblemMaker {

	public void generateProblem(int numTests,  
			                           int targetRange,  // range is 0 to targetRange
			                           int maxEntriesPerTarget,
			                           String fileName)
   {
		BufferedWriter out = null;
		try {
			String newLine  = System.getProperty("line.separator");
			out = new BufferedWriter(new PrintWriter(fileName));
			out.write(numTests + " " + targetRange + newLine);
			
			for(int i = 0;i<numTests;i++)
			{
				int numConnect = (int)(Math.random() * maxEntriesPerTarget) + 1;
				out.write(numConnect + " ");
				for(int ip = 0;ip<numConnect;ip++)
				{
					int x = (int)(Math.random()*targetRange)+1;
					out.write(x+"");
					if(ip != numConnect-1)
						out.write(' ');
				}
				if(i!=numTests-1)
					out.write(newLine);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(out!=null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
   }

	public void generateProblem(int numTests,  
								        int targetRange,  // range is 0 to targetRange
								        int maxEntriesPerTarget,
								        double perc,
								        String fileName)
    {
		if(maxEntriesPerTarget*numTests < (targetRange*perc))
			throw new IllegalArgumentException("Not enough tests to cover the specified percentage of targets");
	
		//constants  CAPITALIZE THEM IF YOU WANT TO
  		float middAvg = (maxEntriesPerTarget+1)/2.0f;
  		int entriesNeeded = (int)(targetRange*perc + 0.5);   //rename this to unique targetsNeeded
  		//
		//Making and filling the int[] ArrayList
  		ArrayList<int[]> bGraph = new ArrayList<int[]>();
  		int targFilled = 0; 
		for(int i = 0;i<numTests;i++)
		{
			float avg = (float)(entriesNeeded-targFilled)/(numTests-i);
			float offset = (avg-middAvg); //SHOULD WE ROUND?
			int min = (int)(offset+middAvg+0.5), max = maxEntriesPerTarget;
			min = Math.max(1,min);
			//System.out.println("avg: " + avg + "  offset: " + offset + "   min: " + min + "  max: " + max);
			int [] bar = new int[(int)(Math.random()*(max-min+1))+min];
			targFilled+=bar.length;
			bGraph.add(bar);
		}
		ArrayList<int[]> temp = new ArrayList<int[]>();
		ArrayList<Integer> numberLine = new ArrayList<Integer>(); 
		for(int i = 1;i<=targetRange;i++)
			numberLine.add(i);
		for(int [] b:bGraph)
			temp.add(b);    // this adds the reference of the int[] in bGraph to the temp arrayList
		                    /* this way we can modify indices inside the int[] arrays in temp and they will be reflected in bGraph
		                      although when we remove a int[] from temp, it will not be removed from bGraph */
		while(temp.size() > 0){
			int ranIndex = (int)(Math.random() * temp.size());
			int ranTarg;
			if(numberLine.size() <= 0)
				ranTarg = (int)(Math.random() * targetRange) + 1;
			else{
				int ind = (int)Math.random()*numberLine.size();
				ranTarg = numberLine.get(ind); //this should be removing the index
				numberLine.remove(ind);
			}
			int [] tArray = temp.get(ranIndex);
			int i = 0;
			for(;i<tArray.length;i++)
				if(tArray[i]==0){
					tArray[i] = ranTarg;
					break;
				}
			if(i==tArray.length-1)
				temp.remove(ranIndex);
		}
		
		//writing to the file
		BufferedWriter out = null;
		try {
			String newLine  = System.getProperty("line.separator");
			out = new BufferedWriter(new PrintWriter(fileName));
			out.write(numTests + " " + targetRange + newLine);
			for(int i = 0;i<bGraph.size();i++){
				int [] a = bGraph.get(i);
				out.write(a.length + " ");
				for(int ip= 0;ip<a.length;ip++){
					out.write(a[ip]+"");
					if(ip!=a.length-1)
						out.write(" ");						
				}
				if(i != bGraph.size()-1)
					out.write(newLine);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(out!=null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//System.out.println("");
		/*for(int [] b : bGraph)
			System.out.println(Arrays.toString(b));*/
    }
}

