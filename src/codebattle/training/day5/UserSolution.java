// 정답이지만 구현이 어렵고 해시를 남발한다. 문자열 키 해시는 해싱 과정과 문자열 비교(충돌 시) 과정을 거치므로 배열보다 나쁜 성능을 낼 수도 있다.
// 해시는 키와 값을 가지므로 메모리를 더 사용한다. 주의.
/*
package codebattle.training.day5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

class UserSolution {
    static HashMap<String, Branch> branches; // "name": Branch
    static HashMap<String, File> files; // "name": File

    public static String convertCharToStr(char[] c){
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < c.length - 1; i++){
            if (c[i] == '\0')
                break;
            ret.append(c[i]);
        }
        return ret.toString();
    }
    void init() {
        branches = new HashMap<>();
        files = new HashMap<>();

        branches.put("root", new Branch("root", null));
    }

    void create(int mTime, char mBranch[], char mFile[], char mData[]) {
        String fileName = convertCharToStr(mFile);
        String branchName = convertCharToStr(mBranch);
        String content = convertCharToStr(mData);
        if (files.getOrDefault(fileName, null) == null)
            files.put(fileName, new File(fileName));
        
        File file = files.get(fileName);
        Branch branch = branches.get(branchName);
        
        file.branchFiles.put(branchName, new FileInfo(mTime, mTime, content));
        branch.addFiles(file);
    }

    void edit(int mTime, char mBranch[], char mFile[], char mData[]) {
        String fileName = convertCharToStr(mFile);
        String branchName = convertCharToStr(mBranch);
        String content = convertCharToStr(mData);
        File file = files.get(fileName);
        FileInfo fileInfo = file.branchFiles.get(branchName);
        
        fileInfo.content = content;
        fileInfo.modifiedAt = mTime;
    }

    void branch(int mTime, char mBranch[], char mChild[]) {
        String branchName = convertCharToStr(mBranch);
        String childName = convertCharToStr(mChild);

        Branch parent = branches.get(branchName);
        Branch child = new Branch(childName, parent);
        parent.children.add(child);
        branches.put(childName, child);

        for (File f : parent.files){
            FileInfo pFileInfo = f.branchFiles.get(parent.name);
            f.branchFiles.put(childName, new FileInfo(pFileInfo));
            child.files.add(f);
        }
    }

    void merge(int mTime, char mBranch[]) {
        String branchName = convertCharToStr(mBranch);
        merge(branches.get(branchName));
    }

    void merge(Branch branch){
        String cBranchName = branch.name;
        for (Branch sub : branch.children)
            if (sub.isActive)
                merge(sub);

        Branch parent = branch.parent;
        String pBranchName = parent.name;
        LinkedList<File> cFileList = branch.files;
        LinkedList<File> pFileList = parent.files;
        LinkedList<File> queue = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (i < pFileList.size() && j < cFileList.size()){
            File pFile = pFileList.get(i);
            FileInfo pFileInfo = pFile.branchFiles.get(pBranchName);
            File cFile = cFileList.get(j);
            FileInfo cFileInfo = cFile.branchFiles.get(cBranchName);

            if (pFileInfo.createdAt <= cFileInfo.createdAt){
                queue.add(pFile);
                i++;
            }else{
                if (cFile.branchFiles.get(pBranchName) == null){ //부모가 없음
                    queue.add(cFile);
                    cFile.branchFiles.put(pBranchName, cFileInfo);
                    cFile.branchFiles.remove(cBranchName);
                }
                else{ // 부모도 있음
                    if (cFileInfo.createdAt == cFile.branchFiles.get(pBranchName).createdAt && cFileInfo.modifiedAt > cFile.branchFiles.get(pBranchName).modifiedAt){
                        cFile.branchFiles.get(pBranchName).content = cFileInfo.content;
                        cFile.branchFiles.get(pBranchName).modifiedAt = cFileInfo.modifiedAt;
                    }
                    cFile.branchFiles.remove(cBranchName);
                }
                j++;
            }
        }
        while (i < pFileList.size())
            queue.add(pFileList.get(i++));
        while (j < cFileList.size()) {
            File cFile = cFileList.get(j++);
            FileInfo cFileInfo = cFile.branchFiles.get(cBranchName);
            if(cFile.branchFiles.get(pBranchName) == null){
                queue.add(cFile);
                cFile.branchFiles.put(pBranchName, cFileInfo);
                cFile.branchFiles.remove(cBranchName);
            }
            else{
                if (cFileInfo.createdAt == cFile.branchFiles.get(pBranchName).createdAt && cFileInfo.modifiedAt > cFile.branchFiles.get(pBranchName).modifiedAt){
                    cFile.branchFiles.get(pBranchName).content = cFileInfo.content;
                    cFile.branchFiles.get(pBranchName).modifiedAt = cFileInfo.modifiedAt;
                }
                cFile.branchFiles.remove(cBranchName);
            }
        }
        while (queue.size() > 50) {
            File removed = queue.remove();
            removed.branchFiles.remove(pBranchName);
        }

        branch.isActive = false;
        branches.remove(cBranchName);
        parent.files = queue;

    }

    int readfile(int mTime, char mBranch[], char mFile[], char retString[]) {
        String fileName = convertCharToStr(mFile);
        String branchName = convertCharToStr(mBranch);
        String content = files.get(fileName).branchFiles.get(branchName).content;
        
        int i;
        for (i = 0; i < content.length(); i++)
            retString[i] = content.charAt(i);
        retString[i] = '\0';
        
        return i;
    }

    public static class File{
        String name; // 파일 이름
        HashMap<String, FileInfo> branchFiles; // 브랜치 이름 별 파일 정보

        public File(String name) {
            this.name = name;
            branchFiles = new HashMap<>();
        }
    }

    public static class FileInfo{
        int createdAt;
        int modifiedAt;
        String content;

        public FileInfo(int createdAt, int modifiedAt, String content) {
            this.createdAt = createdAt;
            this.modifiedAt = modifiedAt;
            this.content = content;
        }

        public FileInfo(FileInfo fi) {
            this.createdAt = fi.createdAt;
            this.modifiedAt = fi.modifiedAt;
            this.content = fi.content;
        }

    }

    public static class Branch{
        String name;
        Branch parent;
        ArrayList<Branch> children;
        LinkedList<File> files; // 50개 초과 시 앞에서부터 삭제
        boolean isActive;

        public Branch(String name, Branch parent) {
            this.name = name;
            this.parent = parent;
            this.children = new ArrayList<>();
            this.files = new LinkedList<>();
            this.isActive = true;
        }

        public void addFiles(File f){
            files.add(f);
            if (files.size() > 50) {
                File removed = files.remove();
                removed.branchFiles.remove(this.name);
            }
        }
    }
}*/
