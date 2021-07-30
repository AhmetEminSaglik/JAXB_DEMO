package com.company.xml.record;

import javax.xml.bind.Unmarshaller;

public interface IConvertXMLToObject<T> {
    public <T> T addAllObjectsByConvertingXMLToJavaObjectClass(Unmarshaller unmarshaller, String fileName);

}
