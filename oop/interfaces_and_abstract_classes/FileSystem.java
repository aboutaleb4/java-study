package oop.interfaces_and_abstract_classes;

import java.util.*;

interface resourceInterface {
    String getName();
}

abstract class Resource implements resourceInterface {
    public String name;

    public Resource(String name) {
        this.name = name;
    }

    public abstract List<String> ls();

    public String getName() {
        return "Name: " + name;
    }
}

class File extends Resource {

    String content;

    public File(String name) {
        super(name);
    }

    @Override
    public List<String> ls() {
        List<String> ans =  new ArrayList<>();
        ans.add(getName());
        return ans;
    }

    public void addContent(String content) {
        this.content += content;
    }

    public String getContent() {
        return content;
    }
}

class Directory extends Resource {

    List<Resource> resources = new ArrayList<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public List<String> ls() {
        List<String> ans =  new ArrayList<>();
        for(Resource resource: resources) ans.add(resource.getName());
        return ans;
    }

    public void touch(String name) {
        resources.add(new File(name));
    }

    public void mkdir(String name) {
        resources.add(new Directory(name));
    }
}

class FileSystem {
    Directory root = new Directory("~");

    public void mkdir(String path) {

    }

    public void touch(String path) {

    }

    public void addContent(String path, String content) {

    }

    public String ls(String path) {
        return "";
    }

    public String getContent(String path) {
        return "";
    }
}