======================================================================
	Knopflerfish Release  3.6.0
======================================================================

Contents:
----------------------------------------
 README.txt       - this file.
 release_notes.*  - the release notes for the current release.
 changelog.html   - the subversion change log for this release.
 NOTICE.txt       - notice file on included third party software.
 LICENSE.txt      - the Knopflerfish license.

 ant              - Ant related code and build include files.
 docs             - online documentation (html),
 docs/index.html  - Starting point for reading the documentation.
 osgi             - all OSGi related code.
 osgi/bundles     - bundles included in distribution.
 osgi/bundles_opt - some extra bundles.
 osgi/framework   - core OSGi framework.
 osgi/jars        - Precompiled bundles.
 osgi/test_jars   - Precompiled JUnit test suite bundles.


Basic: How to start
----------------------------------------
 Prerequisites

   - JRE 1.3 (1.4 if you want security) or later, available from
     java.sun.com 

1. Step into the osgi dir
2. Start the OSGi framework by:
   > java -jar framework.jar

3. This starts the framework + a large set of bundles, including
   the desktop


Building:
----------------------------------------
 Prerequisites

   - JDK 1.3(1.4 if you want security) or later, available from java.sun.com
   - Ant 1.7 or later, available from ant.apache.org
   - openssl, to create and manipulate certificates when using
     security and the Conditional Permission Admin (CPA) service. Test
     suites for CPA can not be built and executed without openssl.


1. Step into the osgi dir
2. Start the build by:
   > ant all
