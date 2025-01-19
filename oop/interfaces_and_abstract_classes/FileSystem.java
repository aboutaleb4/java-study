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
        return name;
    }
}

class File extends Resource {

    String content = "";

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

    HashMap<String, Resource> resources = new HashMap<>();

    public Directory(String name) {
        super(name);
    }

    @Override
    public List<String> ls() {
        List<String> ans =  new ArrayList<>();
        for(Resource resource: resources.values()) ans.add(resource.getName());
        return ans;
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
        List<String> resourceDirectoryPath = getResourceDirectory(path);
        String resourceName = getResourceName(path);

        Directory currentDir = root;

        for(String resourceDirectory: resourceDirectoryPath) {
            currentDir = currentDir.mkdir(resourceDirectory);
        }

        currentDir.mkdir(resourceName);
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
        System.out.println("------------------------------");
        List<String> resourceDirectoryPath = getResourceDirectory(path);
        String resourceName = getResourceName(path);

        Directory currentDir = root;

        for(String resourceDirectory: resourceDirectoryPath) {
            currentDir = currentDir.mkdir(resourceDirectory);
        }

        Resource resource = resourceName.isEmpty() ? root : currentDir.getResource(resourceName);

        for(String s: resource.ls()) {
            System.out.println(s);
        }

    }

    public void getContent(String path) {
        File file = touch(path);
        System.out.println("------------------------------");
        System.out.println(file.getContent());
    }

    private List<String> getResourceDirectory(String path) {
        String[] components = path.split("/");
        ArrayList<String> result = new ArrayList<>();
        for (String component : components) {
            if (!component.isEmpty()) {
                result.add(component);
            }
        }
        if(!result.isEmpty()) result.removeLast();
        return result;
    }

    private String getResourceName(String path) {
        String[] components = path.split("/");

        for(int i = components.length - 1; i >= 0; i--){
            if (!components[i].isEmpty()) {
                return components[i];
            }
        }
        return "";
    }
}