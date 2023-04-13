--------------------
*****COMPULSORY*****
--------------------
+ For the first 2 points I have just used what was mostly in the slides

+ For drawing the lines, I used the function graphics.drawLine(parameters) and for the circles: graphics.drawOval(parameters) & graphics.fillOval(parameters)

+For those buttons I used setLayout(new GridLayout(1,4))
for placing all the buttons on the same row on 4 columns

------------------
*****HOMEWORK*****
------------------
+ I did that by implementing every single aspect of the game: from the buttons above to the restart option & quit

+ I used this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { ...});

so whenever the mouse is clicked / pressed something will happen

	It can also tell when somebody wins.

+ The PNG file will be showed after the game is finished : somebody won & the screen is clicked one more time -> it works this way

when someone wins /it is draw -> calls the function savePNG() which does this, a screenshot of the current game and saves it in the folder png/pic.png

+ for the serialization, I created a new class SerializationHelper just because the Serializable interface does not work with graphics. This way I will save the important component of the game in this new class, and by using it I will save the game , also load it (while loading it just recreates everything using the map, in which I saved the colors =))

---------------
*****BONUS*****
---------------
+ The AI is represented in the function decideMove() where it decides which move is the best . It is pretty difficult to win against a bot that stops you from winning.

+ It is represented in countingTriangles() , where the triangles are counted and the result is saved in a linkedList, for easier ways to check if it was already counted as a triangle before.