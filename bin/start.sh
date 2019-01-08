#TITLE=mockSystem

JAVA_OPTIONS="-Xmx128m -Xms128m"
export JAVA_OPTIONS

CLASSPATH=${CLASSPATH}:./lib/mock-0.0.1-SNAPSHOT.jar
export CLASSPATH

#DEBUG_PORT=11119
#export DEBUG_PORT
#export JAVA_HOME=/home/app/java/jdk1.6.0_45
#JAVA_DEBUG="-Xdebug -Xnoagent -Xrunjdwp:transport=dt_socket,address=${DEBUG_PORT},server=y,suspend=n"
#export JAVA_DEBUG

#${JAVA_HOME}/bin/java ${JAVA_OPTIONS}  -Dpackage.count=1 -Dcom.dc.esb.mock.path=./ -Dmock.classpath=./lib com.dc.esb.demo.SystemMockMain	 tellerGalaxy &

${JAVA_HOME}/bin/java -jar ./lib/mock-0.0.1-SNAPSHOT.jar