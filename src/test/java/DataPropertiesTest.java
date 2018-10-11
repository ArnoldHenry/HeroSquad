import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataPropertiesTest {
    @Test
    public void dataProperties_findName_String() {
        DataProperties hero = new DataProperties("arnold", 26, "god", "cryptonite", "Captain America");
        assertTrue(DataProperties.all().contains(hero));
    }
    @Test
    public void dataProperties_getName_String(){
        DataProperties hero = new DataProperties("arnold", 26, "god", "cryptonite", "Captain America");
        assertEquals("anode", hero.getmName());
    }
}
