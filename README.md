Roll_20_Macro_Table_Tool README



# Reason for creating the program:

Roll 20 is a powerful system but there are limits to what you can do for free. 
This application is just one tool to make life a little bit easier while 
writing macros for character abilities. 




# How to use the tool:

First you need to have an idea of what you want to do. Using the tool if fairly straight forward if you have an idea of what you want to do.

You also need to understand half open ranges and interval notation... if you don't know what \[0, 5) means open the following link (http://www.coolmath.com/algebra/07-solving-inequalities/03-interval-notation-01).

Once you know what you want to do, You must create a input file. This will be a normal text file with any name and the .txt extension.  


Let's look at an example...

In D&D 5E Destroy Undead is a add-on to the Turn Undead Channel Divinity feature.
At various cleric levels you can destroy more and more powerful undead.
Before level 5 you don't have access to the destroy undead ability.

At level 5 you can destroy undead up to and including CR 1/2

At level 8 you can destroy undead up to and including CR 1

At level 11 you can destroy undead up to and including CR 2

At level 14 you can destroy undead up to and including CR 3

At level 17 you can destroy undead up to and including CR 4

Lets create the input file. We'll call it destroy_undead.txt

When we run the program it will need to be provided with an attribute.

In Roll20 attributes are statistics attached to a character sheet and it can be accessed
by typing something that looks like @{selected|**attribute_name**}, @{**character_name**|**attribute_name**}, or  @{**attribute_name**}. 

In this example the attribute is @{base_level}

We also need to indicate a range of vales and the value to be returned if the attribute is within that range.

\[lo,hi) -> value;

our input file will look like this:

@{base_level};

\[1,  5) -> -1; 

\[5,  8) -> 0.5;

\[8,  11) -> 1;

\[11, 14) -> 2;

\[14, 17) -> 3;

\[17, 21) -> 4;



We run the program by entering the following into cmd: 

java Block destroy_undead

when we run the program, a file will be made with the name destroy_undead_out.txt

You can copy the text in that file and use it as a math roll in a ability on a character sheet to show the max CR level of undead the player can destroy.


There are many ways to use this program, but the process is simple once you get uesed to it. I hope you find it helpful. 
