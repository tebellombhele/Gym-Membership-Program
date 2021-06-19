package gymmembership;

public class SingleMember extends Member {
    private int Club;
    SingleMember(char p_memberType, int p_memberID, String p_name, double pFees, double p_fees) {
        super(p_memberType, p_memberID, p_name, p_fees);
    }

    public void setClub(int p_club){
        Club = p_club;
    }
    public int getClub(){
        return Club;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + Club;
    }
}
