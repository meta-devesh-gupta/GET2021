package Dictionary;

import static org.junit.Assert.*;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

public class DictionaryImplTest {

	DictionaryImpl dictionaryImpl;

	@Before
	public void init() {
		try {
			JSONObject jsonObject = new JSONObject("{data:[{key:50, value: A},"
					+ "{key:30, value:B}," + "{key:70, value:C},"
					+ "{key:10, value:D}," + "{key:60, value:E},"
					+ "{key:90, value:F}," + "{key:55, value:G},"
					+ "{key:65, value:H}," + "{key:63, value:I},"
					+ "{key:64, value:J}]}");
			dictionaryImpl = new DictionaryImpl(jsonObject);
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	@Test(expected = AssertionError.class)
	public void getValueTest() {
		assertEquals("B", dictionaryImpl.getValue("30"));
		assertEquals("H", dictionaryImpl.getValue("65"));
		assertEquals("F", dictionaryImpl.getValue("90"));

		// key not exists
		assertEquals("F", dictionaryImpl.getValue("343"));
	}

}
