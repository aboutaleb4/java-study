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

    public abstract void ls();

    public String getName() {
        return name;
    }
}

class File extends Resource {
    String content = "";

    public File(String name) {
        super(name);
    }

    @Override
    public void ls() {
        System.out.println("------------------------------");
        System.out.println(getName());
    }

    public void addContent(String content) {
        this.content += content;
    }
}

class Directory extends Resource {

    HashMap<String, Resource> resources = new HashMap<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public void ls() {
        System.out.println("------------------------------");
        for(Resource resource: resources.values()) {
            System.out.println(resource.getName());
        }
    }

    public File touch(String name) {
        if(!resources.containsKey(name)) resources.put(name, new File(name));
        return (File) resources.get(name);
    }

    public Directory mkdir(String name) {
        if(!resources.containsKey(name)) resources.put(name, new Directory(name));
        return (Directory) resources.get(name);
    }

    public Resource getResource(String name) {
        return resources.get(name);
    }
}

class FileSystem {
    Directory root = new Directory("~");

    public void mkdir(String path) {
        Directory currentDir = root;
        for(String resourceDirectory: getResourcePath(path)) {
            currentDir = currentDir.mkdir(resourceDirectory);
        }
    }

    public File touch(String path) {
        List<String> resourceDirectoryPath = getResourceDirectory(path);
        String resourceName = getResourceName(path);

        Directory currentDir = root;
        for(String resourceDirectory: resourceDirectoryPath) {
            currentDir = currentDir.mkdir(resourceDirectory);
        }

        return currentDir.touch(resourceName);
    }

    public void addContent(String path, String content) {
        File file = touch(path);
        file.addContent(content);
    }

    public void ls(String path) {
        Resource currentDir = root;
        for(String resourceDirectory: getResourcePath(path)) {
            currentDir = ((Directory) currentDir).getResource(resourceDirectory);
        }
        currentDir.ls();
    }

    public void getContent(String path) {
        File file = touch(path);
        System.out.println("------------------------------");
        System.out.println(file.content);
    }

    private List<String> getResourceDirectory(String path) {
        List<String> components = getResourcePath(path);
        if(!components.isEmpty()) components.removeLast();
        return components;
    }

    private String getResourceName(String path) {
        List<String>  components = getResourcePath(path);
        return components.isEmpty() ? "" : components.getLast();
    }

    private List<String> getResourcePath(String path) {
        String[] components = path.split("/");
        ArrayList<String> result = new ArrayList<>();
        for (String component : components) {
            if (!component.isEmpty()) {
                result.add(component);
            }
        }
        return result;
    }
}