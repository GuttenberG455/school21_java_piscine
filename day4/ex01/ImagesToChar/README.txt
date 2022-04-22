    # Create target directory
mkdir target

    # Compile .java files into .class files and put into directory target
javac -d ./target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/Logic.java

    # Copy resources from src to target
cp -r src/resources target/.

    # Pack .class files, resources and a manifest file into a .jar file
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

  # Launch jar application:
java -jar target/images-to-chars-printer.jar . $