package gob.senado.ppf.sed.configuracion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 *
 * @author Javatlacati
 */
public class XSSWrapper extends HttpServletRequestWrapper {

	public XSSWrapper(HttpServletRequest httpServletRequest) {
		super(httpServletRequest);
	}

	@Override
	public String[] getParameterValues(String parameter) {
		String[] values = super.getParameterValues(parameter);
		if (values == null) {
			return null;
		}
		int count = values.length;
		String[] encodedValues = new String[count];
		for (int i = 0; i < count; i++) {
			encodedValues[i] = cleanXSS(values[i]);
		}
		return encodedValues;
	}

	@Override
	public String getParameter(String parameter) {
		String value = super.getParameter(parameter);
		return value == null ? null : cleanXSS(value);
	}

	@Override
	public String getHeader(String name) {
		String value = super.getHeader(name);
		return value == null ? null : cleanXSS(value);
	}

	private String cleanXSS(String value) {
		value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\\(", "&#40;")
				.replaceAll("\\)", "&#41;").replaceAll("'", "&#39;").replaceAll("eval\\((.*)\\)", "")
				.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"").replaceAll("script", "");
		return value;
	}

}
