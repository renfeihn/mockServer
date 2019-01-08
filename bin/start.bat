@echo off & setlocal enabledelayedexpansion

set LIB_JARS=""
cd lib
for %%i in (*) do set LIB_JARS=!LIB_JARS!;lib\%%i

cd ..


java  -jar ./lib/mock-0.0.1-SNAPSHOT.jar

pause