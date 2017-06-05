find *.java > sources.txt
javac @sources.txt
# javac Simulator.java
java Simulator scenario.txt
rm *.class sources.txt
