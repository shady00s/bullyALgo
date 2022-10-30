---------------------------------------Bully ALgorithm by shady safwat ---------------------------------------------------------


-FEATURES

	* let the user to choose the number of processes to be monitored
	* select the high ID process value automatically
	* when the coordinator process is failed , the application give the user choice to choose to
		 make automatic election(elect the biggest process id) or
	 	 make manual election (the user input the process id manually and if  
		 the process id is not exist the application will start over to check if the coordinator is back online.)

	* the application is build with clean code to maintain scalability and allowing to add more features

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




-HOW TO USE?

	* open directly in console

		in "excutable" folder , run runApp.bat to start the application.

	* open with vscode (with the executable file )
		 "excutable" folder, open vs code or cmd and type " java --enable-preview -jar .\bullyalgo.jar "
		
	* open with vscode (with the source code)
		in "source code/bullyalgo" folder, run vscode and type in vscode terminal and run the App class " press f5 and choose App.java class" 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


- DOCUMENTATION
	
	the technology that using in this project is  SOCKET to create server/client service to allowing for Multiple processing 
	
	there are two threads one is Server side and the second is client side, the client side is responsible for monitoring 
	
	every process behavioral and output the result to the user to make decisions that is compatable to the situation.

	