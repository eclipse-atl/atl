## !/bin/sh

mvn deploy:deploy-file -DrepositoryId=andromda-repository -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2 -Dfile=lib/ebnfinjector.jar  -DgroupId=org.atl.eclipse.engine -DartifactId=ebnfinjector  -Dversion=1.13 -Dpackaging=jar -DgeneratePom=true
mvn deploy:deploy-file -DrepositoryId=andromda-repository -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2 -Dfile=lib/ebnfextractor.jar -DgroupId=org.atl.eclipse.engine -DartifactId=ebnfextractor -Dversion=1.14 -Dpackaging=jar -DgeneratePom=true
mvn deploy:deploy-file -DrepositoryId=andromda-repository -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2 -Dfile=lib/ATL-importer.jar  -DgroupId=org.atl.eclipse.engine -DartifactId=atl-importer  -Dversion=1.9  -Dpackaging=jar -DgeneratePom=true

