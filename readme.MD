Homework 6: Return of the Music Library

In this assignment, we'll be returning to and extending the Music Library to support more playlist functionality, 
and also reading and writing libraries and playlists with XML and JSON. I've included the starter code from Lab 3; if you would prefer to use the code you wrote for this lab, please feel free!

The assignment also includes two sample music libraries - one in XML and one in JSON. Please feel free to modify or extend the format of these files to fit the needs of your application.

This homework will be graded using specifications grading. There are a sequence of tasks to complete. Grades will be assigned as follows:

    To receive a C, you should complete tasks 1-4
    To receive a B, complete all the C-level tasks, plus tasks 5.
    To receive an A, complete the B-level tasks, plus tasks 6 and 7.



I've provided the instructions at a higher level than in some homeworks, and left you some decisions about how to meet the requirements. You can choose how to best solve these tasks using the concepts and tools we've learned about. Please provide a JUnit class(es) that demonstrate how your program works.

1. To begin, read in music-library.xml using the DOM parser and fill in the library, creating a Song, Artist or Album for each appropriate node.

2. Now let's write a function to read in music-library.json. To do this, you'll need to use [json-simple](https://code.google.com/archive/p/json-simple/). This will also give you some practice installing an external package and managing your classpath.

3. Find duplicates. Back in Lab 3, we implemented equals() for Songs, Artists and Albums. Let's use this to implement a method that will help users find duplicate songs. It should do the following:

- Look through the library, find all songs that are *definitely* duplicates, prompt the user to confirm and then, (if they say yes) delete them.
- Look through the library and find all songs that are *possibly* duplicates and, for each one, prompt the user to see if it should be kept or deleted. Songs are possibly duplicates if:
  - The have the same name and either artist or album is the same.
  - They have the same artist and album, and the names are the same if converted to lower case and punctuation is ignored.
  - Please provide a JUnit test demonstrating that this works.

4. In Lab 3, we started implementing a Playlist class. You may re-use that code, or build a new one if you prefer. Extend this to add the following functionality:
   - add a song to a playlist.
   - Merge two playlists. (remove duplicates!)
   - delete a song from a playlist.
   - Sort the playlist so that the songs that are most liked are at the front.
   - Randomly shuffle the playlist.
   - Please provide JUnit tests for this functionality.   

5. Now, let's add a function to generate a random playlist. 
   - First, choose an additional feature to add to the Song class. Possibilities include: genre, BPM (beats per minutes), likes, hasBeenPlayed, or mood. 
   - Then, implement a method that creates a random playlist based on a value for this feature. (for example, songs where genre="jazz", or where BPM>120.)
   - Again, provide a JUnit test to demonstrate that this works.
   
6. Now implement methods to: write a playlist out to a file as XML, and write the entire library out as XML.

7. Now, implement methods to: write a playlist out to a file as JSON, and write the entire library out as JSON.

