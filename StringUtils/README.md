=> To Create a maven project by using command prompt or Terminal  fallow these commands <==
=> By using "CD WorkLocation" change the dirctrory
=> Check maven version using mvn -v command
=> Create maven project by using this command

                   --> mvn archetype:generate -DgroupId=com.wipro.topgear

                    -DartifactId=Maven

                    -DarchetypeArtifactId=maven-archetype-quickstart

                    -DinteractiveMode=false

=> Given this command for clean installation”mvn clean package”.
=> Open the IDE and import the files as a maven existing file and adding the fallowing dependencies to pom.xmlfile.
    -->apache-commons-lang
    -->maven-pluginn
=> Create a main class and some stringUtil operationds to print string witout spaces.

=> Run the jar file at target folder with command.

   -->java -jar YOUR_PROJECT_QUALIFIED_NAME.

=>After this excuse test class.

   -->mvn test

LEARNNGS FROM ASSIGNMENT:
--> Creating maven project using terminal
--> Adding dependencies to POM.xml file
--> Using stringUtil class 
--> Executing the target jar file 