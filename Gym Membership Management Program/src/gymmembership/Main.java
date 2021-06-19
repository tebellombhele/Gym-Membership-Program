package gymmembership;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String MEM;
        MembershipManagement mm = new MembershipManagement();
        FileHandler fh = new FileHandler();
        LinkedList<Member> members = fh.readFile();
        int choice = mm.getChoice();

        while (choice != -1)
        {
            switch (choice)
            {
                case 1:
                    MEM = mm.AddMembers(members);
                    fh.AppendFile(MEM);
                    break;
                case 2:
                    mm.RemoveMember(members);
                    fh.OverWriteFile(members);
                    break;
                case 3:
                    mm.PrintMemberInfo(members);
                    break;
                default:
                    System.out.print("\nYou have selected an invalid option.\n\n");
                    break;
            }
            choice = mm.getChoice();
        }
        System.out.println("\nThank you for using our service, Good Bye");
    }
}
