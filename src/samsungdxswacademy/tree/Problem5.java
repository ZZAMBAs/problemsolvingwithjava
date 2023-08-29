/*
package samsungdxswacademy.tree;

import java.util.ArrayList;

class Problem5 { // UserSolution 부분만 구현
    static class Directory{
        String name;
        Directory parent;
        ArrayList<Directory> children;

        public Directory(String name, Directory parent) {
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<>();
        }
    }

    private final static int NAME_MAXLEN	= 6;
    private final static int PATH_MAXLEN	= 1999;
    private int n;
    private Directory root;

//	 The below commented methods are for your reference. If you want
//	 to use it, uncomment these methods.
//
//	int mstrcmp(char[] a, char[] b) {
//		int i;
//		for (i = 0; a[i] != '\0'; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return a[i] - b[i];
//	}
//
//	int mstrncmp(char[] a, char[] b, int len) {
//		for (int i = 0; i < len; i++) {
//			if (a[i] != b[i])
//				return a[i] - b[i];
//		}
//		return 0;
//	}
//
//	int mstrlen(char[] a) {
//		int len = 0;
//
//		while (a[len] != '\0')
//			len++;
//
//		return len;
//	}
//
//	void mstrcpy(char[] dest, char[] src) {
//		int i = 0;
//		while (src[i] != '\0') {
//			dest[i] = src[i];
//			i++;
//		}
//		dest[i] = src[i];
//	}
//
//	void mstrncpy(char[] dest, char[] src, int len) {
//		for (int i = 0; i < len; i++) {
//			dest[i] = src[i];
//		}
//		dest[len] = '\0';
//	}

    void init(int n) {
        this.n = n;
        this.root = new Directory("/", null);
    }

    void cmd_mkdir(char[] path, char[] name) {
        Directory curDirectory = getDirectory(path);
        Directory newDir = new Directory(String.valueOf(name, 0, name.length - 1), curDirectory);
        curDirectory.children.add(newDir);
    }

    void cmd_rm(char[] path) {
        Directory curDir = getDirectory(path);
        curDir.parent.children.remove(curDir);
    }

    void cmd_cp(char[] srcPath, char[] dstPath) {
        Directory srcDir = getDirectory(srcPath);
        Directory dstDir = getDirectory(dstPath);
        copy(srcDir, dstDir);
    }

    void cmd_mv(char[] srcPath, char[] dstPath) {
        Directory srcDir = getDirectory(srcPath);
        srcDir.parent.children.remove(srcDir);
        Directory dstDir = getDirectory(dstPath);
        dstDir.children.add(srcDir);
        srcDir.parent = dstDir;
    }

    int cmd_find(char[] path) {
        Directory curDir = getDirectory(path);
        return dfs(curDir) - 1;
    }

    private Directory getDirectory(char[] path) {
        String stringPath = String.valueOf(path, 0, path.length - 1);
        if (stringPath.equals("/"))
            return root;

        String[] pathPart = stringPath.split("/");
        Directory curDirectory = root;
        for (int i = 1; i < pathPart.length; i++){
            for (Directory child : curDirectory.children){
                if (child.name.equals(pathPart[i])){
                    curDirectory = child;
                    break;
                }
            }
        }
        return curDirectory;
    }

    private int dfs(Directory curDir){
        int ret = 1;
        for (Directory child: curDir.children){
            ret += dfs(child);
        }
        return ret;
    }

    private void copy(Directory src, Directory parent){
        Directory newDir = new Directory(src.name, parent);
        parent.children.add(newDir);
        for (Directory child : src.children)
            copy(child, newDir);
    }
}*/
