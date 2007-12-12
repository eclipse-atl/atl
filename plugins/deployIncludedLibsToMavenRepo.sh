#
# This is a script to upload the jar files inside the lib directories which are
# not present in the 'central' maven repository.
#
mvn deploy:deploy-file -DgroupId=antlr \
        -DartifactId=antlr-runtime \
        -Dversion=3.0 \
        -Dpackaging=jar \
        -Dfile=org.eclipse.m2m.atl.engine/lib/antlr-runtime-3.0.jar \
        -DrepositoryId=andromda-repository \
        -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2

mvn deploy:deploy-file -DgroupId=org.eclipse.gmt.tcs \
        -DartifactId=tcs-extractor \
        -Dversion=1.0.0 \
        -Dpackaging=jar \
        -Dfile=org.eclipse.m2m.atl.engine/lib/org.eclipse.gmt.tcs.extractor_1.0.0.jar \
        -DrepositoryId=andromda-repository \
        -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2

mvn deploy:deploy-file -DgroupId=org.eclipse.gmt.tcs \
        -DartifactId=tcs-injector \
        -Dversion=1.0.0 \
        -Dpackaging=jar \
        -Dfile=org.eclipse.m2m.atl.engine/lib/org.eclipse.gmt.tcs.injector_1.0.0.jar \
        -DrepositoryId=andromda-repository \
        -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2

mvn deploy:deploy-file -DgroupId=org.eclipse.m2m.atl.engine \
        -DartifactId=atl-parser \
        -Dversion=1.6 \
        -Dpackaging=jar \
        -Dfile=org.eclipse.m2m.atl.engine/lib/ATL-parser.jar \
        -DrepositoryId=andromda-repository \
        -Durl=scp://galaxy.andromda.org/var/www/andromda/maven2
