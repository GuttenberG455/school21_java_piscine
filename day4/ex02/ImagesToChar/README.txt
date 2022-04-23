    # Create target directory
mkdir target

    # Copy resources from src to target
cp -r src/resources target/.

    # Compile .java files into .class files, put them into target directory
javac -cp ".:./lib/JCDP-4.0.2.jar:./lib/jcommander-1.82.jar" -d ./target/ src/java/edu/school21/printer/*/*.java

    # Unpack lib jar files to target folder, keeping packages and subdir
cd target ; jar xf ../lib/JCDP-4.0.2.jar com ; jar xf ../lib/jcommander-1.82.jar com ; cd ..

    # Delete prevoius jar if exitst. Otherwise, there will be an invalid jarfile error
rm -f ./target/images-to-chars-printer.jar

    # Pack .class files, resources and a manifest file into a .jar file
jar -cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

    # Launch jar application:
java -jar target/images-to-chars-printer.jar --white=RED --black=GREEN