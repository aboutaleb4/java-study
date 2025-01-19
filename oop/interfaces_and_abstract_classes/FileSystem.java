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

    public void addFile(String name) {
        resources.add(new File(name));
    }

    public void addDirectory(String name) {
        resources.add(new Directory(name));
    }
}
