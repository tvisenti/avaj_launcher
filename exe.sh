# find *.java > sources.txt
# javac -sourcepath @sources.txt
javac Simulator.java
java Simulator scenario.txt
rm *.class
