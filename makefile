
SRCDIR = src
BINDIR = bin
DOCDIR = doc
TESTDIR = test

JUNIT = ./gson/gson-2.8.6.jar -sourcepath ./src ./src/$*.java


JAVAC = javac
JFLAGS = -g -d $(BINDIR) -cp $(BINDIR)

#to check the src and test folders for the .java files
#also to ensure that class files are in bin 
vpath %.java $(SRCDIR):$(TESTDIR)
vpath %.class $(BINDIR)

.SUFFIXES: .java .class

.java.class:
	$(JAVAC) $(JFLAGS) $<

classes: DatabaseUser.class  Images.class  Person.class  Profile.class  TinderApp.class 
default: $(CLASSES)

doc:
	javadoc -d $(DOCDIR) -cp $(DOCDIR) $(SRCDIR)/*.java

test_classes: DatabaseUser.class  Images.class  Person.class  Profile.class  TinderApp.class 
	      
junit: test_classes
	
DatabaseUser.class: DatabaseUser.java
	javac -d $(BINDIR) -cp  $(JUNIT)

Images.class: Images.java
	javac -d $(BINDIR) -cp  $(JUNIT)

Person.class: Person.java
	javac -d $(BINDIR) -cp  $(JUNIT)

Profile.class: Profile.java
	javac -d $(BINDIR) -cp  $(JUNIT)

TinderApp.class: TinderApp.java
	javac -d $(BINDIR) -cp  $(JUNIT)



clean:
	rm -f  $(BINDIR)/*.class
	rm -Rf doc

