## !/bin/sh

mvn deploy:deploy-file -DrepositoryId=andromda-repository -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2 -Dfile=lib/ebnfinjector.jar  -DgroupId=org.eclipse.m2m.atl.engine -DartifactId=ebnfinjector  -Dversion=1.1 -Dpackaging=jar -DgeneratePom=true
mvn deploy:deploy-file -DrepositoryId=andromda-repository -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2 -Dfile=lib/ebnfextractor.jar -DgroupId=org.eclipse.m2m.atl.engine -DartifactId=ebnfextractor -Dversion=1.1 -Dpackaging=jar -DgeneratePom=true
mvn deploy:deploy-file -DrepositoryId=andromda-repository -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2 -Dfile=lib/ATL-importer.jar  -DgroupId=org.eclipse.m2m.atl.engine -DartifactId=atl-importer  -Dversion=1.2  -Dpackaging=jar -DgeneratePom=true

