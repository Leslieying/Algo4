package Chapter3;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class listFile {
    public static void listAllFiles(String path, int dep)
    {
        File f = new File(path);
        File[] list = f.listFiles();
        for (File newfile:list)
        {
            for (int i=0;i<dep;i++)
                StdOut.print("\t");
            StdOut.print(newfile.getName());
            if (newfile.isDirectory())
                listAllFiles(newfile.getAbsolutePath(), dep+1);
        }
        return;
    }
}
