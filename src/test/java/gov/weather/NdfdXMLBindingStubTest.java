package gov.weather;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.io.StringReader;

import static org.junit.Assert.*;
/**
 * Created by Kelly on 2/26/2017.
 */
public class NdfdXMLBindingStubTest {
    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub) new NdfdXMLLocator().getndfdXMLPort();

        String result = binding.latLonListZipCode("53711");
        String latlong = unmarshallResult(result);
        assertEquals("Failed", "301", result);
    }

    private String unmarshallResult(String result) throws Exception {

        JAXBContext jaxbcontext = JAXBContext.newInstance(DwmlType.class);

        try {
            Unmarshaller jaxUnmarshaller = jaxbcontext.createUnmarshaller();

            DwmlType dwml = (DwmlType) jaxUnmarshaller.unmarshal(new StringReader(result));
            return dwml.getLatLonList();

        } catch (JAXBException exception) {
            exception.printStackTrace();;
        }

        return null;
    }

}