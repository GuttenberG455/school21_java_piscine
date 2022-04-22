mkdir target

#   Set destination path to class files and compiling the program

javac -d ./target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/Logic.java

#   Specify path for user class files and run the program with correct arguments

java -cp ./target/ edu.school21.printer.app.Main . X ./../it.bmp
