## !/bin/sh

mvn install:install-file -Dfile=lib/ebnfinjector.jar  -DgroupId=org.atl.eclipse.engine -DartifactId=ebnfinjector  -Dversion=1.13 -Dpackaging=jar
mvn install:install-file -Dfile=lib/ebnfextractor.jar -DgroupId=org.atl.eclipse.engine -DartifactId=ebnfextractor -Dversion=1.13 -Dpackaging=jar
mvn install:install-file -Dfile=lib/ATL-importer.jar  -DgroupId=org.atl.eclipse.engine -DartifactId=atl-importer  -Dversion=1.9  -Dpackaging=jar
