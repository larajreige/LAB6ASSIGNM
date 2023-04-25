@echo off

REM Compile the Java file
javac -d . *.java

REM Normal case
echo Testing normal case...
java Lab lara.arxml
echo ----------------------------------------------------------------------------------
REM Not valid Autosar file case
echo Testing not valid Autosar file case...
java Lab lara.txt
echo ----------------------------------------------------------------------------------
REM Empty file case
echo Testing empty file case...
java Lab empty.arxml
echo ----------------------------------------------------------------------------------

REM Clean up compiled Java files
del LARA\*.class

pause