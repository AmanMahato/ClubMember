package ClubMember;

import java.io.*;

public class CommandParsing {

    BufferedReader br;
    PrintWriter out;
    boolean json;

    public CommandParsing(char type, String fileName) {
        if (type == 'I') { // input
            // link input file
            try {
                br = new BufferedReader(new FileReader(fileName));
            } catch (IOException e) {
                System.out.println("Error Opening File");
            }
            if (fileName.endsWith("json")) { // json input
                try {
                    char head = (char) br.read(); // reads the first char
                    if (head != '{') {
                        System.out.println("Unexpected Start of JSON");
                    }
                } catch (IOException e) {
                    System.out.println("Error Reading File");
                }
                json = true;
            } else { // line input
                json = false;
            }
        } else if (type == 'O') { // output
            try {
                out = new PrintWriter(new FileWriter(fileName));
                fileName = fileName;
            } catch (IOException e) {
                System.out.println("Failed to open file " + fileName);
            }
        } else {
            System.out.println("Wrong Type for CMD!");
        }
    }

    public String[] tokenize(String line) {
        if (line != null && line.length() > 0) {
            //remove quotes
            line.replaceAll("\"","");
            String[] tokens = line.split("[\\s,]");
            return tokens;
        }
        return null;
    }

    public String[] getNextLine() {
        if (json) {
            try {
                String current = "";
                boolean open = false;
                char c = (char) br.read();
                while (c > 0) {
                    if (c == '{') {
                        current = "";
                        open = true;
                    } else if (c == '}') {
                        if (open)
                            return tokenize(current);
                        else
                            return null;
                    } else {
                        current += c;
                    }
                    c = (char) br.read();
                }
            } catch (IOException e) {
                System.out.println("Error Reading File");
            }
        } else {
            try {
                return tokenize(br.readLine());
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return null;
    }

    public void writeLine(String line) {
        try {
            System.out.println(line);
        } catch (NullPointerException np) {
            System.out.println("Must first initiate the file writer");
        }
    }

    public void close() {
        try {
            out.flush(); // In case something got stuck in the buffer
            out.close(); // Properlly close the file and release control
        } catch (NullPointerException np) {
            System.out.println("Must first initiate the file writer");
        }
    }

}
