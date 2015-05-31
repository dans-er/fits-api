# fits-api
fits wrapped.

FITS (File Information Tool Set) is developed at Harvard. 
See [http://projects.iq.harvard.edu/fits](http://projects.iq.harvard.edu/fits)



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
