# Roll_20_Macro_table_tool



# Reason for creating the program:

Roll 20 is a powerful system but there are limits to what you can do for free. 
This application is just one tool to make life a little bit easier while 
writing macros for character abilities. 



# How to install the tool:

Please perform a google search on how to compile a .cpp file.
Install a compiler and use it to create a .exe file.
Run that file in a command line environment.



# How to use the tool:

First you need to have an idea of what you want to do.
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

After entering all the needed data just answer "y" when asked if you are done.

You will get output like the following:

\[\[round(100*(-1.000000*((abs(@{Tod|level} - 1.000000 + 0.001)+ @{Tod|level}-1.000000+0.001)/0.002 - (abs(@{Tod|level}-1.000000)+@{Tod|level}-1.000000)/0.002- (abs(@{Tod|level} - 5.000000+ 0.001)+@{Tod|level}-5.000000+0.001)/0.002 + (abs(@{Tod|level}-5.000000)+@{Tod|level}-5.000000)/0.002)+0.500000*((abs(@{Tod|level} - 5.000000 + 0.001)+ @{Tod|level}-5.000000+0.001)/0.002 - (abs(@{Tod|level}-5.000000)+@{Tod|level}-5.000000)/0.002- (abs(@{Tod|level} - 8.000000+ 0.001)+@{Tod|level}-8.000000+0.001)/0.002 + (abs(@{Tod|level}-8.000000)+@{Tod|level}-8.000000)/0.002)+1.000000*((abs(@{Tod|level} - 8.000000 + 0.001)+ @{Tod|level}-8.000000+0.001)/0.002 - (abs(@{Tod|level}-8.000000)+@{Tod|level}-8.000000)/0.002- (abs(@{Tod|level} - 11.000000+ 0.001)+@{Tod|level}-11.000000+0.001)/0.002 + (abs(@{Tod|level}-11.000000)+@{Tod|level}-11.000000)/0.002)+2.000000*((abs(@{Tod|level} - 11.000000 + 0.001)+ @{Tod|level}-11.000000+0.001)/0.002 - (abs(@{Tod|level}-11.000000)+@{Tod|level}-11.000000)/0.002- (abs(@{Tod|level} - 14.000000+ 0.001)+@{Tod|level}-14.000000+0.001)/0.002 + (abs(@{Tod|level}-14.000000)+@{Tod|level}-14.000000)/0.002)+3.000000*((abs(@{Tod|level} - 14.000000 + 0.001)+ @{Tod|level}-14.000000+0.001)/0.002 - (abs(@{Tod|level}-14.000000)+@{Tod|level}-14.000000)/0.002- (abs(@{Tod|level} - 17.000000+ 0.001)+@{Tod|level}-17.000000+0.001)/0.002 + (abs(@{Tod|level}-17.000000)+@{Tod|level}-17.000000)/0.002)+4.000000*((abs(@{Tod|level} - 17.000000 + 0.001)+ @{Tod|level}-17.000000+0.001)/0.002 - (abs(@{Tod|level}-17.000000)+@{Tod|level}-17.000000)/0.002- (abs(@{Tod|level} - 21.000000+ 0.001)+@{Tod|level}-21.000000+0.001)/0.002 + (abs(@{Tod|level}-21.000000)+@{Tod|level}-21.000000)/0.002)))/100]]

You can copy this text and use it as a math roll in a macro to show the max CR level of undead you can destroy.
