# Java 9 modularity: First look.

Module system is one of the biggest changes to Java ever.

HTTP/2 Client, updates to Stream APIs, Collection Factories are additional
features.

  

  1. Creating modules
  2. Working with Modules
  3. Services in a Modular world
  4. The All-new Linking Phase
  5. Getting your code ready for Java 9

  

What is modularity and why it is so important?

  

Content:

The modular JDK

Java Module system concepts

The example: Introducing easy text

Build the example

  

Benefits:

Strong encapsulation

Well-defined interfaces

Explicit dependencies

  

Old system:

One huge library - rt.jar

Many entangled classes

Restricted by backwards compatibility

  

New system:

\- Explicit dependecies

\- Every one module has implicit dependency on java.base module

  

 **3 tenents of modularity** :

\- explicit dependencies (A module lists what it needs from other modules)

\- strong encapsulation (Hide your internals, be strict about what is public
API)

\- well defined interfaces (When modules interact, use stable and well-defined
interfaces)

  

A module has:

1 - public interfaces section. It means every modules depending on this module
will be able to use all public interfaces in this module.

2 - names of internal packages. Strong encapsulation in modular system.

  

  

Module defines by module descriptor.

Declarations should be in the file module-info.java :

module <name > {

**exports** java.lang; // exports - uses package name

**exports** java.utils [ **to** <module name>];

...

**requires** [ **transitive** | **public** | **mandated** ] java.logging; //
dependencies - takes module name

**requires** java.xml;

...

**conceals** com.sun.javafx.charts;

...

**uses** com.api.MyService;

...

**provides** com.api.MyService **with** myProvider.MyServiceImpl; //
_**without export !!!!!**_

}

  

Module resolution process.

\- Checks module path for correctness

\- During compile & run-time

\- For application and platform modules

\- Rejects multiple versions of the same module

\- Multiple root modules possible

  

For testing, questions flow:

\- Can we read the module

\- Do you have require statement

\- Is the package exported

\- Is the type public

  

  

Readability relation is not transitive by default.

  

Implied Readability

requires **transitive** <module name>;

requires **public** <module name>;

requires **mandated** <module name>;

  

Introducing services

1) Service provider (it provides)

2) Service catalog/registry

3) Service consumer (it uses)

  

What's wrong with regular code?

It depends on implementation, not an interface

Implementation class needs to be exported

Tight coupling from front-ends to analysis module

Not extensible

  

  

Linking.

  

Tool - jlink

Usually two fases: compillation and executing.

Linking is completely optional.

  

The main goal is to create - Custom runtime image.

It will be smaller

perfomance

  

jlink --module-path jars/:$JAVA_HOME/jmods --add-modules
easytext.cli,easytext.analysis.coleman,easytext.analysis.kincaid --strip-debug
--compress=2 --output image --launcher
launch=easytext.cli/javamodularity.easytext.cli.Main

  

  

Preparing for Java 9.

  

javac --add-exports java.base/sun.security.x509=ALL-UNNAMED Main.java

java --add-exports java.base/sun.security.x509=ALL-UNNAMED Main

  

Be default in an old fashion application that is using classpath only java.se
module is available.

All the other modules you should add explicitly.

  

1 Add all non-modular JAR to module path (into a folder)

2 Name derived from JAR filename

3 These JAR will export all packages

  

module application {

requires commons.lang; // for commons-langX-X.X.jar

}

  

javac --module-path lib --module-source-path ......

java --module-path lib:out -m application/.......

  

  


---
### NOTE ATTRIBUTES
>Created Date: 2017-12-09 00:11:45  
>Last Evernote Update Date: 2017-12-13 23:22:59  
>author: eim226  
>reminder-order: 0  