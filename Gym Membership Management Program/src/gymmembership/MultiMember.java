package gymmembership;

public class MultiMember extends Member {
    private int Membership_Points;

    MultiMember(char p_memberType, int p_memberID, String p_name, double p_fees, int p_membership_Points) {
        super(p_memberType, p_memberID, p_name, p_fees);
        Membership_Points = p_membership_Points;
    }

    public void setMembership_Points(int p_membership_Points) {
        Membership_Points = p_membership_Points;
    }

    public int getMembership_Points() {
        return Membership_Points;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + Membership_Points;
    }
}
