package gymmembership;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {
    final private Scanner reader = new Scanner(System.in);

    private int getIntInput(){
        int choice = 0;
        while (choice == 0)
        {
            try
            {
                choice = reader.nextInt();
                if (choice == 0)
                    throw new InputMismatchException();
                reader.nextLine();
            }
            catch (InputMismatchException e)
            {
                reader.nextLine();
                System.out.print("\nERROR: INVALID INPUT. Please try again:");
            }
        }
        return choice;
    }

    private void printClubOptions(){
        System.out.println("\n1) Club Bronze");
        System.out.println("2) Club Silver");
        System.out.println("3) Club Gold");
        System.out.println("4) Multi Clubs");
    }
    public int getChoice(){
        int choice;
        System.out.println("================================================");
        System.out.println("\nWELCOME TO FAST PACE FITNESS CENTER");
        System.out.println("================================================");
        System.out.println("1) Add New Member");
        System.out.println("2) Remove Existing Member");
        System.out.println("3) Display Member Information");
        System.out.print("\nPlease select an option (or Enter -1 to quit): ");
        choice = getIntInput();
        return choice;
    }

    public String AddMembers(LinkedList<Member> m)
    {
        String Name;
        int Club;
        String MEM;
        double Fees;
        int MemberID;
        Member mbr;
        Calculator<Integer> cal;
        System.out.print("\nPlease enter the member's name: ");
        Name = reader.nextLine();
        printClubOptions();
        System.out.print("\nPlease enter the member's clubID: ");
        Club = getIntInput();
        while (Club < 1 || Club > 4)
        {
            System.out.print("\nInvalid Club ID. Please try again: ");
            Club = getIntInput();
        }
        if (m.size() > 0)
            MemberID = m.getLast().getMemberID() + 1;
        else
            MemberID = 1;
        if (Club != 4)
        {
            cal = (n)-> {
                switch (n)
                {
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            Fees = cal.Calculate_Member_Fees(Club);
            mbr = new SingleMember('S', MemberID, Name, Fees, Club);
            m.add(mbr);
            MEM = mbr.toString();
            System.out.println("\nSTATUS: Single Club Member added\n");
        }
        else
        {
            cal = (n) -> {
                if (n == 4)
                    return 1200;
                else
                    return -1;};
            Fees = cal.Calculate_Member_Fees(Club);
            mbr = new MultiMember('M', MemberID, Name, Fees, 100);
            m.add(mbr);
            MEM = mbr.toString();
            System.out.println("\nSTATUS: Multi Club Member added\n");
        }
        return MEM;
    }

    public void RemoveMember(LinkedList<Member> m){
        int memberID;
        System.out.print("\nEnter Member ID to remove: ");
        memberID = getIntInput();
        for (int i = 0; i<m.size();i++)
        {
            if (m.get(i).getMemberID() == memberID)
            {
                m.remove(i);
                System.out.print("\nMember Removed\n");
                return;
            }
        }
        System.out.println("\nMember ID not found\n");
    }

    public void PrintMemberInfo(LinkedList<Member> m){
        int MemberID;
        System.out.print("\nEnter Member ID to display information: ");
        MemberID = getIntInput();
        for (int i = 0; i<m.size();i++)
        {
            if (m.get(i).getMemberID() == MemberID)
            {
                String[] memberInfo = m.get(i).toString().split(", ");
                System.out.println("\n\nMember Type = " +
                        memberInfo[0]);
                System.out.println("Member ID = " + memberInfo[1]);
                System.out.println("Member Name = " + memberInfo[2]);
                System.out.println("Membership Fees = " + memberInfo[3]);
                if (memberInfo[0].equals("S"))
                {
                    System.out.println("Club ID = " +
                            memberInfo[4]);
                }else
                {
                    System.out.println("Membership Points = " +
                            memberInfo[4]);}
                return;
            }
        }
        System.out.println("\nMember ID not found\n");
    }
}

