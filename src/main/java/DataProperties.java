import java.util.ArrayList;
import java.util.List;

public class DataProperties {

    private String mName;
    private int mAge;
    private String mSpecialPowers;
    private String mWeakness;
    private String mSquadname;
    private static List<DataProperties> instances = new ArrayList<DataProperties>();

    public static List<DataProperties> all(){
        return instances;
    }

    public int getmAge() {
        return mAge;
    }

    public String  getmName() {
        return mName;
    }

    public String getmSpecialPowers() {
        return mSpecialPowers;
    }

    public String getmSquadname() {
        return mSquadname;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public void setmAge(int mAge) {
        this.mAge = mAge;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public void setmSpecialPowers(String mSpecialPowers) {
        this.mSpecialPowers = mSpecialPowers;
    }

    public void setmSquadname(String mSquadname) {
        this.mSquadname = mSquadname;
    }

    public void setmWeakness(String mWeakness) {
        this.mWeakness = mWeakness;
    }


}
