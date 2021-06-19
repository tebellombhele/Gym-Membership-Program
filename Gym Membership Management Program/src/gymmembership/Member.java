package gymmembership;

public class Member {
    private char MemberType;
    private int MemberID;
    private String Name;
    private double Fees;

    Member(char p_memberType, int p_memberID, String p_name, double p_fees) {
        MemberType = p_memberType;
        MemberID =  p_memberID;
        Name = p_name;
        Fees = p_fees;
    }

    public void setMemberType(char p_memberType) {
        MemberType = p_memberType;
    }
    public void setMemberID(int p_memberID) {
        MemberID = p_memberID;
    }

    public void setName(String p_name) {
        Name = p_name;
    }
    public void setFees(double p_fees) {
        Fees = p_fees;
    }


    public char getMemberType() {
        return MemberType;
    }
    public int getMemberID() {
        return MemberID;
    }
    public String getName() {
        return Name;
    }
    public double getFees() {
        return Fees;
    }

    @Override
    public String toString() {
        return MemberType + ", " + MemberID + ", " + Name + ", " + Fees;
    }
}
