package studentCoursesBackup.driver;

import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;

public class Driver 
{

    public static void main(String[] args) 
    {

	//Name - Jerome Dinal Herath Muthukumaranage
	//B no - B00708543
	//check for no of arugments 
	System.out.println("Hello World: " + args[0] + ", " + args[1] + ", " + args[2]+", "+args[3]+", "+args[4]);
	TreeBuilder myTreeBuilder = new TreeBuilder(args[0],args[1]);
	Results output1 = new Results(args[2]);//main tree
	Results output2 = new Results(args[3]);//backup tree 1
	Results output3 = new Results(args[4]);//backup tree 2

	//---------------for master tree-------------------
	output1.storeNewResult(myTreeBuilder.getTree(0).printNodes());
	output1.writeToFile();
	//output1.writeToFile(output1.getResults(output1.storeNewResult(myTreeBuilder.getTree(0).printNodes())));
	//---------------for backup 1-----------------------
	output2.storeNewResult(myTreeBuilder.getTree(1).printNodes());
	output2.writeToFile();
	//--------------for backup 2----------------------
	output3.storeNewResult(myTreeBuilder.getTree(2).printNodes());
	output3.writeToFile();
    }
	
}
