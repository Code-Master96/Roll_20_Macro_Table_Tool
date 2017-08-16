Roll_20_Macro_Table_Tool README



# Reason for creating the program:

Roll 20 is a powerful system but there are limits to what you can do for free. 
This application is just one tool to make life a little bit easier while 
writing macros for character abilities. 



# How to install the tool:

1) Start by downloading the main.cpp file.

2) If you don't know how to compile a .cpp file into an executible, please perform a google search on how to compile a .cpp file on your operating system.

3) If you have not already, install a compiler

4) Use your cpp compiler to it to create a executible file.

5) Run that file in a command line environment.



# How to use the tool:

First you need to have an idea of what you want to do. Using the tool if fairly straight forward if you have an idea of what you want to do.

You also need to understand half open ranges and interval notation... if you don't know what \[0, 5) means open the following link (http://www.coolmath.com/algebra/07-solving-inequalities/03-interval-notation-01).

Once you know what you want to do, just follow the prompts in the program to get the math roll generated. It's easier to understand when you see it in action. 


Here's an example...

In D&D 5E Destroy Undead is a add-on to the Turn Undead Channel Divinity feature.
At various cleric levels you can destroy more and more powerful undead.
Before level 5 you don't have access to the destroy undead ability.

At level 5 you can destroy undead up to and including CR 1/2

At level 8 you can destroy undead up to and including CR 1

At level 11 you can destroy undead up to and including CR 2

At level 14 you can destroy undead up to and including CR 3

At level 17 you can destroy undead up to and including CR 4

When we run the program it will ask for an attribute.

In Roll20 attributes are statistics attached to a character sheet and it can be accessed
by typing something that looks like @{selected|**attribute_name**} or @{**character_name**|**attribute_name**}

Enter that for what your dependent variable is. 

Lets say this is for our cleric named Tod. We will enter @{Tod|level}

After that we are asked to enter in x, y, and r according to the formula \[x, y) --> r

Basically x is the first level that you gane the result r and y is the first level that you have a different result r.

What we want is the following:

\[1,  5) --> -1 

\[5,  8) --> 0.5

\[8,  11) --> 1

\[11, 14) --> 2

\[14, 17) --> 3

\[17, 21) --> 4


you will see the following:


\[x,y) --> r

Enter x:

At this point you enter 1.

Then you will see a prompt asking for y.

Enter 5.

Finally the program askes you for r.

Enter -1 because we want to know that no CR is able to be destroyed.

Assuming that you entered everything properly with no errors, it will ask you if your done. The answer is no because we have many ranges to cover yet.


After you are done entering all the needed data just answer "y" when asked if you are done.

At that point you will get output like the following:

\[\[round(100*(-1.000000*((abs(@{Tod|level} - 1.000000 + 0.001)+ @{Tod|level}-1.000000+0.001)/0.002 - (abs(@{Tod|level}-1.000000)+@{Tod|level}-1.000000)/0.002- (abs(@{Tod|level} - 5.000000+ 0.001)+@{Tod|level}-5.000000+0.001)/0.002 + (abs(@{Tod|level}-5.000000)+@{Tod|level}-5.000000)/0.002)+0.500000*((abs(@{Tod|level} - 5.000000 + 0.001)+ @{Tod|level}-5.000000+0.001)/0.002 - (abs(@{Tod|level}-5.000000)+@{Tod|level}-5.000000)/0.002- (abs(@{Tod|level} - 8.000000+ 0.001)+@{Tod|level}-8.000000+0.001)/0.002 + (abs(@{Tod|level}-8.000000)+@{Tod|level}-8.000000)/0.002)+1.000000*((abs(@{Tod|level} - 8.000000 + 0.001)+ @{Tod|level}-8.000000+0.001)/0.002 - (abs(@{Tod|level}-8.000000)+@{Tod|level}-8.000000)/0.002- (abs(@{Tod|level} - 11.000000+ 0.001)+@{Tod|level}-11.000000+0.001)/0.002 + (abs(@{Tod|level}-11.000000)+@{Tod|level}-11.000000)/0.002)+2.000000*((abs(@{Tod|level} - 11.000000 + 0.001)+ @{Tod|level}-11.000000+0.001)/0.002 - (abs(@{Tod|level}-11.000000)+@{Tod|level}-11.000000)/0.002- (abs(@{Tod|level} - 14.000000+ 0.001)+@{Tod|level}-14.000000+0.001)/0.002 + (abs(@{Tod|level}-14.000000)+@{Tod|level}-14.000000)/0.002)+3.000000*((abs(@{Tod|level} - 14.000000 + 0.001)+ @{Tod|level}-14.000000+0.001)/0.002 - (abs(@{Tod|level}-14.000000)+@{Tod|level}-14.000000)/0.002- (abs(@{Tod|level} - 17.000000+ 0.001)+@{Tod|level}-17.000000+0.001)/0.002 + (abs(@{Tod|level}-17.000000)+@{Tod|level}-17.000000)/0.002)+4.000000*((abs(@{Tod|level} - 17.000000 + 0.001)+ @{Tod|level}-17.000000+0.001)/0.002 - (abs(@{Tod|level}-17.000000)+@{Tod|level}-17.000000)/0.002- (abs(@{Tod|level} - 21.000000+ 0.001)+@{Tod|level}-21.000000+0.001)/0.002 + (abs(@{Tod|level}-21.000000)+@{Tod|level}-21.000000)/0.002)))/100]]

You can copy this text and use it as a math roll in a macro to show the max CR level of undead you can destroy.


There are many ways to use this program, but the process is simple once you get uesed to it. I hope you find it helpful. 
