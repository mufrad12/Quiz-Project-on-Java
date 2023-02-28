# Quiz-Project-on-Java

A simple java quiz project where createing a quiz program that will take questions, option and answer from admin user and save it to the question bank. Then if any user want to give the quiz, random 5 questions will be shown to the user from the question bank.

## Prerequisite tools:
- JDK
- Intellij Idea
- Gradle 


## Program output:

1. Add Quiz

2. Start Quiz

if user select option 1, then system will tell user to input a question, 4 options and correct ans to save data in a quiz bank. The quiz bank will be a json file. For an example,

System>Please add a ques here:

User>Which testing is done by developer?

System>Input options.

Option a:

User> Unit Testing

Option b:

User> Integration Testing

Option c:

User> Sanity Testing

Option d:

User> Regression Testing

System> Please input the correct ans

User> a

System: Quiz saved at the database. Do you want to add more? (y/n)

if user press y, then the previous scenario will happen again otherwise the program will be closed.

If user select option 2,  then,

System> You will be asked 5 questions, each questions has 1 marks

1. Which testing is done by developer?

a. Unit Testing

b. Integration Testing

c. Sanity Testing

d. Regression Testing

User> a

System> Correct!

else not correct,

System: Not correct

Finally 5 different random questions will appear from your question database. At least add 15 questions from any category from testing.

Result: You got [correct_marks] out of 5


## Video of the Project: 


https://user-images.githubusercontent.com/58912515/221962817-a9ddddb4-81be-4169-9d9b-b962a010a318.mp4


