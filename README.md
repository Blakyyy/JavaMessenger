Code Description

The task was to create a messenger application. A `MessageModel` was created, which implements the `ChatView` interface and describes all methods. `StartChat` begins a chat with a specified number of messages between two users. `chatMembers` utilizes the console for communication between two users. `outputChatInfo` records the entire chat in a `chatinfo.csv` file.

`UserModel` is where all user information is created. The methods include `writeToCSV` (to record user data in a CSV file), `tryToEnter` (to attempt logging into an account), and `BanAccount` (a method for banning an account).

Code Improvement
-   There are `if-else` blocks that should be broken down into methods for better optimization.
-   Handling exceptions directly is better than throwing them up to the `main` function.
-   Additional functionality should be added, such as registering new users and the ability to communicate in groups.
