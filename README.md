# fits-api
fits wrapped.

FITS (File Information Tool Set) is developed at Harvard. 
See [http://projects.iq.harvard.edu/fits](http://projects.iq.harvard.edu/fits)

The tool set is somehow a bit awkward to use from a Maven project. This
small project wraps an instance of Fits and handles dependency management.


## Managing Dependencies
FITS comes with a lot of dependencies on third party jars.
All of these dependencies are in the FITS download which is
incorporated in this code base under fits-{version}.
An easy way to integrate these dependencies with the maven
life cycle is by using the plugin
_com.googlecode.addjars-maven-plugin_. It will add all of
the jars found recursively at a given location to your local
.m2 repository. In fact you only need to run a maven install 
once, after that the addjars-maven-plugin can safely be 
commented out.

## Building the project
After cloning this project to local disk, follow these steps:

- Comment out the dependency section in the `pom.xml` between

			START dependencies added to .m2 by addjars-maven-plugin
			...
			END dependencies added to .m2 by addjars-maven-plugin

- Built the project from the command line: 

			$ mvn clean install

- Before opening the project under an editor like Eclipse, undo the commenting out from step 1.
