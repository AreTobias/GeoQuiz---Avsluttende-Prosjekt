# GeoQuiz

This is a school project which is designed to create a quiz for a user based on geographical questions, and also an administrator gui to create and delete users and questions.

The project is written in Java and uses a mySQL database.

The program consists of two main interfaces and one smaller one. The two main ones are one for the user of the application to perform quizes and the other is for an administrator to add questions or create or delete users.
The third minor interface is for self registration.




The API I've used to create and validate quiz questions and answers: https://restcountries.com/

Examples:
- What capital does Norway have?
1) Oslo | 2) Berlin | 3) Copenhagen | 4) Paris

- In what region is France located?
1) South-east asia | 2) Europe | 3) South-america | 4) Oceania

- Whats the population of Portugal?
1) 1234123 | 2) 1237 | 3) 1238129 | 4) 9182

- In what country do we find the capital Moscow?
1) China | 2) Bosnia | 3) Russia | 4) Spain


Known errors:

- Performance issues doing GET requests to the dabase
- Performance issues doing GET requests to the API
- Missing score tracker after quiz iz finished
- Its not hosted and won't run on other machines currently - Need to implement a standard username and password for both user and admin GUI.
