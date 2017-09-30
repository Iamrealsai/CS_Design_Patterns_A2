package studentCoursesBackup.driver;

import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;

public class Driver 
{

    public static void main(String[] args) 
    {

	//Name - Jerome Dinal Herath Muthukumaranage
	//B no - B00708543
	
	System.out.println("Hello World: " + args[0] + ", " + args[1] + ", " + args[2]+", "+args[3]+", "+args[4]);

	String s1="src/input.txt";
	String s2="src/delete.txt";
	String s3="src/o1.txt";
	String s4="src/o2.txt";
	String s5="arc/o3.txt";
	TreeBuilder myTreeBuilder = new TreeBuilder(s1,s2);
	Results output1 = new Results(s3);//main tree
	//Results output2 = new Results(s4);//backup tree 1
	//Results output3 = new Results(s5);//backup tree 2

	//---------------for master tree-------------------
	output1.storeNewResult(myTreeBuilder.getTree(0).printNodes());
	output1.writeToFile();
	//output1.writeToFile(output1.getResults(output1.storeNewResult(myTreeBuilder.getTree(0).printNodes())));
	//---------------for backup 1-----------------------
	//output2.storeNewResult(myTreeBuilder.getTree(1).printNodes());
	//output2.writeToFile(output2.getResults());
	//--------------for backup 2----------------------
	//output3.storeNewResult(myTreeBuilder.getTree(2).printNodes());
	//output3.writeToFile(output3.getResults());
    }
	
}
