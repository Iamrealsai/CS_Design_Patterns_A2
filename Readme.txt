## CS 542 - Assignment 1

Name - Jerome Dinal Herath Muthukumaranage
B number - B00708543

Assuming you are in the directory containing this README:

## Initial steps:
Before cleaning, compiling & running follow the steps below:
	1. navigate into the directory myArrayList starting from
	the directory containing the README.txt
		(use cd myArrayList from terminal for linux)

## To clean:
ant -buildfile src/build.xml clean

--------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

--------------------------------------------------------
## To run by specifying arguments from command line

ant -buildfile src/build.xml run -Darg0=src/input.txt -Darg1=src/output.txt

(assuming the input file is "input.txt" & the ouput file "output.txt" and 
is within the src directory)
1. place any input text file within the src folder for the exact commands above to work. 
Otherwise please note that the absolute path to the respective input/ouput files must be given.
2. Assuming the ouput.txt file was not present at runtime then the program will create 
such a text file within the specified path.Even then the absolute path must be given.

--------------------------------------------------------
## Note :

1) The code is designed such that if a value that is not the required format(not int,<0,>10000)
 is observed within the input.txt document , it will ignore that value and traverse until the end of file. 
 This is done because there might be other values which are of the correct format after an incorrect one.
 However provided such a value was observed then a seperate output string will be printed on terminal 
 notifying the user that a value of incorrect format was observed within the text document.

2) The program identifies  both an empty text document with no values and a text document with 
 blank spaces 'only' as "empty". Provided such a case the program throws an exception and exits.

3) In case the entire text document completely contains incorrect input(string,double), then the program 
 would throw an exception and exit as well.

--------------------------------------------------------
"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 09/15/2017]

--------------------------------------------------------

justification for Data Structures used in this assignment in
term of Big O complexity

- The primary data structure used here is an array.
- There is no formal sorting algorithm used within the code.
	Justification:
		The program is designed such that for every insertion, a helper function identifies 
		the correct index for that insertion and then inserts that value, finally followed 
		by incrementing the rest of the values after it by one index. This could be done 
		because by specification the insertSorted() needs to maintain sorted order at each 
		iteration. Therefore a complete sort of the entire array is not needed as per the 
		standard sorting algorithms. With this approach the time complexity is: Big O(n).
- A similar method was utilized for the removeValue() as well where the index of the 
	first instance of the value was found along with the number of times it was repeated. 
	Based on these results the values(or value) was removed.

--------------------------------------------------------


