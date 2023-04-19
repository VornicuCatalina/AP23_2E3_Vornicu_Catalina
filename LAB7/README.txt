--------------------
*****COMPULSORY*****
--------------------
+ I used the slides, for implementing the model of the classes

+ For moving randomly, I used the property Math.rand() * sizeOfTheMap twice, once for the row, and once for the column.
    The robot has an attribute called name for the name.
    I display more messages : for checking if the program works properly: "It is empty" - has no tokens ; "This cell has been visited before" - in the visited matrix, another bot already went there ; "<robotName> <msg>" - when it is the first time visiting it
    For the extracting, I wrote a function that does this
    Whenever it reaches a cell that is empty -> the thread is stopped

+ I simulated that by using "new Thread(robot).start();" -> working as it should do

------------------
*****HOMEWORK*****
------------------
+ added 2 functions that help me with those in a while loop i check the commands from the keyboard by using the Scanner class

-----PROOF THAT IT WORKS-----
start R2D2
R2D2 started its execution!
New cell has been explored by robot R2D2 at cords 0 and 3
New cell has been explored by robot R2D2 at cords 1 and 4
R2D2 finished its execution
start R2D2
R2D2 started its execution!
New cell has been explored by robot R2D2 at cords 3 and 4
New cell has been explored by robot R2D2 at cords 4 and 0
New cell has been explored by robot R2D2 at cords 2 and 0
R2D2 finished its execution
-----------------------------
    YOU MUST WRITE "done"   when you do not write to make them start or stop.

+ I only think about the fact that each robot will take its own line , and after finishing it -> will take another free one (current line + number of bots)

+ created a thread : ThreadCount that will be called whenever the program starts: exploration ; and if it takes longer than 3mins for the program
to end -> it will stop automatically

+ I have a function that calculates the number of tokens saved in the matrix & i add it in a local variable in the Robot class -> after finishing the execution : shows the number of tokens as well
---------------
*****BONUS*****
---------------
+ 