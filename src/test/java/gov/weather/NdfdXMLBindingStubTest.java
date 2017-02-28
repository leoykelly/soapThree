package gov.weather;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Kelly on 2/26/2017.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53711");

        assertEquals("Failed", "301", result);
    }

}