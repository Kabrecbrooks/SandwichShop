import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ChipsTest {
    @Test
    public void getPriceTest(){
        Chips chips = new Chips("Lays");
        assertEquals(1.50, chips.getPrice());
    }
}
