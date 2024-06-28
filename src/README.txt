How to run my solution:
- Unzip the file and open in IntelliJ or some other code editor
- Make sure all the files are present, and then run the MainCall.java file
- The code should work successfully after this step!

My thought process for designing this program:
- The Java portion of this code is similar to code that I have written for OOD and Fundies 2, and
  it wasn't that hard for me to think of how the different parts should be connected in my code.
- I wanted to make several separate classes to split up the code and make it more readable, which
  is why I made two Comparator classes and separate classes for the main call and initialization.
- I also chose to use a lot of helper methods to improve readability of my code, and this also
  helped me a lot when I was debugging my code.
- I ended up making a static field in my Initializer class so that I could access all the
  participants, sessions, and rounds when I was running my program through a call to the static field.
- I've worked with HashMaps and ArrayLists a lot recently, so I decided to use those often in my code
  instead of other forms of data structure because that was an efficient way for me to store my data.

Technical problems that I encountered:
- This was my first time dealing with API calls, and it took me a while to figure out how they worked.
  I had to do a lot of YouTube consulting and trial and error to figure out what went in the
  different parts of the HttpRequest.
- I had to change my original design a bit once I realized that the fields of certain classes
  had to align with the different parts of the JSON that is passed in/returned.
- I wanted to keep my data as private as possible, so I had to figure out how to access the private
  components when necessary while still minimizing how often that private data was accessed.
- I had to figure out how to represent the averageRoundScore and averageSessionDuration fields
  in the FinalJson file so that they could be either doubles or Strings, and I eventually
  realized that I could make these fields have type Object.

Approximate time that it took me to complete this project:
- Around 5 hours