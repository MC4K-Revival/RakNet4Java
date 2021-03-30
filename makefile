VERSION:=v0.0.1

all: config
	javac -Xlint:deprecation -d build @sources.txt
	cd build && jar cfm RakNet4Java.jar ../Manifest.txt .

config:
	mkdir -p ./build
