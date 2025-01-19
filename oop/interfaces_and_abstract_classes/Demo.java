package oop.interfaces_and_abstract_classes;

public class Demo {
    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();

        fileSystem.ls("");
        fileSystem.mkdir("a");
        fileSystem.ls("");
        fileSystem.mkdir("a/b/c");
        fileSystem.ls("a/b/c");
        fileSystem.ls("a/b/");
        fileSystem.ls("a/b");
        fileSystem.touch("a/b/d");
        fileSystem.ls("a/b");
        fileSystem.addContent("a/b/d", "Ahmed ");
        fileSystem.getContent("a/b/d");
        fileSystem.addContent("a/b/d", "Aboutaleb");
        fileSystem.getContent("a/b/d");
    }
}

