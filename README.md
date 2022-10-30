# Bully ALgorithm
## Features

- Lets the user to choose the number of processes to be monitored
- Select the high ID process value automatically
- When the coordinator process fails, the application give the user choice to choose to make automatic election(elect the biggest process id) or make manual election (the user input the process id manually and if the process id is not exist the application will start over to check if the coordinator is back online.)

- The application is build with clean code to maintain scalability and allowing to add more 

## How to use?

- Open directly in console, "excutable" folder.
  run runApp.bat to start the application.

- Open with VSCode (with the executable file), "excutable" folder, open vs code or cmd and type
 
java --enable-preview -jar .\bullyalgo.jar
		
- Open with vscode (with the source code) in "source code/bullyalgo" folder, run vscode and type in terminal and run the App class, press F5 and choose App.java class 

## Documentation
- The technology used in this project is Sockets to create server/client service to allow multiple processing.

- There are two threads one is server side and the second is client side, the client side is responsible for monitoring every process behavioral and output the result to the user to make decisions that is compatible to the situation.
