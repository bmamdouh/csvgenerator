package apps;

import java.io.*;
import java.sql.Timestamp;

public class Main {

    private static Timestamp timestamp;
    private static FileWriter fw;
    private static PrintWriter out;
    private static BufferedWriter bw;
    private static BufferedReader br;
    private static File file;
    private static int chunks;
    private static int total;
    private static String head;
    public static void main(String[] args) throws IOException {
        // write your code here
        timestamp = new Timestamp(System.currentTimeMillis());

        String path = "./Data-" + timestamp + ".csv";
        file = new File(path);
        out = new PrintWriter(new BufferedWriter(new FileWriter(path, true)));
        fw = new FileWriter(file.getAbsoluteFile());
        bw = new BufferedWriter(fw);
        int id = 0;
        total = Integer.parseInt(args[1]);
        chunks = total / 1000;
        System.out.println("File Path : " + path);
        System.out.println("Chunk Size : " + "1000 row");
        System.out.println("Chunks number : " + chunks);
        System.out.println("--------------------------------");
        for (int i = 1; i <= chunks; i++) {
            String[] cmd = {"curl", args[0], " > ", "/Users/Bassam/eai_testbench22.csv"};
            Process rt = Runtime.getRuntime().exec(cmd);
            br = new BufferedReader(new InputStreamReader(rt.getInputStream()));
            if (!file.exists()) {
                file.createNewFile();
            }
            int headers = 0;
            if (i == 1) {
                headers = 1;
            }

            String line = "";
            while ((line = br.readLine()) != null) {
                if (headers == 1) {
                    head=line;
                    out.println("id," + line);
                    headers = 0;
                } else {
                    if (!line.contentEquals(head)) {
                        out.println(id + "," + line);
                        id++;
                    }
                }
            }
            progressSync(i);
        }
        fw.close();
        bw.close();
        out.close();
    }

    public static void progressSync(int num) {
        int pa = total / 100;
        int percentage = (num * 1000) / pa;
        System.out.print("## " + percentage + "% ");
    }
}
