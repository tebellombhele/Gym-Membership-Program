package gymmembership;
import java.util.LinkedList;
import java.io.*;

public class FileHandler {

    public LinkedList<Member> readFile(){
        LinkedList<Member> M = new LinkedList();
        String LineRead;
        String[] SplitLine;
        Member MEM;

        try(BufferedReader reader = new BufferedReader(new FileReader("Members.csv")))
        {
            LineRead = reader.readLine();
            while (LineRead != null)
            {
               SplitLine = LineRead.split(", ");
               if (SplitLine[0].equals("S"))
               {
                   MEM = new SingleMember('S', Integer.parseInt(SplitLine[1]), SplitLine[2], Double.parseDouble(SplitLine[3]), Integer.parseInt(SplitLine[4]));
               } else
               {
                   MEM = new MultiMember('M', Integer.parseInt(SplitLine[1]), SplitLine[2], Double.parseDouble(SplitLine[3]), Integer.parseInt(SplitLine[4]));
               }
               M.add(MEM);
               LineRead = reader.readLine();
            }
        }
        catch (IOException e)
        {
                System.out.println(e.getMessage());
        }
        return M;
    }

    public void AppendFile(String MEM){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Members.csv", true)))
        {
            writer.write(MEM + "\n");
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void OverWriteFile(LinkedList<Member> M)
    {
        String s;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("Members.temp", false)))
        {
            for (int i = 0; i < M.size(); i++)
            {
                s = M.get(i).toString();
                writer.write(s + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        try {
            File f = new File("Members.csv");
            File tempf = new File("Members.temp");

            f.delete();
            tempf.renameTo(f);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
