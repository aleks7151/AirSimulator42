find . -name "*.java" > sources.txt
javac @sources.txt
rm -rf sources.txt
java -cp ./src simulator/Simulator42 ./scenario.txt
rm -rf $(find . -name "*.class")
exit
