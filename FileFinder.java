/*
The Unix "find" command allows you to search for files under a given directory. You can specify criteria for files you are interested in such as:
- Files that have a given size requirement
- Files with a certain naming pattern.

Please implement a solution that works similar to the "find" command, focusing on the 2 use cases at first:
- Find all files over 5MB somewhere under a directory
- Find All XML files somewhere under a directory

Please write code as if it is part of easy-to-use library. The library can be extended to other usecases. 
Design the classes/interfaces
Implement the core components
Write out the code snippets showing how you would use this library

*/

/*

Consider file and directory structure as n-ary tree.
Root path is starting node. All files in system are leaf nodes. All directories are n-ary sub trees.
Perform DFS/BFS.
*/

class File {
    String name;
    int size;
    int type;
    boolean isDirectory;
    File[] children;
}

abstract class Filter {
    abstract boolean apply(File file);
}

class MinSizeFilter extends Filter {

    int minSize;

    public MinSizeFilter(int minSize) {
        this.minSize = minSize;
    }

    @Override
    boolean apply(File file) {
        return file.size > minSize;
    }
}

class TypeFilter extends Filter {

    int type;

    public TypeFilter(int type) {
        this.type = type;
    }

    @Override
    boolean apply(File file) {
        return file.type == type;
    }
}

enum OPS {
    AND,
    OR,
}

class FindSearcher {

    public List<File> findFiles(File directory, List<Filter> filters, OPS ops) {
        if (!directory.isDirectory) {
            return new NotADirectoryException();
        }
        List<File> output = new ArrayList<>();
        findFilesDfs(directory, filters, output);
        return output;
    }

    private void findFilesDfs(File directory, List<Filter> filters, List<File> output) {
        if (directory.children == null) {
            return;
        }
        for (File file : directory.children) {
            if (file.isDirectory) { // directory
                findFilesDfs(file, filters, output);
            } else { // file
                boolean selectFile = true;
                for (Filter filter : filters) {
                    if (!filter.apply(file)) { // AND
                        selectFile = false;
                    }
                }
                if (selectFile) {
                    output.add(file);
                }
            }
        }
    }
}