find *.java > sources.txt
javac @sources.txt
java Simulator scenario.txt
rm *.class sources.txt
cat simulation.txt