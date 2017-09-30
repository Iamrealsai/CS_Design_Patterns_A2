## CS 542 - Assignment 2

Name - Jerome Dinal Herath Muthukumaranage
B number - B00708543
email - jherath1@binghamton.edu

Assuming you are in the directory containing this README:

## Initial steps:
Before cleaning, compiling & running follow the steps below:
	1. navigate into the directory studentcoursesbackup starting from
	the directory containing the README.txt
		(use cd studentcoursesbackup from terminal for linux)

## To clean:
ant -buildfile src/build.xml clean

--------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

--------------------------------------------------------
## To run by specifying arguments from command line

ant -buildfile src/build.xml run -Darg0=src/input.txt -Darg1=src/delete.txt -Darg2=src/output1.txt -Darg3=src/output2.txt -Darg4=src/output4.txt

(assuming the input file is "input.txt" , the file with courses to be deleted is "delete.txt"
and the respective output files for the three trees are output1.txt,output2.txt & output3.txt
within the src/ directory)

1.place these five text files within the src folder for the exact commands to work.
Otherwise please note that the absolute path for  files must be given.
2. Assuming the output.txt files was not present at runtime then the program will create 
such a text file within the specified path.Even then the absolute path must be given.

--------------------------------------------------------
## Note :



--------------------------------------------------------
"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.”

[Date: 10/03/2017]

--------------------------------------------------------

justification for Data Structures used in this assignment in
term of Big O complexity



--------------------------------------------------------


